package rs.e75.alfrescowrapper.service;

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
 * 
 * @author Savic Prvoslav
 * 
 */
public interface NodeService {

	List<Node> listChildren(NodeRef nodeRef, User user,
			RestSetsOfData setsOfData, Integer length, Integer currentPage)
			throws YanadoException;

	Node loadNode(NodeRef nodeRef, User user, String caller)
			throws YanadoException;

	SearchActionReturn search(User user, String query, String sortColumn,
			Boolean asc, String textToShow) throws YanadoException;

	ActionReturn createFolder(User user, NodePropertyAbstraction abstraction,
			NodeRef currentNode) throws YanadoException;

	ActionReturn executeDelete(User user, List<Node> list)
			throws YanadoException;

	ActionReturn executeDelete(User user, Node node) throws YanadoException;

	ActionReturn updateNode(User user, NodePropertyAbstraction abstraction)
			throws YanadoException;

	ActionReturn upload(User user, NodePropertyAbstraction abstraction,
			NodeRef currentNode, String path) throws YanadoException;

	String getContent(User user, Node node) throws YanadoException;

	List<Node> listContentVersions(NodeRef nodeRef, User user,
			RestSetsOfData setsOfData, Integer length, Integer currentPage)
			throws YanadoException;
	List<Node> deleteVersions(NodeRef nodeRef, User user,
			RestSetsOfData setsOfData, Integer length, Integer currentPage,String version)
			throws YanadoException;
	

	ActionReturn move(User user, List<Node> items, Node target)
			throws YanadoException;
	
	ActionReturn moveRevert(User user, List<Node> items, Node target)
			throws YanadoException;


}
