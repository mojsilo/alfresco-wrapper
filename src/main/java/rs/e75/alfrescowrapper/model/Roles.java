package rs.e75.alfrescowrapper.model;


/**
 * 
 * Defines roles in yanado
 * 
 * @author Savic Prvoslav
 * 
 */
public enum Roles {

	Contributor {
		@Override
		public String toString() {
			return "Contributor";
		}
	},
	Editor {
		@Override
		public String toString() {

			return "Editor";
		}
	},
	Consumer {
		@Override
		public String toString() {
			return "Consumer";
		}
	},
	Collaborator {
		@Override
		public String toString() {
			return "Collaborator";
		}

	},
	Coordinator {
		@Override
		public String toString() {
			return "Coordinator";
		}

	},
	NOTHING {
		@Override
		public String toString() {

			return "Nothing";
		}
	};

	
}