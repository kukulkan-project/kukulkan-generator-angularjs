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

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import mx.infotec.dads.kukulkan.KukulkanEngineApp;
import mx.infotec.dads.kukulkan.engine.service.GenerationService;
import mx.infotec.dads.kukulkan.metamodel.foundation.GeneratorContext;
import mx.infotec.dads.kukulkan.metamodel.foundation.ProjectConfiguration;
import mx.infotec.dads.kukulkan.metamodel.util.FileUtil;

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

	@BeforeClass
	public static void runOnceBeforeClass() {

	}

	@Test
	public void generationService() {
		ProjectConfiguration pConf = new ProjectConfiguration();
		pConf.setId("archetype");
		pConf.setGroupId("mx.infotec.dads.mongo");
		pConf.setVersion("1.0.0");
		pConf.setPackaging("mx.infotec.dads.mongo");
		pConf.setYear("2017");
		pConf.setAuthor("KUKULKAN");
		pConf.setWebLayerName("web.rest");
		pConf.setServiceLayerName("service");
		pConf.setDaoLayerName("repository");
		pConf.setDomainLayerName("domain");
		pConf.setMongoDb(true);

		GeneratorContext genCtx = new GeneratorContext(pConf);
		generationService.findGeneratorByName("angular-js-archetype-generator").ifPresent(generator -> {
			System.out.println("template found");
			System.out.println("***************************");
			System.out.println("***************************");
			System.out.println("***************************");
			System.out.println("***************************");
			System.out.println("***************************");
			System.out.println("***************************");
			System.out.println("***************************");
			System.out.println("***************************");
			generationService.process(genCtx, generator);
		});
	}
}
