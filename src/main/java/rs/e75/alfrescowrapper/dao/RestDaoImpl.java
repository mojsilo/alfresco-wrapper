package rs.e75.alfrescowrapper.dao;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import rs.e75.alfrescowrapper.constants.ContentModel;
import rs.e75.alfrescowrapper.constants.RestSetsOfData;
import rs.e75.alfrescowrapper.dao.util.ResetServiceStatic;
import rs.e75.alfrescowrapper.exceptions.ForbidenException;
import rs.e75.alfrescowrapper.exceptions.RestException;
import rs.e75.alfrescowrapper.exceptions.ServerNotFoundException;
import rs.e75.alfrescowrapper.exceptions.WebScriptException;
import rs.e75.alfrescowrapper.exceptions.YanadoException;
import rs.e75.alfrescowrapper.model.ActionReturn;
import rs.e75.alfrescowrapper.model.Node;
import rs.e75.alfrescowrapper.model.NodePropertyAbstraction;
import rs.e75.alfrescowrapper.model.NodeRef;
import rs.e75.alfrescowrapper.model.SearchActionReturn;
import rs.e75.alfrescowrapper.model.User;
import rs.e75.alfrescowrapper.service.TimeElapsedService;

import com.thoughtworks.xstream.XStream;


/**
 * 
 * @author Savic Prvoslav
 * @revision r1
 */
public class RestDaoImpl extends ResetServiceStatic implements RestDao {

	private String serverPath = "http://localhost:8080/alfresco/";
	private TimeElapsedService elapsedService;

	public RestDaoImpl(TimeElapsedService elapsedService, String serverPath) {
		this.elapsedService = elapsedService;
		this.serverPath = serverPath;
	}

	public String login(User user) throws RestException,
			ServerNotFoundException, WebScriptException, ForbidenException,
			YanadoException {
		org.apache.commons.lang.time.StopWatch stopWatch = null;
		try {
			stopWatch = new org.apache.commons.lang.time.StopWatch();
			stopWatch.start();

			String fullLoginUrl = serverPath + LOGIN_URI;

			fullLoginUrl = MessageFormat.format(fullLoginUrl, new Object[] {
					user.getFullUserName(), user.getPassword() });
			String xml = executeRest(fullLoginUrl);
			XStream stream = new XStream();
			stream.alias("ticket", String.class);
			String ticket = (String) stream.fromXML(xml);
			return ticket;

		} catch (RestException ex) {
			throw new YanadoException(ex);
		} catch (ServerNotFoundException ex) {
			throw new YanadoException(ex);
		} catch (WebScriptException ex) {
			throw new YanadoException(ex);
		} catch (ForbidenException ex) {
			// forbidenEx is when U/P is not right
			throw ex;
		} catch (Exception ex) {
			throw new YanadoException(ex);
		} finally {
			stopWatch.stop();
			elapsedService.logRestTime("RestService.login", stopWatch);
		}
	}

	public Node loadNodeProperties(NodeRef nodeRef, User user)
			throws RestException, ServerNotFoundException, WebScriptException,
			ForbidenException, YanadoException {
		String fullGetNodeDetails = serverPath + GET_NODE_DETAILS;

		Map<String, String> params = new HashMap<String, String>();
		params.put("current", nodeRef.getId());
		if (nodeRef.getStoreIdentifier() != null
				&& nodeRef.getStoreProtocol() != null) {
			params.put("storeIdentifier", nodeRef.getStoreIdentifier());
			params.put("storeProtocol", nodeRef.getStoreProtocol());

		} else {
			params.put("storeIdentifier", "SpacesStore");
			params.put("storeProtocol", "workspace");

		}
		params.put("set", RestSetsOfData.FULL.toString());

		Node retVal = loadFirst(fullGetNodeDetails, user, params);
		return retVal;

	}

	public List<rs.e75.alfrescowrapper.model.Node> listChildren(User user,
			NodeRef nodeRef, RestSetsOfData setsOfData, Integer length,
			Integer currentPage) throws RestException, ServerNotFoundException,
			WebScriptException, ForbidenException, YanadoException {

		String fullGetChildren = serverPath + GET_CHILDREN;

		Map<String, String> params = new HashMap<String, String>();
		params.put("current", nodeRef.getId());
		params.put("set", setsOfData.toString());

		if (length > 0) {
			params.put("lengthh", length.toString());
		}

		if (currentPage > -1) {
			params.put("currentPage", currentPage.toString());
		}

		List<Node> list = load(fullGetChildren, user, params);

		return list;
	}

	public SearchActionReturn simpleSearch(User user, String query,
			String sortColumn, Boolean asc, String textToShow,
			RestSetsOfData set, Integer length, Integer currentPage)
			throws RestException, ServerNotFoundException, WebScriptException,
			ForbidenException, YanadoException {

		return simpleSearch(user, query, sortColumn, asc, textToShow, set, true);
	}

	public SearchActionReturn simpleSearch(User user, String query,
			String sortColumn, Boolean asc, String textToShow,
			RestSetsOfData set, Integer length, Integer currentPage,
			Boolean typeOrder) throws RestException, ServerNotFoundException,
			WebScriptException, ForbidenException, YanadoException {
		String fullPath = serverPath + ACTION_SEARCH;

		Map<String, String> params = new HashMap<String, String>();
		params.put("store", "SpacesStore");
		params.put("query", query);
		params.put("sortColumn", sortColumn);
		params.put("asc", asc.toString());
		params.put("set", set.toString());
		params.put("typeorder", typeOrder.toString());

		if (length > 0) {
			params.put("lengthh", length.toString());
		}
		if (currentPage > -1) {
			params.put("currentPage", currentPage.toString());
		}

		rs.e75.alfrescowrapper.model.SearchActionReturn actionReturn = executeSearchAction(
				fullPath, user, params);
		actionReturn.setShowText(textToShow);
		return actionReturn;
	}

	public SearchActionReturn simpleSearch(User user, String query,
			String sortColumn, Boolean asc, String textToShow,
			RestSetsOfData set) throws RestException, ServerNotFoundException,
			WebScriptException, ForbidenException, YanadoException {
		return simpleSearch(user, query, sortColumn, asc, textToShow, set, 0,
				-1);
	}

	public SearchActionReturn simpleSearch(User user, String query,
			String sortColumn, Boolean asc, String textToShow,
			RestSetsOfData set, Boolean typeOrder) throws RestException,
			ServerNotFoundException, WebScriptException, ForbidenException,
			YanadoException {
		return simpleSearch(user, query, sortColumn, asc, textToShow, set, 0,
				-1, typeOrder);
	}

	public SearchActionReturn simpleSearch(User user, String query,
			String sortColumn, Boolean asc, String textToShow)
			throws RestException, ServerNotFoundException, WebScriptException,
			ForbidenException, YanadoException {

		return simpleSearch(user, query, sortColumn, asc, textToShow,
				RestSetsOfData.FULL);
	}

	public ActionReturn createFolder(User user,
			NodePropertyAbstraction abstraction, NodeRef currentNode)
			throws RestException, ServerNotFoundException, WebScriptException,
			ForbidenException, YanadoException {
		String fullPath = serverPath + ACTION_CREATE_FOLDER;

		Map<String, String> params = new HashMap<String, String>();
		getModifiedProperties(abstraction, params);
		params.put("current", currentNode.getId());
		params.put("set", RestSetsOfData.FULL.toString());

		return executeAction(fullPath, user, params);

	}

	public ActionReturn executeDelete(User user, Node node)
			throws RestException, ServerNotFoundException, WebScriptException,
			ForbidenException, YanadoException {

		List<Node> list = new ArrayList<Node>();
		list.add(node);
		return executeDelete(user, list);

	}

	public ActionReturn executeDelete(User user, List<Node> nodes)
			throws RestException, ServerNotFoundException, WebScriptException,
			ForbidenException, YanadoException {
		String fullPath = serverPath + ACTION_DELETE;

		String ids = getIdsString(nodes);

		Map<String, String> params = new HashMap<String, String>();
		params.put("who", ids);
		params.put("set", RestSetsOfData.FULL.toString());

		return executeAction(fullPath, user, params);

	}

	public ActionReturn updateNode(User user,
			NodePropertyAbstraction abstraction) throws RestException,
			ServerNotFoundException, WebScriptException, ForbidenException,
			YanadoException {
		String fullPath = serverPath + ACTION_UPDATE;

		Map<String, String> params = new HashMap<String, String>();
		getModifiedProperties(abstraction, params);
		params.put("current", abstraction.getId());
		params.put("set", RestSetsOfData.FULL.toString());

		return executeAction(fullPath, user, params);

	}

	public ActionReturn uploadFile(User user,
			NodePropertyAbstraction abstraction, NodeRef currentNode,
			String path) throws RestException, ServerNotFoundException,
			WebScriptException, ForbidenException, YanadoException {
		String fullPath = serverPath + ACTION_UPLOAD;

		Map<String, String> params = new HashMap<String, String>();
		getModifiedProperties(abstraction, params);
		params.put("current", currentNode.getId());
		params.put("file", path);
		params.put("set", RestSetsOfData.FULL.toString());

		return executeAction(fullPath, user, params);

	}

	public ActionReturn createGroup(User user, String newGroupName,
			String currentNodeGroup) throws RestException,
			ServerNotFoundException, WebScriptException, ForbidenException,
			YanadoException {
		String fullPath = serverPath + ACTION_CREATE_GROUP;

		Map<String, String> params = new HashMap<String, String>();
		if (currentNodeGroup != null) {
			params.put("current", currentNodeGroup);
		}
		params.put("newgroup", newGroupName);

		ActionReturn actionReturn = executeAction(fullPath, user, params);

		return actionReturn;
	}

	public List<Node> listGroups(Node group, User user, Integer length,
			Integer currentPage) throws RestException, ServerNotFoundException,
			WebScriptException, ForbidenException, YanadoException {
		String fullGetChildren = serverPath + GET_GROUPS;

		Map<String, String> params = new HashMap<String, String>();
		if (group == null) {
			params.put("root", "value");
		} else {
			logger.debug("GROUP NAME " + group.getName());

			params.put("group", group.getId());
		}

		if (length > 0) {
			params.put("lengthh", length.toString());
		}

		if (currentPage > -1) {
			params.put("currentPage", currentPage.toString());
		}

		params.put("set", RestSetsOfData.FULL.toString());

		List<Node> list = load(fullGetChildren, user, params);

		return list;

	}

	public ActionReturn executeAddUser(User user, NodePropertyAbstraction node)
			throws RestException, ServerNotFoundException, WebScriptException,
			ForbidenException, YanadoException {
		String fullPath = serverPath + ACTION_CREATE_USER;

		Map<String, String> params = new HashMap<String, String>();
		String userName = node.getPropertyNode(ContentModel.NODE_USER_NAME)
				.getStringValue();
		// if(!userName.contains("@"))
		// {
		// userName+= "@" + user.getTenant();
		// }

		String firstName = node.getPropertyNode(ContentModel.NODE_FIRST_NAME)
				.getStringValue();

		String lastName = node.getPropertyNode(ContentModel.NODE_LAST_NAME)
				.getStringValue();

		String email = node.getPropertyNode(ContentModel.NODE_EMAIL)
				.getStringValue();

		String password = node.getPropertyNode(ContentModel.NODE_USER_PASSWORD)
				.getStringValue();

		params.put("username", userName);
		params.put("firstname", firstName);
		params.put("lastname", lastName);
		params.put("email", email);
		params.put("password", password);
		params.put("set", RestSetsOfData.FULL.toString());

		ActionReturn actionReturn = executeAction(fullPath, user, params);

		return actionReturn;

	}

	public ActionReturn saveAuthoritiesToGroup(User currentUser,
			Node currentGroup, List<Node> users) throws RestException,
			ServerNotFoundException, WebScriptException, ForbidenException,
			YanadoException {
		String fullPath = serverPath + GET_SAVEAUTHORITIESTOGROUP;

		Map<String, String> params = new HashMap<String, String>();

		params.put("current", currentGroup.getNodeRef().toNodeRef());

		params.put("authorities", getIdsString(users));

		params.put("set", RestSetsOfData.FULL.toString());

		ActionReturn actionReturn = executeAction(fullPath, currentUser, params);

		return actionReturn;
	}

	public String getContent(User user, Node node) throws RestException,
			ServerNotFoundException, WebScriptException, ForbidenException,
			YanadoException {

		rs.e75.alfrescowrapper.model.Content content = ((rs.e75.alfrescowrapper.model.Content) node
				.getPropertie(ContentModel.CONTENT));

		if (content != null) {
			String downLoadUrl = serverPath + content.getUrl().trim() + "?ticket="
					+ user.getTicket();
			logger.debug("DOWNLOAD URL: " + downLoadUrl);
			return downLoadUrl;
		} else {
			return null;
		}
	}

	

	public List<rs.e75.alfrescowrapper.model.Node> listContentVersions(User user,
			NodeRef nodeRef, RestSetsOfData setsOfData, Integer length,
			Integer currentPage) throws RestException, ServerNotFoundException,
			WebScriptException, ForbidenException, YanadoException {

		String fullGetChildren = serverPath + GET_LISTVERSIONS;

		Map<String, String> params = new HashMap<String, String>();
		params.put("current", nodeRef.getId());
		params.put("set", setsOfData.toString());

		if (length > 0) {
			params.put("lengthh", length.toString());
		}

		if (currentPage > -1) {
			params.put("currentPage", currentPage.toString());
		}

		List<Node> list = load(fullGetChildren, user, params);

		return list;
	}
	
	public List<rs.e75.alfrescowrapper.model.Node> deleteVersions(User user,
			NodeRef nodeRef, RestSetsOfData setsOfData, Integer length,
			Integer currentPage,String version) throws RestException, ServerNotFoundException,
			WebScriptException, ForbidenException, YanadoException {

		String fullGetChildren = serverPath + GET_DELETEVERSION;

		Map<String, String> params = new HashMap<String, String>();
		params.put("current", nodeRef.getId());
		params.put("set", setsOfData.toString());
		params.put("version",version);

		if (length > 0) {
			params.put("lengthh", length.toString());
		}

		if (currentPage > -1) {
			params.put("currentPage", currentPage.toString());
		}

		List<Node> list = load(fullGetChildren, user, params);

		return list;
	}
	
	
	
	public ActionReturn executeMove( User user,
			List<Node> items, Node target)
			throws RestException, ServerNotFoundException, WebScriptException,
			ForbidenException, YanadoException {
		String fullPath=serverPath + ACTION_MOVE;
		String ids = getIdsString(items);

		Map<String, String> params = new HashMap<String, String>();
		params.put("where", target.getNodeRef().getId());
		params.put("who", ids);
		params.put("set", RestSetsOfData.FULL.toString());

		return executeAction(fullPath, user, params);

	}
	
	public ActionReturn executeMoveRevert( User user,
			List<Node> items, Node target)
			throws RestException, ServerNotFoundException, WebScriptException,
			ForbidenException, YanadoException {
		String fullPath=serverPath + ACTION_MOVE_REVERT;
		String ids = getIdsString(items);

		Map<String, String> params = new HashMap<String, String>();
		params.put("where", target.getNodeRef().getId());
		params.put("who", ids);
		params.put("set", RestSetsOfData.FULL.toString());

		return executeAction(fullPath, user, params);

	}

	
	public ActionReturn changePass(User user, String userName, String passWord) throws RestException,
			ServerNotFoundException, WebScriptException, ForbidenException,
			YanadoException {
		String fullPath=serverPath + ACTION_CHANGE_PASS;

		
	
		try {
			passWord = URLEncoder.encode(passWord, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new YanadoException(e);
		}

		Map<String, String> params = new HashMap<String, String>();
		params.put("password", passWord);
		params.put("username", userName);
		params.put("set", RestSetsOfData.FULL.toString());

		return executeAction(fullPath, user, params);

	}
}
