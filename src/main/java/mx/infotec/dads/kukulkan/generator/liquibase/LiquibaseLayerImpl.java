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
package mx.infotec.dads.kukulkan.generator.liquibase;

import static mx.infotec.dads.kukulkan.generator.angularjs.util.EntitiesFactory.createServiceImplName;
import static mx.infotec.dads.kukulkan.generator.angularjs.util.EntitiesFactory.createServiceName;
import static mx.infotec.dads.kukulkan.metamodel.util.JavaFileNameParser.formatToPackageStatement;
import static mx.infotec.dads.kukulkan.metamodel.util.LayerUtils.PACKAGE_IMPL_PROPERTY;
import static mx.infotec.dads.kukulkan.metamodel.util.LayerUtils.PACKAGE_PROPERTY;
import static mx.infotec.dads.kukulkan.metamodel.util.NameConventions.SERVICE_IMPLEMENTS_LAYER_NAME;
import static mx.infotec.dads.kukulkan.metamodel.util.NameConventions.SERVICE_LAYER_NAME;
import static mx.infotec.dads.kukulkan.metamodel.util.Validator.requiredNotEmpty;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.infotec.dads.kukulkan.engine.model.ModelContext;
import mx.infotec.dads.kukulkan.engine.templating.service.TemplateService;
import mx.infotec.dads.kukulkan.generator.angularjs.service.layers.LayerNameConstants;
import mx.infotec.dads.kukulkan.generator.angularjs.util.EntitiesFactory;
import mx.infotec.dads.kukulkan.generator.angularjs.util.TemplateEnum;
import mx.infotec.dads.kukulkan.metamodel.context.GeneratorContext;
import mx.infotec.dads.kukulkan.metamodel.editor.LanguageType;
import mx.infotec.dads.kukulkan.metamodel.foundation.DomainModel;
import mx.infotec.dads.kukulkan.metamodel.foundation.Entity;
import mx.infotec.dads.kukulkan.metamodel.foundation.ProjectConfiguration;
import mx.infotec.dads.kukulkan.metamodel.util.BasePathEnum;
import mx.infotec.dads.kukulkan.metamodel.util.FileUtil;
import mx.infotec.dads.kukulkan.metamodel.util.NameConventions;

/**
 * Service Layer Task.
 *
 * @author Daniel Cortes Pichardo
 */
@Component(LayerNameConstants.DataAccess.Liquibase.SERVICE_NAME)
public class LiquibaseLayerImpl extends LiquibaseLayer {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(LiquibaseLayerImpl.class);

    /** The template service. */
    @Autowired
    private TemplateService templateService;

    /*
     * (non-Javadoc)
     * 
     * @see mx.infotec.dads.kukulkan.metamodel.generator.AbstractNavigableLayer#
     * doBeforeProcessDataModelGroup(mx.infotec.dads.kukulkan.metamodel.
     * foundation.GeneratorContext, java.util.Map)
     */
    @Override
    public void doBeforeProcessDataModelGroup(GeneratorContext context, Map<String, Object> model) {
        ProjectConfiguration pConf = requiredNotEmpty(context.get(ProjectConfiguration.class));
        DomainModel domainModel = requiredNotEmpty(context.get(DomainModel.class));
        fillIndex(pConf, model, domainModel);
    }
    
    /**
     * Fill index.
     *
     * @param pConf
     *            the conf
     * @param model
     *            the model
     * @param domainModel
     *            the domain model
     */
    private void fillIndex(ProjectConfiguration pConf, Map<String, Object> model, DomainModel domainModel) {
        Path templateFilePath = TemplateEnum.COMMON.getLocation("index.html.ftl");
        Path relativeFilePath = Paths.get(BasePathEnum.SRC_MAIN_JAVA.toString());
        Path realFilePath = Paths.get(pConf.getOutputDir().toString(), pConf.getId(), BasePathEnum.WEB_INDEX.getPath(),
                "index.html");
        ModelContext modelContext = EntitiesFactory.createModelContext(model, realFilePath, relativeFilePath,
                templateFilePath, LanguageType.HTML);
        templateService.createGeneratedElement(modelContext).ifPresent(domainModel::addGeneratedElement);
    }

    /*
     * (non-Javadoc)
     * 
     * @see mx.infotec.dads.kukulkan.metamodel.generator.Layer#getName()
     */
    @Override
    public String getName() {
        return LayerNameConstants.DataAccess.Liquibase.SERVICE_NAME;
    }
}
