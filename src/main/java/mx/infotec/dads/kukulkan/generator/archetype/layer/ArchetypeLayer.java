package mx.infotec.dads.kukulkan.generator.archetype.layer;

import static mx.infotec.dads.kukulkan.metamodel.util.LayerUtils.addProjectData;

import java.util.Map;

import mx.infotec.dads.kukulkan.metamodel.foundation.GeneratorContext;
import mx.infotec.dads.kukulkan.metamodel.generator.Layer;

/**
 * Abstract Navigable Layer
 * 
 * @author Daniel Cortes Pichardo
 *
 */
public abstract class ArchetypeLayer implements Layer {

	@Override
	public void process(GeneratorContext context) {
		processLayer(context, addProjectData(context));

	}

	/**
	 * ProcessLayer method: Do generation functionalities
	 * 
	 * @param context
	 * @param propertiesMap
	 */
	public abstract void processLayer(GeneratorContext context, Map<String, Object> propertiesMap);
}
