/*
 *  
 * The MIT License (MIT)
 * Copyright (c) 2018 Roberto Villarejo Martínez
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

package mx.infotec.dads.kukulkan.generator.layers.frontend;

import static mx.infotec.dads.kukulkan.generator.layers.frontend.AngularJsLayer.fillEntityControllerJs;
import static mx.infotec.dads.kukulkan.generator.layers.frontend.AngularJsLayer.fillEntityDeleteDialogControllerJs;
import static mx.infotec.dads.kukulkan.generator.layers.frontend.AngularJsLayer.fillEntityDeleteDialogHtml;
import static mx.infotec.dads.kukulkan.generator.layers.frontend.AngularJsLayer.fillEntityDetailControllerJs;
import static mx.infotec.dads.kukulkan.generator.layers.frontend.AngularJsLayer.fillEntityDetailHtml;
import static mx.infotec.dads.kukulkan.generator.layers.frontend.AngularJsLayer.fillEntitySearchServiceJs;
import static mx.infotec.dads.kukulkan.generator.layers.frontend.AngularJsLayer.fillEntityServiceJs;
import static mx.infotec.dads.kukulkan.generator.layers.frontend.AngularJsLayer.fillEntityStateJs;
import static mx.infotec.dads.kukulkan.generator.layers.frontend.AngularJsLayer.fillIdiomaEnJs;
import static mx.infotec.dads.kukulkan.generator.layers.frontend.AngularJsLayer.fillIdiomaEsJs;
import static mx.infotec.dads.kukulkan.generator.layers.frontend.AngularJsLayer.fillIdiomaGlobalEnJs;
import static mx.infotec.dads.kukulkan.generator.layers.frontend.AngularJsLayer.fillIdiomaGlobalEsJs;
import static mx.infotec.dads.kukulkan.generator.layers.frontend.AngularJsLayer.saveFrontEndTemplate;
import static mx.infotec.dads.kukulkan.generator.util.LayerConstants.ENTITY_DETAIL_HTML;
import static mx.infotec.dads.kukulkan.generator.util.LayerConstants.ENTITY_DIALOG_CONTROLLER_JS;
import static mx.infotec.dads.kukulkan.generator.util.LayerConstants.ENTITY_DIALOG_HTML;
import static mx.infotec.dads.kukulkan.generator.util.LayerConstants.ENTITY_HTML;
import static mx.infotec.dads.kukulkan.metamodel.editor.LanguageType.HTML;
import static mx.infotec.dads.kukulkan.metamodel.util.Validator.requiredNotEmpty;

import java.util.Collection;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.infotec.dads.kukulkan.engine.model.AbstractNavigableLayer;
import mx.infotec.dads.kukulkan.engine.service.WriterService;
import mx.infotec.dads.kukulkan.engine.templating.service.TemplateService;
import mx.infotec.dads.kukulkan.generator.util.LayerNameConstants;
import mx.infotec.dads.kukulkan.generator.util.TemplateEnum;
import mx.infotec.dads.kukulkan.metamodel.context.GeneratorContext;
import mx.infotec.dads.kukulkan.metamodel.foundation.DomainModel;
import mx.infotec.dads.kukulkan.metamodel.foundation.DomainModelGroup;
import mx.infotec.dads.kukulkan.metamodel.foundation.Entity;
import mx.infotec.dads.kukulkan.metamodel.foundation.ProjectConfiguration;

@Component(LayerNameConstants.FrontEnd.AngularJs.GOBMX_ANGULARJS)
public class GobMxAngularJsLayer extends AbstractNavigableLayer {

    /** The template service. */
    @Autowired
    private TemplateService templateService;

    @Autowired
    private WriterService writerService;

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(GobMxAngularJsLayer.class);

    @Override
    public void doBeforeProcessDataModelGroup(GeneratorContext context, Map<String, Object> propertiesMap) {
        ProjectConfiguration pConf = requiredNotEmpty(context.get(ProjectConfiguration.class));
        DomainModel domainModel = requiredNotEmpty(context.get(DomainModel.class));
        fillNavBar(pConf, domainModel);
        fillIdiomaGlobalEsJs(templateService, pConf, propertiesMap, domainModel);
        fillIdiomaGlobalEnJs(templateService, pConf, propertiesMap, domainModel);
    }

    private void fillNavBar(ProjectConfiguration pConf, DomainModel domainModel) {
        for (DomainModelGroup domainModelGroup : domainModel.getDomainModelGroup()) {
            for (Entity entity : domainModelGroup.getEntities()) {
                writerService.addEntityMenuEntry("rest-spring-jpa/gobmxFrontEnd/menu-entry.html.ftl",
                        pConf.getOutputDir(), entity);
            }
        }
    }

    @Override
    public void visitEntity(ProjectConfiguration pConf, Collection<Entity> dmElementCollection,
            Map<String, Object> propertiesMap, String dmgName, Entity dmElement, String basePackage) {
        fillEntityControllerJs(templateService, pConf, propertiesMap, dmElement);
        fillEntityHtml(templateService, pConf, propertiesMap, dmElement);
        fillEntitySearchServiceJs(templateService, pConf, propertiesMap, dmElement);
        fillEntityServiceJs(templateService, pConf, propertiesMap, dmElement);
        fillEntityStateJs(templateService, pConf, propertiesMap, dmElement);
        fillIdiomaEsJs(templateService, pConf, propertiesMap, dmElement);
        fillIdiomaEnJs(templateService, pConf, propertiesMap, dmElement);
        if (!dmElement.getFeatures().isSheetable()) {
            fillEntityDeleteDialogControllerJs(templateService, pConf, propertiesMap, dmElement);
            fillEntityDeleteDialogHtml(templateService, pConf, propertiesMap, dmElement);
            fillEntityDetailControllerJs(templateService, pConf, propertiesMap, dmElement);
            fillEntityDetailHtml(templateService, pConf, propertiesMap, dmElement);
            fillEntityDialogControllerJs(templateService, pConf, propertiesMap, dmElement);
            fillEntityDialogHtml(templateService, pConf, propertiesMap, dmElement);
        }
    }

    private void fillEntityHtml(TemplateService templateService, ProjectConfiguration pConf, Map<String, Object> model,
            Entity dmElement) {
        LOGGER.debug("fillEntityHtml {}", ENTITY_HTML);
        saveFrontEndTemplate(templateService, pConf, model, dmElement,
                TemplateEnum.GOB_MX_FRONT_END_ENTITIES_LOCATION.getLocation(ENTITY_HTML), ENTITY_HTML, true, HTML);
    }

    /**
     * Fill entity dialog html.
     *
     * @param pConf
     *            the conf
     * @param model
     *            the model
     * @param dmElement
     *            the dm element
     */
    private void fillEntityDialogHtml(TemplateService templateService, ProjectConfiguration pConf,
            Map<String, Object> model, Entity dmElement) {
        LOGGER.debug("fillEntityDialogHtml {}", ENTITY_DETAIL_HTML);
        saveFrontEndTemplate(templateService, pConf, model, dmElement,
                TemplateEnum.GOB_MX_FRONT_END_ENTITIES_LOCATION.getLocation(ENTITY_DIALOG_HTML), ENTITY_DIALOG_HTML,
                false, HTML);
    }

    /**
     * Fill entity dialog controller js.
     *
     * @param pConf
     *            the conf
     * @param model
     *            the model
     * @param dmElement
     *            the dm element
     */
    private void fillEntityDialogControllerJs(TemplateService templateService, ProjectConfiguration pConf,
            Map<String, Object> model, Entity dmElement) {
        LOGGER.debug("fillEntityDialogControllerJs {}", ENTITY_DIALOG_CONTROLLER_JS);
        saveFrontEndTemplate(templateService, pConf, model, dmElement, TemplateEnum.GOB_MX_FRONT_END_ENTITIES_LOCATION,
                ENTITY_DIALOG_CONTROLLER_JS, false);
    }

    @Override
    public String getName() {
        return LayerNameConstants.FrontEnd.AngularJs.GOBMX_ANGULARJS;
    }

}
