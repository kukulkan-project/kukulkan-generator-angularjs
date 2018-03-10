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
package mx.infotec.dads.kukulkan.generator.util;

/**
 * Character for Layer types in the generator.
 *
 * @author Daniel Cortes Pichardo
 */
public class LayerNameConstants {

    /**
     * Instantiates a new layer name constants.
     */
    private LayerNameConstants() {

    }

    /**
     * The Class FrontEnd.
     */
    public static class FrontEnd {
        
        /**
         * Instantiates a new front end.
         */
        private FrontEnd() {
        }

        /**
         * The Class AngularJs.
         */
        public static class AngularJs {
            
            /** The Constant SERVICE_NAME. */
            public static final String SERVICE_NAME = "angular-js";

            /**
             * Instantiates a new angular js.
             */
            private AngularJs() {
            }
        }
    }

    /**
     * The Class Web.
     */
    public static class Web {
        
        /**
         * Instantiates a new web.
         */
        private Web() {

        }

        /**
         * The Class SpringRest.
         */
        public static class SpringRest {
            
            /** The Constant SERVICE_NAME. */
            public static final String SERVICE_NAME = "spring-rest";

            /**
             * Instantiates a new spring rest.
             */
            private SpringRest() {

            }

        }
    }

    /**
     * The Class Business.
     */
    public static class Business {
        
        /**
         * Instantiates a new business.
         */
        private Business() {
        }

        /**
         * The Class SpringService.
         */
        public static class SpringService {
            
            /** The Constant SERVICE_NAME. */
            public static final String SERVICE_NAME = "spring-service";

            /**
             * Instantiates a new spring service.
             */
            private SpringService() {
            }

        }
    }

    /**
     * The Class DataAccess.
     */
    public static class DataAccess {
        
        /**
         * Instantiates a new data access.
         */
        private DataAccess() {
        }

        /**
         * The Class Repository.
         */
        public static class Repository {
            
            /** The Constant SERVICE_NAME. */
            public static final String SERVICE_NAME = "spring-repository";

            /**
             * Instantiates a new repository.
             */
            private Repository() {

            }
        }
        
        /**
         * The Class Repository.
         */
        public static class Liquibase {
            
            /** The Constant SERVICE_NAME. */
            public static final String SERVICE_NAME = "liquibase";

            /**
             * Instantiates a new repository.
             */
            private Liquibase() {

            }
        }
    }

    /**
     * The Class Domain.
     */
    public static class Domain {
        
        /**
         * Instantiates a new domain.
         */
        private Domain() {
        }

        /**
         * The Class Core.
         */
        public static class Core {
            
            /** The Constant SERVICE_NAME. */
            public static final String SERVICE_NAME = "domain-core";

            /**
             * Instantiates a new core.
             */
            private Core() {

            }
        }
    }

    /**
     * The Class Archetype.
     */
    public static class Archetype {
        
        /**
         * Instantiates a new archetype.
         */
        private Archetype() {
        }

        /**
         * The Class AngularJs.
         */
        public static class AngularJs {
            
            /** The Constant GENERATOR_NAME. */
            public static final String GENERATOR_NAME = "angular-js-archetype-generator";
            
            /** The Constant GENERATOR_NAME. */
            public static final String JPA_GENERATOR = "angular-js-jpa-archetype-generator";
            
            /** The Constant LAYER_NAME. */
            public static final String LAYER_NAME = "angular-js-archetype-layer";

            /**
             * Instantiates a new angular js.
             */
            private AngularJs() {
            }
        }
    }
}
