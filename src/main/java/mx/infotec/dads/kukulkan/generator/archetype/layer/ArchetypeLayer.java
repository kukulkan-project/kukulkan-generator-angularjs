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
package mx.infotec.dads.kukulkan.generator.archetype.layer;

import static mx.infotec.dads.kukulkan.engine.util.LayerUtils.addProjectData;

import java.util.Map;

import mx.infotec.dads.kukulkan.metamodel.context.GeneratorContext;
import mx.infotec.dads.kukulkan.metamodel.generator.Layer;

/**
 * Abstract Navigable Layer.
 *
 * @author Daniel Cortes Pichardo
 */
public abstract class ArchetypeLayer implements Layer {

    /* (non-Javadoc)
     * @see mx.infotec.dads.kukulkan.metamodel.generator.Layer#process(mx.infotec.dads.kukulkan.metamodel.foundation.GeneratorContext)
     */
    @Override
    public void process(GeneratorContext context) {
        processLayer(context, addProjectData(context));
    }

    /**
     * ProcessLayer method: Do generation functionalities.
     *
     * @param context the context
     * @param propertiesMap the properties map
     */
    public abstract void processLayer(GeneratorContext context, Map<String, Object> propertiesMap);
}
