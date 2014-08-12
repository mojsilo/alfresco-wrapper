package rs.e75.alfrescowrapper.model;

/**
 * 
 * @author Savic Prvoslav
 * 
 */
public enum RolesV2 {
	Consumer {
		@Override
		public String toString() {
			return "Consumer";
		}
	},
	Coordinator {
		@Override
		public String toString() {
			return "Coordinator";
		}

	},
	Nothing {
		@Override
		public String toString() {

			return "Nothing";
		}
	};
}
