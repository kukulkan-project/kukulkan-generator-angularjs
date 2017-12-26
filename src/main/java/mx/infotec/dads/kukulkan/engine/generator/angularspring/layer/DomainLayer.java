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
package mx.infotec.dads.kukulkan.engine.generator.angularspring.layer;

import static mx.infotec.dads.kukulkan.metamodel.editor.LanguageType.JAVA;
import static mx.infotec.dads.kukulkan.metamodel.editor.ace.EditorFactory.createDefaultAceEditor;
import static mx.infotec.dads.kukulkan.metamodel.util.JavaFileNameParser.formatToPackageStatement;
import static mx.infotec.dads.kukulkan.metamodel.util.LayerUtils.PACKAGE_PROPERTY;

import java.util.Collection;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.infotec.dads.kukulkan.engine.service.layers.LayerNameConstants;
import mx.infotec.dads.kukulkan.engine.templating.service.TemplateService;
import mx.infotec.dads.kukulkan.metamodel.foundation.DomainModelElement;
import mx.infotec.dads.kukulkan.metamodel.foundation.ProjectConfiguration;
import mx.infotec.dads.kukulkan.metamodel.util.BasePathEnum;

/**
 * Service Layer Task
 * 
 * @author Daniel Cortes Pichardo
 *
 */
@Component(LayerNameConstants.Domain.Core.SERVICE_NAME)
public class DomainLayer extends AngularJsSpringLayer {

    @Autowired
    private TemplateService templateService;

    private static final Logger LOGGER = LoggerFactory.getLogger(DomainLayer.class);

    @Override
    public void visitDomainModelElement(ProjectConfiguration confg, Collection<DomainModelElement> dmElementCollection,
            Map<String, Object> propertiesMap, String dmgName, DomainModelElement dmElement, String basePackage) {
        LOGGER.debug("visitDomainModelElement for {}", basePackage);
        propertiesMap.put(PACKAGE_PROPERTY, formatToPackageStatement(false, basePackage, confg.getDomainLayerName()));
        fillModel(confg, propertiesMap, dmgName, basePackage, dmElement);
        fillPrimaryKey(confg, propertiesMap, dmgName, basePackage, dmElement);
    }

    private void fillModel(ProjectConfiguration pConf, Map<String, Object> model, String dmgName, String basePackage,
            DomainModelElement dmElement) {
        String template = null;
        if (pConf.isMongoDb()) {
            template = "common/model-mongo.ftl";
        } else {
            template = "common/model.ftl";
        }
        templateService.fillModel(dmElement, pConf.getId(), template, model,
                BasePathEnum.SRC_MAIN_JAVA, basePackage.replace('.', '/') + "/" + dmgName + "/"
                        + pConf.getDomainLayerName() + "/" + dmElement.getName() + ".java",
                createDefaultAceEditor(JAVA));
    }

    private void fillPrimaryKey(ProjectConfiguration pConf, Map<String, Object> model, String dmgName,
            String basePackage, DomainModelElement dmElement) {
        if (dmElement.getPrimaryKey().isComposed()) {
            templateService.fillModel(dmElement, pConf.getId(), "common/primaryKey.ftl", model,
                    BasePathEnum.SRC_MAIN_JAVA, basePackage.replace('.', '/') + "/" + dmgName + "/"
                            + pConf.getDomainLayerName() + "/" + dmElement.getPrimaryKey().getType() + ".java",
                    createDefaultAceEditor(JAVA));
        }
    }

    @Override
    public String getName() {
        return LayerNameConstants.Domain.Core.SERVICE_NAME;
    }
}
