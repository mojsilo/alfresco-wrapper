package rs.e75.alfrescowrapper.model;

import java.io.Serializable;

/**
 * Shorder represetnation of node
 * 
 * @author Savic Prvoslav
 * @revision r1
 */
public class NodeRef implements Serializable {

	private static final long serialVersionUID = -7210687253779264047L;
	private String id;
	private String propertyName;
	private String name;
	private String storeIdentifier;
	private String storeProtocol;
	private String type;

	
	public NodeRef(String refId) {

		if (refId != null) {
			if (refId.contains("//")) {
				// workspace://SpacesStore/fd986a97-85a2-4232-96ec-65c3346c3cb1
				String[] split1 = refId.split("://");
				storeProtocol = split1[0];

				split1 = split1[1].split("/");

				storeIdentifier = split1[0];
				this.id = split1[1];

			} else {
				this.storeProtocol="workspace";
				this.storeIdentifier="SpacesStore";	
				this.id = refId;
			}
		}

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setStoreIdentifier(String storeIdentifier) {
		this.storeIdentifier = storeIdentifier;
	}

	public void setStoreProtocol(String storeProtocol) {
		this.storeProtocol = storeProtocol;
	}

	public String getStoreIdentifier() {
		return storeIdentifier;
	}

	public String getStoreProtocol() {
		return storeProtocol;
	}
	
	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}


	public Boolean validateNodeRef() {
		// TODO finish node ref validation on id and pattern
		return (id != null) && !id.equals("");
	}

	public String toNodeRef() {
//		return getStoreProtocol() + "://" + getStoreIdentifier() + "/"
//				+ getId();
		
		return toString();

	}
	
	public String toDownloadNodeRef() {
		return "/d/d/"+getStoreProtocol() + "/" + getStoreIdentifier() + "/"
				+ getId()+"/file.bin";
	}

	@Override
	public String toString() {
		return getStoreProtocol() + "://" + getStoreIdentifier() + "/"
				+ getId();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof NodeRef) {
			NodeRef ref = (NodeRef) obj;
			if (ref.getId().equals(getId())) {
				return true;
			} else {
				return false;
			}

		} else {
			return false;
		}
	}
}
