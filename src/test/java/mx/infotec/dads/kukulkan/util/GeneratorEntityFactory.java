package mx.infotec.dads.kukulkan.util;

import java.time.LocalDateTime;

import mx.infotec.dads.kukulkan.metamodel.foundation.Database;
import mx.infotec.dads.kukulkan.metamodel.foundation.DatabaseType;
import mx.infotec.dads.kukulkan.metamodel.foundation.ProjectConfiguration;
import mx.infotec.dads.kukulkan.metamodel.util.PKGenerationStrategy;

public class GeneratorEntityFactory {

    public static ProjectConfiguration createProjectConfiguration(DatabaseType type) {
        ProjectConfiguration pConf = new ProjectConfiguration();
        pConf.setId("kukulkan");
        pConf.setVersion("1.0.0");
        pConf.setPackaging("mx.infotec.dads.archetype");
        pConf.setYear("2018");
        pConf.setAuthor("KUKULKAN");
        pConf.setOutputDir(TemporalDirectoryUtil.getTemporalPath());
        pConf.setTargetDatabase(new Database(type, PKGenerationStrategy.IDENTITY));
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
        pConf.setOutputDir(TemporalDirectoryUtil.getTemporalPath());
        pConf.setTargetDatabase(new Database(type, PKGenerationStrategy.IDENTITY));
        pConf.setTimestamp(LocalDateTime.of(2018, 05, 07, 20, 45, 32));
        pConf.addLayers("angular-js", "spring-rest", "spring-service", "spring-repository", "domain-core");
        pConf.getLayersToProcess().add("angular-js");
        pConf.getLayersToProcess().add("spring-rest");
        pConf.getLayersToProcess().add("spring-service");
        pConf.getLayersToProcess().add("spring-repository");
        pConf.getLayersToProcess().add("domain-core");
        if (DatabaseType.SQL_MYSQL == type) {
            pConf.addLayer("liquibase");
            pConf.getLayersToProcess().add("liquibase");
        }
        return pConf;
    }
}
