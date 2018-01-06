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
package mx.infotec.dads.kukulkan.generator.angularjs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import mx.infotec.dads.kukulkan.generator.angularjs.layer.AngularJsSpringLayer;
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

    /** The layers. */
    @Autowired
    List<AngularJsSpringLayer> layers;

    /* (non-Javadoc)
     * @see mx.infotec.dads.kukulkan.metamodel.generator.Generator#getName()
     */
    @Override
    public String getName() {
        return "angularJs-spring";
    }

    /* (non-Javadoc)
     * @see mx.infotec.dads.kukulkan.metamodel.generator.Generator#getVersion()
     */
    @Override
    public String getVersion() {
        return "1.0.0";
    }

    /* (non-Javadoc)
     * @see mx.infotec.dads.kukulkan.metamodel.generator.Generator#getDescription()
     */
    @Override
    public String getDescription() {
        return "Angular 1.5.8 and Spring boot application";
    }

    /* (non-Javadoc)
     * @see mx.infotec.dads.kukulkan.metamodel.generator.Generator#getKeywords()
     */
    @Override
    public String getKeywords() {
        return null;
    }

    /* (non-Javadoc)
     * @see mx.infotec.dads.kukulkan.metamodel.generator.Generator#getLayers()
     */
    @Override
    public List<? extends Layer> getLayers() {
        return layers;
    }

}
