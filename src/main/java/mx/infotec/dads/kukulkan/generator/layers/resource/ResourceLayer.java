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
package mx.infotec.dads.kukulkan.generator.layers.resource;

import static mx.infotec.dads.kukulkan.generator.util.EntitiesFactory.createRestResourceName;
import static mx.infotec.dads.kukulkan.metamodel.util.JavaFileNameParser.formatToPackageStatement;
import static mx.infotec.dads.kukulkan.metamodel.util.JavaFileNameParser.replaceDotBySlash;
import static mx.infotec.dads.kukulkan.metamodel.util.JavaFileNameParser.replaceSlashByDot;
import static mx.infotec.dads.kukulkan.metamodel.util.LayerUtils.PACKAGE_PROPERTY;
import static mx.infotec.dads.kukulkan.metamodel.util.LayerUtils.PACKAGE_SIMPLE_FORMAT_PROPERTY;

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
import mx.infotec.dads.kukulkan.generator.util.EntitiesFactory;
import mx.infotec.dads.kukulkan.generator.util.LayerNameConstants;
import mx.infotec.dads.kukulkan.generator.util.TemplateEnum;
import mx.infotec.dads.kukulkan.metamodel.editor.LanguageType;
import mx.infotec.dads.kukulkan.metamodel.foundation.Entity;
import mx.infotec.dads.kukulkan.metamodel.foundation.ProjectConfiguration;
import mx.infotec.dads.kukulkan.metamodel.generator.AbstractNavigableLayer;
import mx.infotec.dads.kukulkan.metamodel.util.BasePathEnum;
import mx.infotec.dads.kukulkan.metamodel.util.FileUtil;
import mx.infotec.dads.kukulkan.metamodel.util.NameConventions;

/**
 * Service Layer Task.
 *
 * @author Daniel Cortes Pichardo
 */
@Component(LayerNameConstants.Web.SpringRest.SERVICE_NAME)
public class ResourceLayer extends AbstractNavigableLayer {

    /** The Constant LAYER_NAME. */
    private static final String LAYER_NAME = LayerNameConstants.Web.SpringRest.SERVICE_NAME;

    /** The template service. */
    @Autowired
    private TemplateService templateService;

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(ResourceLayer.class);

    /*
     * (non-Javadoc)
     * 
     * @see mx.infotec.dads.kukulkan.metamodel.generator.NavigableLayer#
     * visitDomainModelElement(mx.infotec.dads.kukulkan.metamodel.foundation.
     * ProjectConfiguration, java.util.Collection, java.util.Map,
     * java.lang.String,
     * mx.infotec.dads.kukulkan.metamodel.foundation.Entity,
     * java.lang.String)
     */
    @Override
    public void visitDomainModelElement(ProjectConfiguration pConf, Collection<Entity> dmElementCollection,
            Map<String, Object> propertiesMap, String dmgName, Entity dmElement, String basePackage) {
        LOGGER.debug("visitDomainModelElement {} ", basePackage);
        String webLayerDotFormat = replaceSlashByDot(NameConventions.REST_LAYER_NAME);
        String webLayerSlashFormat = replaceDotBySlash(NameConventions.REST_LAYER_NAME);
        propertiesMap.put(PACKAGE_PROPERTY, formatToPackageStatement(basePackage, webLayerDotFormat));
        propertiesMap.put(PACKAGE_SIMPLE_FORMAT_PROPERTY,
                formatToPackageStatement(true, basePackage, webLayerDotFormat));
        Path templateFilePath = TemplateEnum.BACK_END.getLocation("restResource.ftl");
        Path relativeFilePath = Paths.get(BasePathEnum.SRC_MAIN_JAVA.toString());
        Path realFilePath = FileUtil.buildRealFilePath(pConf.getOutputDir(), pConf.getId(), BasePathEnum.SRC_MAIN_JAVA,
                basePackage, webLayerSlashFormat, createRestResourceName(dmElement.getName()));
        ModelContext modelContext = EntitiesFactory.createModelContext(propertiesMap, realFilePath, relativeFilePath,
                templateFilePath, LanguageType.JAVA);
        templateService.createGeneratedElement(modelContext).ifPresent(dmElement::addGeneratedElement);
    }

    /*
     * (non-Javadoc)
     * 
     * @see mx.infotec.dads.kukulkan.metamodel.generator.Layer#getName()
     */
    @Override
    public String getName() {
        return LAYER_NAME;
    }
}
