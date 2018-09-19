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
import static mx.infotec.dads.kukulkan.generator.util.LayerConstants.ENTITY_HANDSONTABLE_CONTROLLER_JS;
import static mx.infotec.dads.kukulkan.generator.util.LayerConstants.ENTITY_HANDSONTABLE_HTML;
import static mx.infotec.dads.kukulkan.generator.util.LayerConstants.ENTITY_HANDSONTABLE_SERVICE_JS;
import static mx.infotec.dads.kukulkan.generator.util.LayerConstants.ENTITY_HANDSONTABLE_STATE_JS;
import static mx.infotec.dads.kukulkan.generator.util.LayerConstants.ENTITY_HTML;
import static mx.infotec.dads.kukulkan.generator.util.LayerConstants.ENTITY_SEARCH_SERVICE_JS;
import static mx.infotec.dads.kukulkan.generator.util.LayerConstants.ENTITY_SERVICE_JS;
import static mx.infotec.dads.kukulkan.generator.util.LayerConstants.ENTITY_STATE_JS;
import static mx.infotec.dads.kukulkan.generator.util.LayerConstants.IDIOMA_JS;
import static mx.infotec.dads.kukulkan.metamodel.editor.LanguageType.HTML;
import static mx.infotec.dads.kukulkan.metamodel.editor.LanguageType.JAVASCRIPT;
import static mx.infotec.dads.kukulkan.metamodel.util.Validator.requiredNotEmpty;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.infotec.dads.kukulkan.engine.model.AbstractNavigableLayer;
import mx.infotec.dads.kukulkan.engine.model.ModelContext;
import mx.infotec.dads.kukulkan.engine.service.WriterService;
import mx.infotec.dads.kukulkan.engine.templating.service.TemplateService;
import mx.infotec.dads.kukulkan.generator.util.EntitiesFactory;
import mx.infotec.dads.kukulkan.generator.util.LayerConstants;
import mx.infotec.dads.kukulkan.generator.util.LayerNameConstants;
import mx.infotec.dads.kukulkan.generator.util.TemplateEnum;
import mx.infotec.dads.kukulkan.generator.util.TemplateFormatter;
import mx.infotec.dads.kukulkan.metamodel.context.GeneratorContext;
import mx.infotec.dads.kukulkan.metamodel.editor.LanguageType;
import mx.infotec.dads.kukulkan.metamodel.foundation.DomainModel;
import mx.infotec.dads.kukulkan.metamodel.foundation.DomainModelGroup;
import mx.infotec.dads.kukulkan.metamodel.foundation.Entity;
import mx.infotec.dads.kukulkan.metamodel.foundation.ProjectConfiguration;
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

    @Autowired
    private WriterService writerService;

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
        fillNavBar(pConf, domainModel);
        fillIdiomaGlobalEsJs(templateService, pConf, model, domainModel);
        fillIdiomaGlobalEnJs(templateService, pConf, model, domainModel);
    }

    /*
     * (non-Javadoc)
     * 
     * @see mx.infotec.dads.kukulkan.metamodel.generator.NavigableLayer#
     * visitDomainModelElement(mx.infotec.dads.kukulkan.metamodel.foundation.
     * ProjectConfiguration, java.util.Collection, java.util.Map, java.lang.String,
     * mx.infotec.dads.kukulkan.metamodel.foundation.Entity, java.lang.String)
     */
    @Override
    public void visitEntity(ProjectConfiguration pConf, Collection<Entity> dmElementCollection,
            Map<String, Object> propertiesMap, String dmgName, Entity dmElement, String basePackage) {
        fillEntityControllerJs(templateService, pConf, propertiesMap, dmElement);
        fillEntityHtml(pConf, propertiesMap, dmElement);
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

    /**
     * Fill nav bar.
     *
     * @param pConf
     *            the conf
     * @param domainModel
     *            the domain model
     */
    private void fillNavBar(ProjectConfiguration pConf, DomainModel domainModel) {
        for (DomainModelGroup domainModelGroup : domainModel.getDomainModelGroup()) {
            for (Entity entity : domainModelGroup.getEntities()) {
                writerService.addEntityMenuEntry("rest-spring-jpa/frontEnd/menu-entry.html.ftl", pConf.getOutputDir(),
                        entity);
            }
        }
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
    static void fillIdiomaGlobalEnJs(TemplateService templateService, ProjectConfiguration pConf,
            Map<String, Object> model, DomainModel domainModel) {

        Path templateFilePath = TemplateEnum.FRONT_END_I18N_LOCATION_EN.getLocation("global.json.ftl");
        Path relativeFilePath = Paths.get(BasePathEnum.WEB_APP_I18N.getPath(), "en/global.json");
        Path realFilePath = pConf.getOutputDir().resolve(BasePathEnum.WEB_APP_I18N.getPath()).resolve("en/global.json");
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
    static void fillIdiomaGlobalEsJs(TemplateService templateService, ProjectConfiguration pConf,
            Map<String, Object> model, DomainModel domainModel) {
        Path templateFilePath = TemplateEnum.FRONT_END_I18N_LOCATION_ES.getLocation("global.json.ftl");
        Path relativeFilePath = Paths.get(BasePathEnum.WEB_APP_I18N.getPath(), "es/global.json");
        Path realFilePath = pConf.getOutputDir().resolve(BasePathEnum.WEB_APP_I18N.getPath()).resolve("es/global.json");
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
    static void fillEntityControllerJs(TemplateService templateService, ProjectConfiguration pConf,
            Map<String, Object> model, Entity dmElement) {
        if (dmElement.getFeatures().isSheetable()) {
            LOGGER.debug("fillEntityHandsontableControllerJs {}", ENTITY_HANDSONTABLE_CONTROLLER_JS);
            saveFrontEndTemplate(templateService, pConf, model, dmElement, TemplateEnum.FRONT_END_ENTITIES_LOCATION,
                    ENTITY_HANDSONTABLE_CONTROLLER_JS, false);
        } else {
            LOGGER.debug("fillEntityControllerJs {}", ENTITY_CONTROLLER_JS);
            saveFrontEndTemplate(templateService, pConf, model, dmElement, TemplateEnum.FRONT_END_ENTITIES_LOCATION,
                    ENTITY_CONTROLLER_JS, false);
        }
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
    static void fillIdiomaEsJs(TemplateService templateService, ProjectConfiguration pConf, Map<String, Object> model,
            Entity dmElement) {
        LOGGER.debug("fillIdiomaEsJs {}", IDIOMA_JS);
        saveInternationalizationTemplate(templateService, pConf, model, dmElement,
                TemplateEnum.FRONT_END_I18N_LOCATION_ES, IDIOMA_JS, "es");
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
    static void fillIdiomaEnJs(TemplateService templateService, ProjectConfiguration pConf, Map<String, Object> model,
            Entity dmElement) {
        LOGGER.debug("fillIdiomaEnJs {}", IDIOMA_JS);
        saveInternationalizationTemplate(templateService, pConf, model, dmElement,
                TemplateEnum.FRONT_END_I18N_LOCATION_EN, IDIOMA_JS, "en");
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
    static void fillEntityStateJs(TemplateService templateService, ProjectConfiguration pConf,
            Map<String, Object> model, Entity dmElement) {
        if (dmElement.getFeatures().isSheetable()) {
            LOGGER.debug("fillEntityHandsontableStateJs {}", ENTITY_HANDSONTABLE_STATE_JS);
            saveFrontEndTemplate(templateService, pConf, model, dmElement, TemplateEnum.FRONT_END_ENTITIES_LOCATION,
                    ENTITY_HANDSONTABLE_STATE_JS, false);
        } else {
            LOGGER.debug("fillEntityStateJs {}", ENTITY_STATE_JS);
            saveFrontEndTemplate(templateService, pConf, model, dmElement, TemplateEnum.FRONT_END_ENTITIES_LOCATION,
                    ENTITY_STATE_JS, false);
        }
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
    static void fillEntityServiceJs(TemplateService templateService, ProjectConfiguration pConf,
            Map<String, Object> model, Entity dmElement) {
        if (dmElement.getFeatures().isSheetable()) {
            LOGGER.debug("fillEntityHandsontableServiceJs {}", ENTITY_HANDSONTABLE_SERVICE_JS);
            saveFrontEndTemplate(templateService, pConf, model, dmElement, TemplateEnum.FRONT_END_ENTITIES_LOCATION,
                    ENTITY_HANDSONTABLE_SERVICE_JS, false);
        }
        LOGGER.debug("fillEntityServiceJs {}", ENTITY_SERVICE_JS);
        saveFrontEndTemplate(templateService, pConf, model, dmElement, TemplateEnum.FRONT_END_ENTITIES_LOCATION,
                ENTITY_SERVICE_JS, false);
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
    static void fillEntitySearchServiceJs(TemplateService templateService, ProjectConfiguration pConf,
            Map<String, Object> model, Entity dmElement) {
        LOGGER.debug("fillEntitySearchServiceJs {}", ENTITY_SEARCH_SERVICE_JS);
        saveFrontEndTemplate(templateService, pConf, model, dmElement, TemplateEnum.FRONT_END_ENTITIES_LOCATION,
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
        if (dmElement.getFeatures().isSheetable()) {
            LOGGER.debug("fillEntityHandsontableHtml {}", ENTITY_HANDSONTABLE_HTML);
            saveFrontEndTemplate(templateService, pConf, model, dmElement,
                    TemplateEnum.FRONT_END_ENTITIES_LOCATION.getLocation(ENTITY_HANDSONTABLE_HTML),
                    ENTITY_HANDSONTABLE_HTML, true, HTML);
        } else {
            LOGGER.debug("fillEntityHtml {}", ENTITY_HTML);
            saveFrontEndTemplate(templateService, pConf, model, dmElement,
                    TemplateEnum.FRONT_END_ENTITIES_LOCATION.getLocation(ENTITY_HTML), ENTITY_HTML, true, HTML);
        }
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
    static void fillEntityDialogHtml(TemplateService templateService, ProjectConfiguration pConf,
            Map<String, Object> model, Entity dmElement) {
        LOGGER.debug("fillEntityDialogHtml {}", ENTITY_DETAIL_HTML);
        saveFrontEndTemplate(templateService, pConf, model, dmElement,
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
    static void fillEntityDialogControllerJs(TemplateService templateService, ProjectConfiguration pConf,
            Map<String, Object> model, Entity dmElement) {
        LOGGER.debug("fillEntityDialogControllerJs {}", ENTITY_DIALOG_CONTROLLER_JS);
        saveFrontEndTemplate(templateService, pConf, model, dmElement, TemplateEnum.FRONT_END_ENTITIES_LOCATION,
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
    static void fillEntityDetailControllerJs(TemplateService templateService, ProjectConfiguration pConf,
            Map<String, Object> model, Entity dmElement) {
        LOGGER.debug("fillEntityDetailControllerJs {}", ENTITY_DETAIL_CONTROLLER_JS);
        saveFrontEndTemplate(templateService, pConf, model, dmElement, TemplateEnum.FRONT_END_ENTITIES_LOCATION,
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
    static void fillEntityDetailHtml(TemplateService templateService, ProjectConfiguration pConf,
            Map<String, Object> model, Entity dmElement) {
        LOGGER.debug("fillEntityDetailHtml {}", LayerConstants.ENTITY_DETAIL_HTML);
        saveFrontEndTemplate(templateService, pConf, model, dmElement,
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
    static void fillEntityDeleteDialogHtml(TemplateService templateService, ProjectConfiguration pConf,
            Map<String, Object> model, Entity dmElement) {
        LOGGER.debug("fillEntityDeleteDialogHtml {}", ENTITY_DELETE_DIALOG_HTML);
        saveFrontEndTemplate(templateService, pConf, model, dmElement,
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
    static void fillEntityDeleteDialogControllerJs(TemplateService templateService, ProjectConfiguration pConf,
            Map<String, Object> model, Entity dmElement) {
        LOGGER.debug("fillEntityDeleteDialogControllerJs {}", ENTITY_DELETE_DIALOG_CONTROLLER_JS);
        saveFrontEndTemplate(templateService, pConf, model, dmElement, TemplateEnum.FRONT_END_ENTITIES_LOCATION,
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
    static void saveFrontEndTemplate(TemplateService templateService, ProjectConfiguration pConf,
            Map<String, Object> model, Entity dmElement, TemplateEnum templateLocation, String templateName,
            boolean isPlural) {
        saveFrontEndTemplate(templateService, pConf, model, dmElement, templateLocation.getLocation(templateName),
                templateName, isPlural, JAVASCRIPT);
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
    static void saveFrontEndTemplate(TemplateService templateService, ProjectConfiguration pConf,
            Map<String, Object> model, Entity dmElement, Path templateFilePath, String templateName, boolean isPlural,
            LanguageType languageType) {
        String fileNamingConvention = dmElement.getHyphensFormat();
        String entityName = fileNamingConvention;
        if (isPlural) {
            entityName = dmElement.getHyphensPluralFormat();
        }
        Path relativeFilePath = Paths.get(BasePathEnum.WEB_APP_ENTITIES.getPath(), fileNamingConvention,
                entityName + TemplateFormatter.formatNameTemplate(templateName));
        Path realFilePath = pConf.getOutputDir().resolve(BasePathEnum.WEB_APP_ENTITIES.getPath())
                .resolve(fileNamingConvention).resolve(entityName + TemplateFormatter.formatNameTemplate(templateName));
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
    static void saveInternationalizationTemplate(TemplateService templateService, ProjectConfiguration pConf,
            Map<String, Object> model, Entity dmElement, TemplateEnum templateLocation, String templateName,
            String idiomaKey) {
        String fileNamingConvention = dmElement.getHyphensFormat();
        Path relativeFilePath = Paths.get(BasePathEnum.WEB_APP_I18N.getPath()).resolve(idiomaKey)
                .resolve(fileNamingConvention + TemplateFormatter.formatNameTemplate(templateName));
        Path realFilePath = pConf.getOutputDir().resolve(BasePathEnum.WEB_APP_I18N.getPath()).resolve(idiomaKey)
                .resolve(fileNamingConvention + TemplateFormatter.formatNameTemplate(templateName));
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
