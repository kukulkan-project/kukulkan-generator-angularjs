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
package mx.infotec.dads.kukulkan.generator.util;

import static mx.infotec.dads.kukulkan.engine.editor.ace.EditorFactory.createDefaultAceEditor;

import java.nio.file.Path;
import java.util.Map;

import mx.infotec.dads.kukulkan.engine.model.ModelContext;
import mx.infotec.dads.kukulkan.engine.translator.database.DataStore;
import mx.infotec.dads.kukulkan.engine.translator.database.DataStoreType;
import mx.infotec.dads.kukulkan.metamodel.editor.LanguageType;
import mx.infotec.dads.kukulkan.metamodel.foundation.TableTypes;
import mx.infotec.dads.kukulkan.metamodel.util.DataStoreConstants;
import mx.infotec.dads.kukulkan.metamodel.util.NameConventions;

/**
 * EntitiesFactory provide common entities with a properly initialization.
 *
 * @author Daniel Cortes Pichardo
 */
public class EntitiesFactory {

    private static final String NOY_APPLY = "NO APLICA";

    /**
     * Instantiates a new entities factory.
     */
    private EntitiesFactory() {

    }

    /**
     * Creates a new Entities object.
     *
     * @param dst
     *            the dst
     * @return the data store
     */
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

    /**
     * Creates a new Entities object.
     *
     * @param dst
     *            the dst
     * @return the data store
     */
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

    /**
     * Creates a new Entities object.
     *
     * @param dst
     *            the dst
     * @return the data store
     */
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

    /**
     * Creates a new Entities object.
     *
     * @param dst
     *            the dst
     * @return the data store
     */
    public static DataStore createGrammarDataStore(DataStoreType dst) {
        DataStore atlasDataStore = new DataStore();
        atlasDataStore.setDataStoreType(dst);
        atlasDataStore.setDriverClass(NOY_APPLY);
        atlasDataStore.setName(DataStoreConstants.DATA_STORE_TYPE_GRAMMAR);
        atlasDataStore.setPassword(NOY_APPLY);
        atlasDataStore.setTableTypes(TableTypes.TABLE_VIEW);
        atlasDataStore.setUrl(NOY_APPLY);
        atlasDataStore.setSchema(NOY_APPLY);
        atlasDataStore.setUsername(NOY_APPLY);
        return atlasDataStore;
    }

    /**
     * Creates a new Entities object.
     *
     * @return the rule type
     */
    public static RuleType createDefaultSingularRuleType() {
        RuleType singularRuleType = new RuleType();
        singularRuleType.setDescription("regla que aplica para palabras convertir palabras de plural a singular");
        singularRuleType.setName("singular");
        return singularRuleType;
    }

    /**
     * Creates a new Entities object.
     *
     * @return the rule type
     */
    public static RuleType createDefaultPluralRuleType() {
        RuleType plurarlRuleType = new RuleType();
        plurarlRuleType.setDescription("regla que aplica para palabras convertir palabras de singular a plural");
        plurarlRuleType.setName("plural");
        return plurarlRuleType;
    }

    /**
     * Creates a new Entities object.
     *
     * @param ruleType
     *            the rule type
     * @return the rule
     */
    public static Rule createOsRule(RuleType ruleType) {
        Rule osRule = new Rule();
        osRule.setExpression("os$");
        osRule.setReplacement("o");
        osRule.setRuleType(ruleType);
        return osRule;
    }

    /**
     * Creates a new Entities object.
     *
     * @param ruleType
     *            the rule type
     * @return the rule
     */
    public static Rule createEsRule(RuleType ruleType) {
        Rule esRule = new Rule();
        esRule.setExpression("es$");
        esRule.setReplacement("");
        esRule.setRuleType(ruleType);
        return esRule;
    }

    public static ModelContext createModelContext(Map<String, Object> propertiesMap, Path realFilePath,
            Path relativeFilePath, Path templatePath, LanguageType laguageType) {
        ModelContext.Builder builder = new ModelContext.Builder();
        builder.editor(createDefaultAceEditor(laguageType));
        builder.model(propertiesMap);
        builder.realFilePath(realFilePath);
        builder.relativeFilePath(relativeFilePath);
        builder.templatePath(templatePath);
        return builder.build();

    }

    public static String createRestResourceName(String name) {
        return name + NameConventions.REST_CONTROLLER + NameConventions.JAVA_EXTENSION;
    }

    public static String createServiceName(String name) {
        return name + NameConventions.SERVICE + NameConventions.JAVA_EXTENSION;
    }

    public static String createRepositoryName(String name) {
        return name + NameConventions.DAO + NameConventions.JAVA_EXTENSION;
    }

    public static String createPrimaryKeyName(String name) {
        return name + NameConventions.DAO + NameConventions.JAVA_EXTENSION;
    }

    public static String createDomainName(String name) {
        return name + NameConventions.JAVA_EXTENSION;
    }

    public static String createServiceImplName(String name) {
        return name + NameConventions.SERVICE_IMPLEMENTS + NameConventions.JAVA_EXTENSION;
    }

}
