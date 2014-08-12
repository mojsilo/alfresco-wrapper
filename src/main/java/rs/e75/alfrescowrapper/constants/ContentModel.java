package rs.e75.alfrescowrapper.constants;

/**
 * This class represents contentmodel in alfresco, default and custom types,
 * properties, associations ect
 * 
 * @author Savic Prvoslav
 * @revision r1
 */
public class ContentModel {

	/**
	 * username property from @com.yanado.model.restmodel.Node properties
	 */

	private final static String MODEL_CONTENT = "{http://www.alfresco.org/model/content/1.0}";
	private final static String MODEL_OD = "{http://www.organizeddocs.com/model/content/1.0}";
	private final static String MODEL_FORUM = "{http://www.alfresco.org/model/forum/1.0}";
	private final static String MODEL_SYSTEM = "{http://www.alfresco.org/model/system/1.0}";
	private final static String MODEL_APPLICATION = "{http://www.alfresco.org/model/application/1.0}";
	private final static String MODEL_USER = "{http://www.alfresco.org/model/user/1.0}";

	
	
	public final static String TYPE_CONTAINER =MODEL_SYSTEM+"container";
	public final static String TYPE_CONTENT = MODEL_CONTENT + "content";
	public final static String TYPE_FOLDER = MODEL_CONTENT + "folder";
	public final static String TYPE_PROJECT = MODEL_OD + "project";
	public final static String TYPE_THUMBNAIL= MODEL_CONTENT +"thumbnail";
	public final static String TYPE_FORUM = MODEL_FORUM + "forum";
	public final static String TYPE_TOPIC = MODEL_FORUM + "topic";
	public final static String TYPE_POST = MODEL_FORUM + "post";
	public final static String TYPE_AUTHORITY_CONTAINER = MODEL_USER
			+ "authorityContainer";
	public final static String TYPE_USER = MODEL_CONTENT
			+ "person";
	public final static String TYPE_EVENTFOLDER = MODEL_OD + "eventfolder";
	
	/**
	 * used for temp folder for topic
	 */
	public final static String TYPE_TEMPFOLDER = MODEL_OD + "tempfolder";

	public final static String TYPE_FOLDER_LINK = MODEL_APPLICATION
			+ "folderlink";
	public final static String TYPE_STORE_ROOT = MODEL_SYSTEM + "store_root";
	public final static String TYPE_FILE_LINK = MODEL_APPLICATION + "filelink";

	public final static String NODE_CONTENT = MODEL_CONTENT + "content";
	/**
	 * value of content, used for posts
	 */
	public final static String NODE_CONTENT_VALUE = MODEL_CONTENT + "contentValue";
	
	public final static String NODE_EMAIL = MODEL_CONTENT + "email";
	public final static String NODE_USER_NAME = MODEL_CONTENT + "userName";
	public final static String NODE_USER_PASSWORD = MODEL_CONTENT + "password";
	public final static String NODE_LAST_NAME = MODEL_CONTENT + "lastName";
	public final static String NODE_FIRST_NAME = MODEL_CONTENT + "firstName";
	public final static String NODE_ORGANIZATIONID = MODEL_CONTENT
			+ "organizationId";
	public final static String NODE_ORGANIZATION = MODEL_CONTENT
			+ "organization";
	public final static String NODE_JOBTITLE = MODEL_CONTENT + "jobtitle";
	public final static String NODE_LOCATION = MODEL_CONTENT + "location";

	public final static String NODE_UUID = MODEL_SYSTEM + "node-uuid";
	public final static String NODE_NAME = MODEL_CONTENT + "name";
	public final static String NODE_VERSIONLABELE = MODEL_CONTENT + "versionLabel";
	public final static String NODE_DESCRIPTION = MODEL_CONTENT + "description";
	public final static String NODE_MODIFIED = MODEL_CONTENT + "modified";
	public final static String NODE_CREATED = MODEL_CONTENT + "created";
	public final static String NODE_CREATOR = MODEL_CONTENT + "creator";
	public final static String NODE_MODIFIER = MODEL_CONTENT + "modifier";
	public final static String NODE_AUTHOR = MODEL_CONTENT + "author";
	public final static String NODE_DISPLAY_PATH = MODEL_CONTENT
			+ "displaypath";
	public final static String NODE_GROUP_MEMBERS = MODEL_USER + "members";
	public final static String NODE_GROUP_AUTHORITYNAME = MODEL_CONTENT
			+ "authorityName";

	public final static String NODE_STORE_PROTOCOL = MODEL_SYSTEM
			+ "store-protocol";
	public final static String NODE_STORE_IDENTIFIER = MODEL_SYSTEM
			+ "store-identifier";

	public final static String NODE_NODE_DBID = MODEL_SYSTEM + "node-dbid";
	public final static String NODE_DESTINATION = MODEL_CONTENT + "destination";

	public final static String CONTENT = MODEL_CONTENT + "content";

	public final static String ASSOC_AVATAR = MODEL_CONTENT + "avatar";
	public final static String ASSOC_HOME_FOLDER = MODEL_CONTENT + "homeFolder";

	public final static String ASPECT_SHAREABLE = MODEL_OD + "shareable";
	public final static String NODE_ISSHAREABLE = MODEL_OD + "isShareable";
	public final static String NODE_SHARECODE = MODEL_OD + "sharecode";
	public final static String NODE_SHAREDBY = MODEL_OD + "sharedby";
	
	
	public final static String ASPECT_SUBSCRIBED = MODEL_OD + "subscribe";
	public final static String NODE_SUBSCRIBEDUSERS = MODEL_OD + "subscribedusers";
	

	public final static String NODE_PROJECTGROUP = MODEL_OD + "projectgroup";
	public final static String NODE_ADMINGROUP = MODEL_OD + "admingroup";
	public final static String NODE_PUBLICGROUP = MODEL_OD + "publicgroup";
	public final static String NODE_PRIVATEGROUP = MODEL_OD + "privategroup";
	public final static String NODE_PROJECT_FORUM = MODEL_OD + "forum";
	
	
	
	public final static String ASPECT_DEFAULTPROJECTGROUP = MODEL_OD + "defaultprojectgroup";
	public final static String ASPECT_PRIVATEPROJECTGROUP = MODEL_OD + "privateprojectgroup";
	public final static String ASPECT_PUBLICPROJECTGROUP = MODEL_OD + "publicprojectgroup";
	public final static String ASPECT_ADMINPROJECTGROUP= MODEL_OD + "adminprojectgroup";
	
	
	public final static String NODE_ISACTIVE = MODEL_OD + "isActive";

	public final static String ADMIN = "admin";

	public final static String VIRTUAL_PASS = MODEL_CONTENT + "password";
	public final static String VIRTUAL_PASS1 = MODEL_CONTENT + "password1";

	public final static String VIRTUAL_COMMENTSCOUNT = MODEL_FORUM
			+ "commentscount";
	public final static String VIRTUAL_FIRSTREPLY = MODEL_FORUM + "firstreply";

	public final static String VIRTUAL_LASTREPLYDATE = MODEL_FORUM
			+ "lastreplydate";
	public final static String VIRTUAL_LASTREPLY = MODEL_FORUM + "lastreply";
	public final static String VIRTUAL_PRIVATE = MODEL_OD + "private";
	public final static String VIRTUAL_REFERENCE = MODEL_OD + "reference";
	public final static String VIRTUAL_PROJECT = MODEL_OD + "project";
	public final static String VIRTUAL_USERSEMAILS = MODEL_OD + "usersemails";
	public final static String VIRTUAL_PERMISSIONS = MODEL_OD + "permissions";
	public final static String VIRTUAL_PARENTPERMISSIONS = MODEL_OD
			+ "parentpermissions";
	public final static String VIRTUAL_INHERITED = MODEL_OD + "inherited";
	public final static String VIRTUAL_COUNT = MODEL_OD + "count";
	public final static String VIRTUAL_USER_EXISTS = MODEL_OD + "userexists";

	// register
	
	public final static String VIRTUAL_REGISTER_LOCALE = MODEL_OD + "locale";
	public final static String VIRTUAL_REGISTER_URL = MODEL_OD + "url";
	public final static String VIRTUAL_REGISTER_FNAME = MODEL_OD + "fname";
	public final static String VIRTUAL_REGISTER_LNAME = MODEL_OD + "lname";
	public final static String VIRTUAL_REGISTER_EMAIL = MODEL_OD + "email";
	public final static String VIRTUAL_REGISTER_TENANTNAME = MODEL_OD + "tenantName";
	public final static String VIRTUAL_REGISTER_PASS = MODEL_OD + "pass";
	public final static String VIRTUAL_REGISTER_ORGANIZATIONNAME = MODEL_OD + "organizationname";
	public final static String VIRTUAL_REGISTER_SERVER= MODEL_OD + "server";
	public final static String VIRTUAL_REGISTER_TIMEZONE= MODEL_OD + "timezone";
	public final static String VIRTUAL_REGISTER_REFERRAL= MODEL_OD + "referral";
	
	
	public final static String VIRTUAL_PROJECTUSERTYPE= MODEL_OD + "projectusertype";
	
	
	
	
	
	
	

	// EVENT PROPS
	public final static String NODE_EVENTTYPE = MODEL_OD + "eventtype";
	public final static String NODE_EVENT_FOLDER_TYPE = MODEL_OD
			+ "eventfolder";
	public final static String NODE_OD_CREATED = MODEL_OD + "created";
	public final static String NODE_OD_CREATOR = MODEL_OD + "creator";
	public final static String NODE_NODEREF = MODEL_OD + "noderef";
	public final static String NODE_NODEREFTARGET = MODEL_OD + "nodereftarget";
	public final static String NODE_NODEREFTYPE = MODEL_OD + "nodereftype";
	public final static String ASSOC_REFERENCEDBY = MODEL_OD + "referencedby";
	
	
	public final static String NODE_TIMESTAMP_VALUE = MODEL_OD + "timestampvalue";
	public final static String ASPECT_TIMESTAMP= MODEL_OD + "timestamp";
	
	
	
	public final static String VIRTUAL_PRIVATE_USER= MODEL_OD + "private_user";
	public final static String VIRTUAL_PUBLIC_USER= MODEL_OD + "public_user";
	public final static String VIRTUAL_ADMIN_USER= MODEL_OD + "admin";
	
	
	/**
	 * virtual create topic
	 */
	
	
	public final static String CREATE_TOPIC_SELECTUSERS=MODEL_OD +"selectusers1";
	public final static String CREATE_TOPIC_SELECTUSERS_PUBLIC=MODEL_OD +"selectusers1_public";
	
	public final static String CREATE_TOPIC_SELECTGROUPS=MODEL_OD +"selectgroups1";
	
	public final static String CREATE_TOPIC_ISPRIVATE=MODEL_OD +"isprivate";
	public final static String CREATE_TOPIC_SUBSCRIBEDUSERS=MODEL_OD +"subscribedusers";
	
	
	public final static String PREFERENCES_TASKS_HASHTAGS=MODEL_APPLICATION +"taskshashtags";
	
	
	
	/**
	 * returns for instance 'cm-name', used for labels @MetaPropertyRenderer
	 * 
	 * @param value
	 * @return
	 */
	public static String getShort(String value) {
		String shortModel = "";

		if (value.contains(MODEL_CONTENT)) {
			shortModel = "cm";
		} else if (value.contains(MODEL_OD)) {
			shortModel = "sc";
		} else if (value.contains(MODEL_FORUM)) {
			shortModel = "fm";
		} else if (value.contains(MODEL_SYSTEM)) {
			shortModel = "sys";
		} else if (value.contains(MODEL_APPLICATION)) {
			shortModel = "app";
		} else if (value.contains(MODEL_USER)) {
			shortModel = "usr";
		}

		shortModel += "-" + value.split("}")[1];

		return shortModel;

	}

}
