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

import static mx.infotec.dads.kukulkan.util.GeneratorEntityFactory.createProjectConfiguration;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import mx.infotec.dads.kukulkan.KukulkanEngineApp;
import mx.infotec.dads.kukulkan.engine.service.EngineGenerator;
import mx.infotec.dads.kukulkan.engine.service.FileUtil;
import mx.infotec.dads.kukulkan.engine.translator.Source;
import mx.infotec.dads.kukulkan.engine.translator.TranslatorService;
import mx.infotec.dads.kukulkan.engine.translator.dsl.FileSource;
import mx.infotec.dads.kukulkan.metamodel.context.GeneratorContext;
import mx.infotec.dads.kukulkan.metamodel.foundation.DatabaseType;
import mx.infotec.dads.kukulkan.metamodel.foundation.DomainModel;
import mx.infotec.dads.kukulkan.metamodel.foundation.ProjectConfiguration;

/**
 * Test for GeneratorService
 * 
 * @author Daniel Cortes Pichardo
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = KukulkanEngineApp.class)
public class CrudGenerationServiceTest {

    @Autowired
    private EngineGenerator generationService;

    @Autowired
    @Qualifier("grammarTranslatorService")
    private TranslatorService translatorService;

    @BeforeClass
    public static void runOnceBeforeClass() {

    }

    public void generationService() {
        ProjectConfiguration pConf = createProjectConfiguration(DatabaseType.SQL_MYSQL);
        GeneratorContext genCtx = new GeneratorContext();
        Source source = new FileSource("src/test/resources/grammar/single-entity." + "3k");
        genCtx.put(ProjectConfiguration.class, pConf);
        genCtx.put(DomainModel.class, translatorService.translate(pConf, source));
        // Process Activities
        generationService.process(genCtx);
        FileUtil.saveToFile(genCtx);
    }

    @Test
    public void generationServiceNoSql() {
        ProjectConfiguration pConf = createProjectConfiguration(DatabaseType.NO_SQL_MONGODB);
        // Create GeneratorContext
        GeneratorContext genCtx = new GeneratorContext();
        Source source = new FileSource("src/test/resources/grammar/relationship-entity." + "3k");
        genCtx.put(ProjectConfiguration.class, pConf);
        genCtx.put(DomainModel.class, translatorService.translate(pConf, source));
        genCtx.get(DomainModel.class).ifPresent(dm -> {
            dm.getDomainModelGroup().forEach(group -> {
                group.getEntities().forEach(entity -> {
                    System.out.println("**************");
                    System.out.println(entity.getName());
                    System.out.println("ower Association");
                    entity.getOwnerAssociations().forEach(association -> {
                        System.out.println(association);
                    });
                    System.out.println("Not ower Association");
                    entity.getNotOwnerAssociations().forEach(association -> {
                        System.out.println(association);
                    });
                    System.out.println("**************");
                });
            });

        });
        ;
        generationService.process(genCtx);
        FileUtil.saveToFile(genCtx);
    }
}
