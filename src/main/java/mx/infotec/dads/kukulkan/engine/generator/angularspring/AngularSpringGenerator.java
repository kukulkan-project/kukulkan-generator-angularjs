package mx.infotec.dads.kukulkan.engine.generator.angularspring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import mx.infotec.dads.kukulkan.engine.generator.angularspring.layer.AngularJsSpringLayer;
import mx.infotec.dads.kukulkan.metamodel.annotation.GeneratorComponent;
import mx.infotec.dads.kukulkan.metamodel.generator.Generator;
import mx.infotec.dads.kukulkan.metamodel.generator.Layer;

/**
 * Generator for Angular 1.5.8, Spring boot and Spring Data
 * 
 * @author Daniel Cortes Pichardo
 *
 */
@GeneratorComponent
public class AngularSpringGenerator implements Generator {

    @Autowired
    List<AngularJsSpringLayer> layers;

    @Override
    public String getName() {
        return "angularJs-spring";
    }

    @Override
    public String getVersion() {
        return "1.0.0";
    }

    @Override
    public String getDescription() {
        return "Angular 1.5.8 and Spring boot application";
    }

    @Override
    public String getKeywords() {
        return null;
    }

    @Override
    public List<? extends Layer> getLayers() {
        return layers;
    }

}
