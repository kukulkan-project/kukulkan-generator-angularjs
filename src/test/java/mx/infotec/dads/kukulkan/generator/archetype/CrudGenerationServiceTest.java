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

import java.time.LocalDateTime;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import mx.infotec.dads.kukulkan.KukulkanEngineApp;
import mx.infotec.dads.kukulkan.engine.service.EngineGenerator;
import mx.infotec.dads.kukulkan.engine.service.InflectorService;
import mx.infotec.dads.kukulkan.engine.translator.dsl.GrammarMapping;
import mx.infotec.dads.kukulkan.engine.translator.dsl.GrammarSemanticAnalyzer;
import mx.infotec.dads.kukulkan.metamodel.context.GeneratorContext;
import mx.infotec.dads.kukulkan.metamodel.foundation.Database;
import mx.infotec.dads.kukulkan.metamodel.foundation.DatabaseType;
import mx.infotec.dads.kukulkan.metamodel.foundation.DomainModel;
import mx.infotec.dads.kukulkan.metamodel.foundation.DomainModelGroup;
import mx.infotec.dads.kukulkan.metamodel.foundation.JavaDomainModel;
import mx.infotec.dads.kukulkan.metamodel.foundation.ProjectConfiguration;
import mx.infotec.dads.kukulkan.metamodel.util.FileUtil;
import mx.infotec.dads.kukulkan.metamodel.util.PKGenerationStrategy;
import mx.infotec.dads.kukulkan.util.TemporalDirectoryUtil;

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
    private InflectorService inflectorService;

    @BeforeClass
    public static void runOnceBeforeClass() {

    }

    @Test
    public void generationService() {
        // Create ProjectConfiguration
        ProjectConfiguration pConf = new ProjectConfiguration();
        pConf.setId("kukulkan");
        pConf.setVersion("1.0.0");
        pConf.setPackaging("mx.infotec.dads.archetype");
        pConf.setYear("2017");
        pConf.setAuthor("KUKULKAN");
        pConf.setOutputDir(TemporalDirectoryUtil.getTemporalPath());
        pConf.setDatabase(new Database(DatabaseType.SQL_MYSQL, PKGenerationStrategy.IDENTITY));
        pConf.setTimestamp(LocalDateTime.of(2018, 03, 03, 18, 52, 22));
        pConf.addLayers("angular-js", "spring-rest", "spring-service", "spring-repository", "liquibase", "domain-core");
        // Create DataModel
        DomainModel domainModel = new JavaDomainModel();
        // Mapping DataContext into DataModel
        List<DomainModelGroup> dmgList = GrammarMapping
                .createSingleTestDataModelGroupList(new GrammarSemanticAnalyzer(pConf, inflectorService));
        domainModel.setDomainModelGroup(dmgList);
        // Create GeneratorContext
        GeneratorContext genCtx = new GeneratorContext();
        genCtx.put(ProjectConfiguration.class, pConf);
        genCtx.put(DomainModel.class, domainModel);
        // Process Activities
        generationService.process(genCtx);
        FileUtil.saveToFile(genCtx);
    }
}
