package rs.e75.alfrescowrapper.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.log4j.Logger;

import rs.e75.alfrescowrapper.constants.ContentModel;



/**
 * representation of node from alfresco
 * 
 * @author Savic Prvoslav
 * @revision r1
 */
public class Node implements Serializable {

	private static final long serialVersionUID = -7307077548137168876L;
	private static final Logger LOGGER=Logger.getLogger(Node.class);

	private Map<String, Object> properties = new ConcurrentHashMap<String, Object>(){
		
		private static final long serialVersionUID = 751076746334750595L;

		public Object put(String key, Object value) {
			if(value!=null)
			{
				return super.put(key, value);
			}else{
				LOGGER.info("empty property: "+key+" value: "+value);
				return null;
			}
			
		};
	};
	private Map<String, List<NodeRef>> asocs = new HashMap<String, List<NodeRef>>();
	private Map<String, String> permissions = new HashMap<String, String>();

	private List<String> aspects = new ArrayList<String>();

	private List<Node> children = new ArrayList<Node>();

	private String type;
	private String parent;
	private String parentname;
	private String folder;

	private NodeRef parentNodeRef;

	public void setParentNodeRef(NodeRef parentNodeRef) {
		this.parentNodeRef = parentNodeRef;
	}

	public NodeRef getParentNodeRef() {
		return parentNodeRef;
	}

	public Node() {

	}

	public Node(Node node) {
		setItSelf(node);
	}

	public Node(NodeRef nodeRef) {
	

		getProperties().put(ContentModel.NODE_UUID, nodeRef.getId());

		if (nodeRef.getName() != null) {
			getProperties().put(ContentModel.NODE_NAME, nodeRef.getName());
		}

		if (nodeRef.getStoreIdentifier() != null) {
			getProperties().put(ContentModel.NODE_STORE_IDENTIFIER,
					nodeRef.getStoreIdentifier());
		}
		if (nodeRef.getStoreProtocol() != null) {
			getProperties().put(ContentModel.NODE_STORE_PROTOCOL,
					nodeRef.getStoreProtocol());
		}

		if (nodeRef.getType() != null) {
			setType(nodeRef.getType());
		}

	}

	/**
	 * This method makes initializes this of @param node
	 * 
	 * @param node
	 */
	public void setItSelf(Node node) {

		this.setProperties(node.getProperties());
		this.setAsocs(node.getAsocs());

		this.setType(node.getType());
		this.setParent(node.getParent());
		this.setParentname(node.getParentname());
		this.setFolder(node.getFolder());

		this.setAspects(node.getAspects());
		this.setPermissions(node.getPermissions());
		this.setChildren(node.getChildren());

	}

	public void setChildren(List<Node> children) {
		this.children = children;
	}

	public List<Node> getChildren() {
		return children;
	}

	public Map<String, String> getPermissions() {
		return permissions;
	}

	public void setPermissions(Map<String, String> permissions) {
		this.permissions = permissions;
	}

	public void setAspects(List<String> aspects) {
		this.aspects = aspects;
	}

	public List<String> getAspects() {
		return aspects;
	}

	public void setFolder(String folder) {
		this.folder = folder;
	}

	public String getFolder() {
		return folder;
	}

	/**
	 * is container node
	 * 
	 * @return
	 */
	public Boolean isFolder() {
		if (folder.trim().equals("true")) {
			return true;
		} else {
			return false;
		}
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public Boolean isType(String type) {
		return getType().trim().equals(type);
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public void setParentname(String parentname) {
		this.parentname = parentname;
	}

	public String getParent() {
		return parent;
	}

	public String getParentname() {
		return parentname;
	}

	public void setProperties(Map<String, Object> properties) {
		this.properties = properties;
	}

	public Map<String, Object> getProperties() {
		return properties;
	}

	public Object getPropertie(String key) {
		return properties.get(key);
	}

	public String getStringPropertie(String key) {
		return (String) properties.get(key);
	}

	public Map<String, List<NodeRef>> getAsocs() {
		return asocs;
	}

	public void setAsocs(Map<String, List<NodeRef>> asocs) {
		this.asocs = asocs;
	}

	/**
	 * Converts @Node to @NodeRef
	 * 
	 * @return
	 */
	public NodeRef getNodeRef() {
		
		Boolean nodeid = getProperties().containsKey(ContentModel.NODE_UUID);
		if(nodeid)
		{
			//System.out.println("fdsafds !!!!!!!!!! 654"+getId());
		}
		
		if (getId()!=null && !getId().equals("")) {
			String id = getId();
			String name = (String) getPropertie(ContentModel.NODE_NAME);

			String storeIdentifier = (String) getPropertie(ContentModel.NODE_STORE_IDENTIFIER);
			String storeProtocol = (String) getPropertie(ContentModel.NODE_STORE_PROTOCOL);

			String type = getType();

			NodeRef nodeRef = new NodeRef(id);
			nodeRef.setStoreIdentifier(storeIdentifier);
			nodeRef.setStoreProtocol(storeProtocol);
			nodeRef.setName(name);
			nodeRef.setType(type);
			return nodeRef;

		} else {
			throw new IllegalStateException("load node first");
		}

	}

	/**
	 * Check if user has permission for permission, use @PermissionService for
	 * constants
	 * 
	 * @param permission
	 * @return
	 */
	public Boolean hasPermission(String permission) {
		if (getPermissions().containsKey(permission)) {
			return Boolean.parseBoolean(getPermissions().get(permission));

		} else {
			return false;
		}
	}

	public boolean hasAspect(String aspect) {
		List<String> aspects = getAspects();
		for (String aspectList : aspects) {
			if (aspectList.trim().equals(aspect)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean equals(Object obj) {
		String idObj = (String) ((Node) obj).getId();
		String id = (String) this.getId();

		if (idObj.equals(id)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		String value = (String) this.getProperties()
				.get(ContentModel.NODE_UUID);

		return value.hashCode();
	}

	public String getId() {
		String id = (String) this.getProperties().get(ContentModel.NODE_UUID);
		return id;

	}

	public String getName() {
		String name = (String) this.getProperties().get(ContentModel.NODE_NAME);
		return name;

	}

	private Boolean projectUserType(String type) {
		String projectUserType = getStringPropertie(ContentModel.VIRTUAL_PROJECTUSERTYPE);

		if (projectUserType == null) {
			return false;
		} else if (projectUserType.equals(type)) {
			return true;
		}
		return false;
	}

	public Boolean isPublic() {
		return projectUserType("public");

	}

	public Boolean isPrivate() {
		return projectUserType("private") || isAdmin();

	}

	public Boolean isAdmin() {
		return projectUserType("admin");
	}

	
	
	public Boolean containsChildrenByName(String name) {

		List<Node> childs = getChildren();
		
		String nameTemp=name+".png";

		if (childs != null) {
			for (Node childTemp : childs) {
				
				System.out.println(childTemp.getName()+" "+nameTemp +" "+childTemp.getName().equals(nameTemp) );
				if (childTemp.getName().equals(nameTemp)) {
					return true;
					
				}
			}
		}
		return false;

	}

}
