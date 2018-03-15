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
package mx.infotec.dads.kukulkan.generator.archetype.layer;

import static mx.infotec.dads.kukulkan.metamodel.util.Validator.requiredNotEmpty;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.infotec.dads.kukulkan.engine.templating.service.TemplateService;
import mx.infotec.dads.kukulkan.metamodel.template.TemplateInfo;
import mx.infotec.dads.kukulkan.metamodel.template.TemplateType;
import mx.infotec.dads.kukulkan.generator.integration.BannerService;
import mx.infotec.dads.kukulkan.generator.util.LayerNameConstants;
import mx.infotec.dads.kukulkan.generator.util.TemplateFactory;
import mx.infotec.dads.kukulkan.metamodel.context.GeneratorContext;
import mx.infotec.dads.kukulkan.metamodel.foundation.DatabaseType;
import mx.infotec.dads.kukulkan.metamodel.foundation.ProjectConfiguration;
import mx.infotec.dads.kukulkan.metamodel.util.FileUtil;

/**
 * Service Layer Task.
 *
 * @author Daniel Cortes Pichardo
 */
@Component(LayerNameConstants.Archetype.AngularJs.LAYER_NAME)
public class GeneralArchetypeLayer extends ArchetypeLayer {

    /** The template service. */
    @Autowired
    private TemplateService templateService;

    /** The banner service. */
    @Autowired
    private BannerService bannerService;

    /*
     * (non-Javadoc)
     * 
     * @see mx.infotec.dads.kukulkan.metamodel.generator.Layer#getName()
     */
    @Override
    public String getName() {
        return LayerNameConstants.Archetype.AngularJs.LAYER_NAME;
    }

    /*
     * (non-Javadoc)
     * 
     * @see mx.infotec.dads.kukulkan.generator.archetype.layer.ArchetypeLayer#
     * processLayer(mx.infotec.dads.kukulkan.metamodel.foundation.
     * GeneratorContext, java.util.Map)
     */
    @Override
    public void processLayer(GeneratorContext context, Map<String, Object> propertiesMap) {
        ProjectConfiguration pConf = requiredNotEmpty(context.get(ProjectConfiguration.class));
        for (TemplateInfo templateInfo : getTemplatesToProcess(pConf)) {
            Path toSave = createToSavePath(context, templateInfo, pConf.getOutputDir());
            processTemplate(context, propertiesMap, templateInfo, toSave);
        }
    }

    private List<TemplateInfo> getTemplatesToProcess(ProjectConfiguration pConf) {
        List<TemplateInfo> templateList = new ArrayList<>();
        if (pConf.getDatabase().getDatabaseType().equals(DatabaseType.NO_SQL_MONGODB)) {
            templateList.addAll(TemplateFactory.MONGO_TEMPLATE_LIST);
        } else {
            templateList.addAll(TemplateFactory.JPA_TEMPLATE_LIST);
        }
        templateList.addAll(TemplateFactory.ANGULAR_JS_TEMPLATE_LIST);
        return templateList;
    }

    /**
     * Creates the to save path.
     *
     * @param context
     *            the context
     * @param template
     *            the template
     * @param outputPath
     *            the output path
     * @return the path
     */
    private Path createToSavePath(GeneratorContext context, TemplateInfo template, Path outputPath) {
        ProjectConfiguration pConf = requiredNotEmpty(context.get(ProjectConfiguration.class));
        return createPath(template, pConf.getPackaging(), pConf.getId(), outputPath);
    }

    /**
     * Process template.
     *
     * @param context
     *            the context
     * @param propertiesMap
     *            the properties map
     * @param template
     *            the template
     * @param toSave
     *            the to save
     */
    private void processTemplate(GeneratorContext context, Map<String, Object> propertiesMap, TemplateInfo template,
            Path toSave) {
        if (isFtlFile(template.getFilePath())) {
            String content = templateService.fillTemplate(template.getTemplatePath(), propertiesMap);
            FileUtil.saveToFile(toSave, content);
        } else if (template.getFilePath().contains("banner.txt")) {
            createBanner(context, template, toSave);
        } else {
            FileUtil.copyFromJar("templates/" + template.getTemplatePath(), toSave);
        }
    }

    /**
     * Creates the banner.
     *
     * @param context
     *            the context
     * @param template
     *            the template
     * @param toSave
     *            the to save
     */
    private void createBanner(GeneratorContext context, TemplateInfo template, Path toSave) {
        ProjectConfiguration pConf = requiredNotEmpty(context.get(ProjectConfiguration.class));
        Optional<String> generateBanner = bannerService.generateBanner(pConf.getId());
        if (generateBanner.isPresent()) {
            FileUtil.saveToFile(toSave, generateBanner.get());
        } else {
            FileUtil.copyFromJar("templates/" + template.getBaseFolder() + template.getFilePath(), toSave);
        }
    }

    /**
     * Creates the path.
     *
     * @param template
     *            the template
     * @param packaging
     *            the packaging
     * @param projectid
     *            the projectid
     * @param outputPath
     *            the output path
     * @param isMongodb
     * @return the path
     */
    private Path createPath(TemplateInfo template, String packaging, String projectid, Path outputPath) {
        String newPackaging = packaging.replaceAll("\\.", "/");
        Path temp = Paths.get(template.getFilePath());
        Path parent = Optional.ofNullable(temp.getParent()).orElse(Paths.get(""));
        String newTemplate = createTemplatePath(newPackaging, parent);
        Path targetPath = Paths.get(outputPath.toString(), projectid, newTemplate,
                temp.getFileName().toString().replaceAll(".ftl", ""));
        return createOutputPath(projectid, targetPath);
    }

    /**
     * Creates the output path.
     *
     * @param projectid
     *            the projectid
     * @param targetPath
     *            the target path
     * @return the path
     */
    private Path createOutputPath(String projectid, Path targetPath) {
        Objects.requireNonNull(projectid, "project id cannot be null");
        Objects.requireNonNull(targetPath, "targetPath cannot be null");
        if (targetPath.getFileName().toString().contains("Kukulkan")) {
            String output = projectid.substring(0, 1).toUpperCase() + projectid.substring(1);
            return Paths.get(targetPath.getParent().toString(), output + "App.java");
        } else {
            return targetPath;
        }
    }

    /**
     * Creates the template path.
     *
     * @param projectid
     *            the projectid
     * @param newPackaging
     *            the new packaging
     * @param parent
     *            the parent
     * @param outputPath
     *            the output path
     * @param isMongodb
     * @return the string
     */
    private String createTemplatePath(String newPackaging, Path parent) {
        return parent.toString().replaceAll("package", newPackaging);
    }

    /**
     * Checks if is ftl file.
     *
     * @param template
     *            the template
     * @return true, if is ftl file
     */
    private boolean isFtlFile(String template) {
        return template.contains(".ftl");
    }
}
