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
package mx.infotec.dads.kukulkan.generator.angularjs.layer;

import static mx.infotec.dads.kukulkan.engine.editor.ace.EditorFactory.createDefaultAceEditor;
import static mx.infotec.dads.kukulkan.generator.angularjs.service.layers.util.LayerConstants.ENTITY_CONTROLLER_JS;
import static mx.infotec.dads.kukulkan.generator.angularjs.service.layers.util.LayerConstants.ENTITY_DELETE_DIALOG_CONTROLLER_JS;
import static mx.infotec.dads.kukulkan.generator.angularjs.service.layers.util.LayerConstants.ENTITY_DELETE_DIALOG_HTML;
import static mx.infotec.dads.kukulkan.generator.angularjs.service.layers.util.LayerConstants.ENTITY_DETAIL_CONTROLLER_JS;
import static mx.infotec.dads.kukulkan.generator.angularjs.service.layers.util.LayerConstants.ENTITY_DETAIL_HTML;
import static mx.infotec.dads.kukulkan.generator.angularjs.service.layers.util.LayerConstants.ENTITY_DIALOG_CONTROLLER_JS;
import static mx.infotec.dads.kukulkan.generator.angularjs.service.layers.util.LayerConstants.ENTITY_DIALOG_HTML;
import static mx.infotec.dads.kukulkan.generator.angularjs.service.layers.util.LayerConstants.ENTITY_HTML;
import static mx.infotec.dads.kukulkan.generator.angularjs.service.layers.util.LayerConstants.ENTITY_SEARCH_SERVICE_JS;
import static mx.infotec.dads.kukulkan.generator.angularjs.service.layers.util.LayerConstants.ENTITY_SERVICE_JS;
import static mx.infotec.dads.kukulkan.generator.angularjs.service.layers.util.LayerConstants.ENTITY_STATE_JS;
import static mx.infotec.dads.kukulkan.generator.angularjs.service.layers.util.LayerConstants.FRONT_END_ENTITIES_LOCATION;
import static mx.infotec.dads.kukulkan.generator.angularjs.service.layers.util.LayerConstants.FRONT_END_I18N_LOCATION_EN;
import static mx.infotec.dads.kukulkan.generator.angularjs.service.layers.util.LayerConstants.FRONT_END_I18N_LOCATION_ES;
import static mx.infotec.dads.kukulkan.generator.angularjs.service.layers.util.LayerConstants.IDIOMA_JS;
import static mx.infotec.dads.kukulkan.metamodel.editor.LanguageType.HTML;
import static mx.infotec.dads.kukulkan.metamodel.editor.LanguageType.JAVASCRIPT;
import static mx.infotec.dads.kukulkan.metamodel.editor.LanguageType.JSON;
import static mx.infotec.dads.kukulkan.metamodel.util.BasePathEnum.WEB_APP_ENTITIES;
import static mx.infotec.dads.kukulkan.metamodel.util.BasePathEnum.WEB_APP_I18N;
import static mx.infotec.dads.kukulkan.metamodel.util.BasePathEnum.WEB_APP_NAV_BAR;
import static mx.infotec.dads.kukulkan.metamodel.util.BasePathEnum.WEB_INDEX;
import static mx.infotec.dads.kukulkan.metamodel.util.NameConventionFormatter.camelCaseToHyphens;

import java.util.Collection;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.infotec.dads.kukulkan.engine.templating.service.TemplateService;
import mx.infotec.dads.kukulkan.generator.angularjs.service.layers.LayerNameConstants;
import mx.infotec.dads.kukulkan.generator.angularjs.service.layers.util.LayerConstants;
import mx.infotec.dads.kukulkan.generator.angularjs.service.layers.util.TemplateFormatter;
import mx.infotec.dads.kukulkan.metamodel.editor.LanguageType;
import mx.infotec.dads.kukulkan.metamodel.foundation.DomainModel;
import mx.infotec.dads.kukulkan.metamodel.foundation.DomainModelElement;
import mx.infotec.dads.kukulkan.metamodel.foundation.GeneratorContext;
import mx.infotec.dads.kukulkan.metamodel.foundation.ProjectConfiguration;

/**
 * Service Layer Task.
 *
 * @author Daniel Cortes Pichardo
 */
@Component(LayerNameConstants.FrontEnd.AngularJs.SERVICE_NAME)
public class FrontEndLayer extends AngularJsSpringLayer {

    /** The template service. */
    @Autowired
    private TemplateService templateService;

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(FrontEndLayer.class);

    /* (non-Javadoc)
     * @see mx.infotec.dads.kukulkan.metamodel.generator.AbstractNavigableLayer#doBeforeProcessDataModelGroup(mx.infotec.dads.kukulkan.metamodel.foundation.GeneratorContext, java.util.Map)
     */
    @Override
    public void doBeforeProcessDataModelGroup(GeneratorContext context, Map<String, Object> model) {
        fillNavBar(context.getProjectConfiguration(), model, context.getDomainModel());
        fillIdiomaGlobalEsJs(context.getProjectConfiguration(), model, context.getDomainModel());
        fillIdiomaGlobalEnJs(context.getProjectConfiguration(), model, context.getDomainModel());
        fillIndex(context.getProjectConfiguration(), model, context.getDomainModel());
    }

    /* (non-Javadoc)
     * @see mx.infotec.dads.kukulkan.metamodel.generator.NavigableLayer#visitDomainModelElement(mx.infotec.dads.kukulkan.metamodel.foundation.ProjectConfiguration, java.util.Collection, java.util.Map, java.lang.String, mx.infotec.dads.kukulkan.metamodel.foundation.DomainModelElement, java.lang.String)
     */
    @Override
    public void visitDomainModelElement(ProjectConfiguration pConf, Collection<DomainModelElement> dmElementCollection,
            Map<String, Object> propertiesMap, String dmgName, DomainModelElement dmElement, String basePackage) {
        fillEntityControllerJs(pConf, propertiesMap, dmElement);
        fillEntityDeleteDialogControllerJs(pConf, propertiesMap, dmElement);
        fillEntityDeleteDialogHtml(pConf, propertiesMap, dmElement);
        fillEntityDetailControllerJs(pConf, propertiesMap, dmElement);
        fillEntityDetailHtml(pConf, propertiesMap, dmElement);
        fillEntityDialogControllerJs(pConf, propertiesMap, dmElement);
        fillEntityDialogHtml(pConf, propertiesMap, dmElement);
        fillEntityHtml(pConf, propertiesMap, dmElement);
        fillEntitySearchServiceJs(pConf, propertiesMap, dmElement);
        fillEntityServiceJs(pConf, propertiesMap, dmElement);
        fillEntityStateJs(pConf, propertiesMap, dmElement);
        fillIdiomaEsJs(pConf, propertiesMap, dmElement);
        fillIdiomaEnJs(pConf, propertiesMap, dmElement);
    }

    /**
     * Fill nav bar.
     *
     * @param pConf the conf
     * @param model the model
     * @param domainModel the domain model
     */
    private void fillNavBar(ProjectConfiguration pConf, Map<String, Object> model, DomainModel domainModel) {
        templateService.fillModel(domainModel, pConf.getId(), "rest-spring-jpa/frontEnd/navbar.html.ftl", model,
                WEB_APP_NAV_BAR, "/navbar.html", createDefaultAceEditor(HTML), pConf.getOutputDir());
    }

    /**
     * Fill idioma global en js.
     *
     * @param pConf the conf
     * @param model the model
     * @param domainModel the domain model
     */
    private void fillIdiomaGlobalEnJs(ProjectConfiguration pConf, Map<String, Object> model, DomainModel domainModel) {
        templateService.fillModel(domainModel, pConf.getId(), "rest-spring-jpa/frontEnd/i18n/en/global.json.ftl", model,
                WEB_APP_I18N, "/en/global.json", createDefaultAceEditor(JSON), pConf.getOutputDir());
    }

    /**
     * Fill idioma global es js.
     *
     * @param pConf the conf
     * @param model the model
     * @param domainModel the domain model
     */
    private void fillIdiomaGlobalEsJs(ProjectConfiguration pConf, Map<String, Object> model, DomainModel domainModel) {
        templateService.fillModel(domainModel, pConf.getId(), "rest-spring-jpa/frontEnd/i18n/es/global.json.ftl", model,
                WEB_APP_I18N, "/es/global.json", createDefaultAceEditor(JSON), pConf.getOutputDir());
    }

    /**
     * Fill index.
     *
     * @param pConf the conf
     * @param model the model
     * @param domainModel the domain model
     */
    private void fillIndex(ProjectConfiguration pConf, Map<String, Object> model, DomainModel domainModel) {
        templateService.fillModel(domainModel, pConf.getId(), "common/index.html.ftl", model, WEB_INDEX, "/index.html",
                createDefaultAceEditor(HTML), pConf.getOutputDir());
    }

    /**
     * Fill entity controller js.
     *
     * @param pConf the conf
     * @param model the model
     * @param dmElement the dm element
     */
    private void fillEntityControllerJs(ProjectConfiguration pConf, Map<String, Object> model,
            DomainModelElement dmElement) {
        LOGGER.info("fillEntityControllerJs {}", ENTITY_CONTROLLER_JS);
        saveFrontEndTemplate(pConf, model, dmElement, FRONT_END_ENTITIES_LOCATION, ENTITY_CONTROLLER_JS, false);

    }

    /**
     * Fill idioma es js.
     *
     * @param pConf the conf
     * @param model the model
     * @param dmElement the dm element
     */
    private void fillIdiomaEsJs(ProjectConfiguration pConf, Map<String, Object> model, DomainModelElement dmElement) {
        LOGGER.info("fillIdiomaEsJs {}", IDIOMA_JS);
        saveInternationalizationTemplate(pConf, model, dmElement, FRONT_END_I18N_LOCATION_ES, IDIOMA_JS, "es");
    }

    /**
     * Fill idioma en js.
     *
     * @param pConf the conf
     * @param model the model
     * @param dmElement the dm element
     */
    private void fillIdiomaEnJs(ProjectConfiguration pConf, Map<String, Object> model, DomainModelElement dmElement) {
        LOGGER.info("fillIdiomaEnJs {}", IDIOMA_JS);
        saveInternationalizationTemplate(pConf, model, dmElement, FRONT_END_I18N_LOCATION_EN, IDIOMA_JS, "en");
    }

    /**
     * Fill entity state js.
     *
     * @param pConf the conf
     * @param model the model
     * @param dmElement the dm element
     */
    private void fillEntityStateJs(ProjectConfiguration pConf, Map<String, Object> model,
            DomainModelElement dmElement) {
        LOGGER.info("fillEntityStateJs {}", ENTITY_STATE_JS);
        saveFrontEndTemplate(pConf, model, dmElement, FRONT_END_ENTITIES_LOCATION, ENTITY_STATE_JS, false);
    }

    /**
     * Fill entity service js.
     *
     * @param pConf the conf
     * @param model the model
     * @param dmElement the dm element
     */
    private void fillEntityServiceJs(ProjectConfiguration pConf, Map<String, Object> model,
            DomainModelElement dmElement) {
        LOGGER.info("fillEntityServiceJs {}", ENTITY_SERVICE_JS);
        saveFrontEndTemplate(pConf, model, dmElement, FRONT_END_ENTITIES_LOCATION, ENTITY_SERVICE_JS, false);
    }

    /**
     * Fill entity search service js.
     *
     * @param pConf the conf
     * @param model the model
     * @param dmElement the dm element
     */
    private void fillEntitySearchServiceJs(ProjectConfiguration pConf, Map<String, Object> model,
            DomainModelElement dmElement) {
        LOGGER.info("fillEntitySearchServiceJs {}", ENTITY_SEARCH_SERVICE_JS);
        saveFrontEndTemplate(pConf, model, dmElement, FRONT_END_ENTITIES_LOCATION, ENTITY_SEARCH_SERVICE_JS, false);
    }

    /**
     * Fill entity html.
     *
     * @param pConf the conf
     * @param model the model
     * @param dmElement the dm element
     */
    private void fillEntityHtml(ProjectConfiguration pConf, Map<String, Object> model, DomainModelElement dmElement) {
        LOGGER.info("fillEntityHtml {}", ENTITY_HTML);
        saveFrontEndTemplate(pConf, model, dmElement, FRONT_END_ENTITIES_LOCATION, ENTITY_HTML, true, HTML);
    }

    /**
     * Fill entity dialog html.
     *
     * @param pConf the conf
     * @param model the model
     * @param dmElement the dm element
     */
    private void fillEntityDialogHtml(ProjectConfiguration pConf, Map<String, Object> model,
            DomainModelElement dmElement) {
        LOGGER.info("fillEntityDialogHtml {}", ENTITY_DETAIL_HTML);
        saveFrontEndTemplate(pConf, model, dmElement, FRONT_END_ENTITIES_LOCATION, ENTITY_DIALOG_HTML, false, HTML);
    }

    /**
     * Fill entity dialog controller js.
     *
     * @param pConf the conf
     * @param model the model
     * @param dmElement the dm element
     */
    private void fillEntityDialogControllerJs(ProjectConfiguration pConf, Map<String, Object> model,
            DomainModelElement dmElement) {
        LOGGER.info("fillEntityDialogControllerJs {}", ENTITY_DIALOG_CONTROLLER_JS);
        saveFrontEndTemplate(pConf, model, dmElement, FRONT_END_ENTITIES_LOCATION, ENTITY_DIALOG_CONTROLLER_JS, false);
    }

    /**
     * Fill entity detail controller js.
     *
     * @param pConf the conf
     * @param model the model
     * @param dmElement the dm element
     */
    private void fillEntityDetailControllerJs(ProjectConfiguration pConf, Map<String, Object> model,
            DomainModelElement dmElement) {
        LOGGER.info("fillEntityDetailControllerJs {}", ENTITY_DETAIL_CONTROLLER_JS);
        saveFrontEndTemplate(pConf, model, dmElement, FRONT_END_ENTITIES_LOCATION, ENTITY_DETAIL_CONTROLLER_JS, false);
    }

    /**
     * Fill entity detail html.
     *
     * @param pConf the conf
     * @param model the model
     * @param dmElement the dm element
     */
    private void fillEntityDetailHtml(ProjectConfiguration pConf, Map<String, Object> model,
            DomainModelElement dmElement) {
        LOGGER.info("fillEntityDetailHtml {}", LayerConstants.ENTITY_DETAIL_HTML);
        saveFrontEndTemplate(pConf, model, dmElement, FRONT_END_ENTITIES_LOCATION, ENTITY_DETAIL_HTML, false, HTML);
    }

    /**
     * Fill entity delete dialog html.
     *
     * @param pConf the conf
     * @param model the model
     * @param dmElement the dm element
     */
    private void fillEntityDeleteDialogHtml(ProjectConfiguration pConf, Map<String, Object> model,
            DomainModelElement dmElement) {
        LOGGER.info("fillEntityDeleteDialogHtml {}", ENTITY_DELETE_DIALOG_HTML);
        saveFrontEndTemplate(pConf, model, dmElement, FRONT_END_ENTITIES_LOCATION, ENTITY_DELETE_DIALOG_HTML, false,
                HTML);
    }

    /**
     * Fill entity delete dialog controller js.
     *
     * @param pConf the conf
     * @param model the model
     * @param dmElement the dm element
     */
    private void fillEntityDeleteDialogControllerJs(ProjectConfiguration pConf, Map<String, Object> model,
            DomainModelElement dmElement) {
        LOGGER.info("fillEntityDeleteDialogControllerJs {}", ENTITY_DELETE_DIALOG_CONTROLLER_JS);
        saveFrontEndTemplate(pConf, model, dmElement, FRONT_END_ENTITIES_LOCATION, ENTITY_DELETE_DIALOG_CONTROLLER_JS,
                false);
    }

    /**
     * Save front end template.
     *
     * @param pConf the conf
     * @param model the model
     * @param dmElement the dm element
     * @param templateLocation the template location
     * @param templateName the template name
     * @param isPlural the is plural
     */
    private void saveFrontEndTemplate(ProjectConfiguration pConf, Map<String, Object> model,
            DomainModelElement dmElement, String templateLocation, String templateName, boolean isPlural) {
        saveFrontEndTemplate(pConf, model, dmElement, templateLocation, templateName, isPlural, JAVASCRIPT);
    }

    /**
     * Save front end template.
     *
     * @param pConf the conf
     * @param model the model
     * @param dmElement the dm element
     * @param templateLocation the template location
     * @param templateName the template name
     * @param isPlural the is plural
     * @param languageType the language type
     */
    private void saveFrontEndTemplate(ProjectConfiguration pConf, Map<String, Object> model,
            DomainModelElement dmElement, String templateLocation, String templateName, boolean isPlural,
            LanguageType languageType) {
        String fileNamingConvention = camelCaseToHyphens(dmElement.getCamelCaseFormat());
        String entityName = fileNamingConvention;
        if (isPlural) {
            entityName = camelCaseToHyphens(dmElement.getCamelCasePluralFormat());
        }
        templateService.fillModel(dmElement, pConf.getId(), templateLocation + templateName, model, WEB_APP_ENTITIES,
                fileNamingConvention + "/" + entityName + TemplateFormatter.formatNameTemplate(templateName),
                createDefaultAceEditor(languageType), pConf.getOutputDir());
    }

    /**
     * Save internationalization template.
     *
     * @param pConf the conf
     * @param model the model
     * @param dmElement the dm element
     * @param templateLocation the template location
     * @param templateName the template name
     * @param idiomaKey the idioma key
     */
    private void saveInternationalizationTemplate(ProjectConfiguration pConf, Map<String, Object> model,
            DomainModelElement dmElement, String templateLocation, String templateName, String idiomaKey) {
        String fileNamingConvention = camelCaseToHyphens(dmElement.getCamelCaseFormat());
        templateService.fillModel(dmElement, pConf.getId(), templateLocation + templateName, model, WEB_APP_I18N,
                idiomaKey + "/" + fileNamingConvention + TemplateFormatter.formatNameTemplate(templateName),
                createDefaultAceEditor(JSON), pConf.getOutputDir());
    }

    /* (non-Javadoc)
     * @see mx.infotec.dads.kukulkan.metamodel.generator.Layer#getName()
     */
    @Override
    public String getName() {
        return LayerNameConstants.FrontEnd.AngularJs.SERVICE_NAME;
    }
}
