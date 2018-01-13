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
package mx.infotec.dads.kukulkan.generator.archetype;

import java.nio.file.Paths;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import mx.infotec.dads.kukulkan.KukulkanEngineApp;
import mx.infotec.dads.kukulkan.engine.service.GenerationService;
import mx.infotec.dads.kukulkan.generator.integration.BannerService;
import mx.infotec.dads.kukulkan.metamodel.foundation.GeneratorContext;
import mx.infotec.dads.kukulkan.metamodel.foundation.ProjectConfiguration;

/**
 * Test for GeneratorService
 * 
 * @author Daniel Cortes Pichardo
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = KukulkanEngineApp.class)
public class AngularJsArchetypeGenerationTest {

    @Autowired
    private GenerationService generationService;

    @Autowired
    private BannerService bannerService;

    @BeforeClass
    public static void runOnceBeforeClass() {

    }

    @Test
    public void generationService() {
        ProjectConfiguration pConf = new ProjectConfiguration();
        pConf.setId("refac");
        pConf.setGroupId("mx.infotec.dads.mongo");
        pConf.setVersion("1.0.0");
        pConf.setPackaging("mx.infotec.dads.mongo");
        pConf.setYear("2017");
        pConf.setOutputDir(Paths.get("/home/daniel/refactoring"));
        pConf.setMongoDb(true);
        GeneratorContext genCtx = new GeneratorContext();
        genCtx.put(ProjectConfiguration.class, pConf);
        generationService.findGeneratorByName("angular-js-archetype-generator").ifPresent(generator -> {
            generationService.process(genCtx, generator);
        });
    }

    // @Test
    public void bannerGenerator() {
        // File file = ResourceUtils.getFile("classpath:templates/error.html");
        //
        // // File is found
        // System.out.println("File Found : " + file.exists());
        //
        // // Read File Content
        // String content = new String(Files.readAllBytes(file.toPath()));
        // System.out.println(content);
        System.out.println(bannerService.generateBanner("kukulkan"));
    }
}
