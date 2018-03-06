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
package mx.infotec.dads.kukulkan.grammar;

import java.nio.file.Paths;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import mx.infotec.dads.kukulkan.engine.translator.dsl.GrammarSemanticAnalyzer;
import mx.infotec.dads.kukulkan.metamodel.foundation.Database;
import mx.infotec.dads.kukulkan.metamodel.foundation.DatabaseType;
import mx.infotec.dads.kukulkan.metamodel.foundation.ProjectConfiguration;
import mx.infotec.dads.kukulkan.metamodel.util.PKGenerationStrategy;

/**
 * Test for GeneratorService
 * 
 * @author Daniel Cortes Pichardo
 *
 */
@RunWith(SpringRunner.class)
public class KukulkanGrammarTest {

    private static final String EXTENSION = "3k";

    @Test
    public void generationService() throws Exception {
        String program = "src/test/resources/grammar/test." + EXTENSION;

        System.out.println("Interpreting file " + program);

        kukulkanLexer lexer = new kukulkanLexer(new ANTLRFileStream(program));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        kukulkanParser parser = new kukulkanParser(tokens);

        kukulkanParser.DomainModelContext tree = parser.domainModel();

        GrammarSemanticAnalyzer visitor = new GrammarSemanticAnalyzer(getDefaulProjectConfiguration());
        // DataModel dataModel = visitor.visit(tree);
        System.out.println("Interpretation finished");
    }

    private static ProjectConfiguration getDefaulProjectConfiguration() {
        // Create ProjectConfiguration
        ProjectConfiguration pConf = new ProjectConfiguration();
        pConf.setId("kukulkan");
        pConf.setVersion("1.0.0");
        pConf.setPackaging("mx.infotec.dads.archetype");
        pConf.setYear("2017");
        pConf.setAuthor("KUKULKAN");
        pConf.setOutputDir(Paths.get("/home/daniel/git"));
        pConf.setDatabase(new Database(DatabaseType.SQL_MYSQL, PKGenerationStrategy.AUTO));
        return pConf;
    }

}