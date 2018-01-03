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

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.infotec.dads.kukulkan.engine.templating.service.TemplateService;
import mx.infotec.dads.kukulkan.generator.angularjs.service.layers.LayerNameConstants;
import mx.infotec.dads.kukulkan.generator.angularjs.util.TemplateFactory;
import mx.infotec.dads.kukulkan.generator.integration.BannerService;
import mx.infotec.dads.kukulkan.metamodel.foundation.GeneratorContext;
import mx.infotec.dads.kukulkan.metamodel.util.FileUtil;
import mx.infotec.dads.kukulkan.metamodel.util.KukulkanConfigurationProperties;

/**
 * Service Layer Task
 * 
 * @author Daniel Cortes Pichardo
 *
 */
@Component(LayerNameConstants.Archetype.AngularJs.LAYER_NAME)
public class GeneralArchetypeLayer extends ArchetypeLayer {

    @Autowired
    private TemplateService templateService;

    @Autowired
    private KukulkanConfigurationProperties prop;

    @Autowired
    private BannerService bannerService;

    @Override
    public String getName() {
        return LayerNameConstants.Archetype.AngularJs.LAYER_NAME;
    }

    @Override
    public void processLayer(GeneratorContext context, Map<String, Object> propertiesMap) {
        for (String template : TemplateFactory.TEMPLATE_LIST) {
            Path toSave = createToSavePath(context, template);
            processTemplate(context, propertiesMap, template, toSave);
        }
    }

    private Path createToSavePath(GeneratorContext context, String template) {
        return createPath(template, context.getProjectConfiguration().getPackaging(),
                context.getProjectConfiguration().getId());
    }

    private void processTemplate(GeneratorContext context, Map<String, Object> propertiesMap, String template,
            Path toSave) {
        if (isFtlFile(template)) {
            String content = templateService.fillAbstractTemplate(template, propertiesMap);
            FileUtil.saveToFile(toSave, content);
        } else if (template.contains("banner.txt")) {
            createBanner(context, template, toSave);
        } else {
            FileUtil.copyFromJar("templates/" + template, toSave);
        }
    }

    private void createBanner(GeneratorContext context, String template, Path toSave) {
        Optional<String> generateBanner = bannerService.generateBanner(context.getProjectConfiguration().getId());
        if (generateBanner.isPresent()) {
            FileUtil.saveToFile(toSave, generateBanner.get());
        } else {
            FileUtil.copyFromJar("templates/" + template, toSave);
        }
    }

    private Path createPath(String template, String packaging, String projectid) {
        String newPackaging = packaging.replaceAll("\\.", "/");
        Path temp = Paths.get(template);
        Path parent = temp.getParent();
        String newTemplate = createTemplatePath(projectid, newPackaging, parent);
        Path targetPath = Paths.get(newTemplate, temp.getFileName().toString().replaceAll(".ftl", ""));
        return createOutputPath(projectid, targetPath);
    }

    private Path createOutputPath(String projectid, Path targetPath) {
        if (targetPath.getFileName().toString().contains("Kukulkan")) {
            String output = projectid.substring(0, 1).toUpperCase() + projectid.substring(1);
            return Paths.get(targetPath.getParent().toString(), output + "App.java");
        } else {
            return targetPath;
        }
    }

    private String createTemplatePath(String projectid, String newPackaging, Path parent) {
        return parent.toString()
                .replaceAll("archetypes/angularjs-spring-mongo", prop.getConfig().getOutputdir() + "/" + projectid)
                .replaceAll("package", newPackaging);
    }

    private boolean isFtlFile(String template) {
        return template.contains(".ftl");
    }
}
