/*
 *  
 * The MIT License (MIT)
 * Copyright (c) 2016 Daniel Cortes Pichardo
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package mx.infotec.dads.kukulkan.generator.layers.data;

import static mx.infotec.dads.kukulkan.engine.util.LayerUtils.PACKAGE_PROPERTY;
import static mx.infotec.dads.kukulkan.metamodel.util.JavaFileNameParser.formatToPackageStatement;

import java.nio.file.Path;
import java.util.Collection;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.infotec.dads.kukulkan.engine.model.AbstractNavigableLayer;
import mx.infotec.dads.kukulkan.engine.model.ModelContext;
import mx.infotec.dads.kukulkan.engine.service.FileUtil;
import mx.infotec.dads.kukulkan.engine.service.WriterService;
import mx.infotec.dads.kukulkan.engine.templating.service.TemplateService;
import mx.infotec.dads.kukulkan.engine.util.PathPair;
import mx.infotec.dads.kukulkan.generator.util.EntitiesFactory;
import mx.infotec.dads.kukulkan.generator.util.LayerNameConstants;
import mx.infotec.dads.kukulkan.generator.util.TemplateEnum;
import mx.infotec.dads.kukulkan.metamodel.editor.LanguageType;
import mx.infotec.dads.kukulkan.metamodel.foundation.DatabaseType;
import mx.infotec.dads.kukulkan.metamodel.foundation.Entity;
import mx.infotec.dads.kukulkan.metamodel.foundation.ProjectConfiguration;
import mx.infotec.dads.kukulkan.metamodel.util.BasePathEnum;
import mx.infotec.dads.kukulkan.metamodel.util.NameConventions;

/**
 * Service Layer Task.
 *
 * @author Daniel Cortes Pichardo
 */
@Component(LayerNameConstants.Domain.Core.SERVICE_NAME)
public class DomainLayer extends AbstractNavigableLayer {

    /** The template service. */
    @Autowired
    private TemplateService templateService;

    @Autowired
    private WriterService writerService;

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(DomainLayer.class);

    /*
     * (non-Javadoc)
     * 
     * @see mx.infotec.dads.kukulkan.metamodel.generator.NavigableLayer#
     * visitDomainModelElement(mx.infotec.dads.kukulkan.metamodel.foundation.
     * ProjectConfiguration, java.util.Collection, java.util.Map, java.lang.String,
     * mx.infotec.dads.kukulkan.metamodel.foundation.Entity, java.lang.String)
     */
    @Override
    public void visitEntity(ProjectConfiguration confg, Collection<Entity> dmElementCollection,
            Map<String, Object> propertiesMap, String dmgName, Entity dmElement, String basePackage) {
        LOGGER.debug("visitDomainModelElement for {}", basePackage);
        propertiesMap.put(PACKAGE_PROPERTY,
                formatToPackageStatement(false, basePackage, NameConventions.DOMAIN_LAYER_NAME));
        fillModel(confg, propertiesMap, dmgName, basePackage, dmElement);
        fillPrimaryKey(confg, propertiesMap, basePackage, dmElement);
        if (dmElement.getFeatures().isSheetable()) {
            addKukulkanTablesMavenDependency(confg);
        }
    }

    /**
     * Fill model.
     *
     * @param pConf
     *            the conf
     * @param model
     *            the model
     * @param dmgName
     *            the dmg name
     * @param basePackage
     *            the base package
     * @param dmElement
     *            the dm element
     */
    private void fillModel(ProjectConfiguration pConf, Map<String, Object> model, String dmgName, String basePackage,
            Entity dmElement) {
        LOGGER.debug("Domain {}", dmgName);
        String template;
        if (pConf.getTargetDatabase().getDatabaseType().equals(DatabaseType.NO_SQL_MONGODB)) {
            template = "model-mongo.ftl";
        } else {
            template = "model.ftl";
        }
        Path templateFilePath = TemplateEnum.COMMON.getLocation(template);
        PathPair pathPair = FileUtil.buildRealFilePath(pConf.getOutputDir(), BasePathEnum.SRC_MAIN_JAVA,
                basePackage, NameConventions.DOMAIN_LAYER_NAME, EntitiesFactory.createDomainName(dmElement.getName()));
        ModelContext modelContext = EntitiesFactory.createModelContext(model, pathPair.getRealPath(),
                pathPair.getRelativePath(), templateFilePath, LanguageType.JAVA);
        templateService.createGeneratedElement(modelContext).ifPresent(dmElement::addGeneratedElement);
    }

    /**
     * Fill primary key.
     *
     * @param pConf
     *            the conf
     * @param model
     *            the model
     * @param dmgName
     *            the dmg name
     * @param basePackage
     *            the base package
     * @param dmElement
     *            the dm element
     */
    private void fillPrimaryKey(ProjectConfiguration pConf, Map<String, Object> model, String basePackage,
            Entity dmElement) {
        if (dmElement.getPrimaryKey().isComposed()) {
            Path templateFilePath = TemplateEnum.COMMON.getLocation("primaryKey.ftl");
            PathPair pathPair = FileUtil.buildRealFilePath(pConf.getOutputDir(),
                    BasePathEnum.SRC_MAIN_JAVA, basePackage, NameConventions.DOMAIN_LAYER_NAME,
                    EntitiesFactory.createPrimaryKeyName(dmElement.getPrimaryKey().getType()));
            ModelContext modelContext = EntitiesFactory.createModelContext(model, pathPair.getRealPath(),
                    pathPair.getRelativePath(), templateFilePath, LanguageType.JAVA);
            templateService.createGeneratedElement(modelContext).ifPresent(dmElement::addGeneratedElement);
        }
    }

    private void addKukulkanTablesMavenDependency(ProjectConfiguration pConf) {
        Path projectDir = pConf.getOutputDir();
        writerService.addMavenDependency("rest-spring-jpa/backEnd/extra-dependencies/kukulkan-tables-maven-dep.ftl",
                projectDir);
    }

    /*
     * (non-Javadoc)
     * 
     * @see mx.infotec.dads.kukulkan.metamodel.generator.Layer#getName()
     */
    @Override
    public String getName() {
        return LayerNameConstants.Domain.Core.SERVICE_NAME;
    }
}
