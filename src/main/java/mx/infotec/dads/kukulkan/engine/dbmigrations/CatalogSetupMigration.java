package mx.infotec.dads.kukulkan.engine.dbmigrations;

import static mx.infotec.dads.kukulkan.engine.util.EntitiesFactory.createAtlasDataStore;
import static mx.infotec.dads.kukulkan.engine.util.EntitiesFactory.createDefaultDataStoreType;
import static mx.infotec.dads.kukulkan.engine.util.EntitiesFactory.createDefaultPluralRuleType;
import static mx.infotec.dads.kukulkan.engine.util.EntitiesFactory.createDefaultSingularRuleType;
import static mx.infotec.dads.kukulkan.engine.util.EntitiesFactory.createEsRule;
import static mx.infotec.dads.kukulkan.engine.util.EntitiesFactory.createGrammarDataStore;
import static mx.infotec.dads.kukulkan.engine.util.EntitiesFactory.createGrammarDataStoreType;
import static mx.infotec.dads.kukulkan.engine.util.EntitiesFactory.createOsRule;
import static mx.infotec.dads.kukulkan.engine.util.EntitiesFactory.createTestDataStore;

import org.springframework.data.mongodb.core.MongoTemplate;

import com.github.mongobee.changeset.ChangeLog;
import com.github.mongobee.changeset.ChangeSet;

import mx.infotec.dads.kukulkan.engine.domain.DataStore;
import mx.infotec.dads.kukulkan.engine.domain.DataStoreType;
import mx.infotec.dads.kukulkan.engine.domain.RuleType;

/**
 * Creates the initial database setup
 */
@ChangeLog(order = "002")
public class CatalogSetupMigration {

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
