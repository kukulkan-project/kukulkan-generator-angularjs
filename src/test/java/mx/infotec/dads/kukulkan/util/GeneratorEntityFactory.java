package mx.infotec.dads.kukulkan.util;

import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import mx.infotec.dads.kukulkan.engine.translator.dsl.GrammarMapping;
import mx.infotec.dads.kukulkan.engine.translator.dsl.GrammarSemanticAnalyzer;
import mx.infotec.dads.kukulkan.engine.translator.dsl.GrammarUtil;
import mx.infotec.dads.kukulkan.grammar.kukulkanParser.DomainModelContext;
import mx.infotec.dads.kukulkan.metamodel.foundation.Database;
import mx.infotec.dads.kukulkan.metamodel.foundation.DatabaseType;
import mx.infotec.dads.kukulkan.metamodel.foundation.DomainModelGroup;
import mx.infotec.dads.kukulkan.metamodel.foundation.ProjectConfiguration;
import mx.infotec.dads.kukulkan.metamodel.util.PKGenerationStrategy;

public class GeneratorEntityFactory {

    /**
     * createSingleDataModelGroupList.
     *
     * @param visitor
     *            the visitor
     * @return the list
     */
    public static List<DomainModelGroup> createSingleTestDataModelGroupList(GrammarSemanticAnalyzer visitor) {
        String program = "src/test/resources/grammar/single-entity." + "3k";
        DomainModelContext tree = GrammarUtil.getDomainModelContext(program);
        List<DomainModelGroup> dataModelGroupList = new ArrayList<>();
        dataModelGroupList.add(GrammarMapping.createDefaultDataModelGroup(tree, visitor));
        return dataModelGroupList;
    }

    public static List<DomainModelGroup> createRelationshipTestDataModelGroupList(GrammarSemanticAnalyzer visitor) {
        String program = "src/test/resources/grammar/relationship-entity." + "3k";
        DomainModelContext tree = GrammarUtil.getDomainModelContext(program);
        List<DomainModelGroup> dataModelGroupList = new ArrayList<>();
        dataModelGroupList.add(GrammarMapping.createDefaultDataModelGroup(tree, visitor));
        return dataModelGroupList;
    }

    public static ProjectConfiguration createProjectConfiguration(DatabaseType type) {
        ProjectConfiguration pConf = new ProjectConfiguration();
        pConf.setId("kukulkan");
        pConf.setVersion("1.0.0");
        pConf.setPackaging("mx.infotec.dads.archetype");
        pConf.setYear("2018");
        pConf.setAuthor("KUKULKAN");
        // pConf.setOutputDir(TemporalDirectoryUtil.getTemporalPath());}
        pConf.setOutputDir(Paths.get("/home/daniel/git"));
        pConf.setDatabase(new Database(type, PKGenerationStrategy.IDENTITY));
        pConf.setTimestamp(LocalDateTime.of(2018, 03, 03, 18, 52, 22));
        pConf.addLayers("angular-js", "spring-rest", "spring-service", "spring-repository", "domain-core");
        if (DatabaseType.SQL_MYSQL == type) {
            pConf.addLayer("liquibase");
        }
        return pConf;
    }

    public static ProjectConfiguration createProjectConfigurationJustModel(DatabaseType type) {
        ProjectConfiguration pConf = new ProjectConfiguration();
        pConf.setId("kukulkan");
        pConf.setVersion("1.0.0");
        pConf.setPackaging("mx.infotec.dads.archetype");
        pConf.setYear("2018");
        pConf.setAuthor("KUKULKAN");
        // pConf.setOutputDir(TemporalDirectoryUtil.getTemporalPath());}
        pConf.setOutputDir(Paths.get("/home/daniel/git"));
        pConf.setDatabase(new Database(type, PKGenerationStrategy.IDENTITY));
        pConf.setTimestamp(LocalDateTime.of(2018, 05, 07, 20, 45, 32));
        pConf.addLayers("angular-js");
        pConf.getLayersToProcess().add("angular-js");
        if (DatabaseType.SQL_MYSQL == type) {
            // pConf.addLayer("liquibase");
        }
        return pConf;
    }
}
