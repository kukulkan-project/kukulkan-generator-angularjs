package mx.infotec.dads.kukulkan.generator.archetype;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import mx.infotec.dads.kukulkan.generator.angularjs.service.layers.LayerNameConstants;
import mx.infotec.dads.kukulkan.generator.archetype.layer.ArchetypeLayer;
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
public class AngularJsArchetypeGenerator implements Generator {

	@Autowired
	List<ArchetypeLayer> layers;

	@Override
	public String getName() {
		return LayerNameConstants.Archetype.AngularJs.GENERATOR_NAME;
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
