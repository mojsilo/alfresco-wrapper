package rs.e75.alfrescowrapper.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import rs.e75.alfrescowrapper.constants.ContentModel;
import rs.e75.alfrescowrapper.constants.RestSetsOfData;
import rs.e75.alfrescowrapper.exceptions.ForbidenException;
import rs.e75.alfrescowrapper.exceptions.YanadoException;
import rs.e75.alfrescowrapper.model.ActionReturn;
import rs.e75.alfrescowrapper.model.Content;
import rs.e75.alfrescowrapper.model.Node;
import rs.e75.alfrescowrapper.model.NodePropertyAbstraction;
import rs.e75.alfrescowrapper.model.NodeRef;
import rs.e75.alfrescowrapper.model.User;
import rs.e75.alfrescowrapper.service.MemberService;
import rs.e75.alfrescowrapper.service.ServiceFactory;

/**
 * 
 * @author Savic Prvoslav
 * 
 *         Logovanje Ucitavanje Noda Listanje foldera Pretraga
 * 
 *         Create folder Delete Node Update node Upload fajla
 * 
 */
public class LoginTest {

	private static Logger logger = Logger.getLogger(LoginTest.class);

	private static String DESCRIPTION = "Ovo ce biti opis";
	private static String DESCRIPTION1 = "Ovo ce biti opis 1";
	private static String FOLDER_NAME = "new folder";
	private static String FILE_NAME = "slika13.png";
	private static String FILE_NAME2 = "slika13_yoyoy.png";
	private static String FILE_PATH = "C:\\Users\\Prvoslav\\Desktop\\440.png";
	private static String COMPANY_HOME_REF = "workspace://SpacesStore/7f4061df-a8c4-432e-9f00-e0188965fcaf";

	private static String USERNAME = "admin";
	private static String PASS = "admin";
	private static String serverPath = "http://localhost:8080/alfresco/";

	private static String GROUP_NAME = "sntgroup";
	private static String GROUP_NAME2 = "sntgroup2";

	/**
	 * This example shows how to login.
	 * 
	 * 
	 * @return
	 */
	private static User loginExample() {
		MemberService memberService = ServiceFactory.getFactory(serverPath)
				.getMemberService();

		User user = new User();
		user.setUsername(USERNAME);
		user.setPassword(PASS);

		try {

			logger.debug(memberService.login(user));

		} catch (ForbidenException e) {
			e.printStackTrace();
		} catch (YanadoException e) {
			e.printStackTrace();
		}

		return user;
	}

	/**
	 * Company home is starting point in alfresco, company home ref is hard
	 * coded and should be changed when enviroment changes
	 * 
	 * @param user
	 * @return
	 */
	private static Node loadCompanyHome(User user) {

		Node companyHomeNode = null;
		try {
			NodeRef nodeRef = new NodeRef(COMPANY_HOME_REF);

			companyHomeNode = ServiceFactory.getFactory(serverPath)
					.getNodeService()
					.loadNode(nodeRef, user, "loadCompanyHome");
		} catch (YanadoException e) {

			e.printStackTrace();
		}
		return companyHomeNode;
	}

	/**
	 * Crates group with name
	 * 
	 * @param user
	 * @return
	 */
	private static Node createGroup(User user) {

		try {

			ActionReturn actionReturn = ServiceFactory.getFactory(serverPath)
					.getMemberService().createGroup(user, GROUP_NAME, null);

			return actionReturn.getFistNode();
		} catch (YanadoException e) {

			e.printStackTrace();
		}
		return null;
	}

	private static List<Node> getGroups(User user, Node group) {
		try {

			return ServiceFactory.getFactory(serverPath).getMemberService()
					.listGroups(group, user, 0, -1);
		} catch (YanadoException e) {

			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Creates A group sntgroup2 in a group sntgroup
	 * 
	 * @param user
	 * @return
	 */
	private static Node createGroupInAGroup(User user) {

		try {

			ActionReturn actionReturn = ServiceFactory.getFactory(serverPath)
					.getMemberService()
					.createGroup(user, GROUP_NAME2, "GROUP_" + GROUP_NAME);

			return actionReturn.getFistNode();
		} catch (YanadoException e) {

			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Uploading file from local hard disc to folder(node) on server
	 * 
	 * @param user
	 * @param node
	 * @return
	 */
	private static Node uploadFile(User user, Node node) {
		try {
			NodePropertyAbstraction abstraction = new NodePropertyAbstraction(
					new Node());
			Map<String, Object> map = new HashMap<String, Object>();
			map.put(ContentModel.NODE_NAME, null);
			map.put(ContentModel.NODE_DESCRIPTION, null);
			abstraction.getPropertyNode(ContentModel.NODE_NAME).setValue(
					FILE_NAME);
			abstraction.getPropertyNode(ContentModel.NODE_DESCRIPTION)
					.setValue(DESCRIPTION1);

			ActionReturn actionReturn = ServiceFactory.getFactory(serverPath)
					.getNodeService()
					.upload(user, abstraction, node.getNodeRef(), FILE_PATH);

			return actionReturn.getFistNode();

		} catch (YanadoException e) {
			e.printStackTrace();
		}
		return null;
	}

	private static Node uploadFile2(User user, Node node) {
		try {
			NodePropertyAbstraction abstraction = new NodePropertyAbstraction(
					new Node());
			Map<String, Object> map = new HashMap<String, Object>();
			map.put(ContentModel.NODE_NAME, null);
			map.put(ContentModel.NODE_DESCRIPTION, null);
			abstraction.getPropertyNode(ContentModel.NODE_NAME).setValue(
					FILE_NAME2);
			abstraction.getPropertyNode(ContentModel.NODE_DESCRIPTION)
					.setValue(DESCRIPTION1);

			ActionReturn actionReturn = ServiceFactory.getFactory(serverPath)
					.getNodeService()
					.upload(user, abstraction, node.getNodeRef(), FILE_PATH);

			return actionReturn.getFistNode();

		} catch (YanadoException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Creating folder in folder(node)
	 * 
	 * @param user
	 * @param node
	 * @return
	 */
	private static Node createFolder(User user, Node node) {
		try {
			NodePropertyAbstraction abstraction = new NodePropertyAbstraction(
					new Node());
			Map<String, Object> map = new HashMap<String, Object>();
			map.put(ContentModel.NODE_NAME, null);
			map.put(ContentModel.NODE_DESCRIPTION, null);

			abstraction.getPropertyNode(ContentModel.NODE_NAME).setValue(
					FOLDER_NAME);
			abstraction.getPropertyNode(ContentModel.NODE_DESCRIPTION)
					.setValue(DESCRIPTION1);
			abstraction.getModifiedNodeProperties();
			ActionReturn actionReturn;

			actionReturn = ServiceFactory.getFactory(serverPath)
					.getNodeService()
					.createFolder(user, abstraction, node.getNodeRef());

			Node createdFolder = actionReturn.getFistNode();
			return createdFolder;

		} catch (YanadoException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Deleting file/folder on server , file and folder are represented with
	 * node
	 * 
	 * @param user
	 * @param node
	 */
	private static void delete(User user, Node node) {
		try {
			ServiceFactory.getFactory(serverPath).getNodeService()
					.executeDelete(user, node);
		} catch (YanadoException e) {
			e.printStackTrace();
		}
	}

	/**
	 * UPdating node, and setting description property to @DESCRIPTION
	 * 
	 * @param user
	 * @param node
	 * @return
	 */
	private static Node updateNode(User user, Node node) {
		try {
			NodePropertyAbstraction abstractionFolderEdit = new NodePropertyAbstraction(
					node);

			abstractionFolderEdit
					.getPropertyNode(ContentModel.NODE_DESCRIPTION).setValue(
							DESCRIPTION);

			ActionReturn actionReturnUpdatedFolder;

			actionReturnUpdatedFolder = ServiceFactory.getFactory(serverPath)
					.getNodeService().updateNode(user, abstractionFolderEdit);

			return actionReturnUpdatedFolder.getFistNode();
		} catch (YanadoException e) {

			e.printStackTrace();
		}

		return null;
	}

	private static Node createUser(User user) {
		try {
			NodePropertyAbstraction abstraction = new NodePropertyAbstraction(
					new Node());

			abstraction.getPropertyNode(ContentModel.NODE_USER_NAME).setValue(
					"prvoslav");
			abstraction.getPropertyNode(ContentModel.NODE_FIRST_NAME).setValue(
					"savic");
			abstraction.getPropertyNode(ContentModel.NODE_LAST_NAME).setValue(
					"lastname");
			abstraction.getPropertyNode(ContentModel.NODE_EMAIL).setValue(
					"savic.prvoslav@gmail.com");
			abstraction.getPropertyNode(ContentModel.NODE_USER_PASSWORD)
					.setValue("admin");

			ActionReturn actionReturnUpdatedFolder;

			actionReturnUpdatedFolder = ServiceFactory.getFactory(serverPath)
					.getMemberService().executeAddUser(abstraction, user);

			return actionReturnUpdatedFolder.getFistNode();
		} catch (YanadoException e) {

			e.printStackTrace();
		}

		return null;
	}

	private static void addAuthoritiesToGrup(User user, Node userToAdd,
			Node currentGroup) {
		try {

			List<Node> users = new ArrayList<Node>();
			users.add(userToAdd);

			ServiceFactory.getFactory(serverPath).getMemberService()
					.saveAuthoritiesToGroup(user, currentGroup, users);

		} catch (YanadoException e) {

			e.printStackTrace();
		}

	}

	private static String getContent(User user, Node content) {
		try {

			return ServiceFactory.getFactory(serverPath).getNodeService()
					.getContent(user, content);

		} catch (YanadoException e) {

			e.printStackTrace();
		}

		return null;

	}

	private static List<Node> listContentVersions(User user, Node content) {
		try {

			return ServiceFactory
					.getFactory(serverPath)
					.getNodeService()
					.listContentVersions(content.getNodeRef(), user,
							RestSetsOfData.FULL, 0, -1);

		} catch (YanadoException e) {

			e.printStackTrace();
		}

		return null;

	}

	private static List<Node> deleteVersion(User user, Node content,
			String version) {
		try {

			return ServiceFactory
					.getFactory(serverPath)
					.getNodeService()
					.deleteVersions(content.getNodeRef(), user,
							RestSetsOfData.FULL, 0, -1, version);

		} catch (YanadoException e) {

			e.printStackTrace();
		}

		return null;

	}

	public static ActionReturn moveFile(Node file, Node folder, User user) {
		try {

			List<Node> items = new ArrayList<Node>();
			items.add(file);

			ActionReturn actionReturn = ServiceFactory.getFactory(serverPath)
					.getNodeService().move(user, items, folder);

			return actionReturn;

		} catch (YanadoException e) {

			e.printStackTrace();
			return null;
		}

	}

	public static void moveFileRevert(Node file, Node folder, User user) {
		try {

			List<Node> items = new ArrayList<Node>();
			items.add(file);

			ServiceFactory.getFactory(serverPath).getNodeService()
					.moveRevert(user, items, folder);

		} catch (YanadoException e) {

			e.printStackTrace();
		}

	}

	private static Node loadFolder(User user, String nodeRefStr) {

		Node companyHomeNode = null;
		try {
			NodeRef nodeRef = new NodeRef(nodeRefStr);

			companyHomeNode = ServiceFactory.getFactory(serverPath)
					.getNodeService().loadNode(nodeRef, user, "loadFolder");
		} catch (YanadoException e) {

			e.printStackTrace();
		}
		return companyHomeNode;
	}

	private static ActionReturn changePassword(User user,String userName, String passWord) {

		try {
			

			return ServiceFactory.getFactory(serverPath)
					.getMemberService().changePassword(user,userName, passWord);
		} catch (YanadoException e) {

			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		 User user = loginExample();
		
		
		changePassword(user,"test" ,"novasifra2");
	}

	/**
	 * Demostrates login , load company home, creting folder, updating folder,
	 * deleting folder, uploading file and deleting file.
	 * 
	 * @param args
	 */
	public static void main2(String[] args) {
		logger.debug("Test start---------------------");

		User user = loginExample();
		logger.debug("LOGIN OK-----------------------");

		// createGroup(user);
		// logger.debug("CREATE GROUP OK-----------------------");
		//
		// createGroupInAGroup(user);
		// logger.debug("CREATE GROUP IN A GROUP OK-----------------------");
		//
		// Node targetGroup =null;
		// try {
		// List<Node> groups = getGroups(user, null);
		//
		// logger.debug("ROOT " + groups.size());
		// for (int i = 0; i < groups.size(); i++) {
		//
		// List<Node> groupsPart = getGroups(user, groups.get(i));// this
		// logger.debug("ROOT > CHILDREN " + groupsPart.size());
		//
		// for (int k = 0; k < groupsPart.size(); k++) {
		// String groupName = groupsPart.get(k).getStringPropertie(
		// ContentModel.NODE_GROUP_AUTHORITYNAME);
		// if (groupName.equals("GROUP_" + GROUP_NAME)) {
		//
		// List<Node> groupsSnt = getGroups(user,
		// groupsPart.get(k));
		//
		// for (int j = 0; j < groupsSnt.size(); j++) {
		// targetGroup=groupsSnt.get(j);
		//
		// logger.debug(groupsSnt.get(j).getStringPropertie(
		// ContentModel.NODE_GROUP_AUTHORITYNAME));
		//
		// }
		// }
		// }
		// }
		// } catch (Exception e) {
		// e.printStackTrace();
		// }

		Node companyHOme = loadCompanyHome(user);
		logger.debug("COMPANY HOME LOAD OK-----------");
		//

		//
		// Node newFolderUpdate = updateNode(user, newFolder);
		// logger.debug("FOLDER UPDATED OK---------------"
		// + newFolderUpdate.getPropertie(ContentModel.NODE_DESCRIPTION));
		//
		// delete(user, newFolder);
		// logger.debug("FOLDER DELETED OK---------------");
		//

		Node contentNode = uploadFile(user, companyHOme);
		logger.debug("UPLOAD FILE OK------------------" + contentNode.getName());
		//
		Node contentNode2 = uploadFile(user, companyHOme);
		logger.debug("UPLOAD FILE OK------------------" + contentNode.getName());

		List<Node> nodes = listContentVersions(user, contentNode);

		logger.debug("NORMAL VERSIONS-------------");
		for (Node n : nodes) {
			String downloadUrl1 = getContent(user, n);
			logger.debug(n.getStringPropertie(ContentModel.NODE_VERSIONLABELE));

		}
		logger.debug("DELETED VERSIONS-------------");
		nodes = deleteVersion(user, contentNode, "17.0");

		for (Node n : nodes) {
			String downloadUrl1 = getContent(user, n);
			logger.debug(n.getStringPropertie(ContentModel.NODE_VERSIONLABELE));

		}
		logger.debug("DELETED YOYOY-------------");
		nodes = listContentVersions(user, contentNode);
		for (Node n : nodes) {
			String downloadUrl1 = getContent(user, n);
			logger.debug(n.getStringPropertie(ContentModel.NODE_VERSIONLABELE));

		}

		// -------------------------
		// Node newFolder = createFolder(user, companyHOme);
		// logger.debug("FOLDER CREATE OK---------------");
		// Node contentNodeNewFolder = uploadFile2(user, newFolder);
		// logger.debug("UPLOAD FILE OK------------------" +
		// contentNodeNewFolder.getName());

		// moveFile(contentNodeNewFolder, companyHOme, user);

		// delete(user, contentNode);
		// logger.debug("DELETE FILE OK------------------");

		// Node userCreated = createUser(user);
		// addAuthoritiesToGrup(user, userCreated, targetGroup);

		// Node contentNode = uploadFile(user, companyHOme);
		// logger.debug("UPLOAD FILE OK------------------" +
		// contentNode.getName());

		// Node newFolder = createFolder(user, companyHOme);
		// logger.debug("CREATE FOLDER OK------------------" +
		// newFolder.getName());
		// Node contentNodeNewFolder = uploadFile(user, newFolder);
		// logger.debug("UPLOAD 2 OK------------------"
		// + contentNodeNewFolder.getName());
		// ActionReturn actionReturn = moveFile(contentNodeNewFolder,
		// companyHOme,
		// user);
		//
		// logger.debug("MOVE------------------" + contentNodeNewFolder.getId()
		// + " " + actionReturn.getFistNode().getId());
		//
		// logger.debug("MOVE------------------" +
		// contentNodeNewFolder.getName()
		// + " " + actionReturn.getFistNode().getName());

		// Node newFolder = loadFolder(user,
		// "workspace://SpacesStore/6fb02335-76bf-4b9c-a3f5-1662cd33a5c5");
		// logger.debug("FOLDER CREATE OK---------------");
		//
		// Node contentNodeNewFolder = uploadFile2(user, companyHOme);
		// logger.debug("UPLOAD FILE OK------------------"
		// + contentNodeNewFolder.getName());
		//
		// moveFileRevert(contentNodeNewFolder, newFolder, user);

	}
}
