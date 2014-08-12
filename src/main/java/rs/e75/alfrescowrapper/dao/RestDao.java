package rs.e75.alfrescowrapper.dao;

import java.util.List;

import rs.e75.alfrescowrapper.constants.RestSetsOfData;
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

/**
 * Used to execute rest queries and return objects
 * 
 * @author Savic Prvoslav
 * @revision r1
 */
public interface RestDao {

	/**
	 * Login User
	 * @param user
	 * @return
	 * @throws RestException
	 * @throws ServerNotFoundException
	 * @throws WebScriptException
	 * @throws ForbidenException
	 * @throws YanadoException
	 */
	String login(User user) throws RestException, ServerNotFoundException,
			WebScriptException, ForbidenException, YanadoException;

	List<Node> listChildren(User user, NodeRef nodeRef,
			RestSetsOfData setsOfData, Integer length, Integer currentPage)
			throws RestException, ServerNotFoundException, WebScriptException,
			ForbidenException, YanadoException;

	Node loadNodeProperties(NodeRef nodeRef, User user) throws RestException,
			ServerNotFoundException, WebScriptException, ForbidenException,
			YanadoException;

	SearchActionReturn simpleSearch(User user, String query, String sortColumn,
			Boolean asc, String textToShow, RestSetsOfData set, Integer length,
			Integer currentPage) throws RestException, ServerNotFoundException,
			WebScriptException, ForbidenException, YanadoException;

	SearchActionReturn simpleSearch(User user, String query, String sortColumn,
			Boolean asc, String textToShow, RestSetsOfData set)
			throws RestException, ServerNotFoundException, WebScriptException,
			ForbidenException, YanadoException;

	SearchActionReturn simpleSearch(User user, String query, String sortColumn,
			Boolean asc, String textToShow, RestSetsOfData set,
			Boolean typeOrder) throws RestException, ServerNotFoundException,
			WebScriptException, ForbidenException, YanadoException;

	SearchActionReturn simpleSearch(User user, String query, String sortColumn,
			Boolean asc, String textToShow) throws RestException,
			ServerNotFoundException, WebScriptException, ForbidenException,
			YanadoException;

	ActionReturn createFolder(User user, NodePropertyAbstraction abstraction,
			NodeRef currentNode) throws RestException, ServerNotFoundException,
			WebScriptException, ForbidenException, YanadoException;

	ActionReturn executeDelete(User user, Node node) throws RestException,
			ServerNotFoundException, WebScriptException, ForbidenException,
			YanadoException;

	ActionReturn executeDelete(User user, List<Node> nodes)
			throws RestException, ServerNotFoundException, WebScriptException,
			ForbidenException, YanadoException;

	ActionReturn updateNode(User user, NodePropertyAbstraction abstraction)
			throws RestException, ServerNotFoundException, WebScriptException,
			ForbidenException, YanadoException;

	ActionReturn uploadFile(User user, NodePropertyAbstraction abstraction,
			NodeRef currentNode, String path) throws RestException,
			ServerNotFoundException, WebScriptException, ForbidenException,
			YanadoException;

	ActionReturn createGroup(User user, String newGroupName,
			String currentNodeGroup) throws RestException,
			ServerNotFoundException, WebScriptException, ForbidenException,
			YanadoException;

	List<Node> listGroups(Node group, User user, Integer length,
			Integer currentPage) throws RestException, ServerNotFoundException,
			WebScriptException, ForbidenException, YanadoException;

	ActionReturn executeAddUser(User user, NodePropertyAbstraction node)
			throws RestException, ServerNotFoundException, WebScriptException,
			ForbidenException, YanadoException;

	ActionReturn saveAuthoritiesToGroup(User currentUser, Node currentGroup,
			List<Node> users) throws RestException, ServerNotFoundException,
			WebScriptException, ForbidenException, YanadoException;

	String getContent(User user, Node node) throws RestException,
			ServerNotFoundException, WebScriptException, ForbidenException,
			YanadoException;

	List<Node> listContentVersions(User user, NodeRef nodeRef,
			RestSetsOfData setsOfData, Integer length, Integer currentPage)
			throws RestException, ServerNotFoundException, WebScriptException,
			ForbidenException, YanadoException;
	
	List<rs.e75.alfrescowrapper.model.Node> deleteVersions(User user,
			NodeRef nodeRef, RestSetsOfData setsOfData, Integer length,
			Integer currentPage,String version) throws RestException, ServerNotFoundException,
			WebScriptException, ForbidenException, YanadoException;

	ActionReturn executeMove(User user, List<Node> items, Node target)
			throws RestException, ServerNotFoundException, WebScriptException,
			ForbidenException, YanadoException;

	ActionReturn executeMoveRevert(User user, List<Node> items, Node target)
			throws RestException, ServerNotFoundException, WebScriptException,
			ForbidenException, YanadoException;
	
	ActionReturn changePass(User user, String userName, String passWord)
			throws RestException, ServerNotFoundException, WebScriptException,
			ForbidenException, YanadoException;

	

}
