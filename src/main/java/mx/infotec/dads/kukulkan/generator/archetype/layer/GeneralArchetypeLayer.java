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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.infotec.dads.kukulkan.engine.templating.service.TemplateService;
import mx.infotec.dads.kukulkan.generator.angularjs.service.layers.LayerNameConstants;
import mx.infotec.dads.kukulkan.generator.angularjs.util.ReadFileFromResource;
import mx.infotec.dads.kukulkan.generator.angularjs.util.TemplateFactory;
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

    @Override
    public String getName() {
        return LayerNameConstants.Archetype.AngularJs.LAYER_NAME;
    }

    @Override
    public void processLayer(GeneratorContext context, Map<String, Object> propertiesMap) {
        for (String template : TemplateFactory.TEMPLATE_LIST) {
            Path toSave = createPath(template, context.getProjectConfiguration().getPackaging(),
                    context.getProjectConfiguration().getId());
            if (isFtl(template)) {
                String content = templateService.fillAbstractTemplate(template, propertiesMap);

                FileUtil.saveToFile(toSave, content);
            } else {
                ReadFileFromResource.saveFile(template, toSave);
            }
        }
    }

    private Path createPath(String template, String packaging, String projectid) {
        String newPackaging = packaging.replaceAll("\\.", "/");
        Path temp = Paths.get(template);
        Path parent = temp.getParent();
        String newTemplate = parent.toString()
                .replaceAll("archetypes/angularjs-spring-mongo", prop.getConfig().getOutputdir() + "/" + projectid)
                .replaceAll("package", newPackaging);
        Path targetPath = Paths.get(newTemplate, temp.getFileName().toString().replaceAll(".ftl", ""));
        if (targetPath.getFileName().toString().contains("Kukulkan")) {
            String output = projectid.substring(0, 1).toUpperCase() + projectid.substring(1);
            return Paths.get(targetPath.getParent().toString(), output + "App.java");
        } else {
            return targetPath;
        }
    }

    private boolean isFtl(String template) {
        return template.contains(".ftl");
    }

    public static void main(String[] args) {
        String packaging = "mx.dads.infotec";
        String template = "archetypes/angularjs-spring-mongo/src/main/java/package/service/mapper/package-info.java.ftl";
        String newPackaging = packaging.replaceAll("\\.", "/");
        String newTemplate = template.replaceFirst("archetypes/angularjs-spring-mongo", "/home/danel/archetype")
                .replaceAll(".ftl", "").replaceFirst("package", newPackaging);
        System.out.println(Paths.get(newTemplate));
    }
}
