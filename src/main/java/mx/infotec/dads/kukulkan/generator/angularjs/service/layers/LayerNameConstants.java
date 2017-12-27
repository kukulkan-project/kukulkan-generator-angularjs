package mx.infotec.dads.kukulkan.generator.angularjs.service.layers;

/**
 * Constants for Layer types in the generator
 * 
 * @author Daniel Cortes Pichardo
 *
 */
public class LayerNameConstants {

	private LayerNameConstants() {

	}

	public static class FrontEnd {
		private FrontEnd() {
		}

		public static class AngularJs {
			public static final String SERVICE_NAME = "angular-js";

			private AngularJs() {
			}
		}
	}

	public static class Web {
		private Web() {

		}

		public static class SpringRest {
			public static final String SERVICE_NAME = "spring-rest";

			private SpringRest() {

			}

		}
	}

	public static class Business {
		private Business() {
		}

		public static class SpringService {
			public static final String SERVICE_NAME = "spring-service";

			private SpringService() {
			}

		}
	}

	public static class DataAccess {
		private DataAccess() {
		}

		public static class Repository {
			public static final String SERVICE_NAME = "spring-repository";

			private Repository() {

			}
		}
	}

	public static class Domain {
		private Domain() {
		}

		public static class Core {
			public static final String SERVICE_NAME = "domain-core";

			private Core() {

			}
		}
	}

	public static class Archetype {
		private Archetype() {
		}

		public static class AngularJs {
			public static final String GENERATOR_NAME = "angular-js-archetype-generator";
			public static final String LAYER_NAME = "angular-js-archetype-layer";

			private AngularJs() {
			}
		}
	}
}
