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
package mx.infotec.dads.kukulkan.generator.angularjs.dbmigrations;

import static mx.infotec.dads.kukulkan.generator.angularjs.util.EntitiesFactory.createAtlasDataStore;
import static mx.infotec.dads.kukulkan.generator.angularjs.util.EntitiesFactory.createDefaultDataStoreType;
import static mx.infotec.dads.kukulkan.generator.angularjs.util.EntitiesFactory.createDefaultPluralRuleType;
import static mx.infotec.dads.kukulkan.generator.angularjs.util.EntitiesFactory.createDefaultSingularRuleType;
import static mx.infotec.dads.kukulkan.generator.angularjs.util.EntitiesFactory.createEsRule;
import static mx.infotec.dads.kukulkan.generator.angularjs.util.EntitiesFactory.createGrammarDataStore;
import static mx.infotec.dads.kukulkan.generator.angularjs.util.EntitiesFactory.createGrammarDataStoreType;
import static mx.infotec.dads.kukulkan.generator.angularjs.util.EntitiesFactory.createOsRule;
import static mx.infotec.dads.kukulkan.generator.angularjs.util.EntitiesFactory.createTestDataStore;

import org.springframework.data.mongodb.core.MongoTemplate;

import com.github.mongobee.changeset.ChangeLog;
import com.github.mongobee.changeset.ChangeSet;

import mx.infotec.dads.kukulkan.generator.angularjs.domain.DataStore;
import mx.infotec.dads.kukulkan.generator.angularjs.domain.DataStoreType;
import mx.infotec.dads.kukulkan.generator.angularjs.domain.RuleType;

/**
 * Creates the initial database setup.
 */
@ChangeLog(order = "002")
public class CatalogSetupMigration {

    /**
     * Adds the data store type.
     *
     * @param mongoTemplate the mongo template
     */
    @ChangeSet(order = "01", author = "dcp", id = "02-kukulkan")
    public void addDataStoreType(MongoTemplate mongoTemplate) {
        DataStoreType dst = createDefaultDataStoreType();
        mongoTemplate.save(dst);
        DataStoreType dstGrammar = createGrammarDataStoreType();
        mongoTemplate.save(dstGrammar);
        DataStore testDs = createTestDataStore(dst);
        mongoTemplate.save(testDs);
        DataStore atlasDs = createAtlasDataStore(dst);
        mongoTemplate.save(atlasDs);
        DataStore grammar = createGrammarDataStore(dstGrammar);
        mongoTemplate.save(grammar);
        RuleType singularRuleType = createDefaultSingularRuleType();
        mongoTemplate.save(singularRuleType);
        mongoTemplate.save(createDefaultPluralRuleType());
        mongoTemplate.save(createOsRule(singularRuleType));
        mongoTemplate.save(createEsRule(singularRuleType));
    }
}
