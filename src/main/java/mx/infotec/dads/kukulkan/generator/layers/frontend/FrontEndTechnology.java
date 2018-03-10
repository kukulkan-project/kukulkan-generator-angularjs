package mx.infotec.dads.kukulkan.generator.layers.frontend;

import mx.infotec.dads.kukulkan.generator.util.LayerNameConstants;

/**
 * FronEndTechnology
 * 
 * @author Daniel Cortes Pichardo
 *
 */
public enum FrontEndTechnology {
    /**
     * Indicates technology with Angular 1.5.8.
     */
    ANGULAR_JS(LayerNameConstants.FrontEnd.AngularJs.SERVICE_NAME),

    /**
     * Indicates technology with Angular 5
     */
    ANGULAR(LayerNameConstants.FrontEnd.Angular.SERVICE_NAME);

    private String value;

    private FrontEndTechnology(String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }
}
