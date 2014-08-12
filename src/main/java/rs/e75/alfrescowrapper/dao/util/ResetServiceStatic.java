package rs.e75.alfrescowrapper.dao.util;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.ws.WebServiceException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import rs.e75.alfrescowrapper.constants.Constants;
import rs.e75.alfrescowrapper.dao.RestDaoImpl;
import rs.e75.alfrescowrapper.exceptions.ForbidenException;
import rs.e75.alfrescowrapper.exceptions.RestException;
import rs.e75.alfrescowrapper.exceptions.ServerNotFoundException;
import rs.e75.alfrescowrapper.exceptions.WebScriptException;
import rs.e75.alfrescowrapper.exceptions.YanadoException;
import rs.e75.alfrescowrapper.model.ActionReturn;
import rs.e75.alfrescowrapper.model.Content;
import rs.e75.alfrescowrapper.model.Node;
import rs.e75.alfrescowrapper.model.NodeProperty;
import rs.e75.alfrescowrapper.model.NodePropertyAbstraction;
import rs.e75.alfrescowrapper.model.NodeRef;
import rs.e75.alfrescowrapper.model.Permission;
import rs.e75.alfrescowrapper.model.SearchActionReturn;
import rs.e75.alfrescowrapper.model.User;
import rs.e75.alfrescowrapper.util.YanadoDefaultHttpClient;

import com.thoughtworks.xstream.XStream;

/**
 * 
 * @author Savic Prvoslav
 * 
 */
public class ResetServiceStatic {
	protected static Logger logger = Logger.getLogger(RestDaoImpl.class);

	protected final String LOGIN_URI = "service/api/login?u={0}&pw={1}";

	protected final String LOGIN_AS_ANY_URI = "LoginAsAnyUserServlet?adminpassword={0}&username={1}";

	protected final String GET_USER_DETAILS = "service/yanado/listusers/";
	protected final String GET_USER_PREFERENCES = "service/yanado/getuserpreferences/";

	protected final String GET_USERS = "service/yanado/listusers/";
	protected final String GET_USERS_FILTER = "service/yanado/listusers/";

	protected final String GET_NODE_DETAILS = "service/yanado/listnodedetails/";
	protected final String GET_CHILDREN = "service/yanado/listchildren/";
	protected final String GET_CHILDREN_TREE = "service/yanado/listchildrentree/";
	protected final String GET_PARENTS = "service/yanado/navigation/";

	protected final String ACTION_PASTE = "service/yanado/paste/";
	protected final String ACTION_PASTE_AS_LINK = "service/yanado/pasteaslink/";

	protected final String ACTION_DELETE = "service/yanado/delete/";
	protected final String ACTION_MOVEPACKAGETOTASKS = "service/yanado/movepackagetotasks/";
	protected final String ACTION_UPDATE = "service/yanado/saveproperties/";
	protected final String ACTION_CREATE_FOLDER = "service/yanado/createfolder/";

	protected final String ACTION_CHANGE_PASS = "service/yanado/changepassword/";

	protected final String ACTION_CHANGE_PASS_SERVLET = "SetUserPass?ticket={0}&username={1}&password={2}&tenantname={3}";

	protected final String ACTION_SEARCH = "service/yanado/search/";

	protected final String ACTION_FORUM_SEARCH = "service/yanado/forumsearch/";

	protected final String ACTION_CREATE_POST = "service/yanado/postcomment/";

	protected final String GET_NODE_DISCUSSION = "service/yanado/listdiscussions/";

	protected final String GET_PROJECTS = "service/yanado/listprojects/";

	protected final String GET_PROJECTS_FILTER = "service/yanado/listprojects/";

	protected final String GET_PROJECT_EVENTS = "service/yanado/listprojectsevents/";

	protected final String GET_GROUPS = "service/yanado/listgroups/";

	protected final String ACTION_CREATE_USER = "service/yanado/createuser/";

	protected final String ACTION_CREATE_GROUP = "service/yanado/creategroup/";

	protected final String ACTION_CREATE_PROJECT = "service/yanado/createproject/";

	protected final String ACTION_CREATE_TOPIC = "service/yanado/createtopic/";

	protected final String ACTION_CREATE_TOPIC_FOLDER = "service/yanado/createtopicfolder/";

	protected final String ACTION_AUTO_SAVE_TOPIC = "service/yanado/autosavetopic/";
	protected final String ACTION_AUTO_SAVE_TOPIC_REPLY = "service/yanado/autosavetopicreply/";
	protected final String ACTION_SHARE = "service/yanado/sharenode/";

	protected final String ACTION_UNSHARE = "service/yanado/unsharenode/";
	protected final String ACTION_NODEPERMISSIONS = "service/yanado/nodepermissions/";
	protected final String ACTION_NODEPERMISSIONSV2 = "service/yanado/nodepermissionsV2/";
	protected final String ACTION_DELETENODEPERMISSIONS = "service/yanado/deletenodepermissions/";
	protected final String ACTION_REPLACE_NODEPERMISSIONS = "service/yanado/replacenodepermissions/";

	protected final String GET_SEARCHGROUPSPROJECT = "service/yanado/listgroupsproject/";

	protected final String GET_SAVEAUTHORITIESTOGROUP = "service/yanado/saveauthoritiestogroup/";
	protected final String GET_REMOVEAUTHORITIESFROMGROUP = "service/yanado/removeauthoritiesfromgroup/";
	protected final String GET_LISTASSOCS = "service/yanado/listassocs/";
	protected final String GET_CREATEPOOL = "service/yanado/createpool/";

	protected final String GET_REGISTER = "service/yanado/register/";

	protected final String ACTION_SUBSCRIBE = "service/yanado/subscribe/";
	protected final String ACTION_UNSCRIBE = "service/yanado/unscribe/";

	protected final String GET_PROJECT_ROOT_GROUPS = "service/yanado/listprojectgrupsnosearch/";
	protected final String GET_PROJECT_USERS = "service/yanado/listprojectusersnosearch/";

	protected final String GET_USER_SHORTCUTS = "ShortCutServlet?ticket={0}";

	protected final String ACTION_UPLOAD = "service/yanado/upload/";

	protected final String GET_LISTVERSIONS = "service/yanado/listversions/";

	protected final String GET_DELETEVERSION = "service/yanado/deleteversion/";

	protected final String ACTION_MOVE = "service/yanado/move/";

	protected final String ACTION_MOVE_REVERT = "service/yanado/moverevert/";

	/*
	 * @Autowired private TimeElapsedService elapsedService;
	 */

	protected String executePostRest(String url, Map<String, String> paramMap)
			throws RestException, ServerNotFoundException, WebScriptException,
			ForbidenException, YanadoException {

		Date dateTimer = new Date();

		logger.debug("REST " + url);

		// DefaultHttpClient httpClient = YanadoDefaultHttpClient.getInstance();

		DefaultHttpClient httpClient = new DefaultHttpClient();

		Iterator<String> it = paramMap.keySet().iterator();
		String ticket = "";
		while (it.hasNext()) {
			String key = it.next();
			if (key.equals("alf_ticket")) {
				ticket = paramMap.get(key);
			}
		}

		HttpPost httpPost = new HttpPost(url + "?alf_ticket=" + ticket);

		MultipartEntityBuilder multipart = MultipartEntityBuilder.create();
		multipart.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);

		Iterator<String> it1 = paramMap.keySet().iterator();
		while (it1.hasNext()) {
			String key = it1.next();
			String value = paramMap.get(key);

			if (key.equals("file")) {
				FileBody bin = new FileBody(new File(value));

				multipart.addPart("file", bin);
			} else {
				try {
					multipart.addPart(key, new StringBody(value));
				} catch (UnsupportedEncodingException e) {
					throw new YanadoException(e);
				}
			}

		}
		HttpEntity reqEntit = multipart.build();
		httpPost.setEntity(reqEntit);

		// try {
		// httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
		// } catch (UnsupportedEncodingException e1) {
		// e1.printStackTrace();
		// }
		//
		Date dateCreating = new Date();
		logger.debug("creating :"
				+ (dateCreating.getTime() - dateTimer.getTime()));
		HttpResponse response;
		String output;
		try {
			response = httpClient.execute(httpPost);
			Date dateMeasure = new Date();
			logger.debug("waiting :"
					+ (dateMeasure.getTime() - dateTimer.getTime()));
			Integer statucCode = response.getStatusLine().getStatusCode();
			switch (statucCode) {
			case 404: {
				logger.debug(response);
				throw new ServerNotFoundException("server not found");
			}

			case 500: {
				logger.debug(response + " " + response.getEntity());
				throw new WebServiceException("web script exception on" + url);
			}

			case 403: {
				logger.debug(response + " " + response.getEntity());
				throw new ForbidenException("forbiden exception on " + url);
			}
			case 401: {
				logger.debug(response);
				throw new ForbidenException("forbiden exception on " + url);
			}

			}
			output = EntityUtils.toString(response.getEntity());
			logger.debug("receiving :"
					+ (new Date().getTime() - dateMeasure.getTime()));
		} catch (ParseException e) {
			throw new RestException("execute rest " + url, e);

		} catch (IOException e) {
			throw new RestException("execute rest " + url, e);
		} catch (Exception e) {
			throw new YanadoException(e);
		} finally {

			// httpClient.getConnectionManager().shutdown();
		}

		return output;
	}

	protected String executeRest(String url) throws RestException,
			ServerNotFoundException, WebScriptException, ForbidenException,
			YanadoException {
		logger.debug("REST " + url);
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpGet getRequest = new HttpGet(url);
		HttpResponse response;
		String output;
		try {
			response = httpClient.execute(getRequest);

			Integer statucCode = response.getStatusLine().getStatusCode();
			switch (statucCode) {
			case 404:
				throw new ServerNotFoundException("server not found");

			case 500:
				throw new WebServiceException("web script exception on" + url);

			case 403:
				throw new ForbidenException("forbiden exception on " + url);

			}
			output = EntityUtils.toString(response.getEntity());
		} catch (ParseException e) {
			throw new RestException("execute rest " + url, e);

		} catch (IOException e) {
			throw new RestException("execute rest " + url, e);
		} catch (Exception e) {
			throw new YanadoException(e);
		} finally {
			httpClient.getConnectionManager().shutdown();
		}

		return output;
	}

	protected static XStream getXStream() {
		XStream stream = new XStream();

		stream.alias("nodes", ArrayList.class);
		stream.alias("strings", ArrayList.class);

		stream.alias("node", Node.class);

		stream.alias("list", ArrayList.class);
		stream.alias("listelement", String.class);

		stream.alias("aspects", ArrayList.class);
		stream.alias("children", ArrayList.class);
		stream.alias("aspect", String.class);

		stream.alias("permissions", HashMap.class);
		stream.alias("detailedpermissions", ArrayList.class);
		stream.alias("permission", Permission.class);

		stream.alias("properties", HashMap.class);
		stream.alias("asocs", HashMap.class);
		stream.alias("nodeRef", NodeRef.class);
		stream.alias("nodeRefs", ArrayList.class);
		stream.alias("content", Content.class);

		stream.alias("parentNodeRef", NodeRef.class);

		return stream;
	}

	private Object getXmlObject(XStream stream, String xml) {
		// StopWatch stopWatch = null;
		//
		// stopWatch = new StopWatch();
		// stopWatch.start();

		Object object = stream.fromXML(xml);

		// stopWatch.stop();
		// elapsedService.logRestTime("ResetServiceStatic.convertXml",
		// stopWatch);

		return object;
	}

	@SuppressWarnings("unchecked")
	/**
	 * converts xml to list of nodes
	 * @param xml
	 * @return
	 */
	protected List<Node> convertToNodes(String xml) throws YanadoException {
		try {
			XStream stream = getXStream();

			List<Node> list = (List<Node>) getXmlObject(stream, xml);

			return list;
		} catch (Exception e) {
			logger.debug(xml);
			throw new YanadoException(e);
		}

	}

	protected ActionReturn convertToActionReturn(String xml)
			throws YanadoException {
		try {
			XStream stream = getXStream();
			stream.alias("actionreturn", ActionReturn.class);

			ActionReturn actionReturn = (ActionReturn) getXmlObject(stream, xml);
			return actionReturn;
		} catch (Exception e) {
			logger.debug(xml);
			throw new YanadoException(e);
		}

	}

	protected SearchActionReturn convertToSearchActionReturn(String xml)
			throws YanadoException {
		try {
			XStream stream = getXStream();

			stream.alias("actionreturn", SearchActionReturn.class);

			SearchActionReturn actionReturn = (SearchActionReturn) getXmlObject(
					stream, xml);

			return actionReturn;
		} catch (Exception e) {
			logger.debug(xml);
			throw new YanadoException(e);
		}

	}

	// /**
	// * returns ids in format id;id;id
	// *
	// * @param list
	// * @return
	// */
	// protected String getClipBoardRestString(List<ClipBoardItem> list) {
	//
	// String ids = "";
	// for (int i = 0; i < list.size(); i++) {
	// if (i == 0) {
	// ids += list.get(i).toString();
	// } else {
	// ids += ";" + list.get(i).toString();
	// }
	// }
	//
	// return ids;
	// }

	protected void getModifiedProperties(NodePropertyAbstraction abstraction,
			Map<String, String> params) throws YanadoException {
		List<NodeProperty> list = abstraction.getModifiedNodeProperties();
		// String exportProps = "";

		for (int i = 0; i < list.size(); i++) {

			// exportProps += "&";
			// try {
			// exportProps += URLEncoder
			// .encode(list.get(i).getName(), "UTF-8")
			// + "="
			// + URLEncoder.encode((String) list.get(i).getValue(),
			// "UTF-8");
			// params.put(URLEncoder.encode(list.get(i).getName(),
			// Constants.UTF8), URLEncoder.encode((String) list.get(i)
			// .getValue(), Constants.UTF8));

			try {

				String value = URLEncoder.encode((String) list.get(i)
						.getValue(), "UTF-8");
				value = value.replace("+", " ");// there is some problem with
												// decoing on alf side
				params.put(list.get(i).getName(), value);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}

		}

		// return exportProps;
	}

	protected String getIdsString(List<Node> list) {

		String ids = "";
		for (int i = 0; i < list.size(); i++) {
			if (i == 0) {
				ids += list.get(i).getNodeRef().toNodeRef();
			} else {
				ids += ";" + list.get(i).getNodeRef().toNodeRef();
			}
		}

		return ids;
	}

	/**
	 * returns all nodes from the alfresco server
	 * 
	 * @param url
	 * @param user
	 * @return
	 */
	protected List<Node> load(String url, User user,
			Map<String, String> paramMap) throws RestException,
			ServerNotFoundException, WebScriptException, ForbidenException,
			YanadoException {
		if (!user.getLoggedIn()) {
			return new ArrayList<Node>();
		}

		logger.debug(url);

		paramMap.put(Constants.ALF_TICKET, user.getTicket());

		printParams(paramMap);

		String xml;

		// if (paramMap == null) {
		// paramMap = new HashMap<String, String>();
		// }

		xml = executePostRest(url, paramMap);
		List<Node> list = convertToNodes(xml);

		return list;

	}

	/**
	 * returns first node in the return list
	 * 
	 * @param url
	 * @param user
	 * @return
	 */
	protected Node loadFirst(String url, User user, Map<String, String> paramMap)
			throws RestException, ServerNotFoundException, WebScriptException,
			ForbidenException, YanadoException {

		List<Node> list = load(url, user, paramMap);

		if (list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}

	}

	protected ActionReturn executeAction(String url, User user,
			Map<String, String> paramMap) throws RestException,
			ServerNotFoundException, WebScriptException, ForbidenException,
			YanadoException {

		if (user == null) {
			throw new YanadoException(new IllegalStateException(
					"user is null @ executeAction(..)"));
		}

		if (!user.getLoggedIn()) {
			throw new YanadoException(new IllegalStateException(
					"user is not logged in @ executeAction(..)"));
		}
		if (paramMap == null) {
			paramMap = new HashMap<String, String>();
		}

		paramMap.put(Constants.ALF_TICKET, user.getTicket());

		printParams(paramMap);

		String xml = executePostRest(url, paramMap);
		ActionReturn actionReturn = convertToActionReturn(xml);

		return actionReturn;

	}

	protected ActionReturn executePostAction(String url, User user,
			Map<String, String> paramMap) throws RestException,
			ServerNotFoundException, WebScriptException, ForbidenException,
			YanadoException {

		if (!user.getLoggedIn()) {
			return new ActionReturn();
		}

		if (paramMap == null) {
			paramMap = new HashMap<String, String>();
		}

		paramMap.put(Constants.ALF_TICKET, user.getTicket());

		printParams(paramMap);

		String xml = executePostRest(url, paramMap);
		ActionReturn actionReturn = convertToActionReturn(xml);

		return actionReturn;

	}

	protected void printParams(Map<String, String> paramMap) {
		Iterator<String> it = paramMap.keySet().iterator();

		while (it.hasNext()) {
			String key = it.next();

			String value = paramMap.get(key);
			String print = "<input name='" + key + "' value='" + value + "'/>";
			logger.debug(print);

		}
	}

	protected SearchActionReturn executeSearchAction(String url, User user,
			Map<String, String> paramMap) throws RestException,
			ServerNotFoundException, WebScriptException, ForbidenException,
			YanadoException {

		if (!user.getLoggedIn()) {
			return new SearchActionReturn();
		}

		if (paramMap == null) {
			paramMap = new HashMap<String, String>();
		}

		paramMap.put(Constants.ALF_TICKET, user.getTicket());

		printParams(paramMap);

		String xml = executePostRest(url, paramMap);

		// logger.debug(xml);

		SearchActionReturn actionReturn = convertToSearchActionReturn(xml);

		return actionReturn;

	}

}
