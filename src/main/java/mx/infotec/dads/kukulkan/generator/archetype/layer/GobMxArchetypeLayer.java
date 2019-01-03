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

package mx.infotec.dads.kukulkan.generator.archetype.layer;

import static mx.infotec.dads.kukulkan.generator.archetype.layer.WriteResources.generateGobMxAngularJs;
import static mx.infotec.dads.kukulkan.generator.archetype.layer.WriteResources.generateJpaResources;
import static mx.infotec.dads.kukulkan.generator.archetype.layer.WriteResources.generateMongo;
import static mx.infotec.dads.kukulkan.generator.archetype.layer.WriteResources.writeBanner;
import static mx.infotec.dads.kukulkan.generator.util.GeneratorUtils.getBase64Secret;
import static mx.infotec.dads.kukulkan.generator.util.LayerConstants.BASE_64_SECRET_KEY;
import static mx.infotec.dads.kukulkan.generator.util.LayerConstants.BASE_64_SECRET_LENGTH;
import static mx.infotec.dads.kukulkan.metamodel.util.Validator.requiredNotEmpty;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.infotec.dads.kukulkan.engine.service.WriterService;
import mx.infotec.dads.kukulkan.generator.integration.BannerService;
import mx.infotec.dads.kukulkan.generator.util.LayerNameConstants;
import mx.infotec.dads.kukulkan.metamodel.context.GeneratorContext;
import mx.infotec.dads.kukulkan.metamodel.foundation.DatabaseType;
import mx.infotec.dads.kukulkan.metamodel.foundation.ProjectConfiguration;

@Component(LayerNameConstants.Archetype.AngularJs.GOBMX)
public class GobMxArchetypeLayer extends ArchetypeLayer {

    /** The writer service. */
    @Autowired
    private WriterService writer;

    /** The banner service. */
    @Autowired
    private BannerService bannerService;

    @Override
    public String getName() {
        return LayerNameConstants.Archetype.AngularJs.GOBMX;
    }

    @Override
    public void processLayer(GeneratorContext context, Map<String, Object> propertiesMap) {
        ProjectConfiguration pConf = requiredNotEmpty(context.get(ProjectConfiguration.class));
        Optional<Object> maybeSecretKey = context.get(BASE_64_SECRET_KEY);
        if (maybeSecretKey.isPresent()) {
            propertiesMap.put(BASE_64_SECRET_KEY, maybeSecretKey.get().toString());
        } else {
            propertiesMap.put(BASE_64_SECRET_KEY, getBase64Secret(BASE_64_SECRET_LENGTH));
        }
        writeResources(pConf, propertiesMap);
    }

    private void writeResources(ProjectConfiguration pConf, Map<String, Object> propertiesMap) {
        if (pConf.getTargetDatabase().getDatabaseType().equals(DatabaseType.NO_SQL_MONGODB)) {
            generateMongo(writer, pConf, propertiesMap);
        } else {
            generateJpaResources(writer, pConf, propertiesMap);
        }
        generateGobMxAngularJs(writer, pConf, propertiesMap);
        writeBanner(writer, bannerService, pConf);
        pConf.getLayers().remove(LayerNameConstants.Archetype.AngularJs.GOBMX);
    }

}
