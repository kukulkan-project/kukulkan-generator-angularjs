package mx.infotec.dads.kukulkan.generator.angularjs.util;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 
 * Layer Enum used for most layers in the generator
 * 
 * @author Daniel Cortes Pichardo
 *
 */
public enum TemplateEnum {

    BACK_END("rest-spring-jpa/backEnd"), 
    FRONT_END_ENTITIES_LOCATION("rest-spring-jpa/frontEnd/entities/"), 
    FRONT_END("rest-spring-jpa/frontEnd"), 
    COMMON("common"),
    FRONT_END_I18N_LOCATION_EN("rest-spring-jpa/frontEnd/i18n/en"),
    FRONT_END_I18N_LOCATION_ES("rest-spring-jpa/frontEnd/i18n/es");

    
    private String location;

    TemplateEnum(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public Path getLocation(String fileName) {
        return Paths.get(location, fileName);
    }

}
