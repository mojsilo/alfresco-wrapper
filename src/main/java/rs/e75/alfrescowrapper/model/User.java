package rs.e75.alfrescowrapper.model;

import org.apache.log4j.Logger;

import rs.e75.alfrescowrapper.constants.ContentModel;



/**
 * 
 * @author Savic Prvoslav
 * @revision r1
 * 
 */
public class User extends Node {

	private static final long serialVersionUID = 1L;

	private static Logger logger = Logger.getLogger(User.class);
	private String username;
	private String password;
	private String email;
	private String tenant = null;
	private String ticket;
	private Boolean loggedIn = false;
	private Node preferences = null;

	public User() {

	}

	public User(String tenant) {
		logger.debug("Create user for tenant :" + tenant);
		this.tenant = tenant;
	}

	public User(Node node) {

		setItSelf(node);

		username = (String) node.getPropertie(ContentModel.NODE_USER_NAME);
		String[] split = username.split("@");
		if (split.length > 0) {
			tenant = username.split("@")[1];
		}

	}

	public void setPreferences(Node preferences) {
		this.preferences = preferences;
	}
	public Node getPreferences() {
		return preferences;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public String getTicket() {
		return ticket;
	}

	public void setLoggedIn(Boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public Boolean getLoggedIn() {
		return loggedIn;
	}

	public String getUsername() {
		if (username == null) {
			username = (String) getPropertie(ContentModel.NODE_USER_NAME);
		}
		return username;
	}

	public String getShortUsername() {
		if (username != null) {
			if (username.contains("@")) {
				return username.split("@")[0];
			}
		}
		return username;
	}

	/**
	 * get userName@tenant
	 * 
	 * @return
	 */
	public String getFullUserName() {
		// if (getUsername().contains("@")) {
		// return getUsername();
		// } else if (getTenant() != null && !getTenant().equals("")) {
		// return getUsername() + "@" + getTenant();
		// } else {
		// return getUsername();
		// }
		//
		return getFullUserName(getUsername());
	}

	public String getFullUserName(String userName) {
		if (getUsername().contains("@")) {

			return getUsername();
			// return getUsername();
		} else if (getTenant() != null && !getTenant().equals("")) {
			return getUsername() + "@" + getTenant();
		} else {
			return getUsername();
		}
	}

	public void setUsername(String username) {
		if (username.contains("@")) {
			String[] temp = username.split("@");
			this.username = temp[0];
			this.tenant = temp[1];
		} else {
			this.username = username;
		}
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTenant() {

		return tenant;
	}

	public void setTenant(String tenant) {
		this.tenant = tenant;
	}

	public NodeRef getUserHome() {
		NodeRef nodeRef = (NodeRef) getPropertie(ContentModel.ASSOC_HOME_FOLDER);
		return nodeRef;
	}

	public Boolean isAdmin() {
		String value = (String) getPropertie(ContentModel.ADMIN);
		return Boolean.parseBoolean(value.trim());
	}

	public String getFullName() {
		return getPropertie(ContentModel.NODE_FIRST_NAME) + " "
				+ getPropertie(ContentModel.NODE_LAST_NAME);
	}

	public static String getFullName(Node node) {
		return node.getPropertie(ContentModel.NODE_FIRST_NAME) + " "
				+ node.getPropertie(ContentModel.NODE_LAST_NAME);
	}

	public static String getFullUserName(Node node) {
		String userNameTmp = node
				.getStringPropertie(ContentModel.NODE_USER_NAME);

		return userNameTmp;
	}
	
	public static String getEmail(Node node) {
		String emailTmp = node
				.getStringPropertie(ContentModel.NODE_EMAIL);

		return emailTmp;
	}

	@Override
	public String toString() {

		return "{" + getUsername() + "} {" + getPassword() + "} {"
				+ getTenant() + "} {" + getTicket() + "} {" + getLoggedIn()
				+ "}";
	}

}
