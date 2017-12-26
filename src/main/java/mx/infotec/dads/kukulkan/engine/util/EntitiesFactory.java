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
package mx.infotec.dads.kukulkan.engine.util;

import mx.infotec.dads.kukulkan.engine.domain.DataStore;
import mx.infotec.dads.kukulkan.engine.domain.DataStoreType;
import mx.infotec.dads.kukulkan.engine.domain.Rule;
import mx.infotec.dads.kukulkan.engine.domain.RuleType;
import mx.infotec.dads.kukulkan.metamodel.context.KukulkanContext;
import mx.infotec.dads.kukulkan.metamodel.foundation.PrimaryKey;
import mx.infotec.dads.kukulkan.metamodel.foundation.ProjectConfiguration;
import mx.infotec.dads.kukulkan.metamodel.foundation.TableTypes;
import mx.infotec.dads.kukulkan.metamodel.util.DataStoreConstants;

/**
 * EntitiesFactory provide common entities with a properly initialization
 * 
 * @author Daniel Cortes Pichardo
 */
public class EntitiesFactory {

    private static final String STRING_TYPE = "String";
    private static final String STRING_QUALIFIED_NAME = "java.lang.String";
    private static final String ID_DEFAULT_NAME = "id";

    private EntitiesFactory() {

    }
    
    public static DataStore createDataStore() {
        DataStore ds = new DataStore();
        ds.setDataStoreType(new DataStoreType());
        ds.setDriverClass("");
        ds.setName("");
        ds.setSchema("");
        ds.setPassword("");
        ds.setTableTypes(TableTypes.TABLE_VIEW);
        ds.setUsername("");
        return ds;
    }

    public static KukulkanContext createDefaultKukulkanContext() {
        ProjectConfiguration pConf = new ProjectConfiguration();
        pConf.setId("conacyt");
        pConf.setGroupId("");
        pConf.setVersion("1.0.0");
        pConf.setPackaging("");
        pConf.setYear("2017");
        pConf.setAuthor("KUKULKAN");
        pConf.setWebLayerName("rest");
        pConf.setServiceLayerName("service");
        pConf.setDaoLayerName("repository");
        pConf.setDomainLayerName("model");
        pConf.setGroupId("mx.infotec.dads");
        pConf.setPackaging("mx.infotec.dads.conacyt");
        return new KukulkanContext(pConf, "");
    }

    public static DataStore createTestDataStore(DataStoreType dst) {
        DataStore testDataStore = new DataStore();
        testDataStore.setDataStoreType(dst);
        testDataStore.setDriverClass("org.h2.Driver");
        testDataStore.setName("h2-db-test");
        testDataStore.setPassword("");
        testDataStore.setTableTypes(TableTypes.TABLE_VIEW);
        testDataStore.setUrl("jdbc:h2:~");
        testDataStore.setSchema("test");
        testDataStore.setUsername("");
        return testDataStore;
    }

    public static DataStore createAtlasDataStore(DataStoreType dst) {
        DataStore atlasDataStore = new DataStore();
        atlasDataStore.setDataStoreType(dst);
        atlasDataStore.setDriverClass("com.mysql.jdbc.Driver");
        atlasDataStore.setName("atlas");
        atlasDataStore.setPassword("");
        atlasDataStore.setTableTypes(TableTypes.TABLE_VIEW);
        atlasDataStore.setUrl("jdbc:mysql://localhost");
        atlasDataStore.setSchema("atlas");
        atlasDataStore.setUsername("root");
        return atlasDataStore;
    }

    public static DataStore createMysqlTestDataStore(DataStoreType dst) {
        DataStore mysqlDataStore = new DataStore();
        mysqlDataStore.setDataStoreType(dst);
        mysqlDataStore.setDriverClass("org.h2.Driver");
        mysqlDataStore.setName("test");
        mysqlDataStore.setPassword("");
        mysqlDataStore.setTableTypes(TableTypes.TABLE_VIEW);
        mysqlDataStore.setUrl("jdbc:h2:~");
        mysqlDataStore.setSchema("test");
        mysqlDataStore.setUsername("");
        return mysqlDataStore;
    }

    public static DataStore createGrammarDataStore(DataStoreType dst) {
        DataStore atlasDataStore = new DataStore();
        atlasDataStore.setDataStoreType(dst);
        atlasDataStore.setDriverClass("NO APLICA");
        atlasDataStore.setName(DataStoreConstants.DATA_STORE_TYPE_GRAMMAR);
        atlasDataStore.setPassword("NO APLICA");
        atlasDataStore.setTableTypes(TableTypes.TABLE_VIEW);
        atlasDataStore.setUrl("NO APLICA");
        atlasDataStore.setSchema("NO APLICA");
        atlasDataStore.setUsername("NO APLICA");
        return atlasDataStore;
    }

    public static DataStoreType createDefaultDataStoreType() {
        DataStoreType dst = new DataStoreType();
        dst.setDescription("Data Store for JDBC connector");
        dst.setName("jdbc");
        return dst;
    }

    public static DataStoreType createGrammarDataStoreType() {
        DataStoreType dst = new DataStoreType();
        dst.setDescription("Kukulan DataStore Type");
        dst.setName(DataStoreConstants.DATA_STORE_TYPE_GRAMMAR);
        return dst;
    }

    public static RuleType createDefaultSingularRuleType() {
        RuleType singularRuleType = new RuleType();
        singularRuleType.setDescription("regla que aplica para palabras convertir palabras de plural a singular");
        singularRuleType.setName("singular");
        return singularRuleType;
    }

    public static RuleType createDefaultPluralRuleType() {
        RuleType plurarlRuleType = new RuleType();
        plurarlRuleType.setDescription("regla que aplica para palabras convertir palabras de singular a plural");
        plurarlRuleType.setName("plural");
        return plurarlRuleType;
    }

    public static Rule createOsRule(RuleType ruleType) {
        Rule osRule = new Rule();
        osRule.setExpression("os$");
        osRule.setReplacement("o");
        osRule.setRuleType(ruleType);
        return osRule;
    }

    public static Rule createEsRule(RuleType ruleType) {
        Rule esRule = new Rule();
        esRule.setExpression("es$");
        esRule.setReplacement("");
        esRule.setRuleType(ruleType);
        return esRule;
    }

}
