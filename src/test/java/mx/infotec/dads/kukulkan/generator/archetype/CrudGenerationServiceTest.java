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

import static mx.infotec.dads.kukulkan.util.ChecksumUtils.computeHashesMap;
import static mx.infotec.dads.kukulkan.util.GeneratorEntityFactory.createProjectConfiguration;
import static mx.infotec.dads.kukulkan.util.GeneratorEntityFactory.createProjectConfigurationJustModel;
import static org.junit.Assert.fail;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
import mx.infotec.dads.kukulkan.engine.service.GenerationService;
import mx.infotec.dads.kukulkan.engine.translator.dsl.FileSource;
import mx.infotec.dads.kukulkan.metamodel.context.GeneratorContext;
import mx.infotec.dads.kukulkan.metamodel.conventions.CodeStandard;
import mx.infotec.dads.kukulkan.metamodel.foundation.Database;
import mx.infotec.dads.kukulkan.metamodel.foundation.DatabaseType;
import mx.infotec.dads.kukulkan.metamodel.foundation.DomainModel;
import mx.infotec.dads.kukulkan.metamodel.foundation.ProjectConfiguration;
import mx.infotec.dads.kukulkan.metamodel.translator.Source;
import mx.infotec.dads.kukulkan.metamodel.translator.TranslatorService;
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
    private EngineGenerator engineGenerator;

    @Autowired
    private GenerationService generationService;

    @Autowired
    @Qualifier("grammarTranslatorService")
    private TranslatorService translatorService;

    private static Path outputDir = null;
    private static final String idProject = "testcase";
    private static final String baseProject = "src/test/resources/relationships/" + idProject;
    private static final String csvHashesBaseProject = "src/test/resources/relationships/hashes.csv";

    @BeforeClass
    public static void runOnceBeforeClass() {
        outputDir = TemporalDirectoryUtil.getTemporalPath();
    }

    public void generationService() {
        ProjectConfiguration pConf = createProjectConfiguration(DatabaseType.SQL_MYSQL);
        GeneratorContext genCtx = new GeneratorContext();
        Source source = new FileSource("src/test/resources/grammar/single-entity." + "3k");
        genCtx.put(ProjectConfiguration.class, pConf);
        genCtx.put(DomainModel.class, translatorService.translate(pConf, source));
        // Process Activities
        engineGenerator.process(genCtx);
        FileUtil.saveToFile(genCtx);
    }

    @Test
    public void generationRelationshipService() {
        ProjectConfiguration pConf = createProjectConfigurationJustModel(DatabaseType.SQL_MYSQL);
        // Create GeneratorContext
        GeneratorContext genCtx = new GeneratorContext();
        Source source = new FileSource("src/test/resources/grammar/simple-relationship." + "3k");
        genCtx.put(ProjectConfiguration.class, pConf);
        genCtx.put(DomainModel.class, translatorService.translate(pConf, source));
        engineGenerator.process(genCtx);
        FileUtil.saveToFile(genCtx);
    }

    public void generationServiceNoSql() {
        ProjectConfiguration pConf = createProjectConfiguration(DatabaseType.NO_SQL_MONGODB);
        // Create GeneratorContext
        GeneratorContext genCtx = new GeneratorContext();
        Source source = new FileSource("src/test/resources/grammar/relationship-entity." + "3k");
        genCtx.put(ProjectConfiguration.class, pConf);
        genCtx.put(DomainModel.class, translatorService.translate(pConf, source));
        engineGenerator.process(genCtx);
        FileUtil.saveToFile(genCtx);
    }

    @Test
    public void generateProjectAndCrudFromRelationshipsTestCase()
            throws IOException, NoSuchAlgorithmException, ClassNotFoundException {
        String domainModel3k = "src/test/resources/relationships/Model.3k";
        ProjectConfiguration pConf = new ProjectConfiguration();
        pConf.setId(idProject);
        pConf.setPackaging("mx.infotec.dads.archetype");
        pConf.setYear("2018");
        pConf.setAuthor("kukulkan");
        pConf.setOutputDir(outputDir);
        pConf.setTargetDatabase(new Database(DatabaseType.SQL_MYSQL));
        pConf.setTimestamp(LocalDateTime.of(2018, 01, 01, 00, 00, 00));
        pConf.addLayers("angular-js", "spring-rest", "spring-service", "spring-repository", "domain-core", "liquibase");
        pConf.getLayersToProcess().add("angular-js");
        pConf.getLayersToProcess().add("spring-rest");
        pConf.getLayersToProcess().add("spring-service");
        pConf.getLayersToProcess().add("spring-repository");
        pConf.getLayersToProcess().add("domain-core");
        pConf.getLayersToProcess().add("liquibase");

        // Create GeneratorContext
        GeneratorContext genCtx = new GeneratorContext();
        Source source = new FileSource(domainModel3k);
        genCtx.put(ProjectConfiguration.class, pConf);
        genCtx.put(DomainModel.class, translatorService.translate(pConf, source));
        generationService.findGeneratorByName("angular-js-archetype-generator").ifPresent(generator -> {
            generationService.process(genCtx, generator);
        });
        engineGenerator.process(genCtx);
        Files.copy(Paths.get(domainModel3k), outputDir.resolve(idProject + "/Model.3k"),
                StandardCopyOption.REPLACE_EXISTING);
        FileUtil.saveToFile(genCtx);
        compareGeneratedAgainstBaseProject();
    }

    /**
     * Generates a project and generates a CRUD from a Kukulkan file (3k) then
     * computes the checksum for every generated file and compares to checksum from
     * a base project
     * 
     * @throws NoSuchAlgorithmException
     * @throws IOException
     * @throws ClassNotFoundException
     */

    public void compareGeneratedAgainstBaseProject()
            throws NoSuchAlgorithmException, IOException, ClassNotFoundException {
        Map<String, String> hashesBase = computeHashesMap(baseProject);
        writeCsvHashes(hashesBase, csvHashesBaseProject);
        Map<String, String> hashesGenerated = computeHashesMap(outputDir.resolve(idProject).toString());

        Set<String> keySetBase = hashesBase.keySet();
        Set<String> keySetGenerated = hashesBase.keySet();

        Set<String> failedFiles = new HashSet<>();
        for (String fileName : keySetBase) {
            String hashBase = hashesBase.get(fileName);
            String hashGenerated = hashesGenerated.get(fileName);
            if (!hashBase.equals(hashGenerated)) {
                failedFiles.add(fileName);
            }
        }

        if (!failedFiles.isEmpty()) {
            fail("Unequal checksums: " + failedFiles);
        }
        if (keySetBase.size() > keySetGenerated.size()) {
            keySetBase.removeAll(keySetGenerated);
            fail("Some files are missing: " + keySetBase);
        } else if (keySetBase.size() < keySetGenerated.size()) {
            keySetGenerated.removeAll(keySetBase);
            fail("Extra files were generated: " + keySetGenerated);
        }
    }

    public static void writeCsvHashes(Map<String, String> hashes, String pathname) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(pathname));) {
            for (String key : hashes.keySet()) {
                writer.write(key + "," + hashes.get(key));
                writer.newLine();
            }
        } catch (IOException e) {
            fail("Exception while writing on " + pathname + ": " + e.getMessage());
        }
    }
}
