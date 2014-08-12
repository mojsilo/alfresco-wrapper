package rs.e75.alfrescowrapper.service;

import java.util.List;

import rs.e75.alfrescowrapper.exceptions.ForbidenException;
import rs.e75.alfrescowrapper.exceptions.RestException;
import rs.e75.alfrescowrapper.exceptions.ServerNotFoundException;
import rs.e75.alfrescowrapper.exceptions.WebScriptException;
import rs.e75.alfrescowrapper.exceptions.YanadoException;
import rs.e75.alfrescowrapper.model.ActionReturn;
import rs.e75.alfrescowrapper.model.Node;
import rs.e75.alfrescowrapper.model.NodePropertyAbstraction;
import rs.e75.alfrescowrapper.model.User;

/**
 * 
 * @author Savic Prvoslav
 * 
 */
public interface MemberService {
	
	/**
	 * Login user, 
	 *  required is to set username and password to user object
	 *  
	 * @param user
	 * @return
	 * @throws ForbidenException
	 * @throws YanadoException
	 */
	String login(User user) throws ForbidenException, YanadoException;

	ActionReturn createGroup(User user, String newGroupName,
			String currentNodeGroup) throws YanadoException;

	List<Node> listGroups(Node group, User user, Integer length,
			Integer currentPage) throws YanadoException;

	ActionReturn executeAddUser(NodePropertyAbstraction node, User user)
			throws YanadoException;

	ActionReturn saveAuthoritiesToGroup(User currentUser, Node currentGroup,
			List<Node> users) throws YanadoException;
	
	ActionReturn changePassword(User user, String userName, String passWord)
			throws YanadoException;
	
	
}
