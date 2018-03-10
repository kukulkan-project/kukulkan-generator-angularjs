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
package mx.infotec.dads.kukulkan.generator.layers.frontend;

import static mx.infotec.dads.kukulkan.generator.util.LayerConstants.ENTITY_CONTROLLER_JS;
import static mx.infotec.dads.kukulkan.generator.util.LayerConstants.ENTITY_DELETE_DIALOG_CONTROLLER_JS;
import static mx.infotec.dads.kukulkan.generator.util.LayerConstants.ENTITY_DELETE_DIALOG_HTML;
import static mx.infotec.dads.kukulkan.generator.util.LayerConstants.ENTITY_DETAIL_CONTROLLER_JS;
import static mx.infotec.dads.kukulkan.generator.util.LayerConstants.ENTITY_DETAIL_HTML;
import static mx.infotec.dads.kukulkan.generator.util.LayerConstants.ENTITY_DIALOG_CONTROLLER_JS;
import static mx.infotec.dads.kukulkan.generator.util.LayerConstants.ENTITY_DIALOG_HTML;
import static mx.infotec.dads.kukulkan.generator.util.LayerConstants.ENTITY_HTML;
import static mx.infotec.dads.kukulkan.generator.util.LayerConstants.ENTITY_SEARCH_SERVICE_JS;
import static mx.infotec.dads.kukulkan.generator.util.LayerConstants.ENTITY_SERVICE_JS;
import static mx.infotec.dads.kukulkan.generator.util.LayerConstants.ENTITY_STATE_JS;
import static mx.infotec.dads.kukulkan.generator.util.LayerConstants.IDIOMA_JS;
import static mx.infotec.dads.kukulkan.metamodel.editor.LanguageType.HTML;
import static mx.infotec.dads.kukulkan.metamodel.editor.LanguageType.JAVASCRIPT;
import static mx.infotec.dads.kukulkan.metamodel.util.NameConventionFormatter.camelCaseToHyphens;
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
import mx.infotec.dads.kukulkan.generator.util.EntitiesFactory;
import mx.infotec.dads.kukulkan.generator.util.LayerConstants;
import mx.infotec.dads.kukulkan.generator.util.LayerNameConstants;
import mx.infotec.dads.kukulkan.generator.util.TemplateEnum;
import mx.infotec.dads.kukulkan.generator.util.TemplateFormatter;
import mx.infotec.dads.kukulkan.metamodel.context.GeneratorContext;
import mx.infotec.dads.kukulkan.metamodel.editor.LanguageType;
import mx.infotec.dads.kukulkan.metamodel.foundation.DomainModel;
import mx.infotec.dads.kukulkan.metamodel.foundation.Entity;
import mx.infotec.dads.kukulkan.metamodel.foundation.ProjectConfiguration;
import mx.infotec.dads.kukulkan.metamodel.generator.AbstractNavigableLayer;
import mx.infotec.dads.kukulkan.metamodel.util.BasePathEnum;

/**
 * Service Layer Task.
 *
 * @author Daniel Cortes Pichardo
 */
@Component(LayerNameConstants.FrontEnd.AngularJs.SERVICE_NAME)
public class AngularJsLayer extends AbstractNavigableLayer {

    /** The template service. */
    @Autowired
    private TemplateService templateService;

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(AngularJsLayer.class);

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
        fillNavBar(pConf, model, domainModel);
        fillIdiomaGlobalEsJs(pConf, model, domainModel);
        fillIdiomaGlobalEnJs(pConf, model, domainModel);
        fillIndex(pConf, model, domainModel);
    }

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
     * @param pConf
     *            the conf
     * @param model
     *            the model
     * @param domainModel
     *            the domain model
     */
    private void fillNavBar(ProjectConfiguration pConf, Map<String, Object> model, DomainModel domainModel) {
        Path templateFilePath = TemplateEnum.FRONT_END.getLocation("navbar.html.ftl");
        Path relativeFilePath = Paths.get(BasePathEnum.SRC_MAIN_JAVA.toString());
        Path realFilePath = Paths.get(pConf.getOutputDir().toString(), pConf.getId(),
                BasePathEnum.WEB_APP_NAV_BAR.getPath(), "navbar.html");
        ModelContext modelContext = EntitiesFactory.createModelContext(model, realFilePath, relativeFilePath,
                templateFilePath, LanguageType.HTML);
        templateService.createGeneratedElement(modelContext).ifPresent(domainModel::addGeneratedElement);
    }

    /**
     * Fill idioma global en js.
     *
     * @param pConf
     *            the conf
     * @param model
     *            the model
     * @param domainModel
     *            the domain model
     */
    private void fillIdiomaGlobalEnJs(ProjectConfiguration pConf, Map<String, Object> model, DomainModel domainModel) {

        Path templateFilePath = TemplateEnum.FRONT_END_I18N_LOCATION_EN.getLocation("global.json.ftl");
        Path relativeFilePath = Paths.get(BasePathEnum.SRC_MAIN_JAVA.toString());
        Path realFilePath = Paths.get(pConf.getOutputDir().toString(), pConf.getId(),
                BasePathEnum.WEB_APP_I18N.getPath(), "en/global.json");
        ModelContext modelContext = EntitiesFactory.createModelContext(model, realFilePath, relativeFilePath,
                templateFilePath, LanguageType.JSON);
        templateService.createGeneratedElement(modelContext).ifPresent(domainModel::addGeneratedElement);
    }

    /**
     * Fill idioma global es js.
     *
     * @param pConf
     *            the conf
     * @param model
     *            the model
     * @param domainModel
     *            the domain model
     */
    private void fillIdiomaGlobalEsJs(ProjectConfiguration pConf, Map<String, Object> model, DomainModel domainModel) {
        Path templateFilePath = TemplateEnum.FRONT_END_I18N_LOCATION_ES.getLocation("global.json.ftl");
        Path relativeFilePath = Paths.get(BasePathEnum.SRC_MAIN_JAVA.toString());
        Path realFilePath = Paths.get(pConf.getOutputDir().toString(), pConf.getId(),
                BasePathEnum.WEB_APP_I18N.getPath(), "es/global.json");
        ModelContext modelContext = EntitiesFactory.createModelContext(model, realFilePath, relativeFilePath,
                templateFilePath, LanguageType.HTML);
        templateService.createGeneratedElement(modelContext).ifPresent(domainModel::addGeneratedElement);
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

    /**
     * Fill entity controller js.
     *
     * @param pConf
     *            the conf
     * @param model
     *            the model
     * @param dmElement
     *            the dm element
     */
    private void fillEntityControllerJs(ProjectConfiguration pConf, Map<String, Object> model,
            Entity dmElement) {
        LOGGER.debug("fillEntityControllerJs {}", ENTITY_CONTROLLER_JS);
        saveFrontEndTemplate(pConf, model, dmElement, TemplateEnum.FRONT_END_ENTITIES_LOCATION, ENTITY_CONTROLLER_JS,
                false);

    }

    /**
     * Fill idioma es js.
     *
     * @param pConf
     *            the conf
     * @param model
     *            the model
     * @param dmElement
     *            the dm element
     */
    private void fillIdiomaEsJs(ProjectConfiguration pConf, Map<String, Object> model, Entity dmElement) {
        LOGGER.debug("fillIdiomaEsJs {}", IDIOMA_JS);
        saveInternationalizationTemplate(pConf, model, dmElement, TemplateEnum.FRONT_END_I18N_LOCATION_ES, IDIOMA_JS,
                "es");
    }

    /**
     * Fill idioma en js.
     *
     * @param pConf
     *            the conf
     * @param model
     *            the model
     * @param dmElement
     *            the dm element
     */
    private void fillIdiomaEnJs(ProjectConfiguration pConf, Map<String, Object> model, Entity dmElement) {
        LOGGER.debug("fillIdiomaEnJs {}", IDIOMA_JS);
        saveInternationalizationTemplate(pConf, model, dmElement, TemplateEnum.FRONT_END_I18N_LOCATION_EN, IDIOMA_JS,
                "en");
    }

    /**
     * Fill entity state js.
     *
     * @param pConf
     *            the conf
     * @param model
     *            the model
     * @param dmElement
     *            the dm element
     */
    private void fillEntityStateJs(ProjectConfiguration pConf, Map<String, Object> model,
            Entity dmElement) {
        LOGGER.debug("fillEntityStateJs {}", ENTITY_STATE_JS);
        saveFrontEndTemplate(pConf, model, dmElement, TemplateEnum.FRONT_END_ENTITIES_LOCATION, ENTITY_STATE_JS, false);
    }

    /**
     * Fill entity service js.
     *
     * @param pConf
     *            the conf
     * @param model
     *            the model
     * @param dmElement
     *            the dm element
     */
    private void fillEntityServiceJs(ProjectConfiguration pConf, Map<String, Object> model,
            Entity dmElement) {
        LOGGER.debug("fillEntityServiceJs {}", ENTITY_SERVICE_JS);
        saveFrontEndTemplate(pConf, model, dmElement, TemplateEnum.FRONT_END_ENTITIES_LOCATION, ENTITY_SERVICE_JS,
                false);
    }

    /**
     * Fill entity search service js.
     *
     * @param pConf
     *            the conf
     * @param model
     *            the model
     * @param dmElement
     *            the dm element
     */
    private void fillEntitySearchServiceJs(ProjectConfiguration pConf, Map<String, Object> model,
            Entity dmElement) {
        LOGGER.debug("fillEntitySearchServiceJs {}", ENTITY_SEARCH_SERVICE_JS);
        saveFrontEndTemplate(pConf, model, dmElement, TemplateEnum.FRONT_END_ENTITIES_LOCATION,
                ENTITY_SEARCH_SERVICE_JS, false);
    }

    /**
     * Fill entity html.
     *
     * @param pConf
     *            the conf
     * @param model
     *            the model
     * @param dmElement
     *            the dm element
     */
    private void fillEntityHtml(ProjectConfiguration pConf, Map<String, Object> model, Entity dmElement) {
        LOGGER.debug("fillEntityHtml {}", ENTITY_HTML);
        saveFrontEndTemplate(pConf, model, dmElement, TemplateEnum.FRONT_END_ENTITIES_LOCATION.getLocation(ENTITY_HTML),
                ENTITY_HTML, true, HTML);
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
    private void fillEntityDialogHtml(ProjectConfiguration pConf, Map<String, Object> model,
            Entity dmElement) {
        LOGGER.debug("fillEntityDialogHtml {}", ENTITY_DETAIL_HTML);
        saveFrontEndTemplate(pConf, model, dmElement,
                TemplateEnum.FRONT_END_ENTITIES_LOCATION.getLocation(ENTITY_DIALOG_HTML), ENTITY_DIALOG_HTML, false,
                HTML);
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
    private void fillEntityDialogControllerJs(ProjectConfiguration pConf, Map<String, Object> model,
            Entity dmElement) {
        LOGGER.debug("fillEntityDialogControllerJs {}", ENTITY_DIALOG_CONTROLLER_JS);
        saveFrontEndTemplate(pConf, model, dmElement, TemplateEnum.FRONT_END_ENTITIES_LOCATION,
                ENTITY_DIALOG_CONTROLLER_JS, false);
    }

    /**
     * Fill entity detail controller js.
     *
     * @param pConf
     *            the conf
     * @param model
     *            the model
     * @param dmElement
     *            the dm element
     */
    private void fillEntityDetailControllerJs(ProjectConfiguration pConf, Map<String, Object> model,
            Entity dmElement) {
        LOGGER.debug("fillEntityDetailControllerJs {}", ENTITY_DETAIL_CONTROLLER_JS);
        saveFrontEndTemplate(pConf, model, dmElement, TemplateEnum.FRONT_END_ENTITIES_LOCATION,
                ENTITY_DETAIL_CONTROLLER_JS, false);
    }

    /**
     * Fill entity detail html.
     *
     * @param pConf
     *            the conf
     * @param model
     *            the model
     * @param dmElement
     *            the dm element
     */
    private void fillEntityDetailHtml(ProjectConfiguration pConf, Map<String, Object> model,
            Entity dmElement) {
        LOGGER.debug("fillEntityDetailHtml {}", LayerConstants.ENTITY_DETAIL_HTML);
        saveFrontEndTemplate(pConf, model, dmElement,
                TemplateEnum.FRONT_END_ENTITIES_LOCATION.getLocation(ENTITY_DETAIL_HTML), ENTITY_DETAIL_HTML, false,
                HTML);
    }

    /**
     * Fill entity delete dialog html.
     *
     * @param pConf
     *            the conf
     * @param model
     *            the model
     * @param dmElement
     *            the dm element
     */
    private void fillEntityDeleteDialogHtml(ProjectConfiguration pConf, Map<String, Object> model,
            Entity dmElement) {
        LOGGER.debug("fillEntityDeleteDialogHtml {}", ENTITY_DELETE_DIALOG_HTML);
        saveFrontEndTemplate(pConf, model, dmElement,
                TemplateEnum.FRONT_END_ENTITIES_LOCATION.getLocation(ENTITY_DELETE_DIALOG_HTML),
                ENTITY_DELETE_DIALOG_HTML, false, HTML);
    }

    /**
     * Fill entity delete dialog controller js.
     *
     * @param pConf
     *            the conf
     * @param model
     *            the model
     * @param dmElement
     *            the dm element
     */
    private void fillEntityDeleteDialogControllerJs(ProjectConfiguration pConf, Map<String, Object> model,
            Entity dmElement) {
        LOGGER.debug("fillEntityDeleteDialogControllerJs {}", ENTITY_DELETE_DIALOG_CONTROLLER_JS);
        saveFrontEndTemplate(pConf, model, dmElement, TemplateEnum.FRONT_END_ENTITIES_LOCATION,
                ENTITY_DELETE_DIALOG_CONTROLLER_JS, false);
    }

    /**
     * Save front end template.
     *
     * @param pConf
     *            the conf
     * @param model
     *            the model
     * @param dmElement
     *            the dm element
     * @param templateLocation
     *            the template location
     * @param templateName
     *            the template name
     * @param isPlural
     *            the is plural
     */
    private void saveFrontEndTemplate(ProjectConfiguration pConf, Map<String, Object> model,
            Entity dmElement, TemplateEnum templateLocation, String templateName, boolean isPlural) {
        saveFrontEndTemplate(pConf, model, dmElement, templateLocation.getLocation(templateName), templateName,
                isPlural, JAVASCRIPT);
    }

    /**
     * Save front end template.
     *
     * @param pConf
     *            the conf
     * @param model
     *            the model
     * @param dmElement
     *            the dm element
     * @param templateLocation
     *            the template location
     * @param templateName
     *            the template name
     * @param isPlural
     *            the is plural
     * @param languageType
     *            the language type
     */
    private void saveFrontEndTemplate(ProjectConfiguration pConf, Map<String, Object> model,
            Entity dmElement, Path templateFilePath, String templateName, boolean isPlural,
            LanguageType languageType) {
        String fileNamingConvention = camelCaseToHyphens(dmElement.getCamelCaseFormat());
        String entityName = fileNamingConvention;
        if (isPlural) {
            entityName = camelCaseToHyphens(dmElement.getCamelCasePluralFormat());
        }
        Path relativeFilePath = Paths.get(BasePathEnum.SRC_MAIN_JAVA.toString());
        Path realFilePath = Paths.get(pConf.getOutputDir().toString(), pConf.getId(),
                BasePathEnum.WEB_APP_ENTITIES.getPath(), fileNamingConvention,
                entityName + TemplateFormatter.formatNameTemplate(templateName));
        ModelContext modelContext = EntitiesFactory.createModelContext(model, realFilePath, relativeFilePath,
                templateFilePath, languageType);
        templateService.createGeneratedElement(modelContext).ifPresent(dmElement::addGeneratedElement);
    }

    /**
     * Save internationalization template.
     *
     * @param pConf
     *            the conf
     * @param model
     *            the model
     * @param dmElement
     *            the dm element
     * @param templateLocation
     *            the template location
     * @param templateName
     *            the template name
     * @param idiomaKey
     *            the idioma key
     */
    private void saveInternationalizationTemplate(ProjectConfiguration pConf, Map<String, Object> model,
            Entity dmElement, TemplateEnum templateLocation, String templateName, String idiomaKey) {
        String fileNamingConvention = camelCaseToHyphens(dmElement.getCamelCaseFormat());
        Path relativeFilePath = Paths.get(BasePathEnum.SRC_MAIN_JAVA.toString());
        Path realFilePath = Paths.get(pConf.getOutputDir().toString(), pConf.getId(),
                BasePathEnum.WEB_APP_I18N.getPath(), idiomaKey,
                fileNamingConvention + TemplateFormatter.formatNameTemplate(templateName));
        ModelContext modelContext = EntitiesFactory.createModelContext(model, realFilePath, relativeFilePath,
                templateLocation.getLocation(templateName), LanguageType.JSON);
        templateService.createGeneratedElement(modelContext).ifPresent(dmElement::addGeneratedElement);
    }

    /*
     * (non-Javadoc)
     * 
     * @see mx.infotec.dads.kukulkan.metamodel.generator.Layer#getName()
     */
    @Override
    public String getName() {
        return LayerNameConstants.FrontEnd.AngularJs.SERVICE_NAME;
    }
}
