package mx.infotec.dads.kukulkan.generator.layers.business;

import mx.infotec.dads.kukulkan.generator.util.LayerNameConstants;

/**
 * BusinessTechnology
 * 
 * @author Daniel Cortes Pichardo
 *
 */
public enum BusinessTechnology {
    /**
     * Indicates that a SPRING SERVICE
     */
    SPRING_SERVICE(LayerNameConstants.Business.SpringService.SERVICE_NAME);
    private String value;

    private BusinessTechnology(String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }
}
