package rs.e75.alfrescowrapper.service;

import java.util.List;

import org.apache.commons.lang.time.StopWatch;

import rs.e75.alfrescowrapper.constants.RestSetsOfData;
import rs.e75.alfrescowrapper.dao.RestDao;
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
public class NodeServiceImpl implements NodeService {

	private RestDao restDao;
	private TimeElapsedService timeElapsedService;

	public NodeServiceImpl(RestDao restDao,
			TimeElapsedService timeElapsedService) {
		this.restDao = restDao;
		this.timeElapsedService = timeElapsedService;

	}

	public Node loadNode(NodeRef nodeRef, User user, String caller)
			throws YanadoException {
		StopWatch stopWatch = null;
		try {
			stopWatch = new StopWatch();
			stopWatch.start();

			// String id = nodeRef.getId();
			Node retVal;
			retVal = restDao.loadNodeProperties(nodeRef, user);
			return retVal;

			// if (retVal == null) {//null should be returned, and caller must
			// see what will he do with it
			// return new Node();
			// } else {
			// return retVal;
			// }
		} catch (RestException e) {
			throw new YanadoException(e);
		} catch (ServerNotFoundException e) {
			throw new YanadoException(e);
		} catch (WebScriptException e) {
			throw new YanadoException(e);
		} catch (ForbidenException e) {
			throw new YanadoException(e);
		} catch (Exception e) {
			throw new YanadoException(e);
		} finally {
			stopWatch.stop();
			timeElapsedService.logRestTime(
					"NodeServiceImpl.loadNode " + caller, stopWatch);
		}

	}

	/**
	 * loads child nodes from server
	 */
	public List<Node> listChildren(NodeRef nodeRef, User user,
			RestSetsOfData setsOfData, Integer length, Integer currentPage)
			throws YanadoException {

		StopWatch stopWatch = null;
		try {
			stopWatch = new StopWatch();
			stopWatch.start();

			List<Node> list = restDao.listChildren(user, nodeRef, setsOfData,
					length, currentPage);

			return list;
		} catch (RestException e) {
			throw new YanadoException(e);
		} catch (ServerNotFoundException e) {
			throw new YanadoException(e);
		} catch (WebScriptException e) {
			throw new YanadoException(e);
		} catch (ForbidenException e) {
			throw new YanadoException(e);
		} catch (Exception e) {
			throw new YanadoException(e);
		} finally {
			stopWatch.stop();
			timeElapsedService.logRestTime("NodeServiceImpl.listChildren",
					stopWatch);
		}
	}

	public SearchActionReturn search(User user, String query,
			String sortColumn, Boolean asc, String textToShow)
			throws YanadoException {
		StopWatch stopWatch = null;
		try {
			stopWatch = new StopWatch();
			stopWatch.start();

			return restDao.simpleSearch(user, query, sortColumn, asc,
					textToShow);

		} catch (RestException e) {
			throw new YanadoException(e);
		} catch (ServerNotFoundException e) {
			throw new YanadoException(e);
		} catch (WebScriptException e) {
			throw new YanadoException(e);
		} catch (ForbidenException e) {
			throw new YanadoException(e);
		} catch (Exception e) {
			throw new YanadoException(e);
		} finally {
			stopWatch.stop();
			timeElapsedService.logRestTime("NodeServiceImpl.search", stopWatch);
		}

	}

	/**
	 * Create folder action
	 */
	public ActionReturn createFolder(User user,
			NodePropertyAbstraction abstraction, NodeRef currentNode)
			throws YanadoException {
		StopWatch stopWatch = null;
		try {
			stopWatch = new StopWatch();
			stopWatch.start();
			return restDao.createFolder(user, abstraction, currentNode);
		} catch (RestException e) {
			throw new YanadoException(e);
		} catch (ServerNotFoundException e) {
			throw new YanadoException(e);
		} catch (WebScriptException e) {
			throw new YanadoException(e);
		} catch (ForbidenException e) {
			throw new YanadoException(e);
		} catch (Exception e) {
			throw new YanadoException(e);
		} finally {
			stopWatch.stop();
			timeElapsedService.logRestTime("NodeServiceImpl.createFolder",
					stopWatch);
		}
	}

	/**
	 * executed delete actions
	 */
	public ActionReturn executeDelete(User user, Node node)
			throws YanadoException {
		StopWatch stopWatch = null;
		try {
			stopWatch = new StopWatch();
			stopWatch.start();
			return restDao.executeDelete(user, node);
		} catch (RestException e) {
			throw new YanadoException(e);
		} catch (ServerNotFoundException e) {
			throw new YanadoException(e);
		} catch (WebScriptException e) {
			throw new YanadoException(e);
		} catch (ForbidenException e) {
			throw new YanadoException(e);
		} catch (Exception e) {
			throw new YanadoException(e);
		} finally {
			stopWatch.stop();
			timeElapsedService.logRestTime("NodeServiceImpl.executeDelete",
					stopWatch);
		}
	}

	public ActionReturn executeDelete(User user, List<Node> list)
			throws YanadoException {
		StopWatch stopWatch = null;
		try {
			stopWatch = new StopWatch();
			stopWatch.start();
			return restDao.executeDelete(user, list);
		} catch (RestException e) {
			throw new YanadoException(e);
		} catch (ServerNotFoundException e) {
			throw new YanadoException(e);
		} catch (WebScriptException e) {
			throw new YanadoException(e);
		} catch (ForbidenException e) {
			throw new YanadoException(e);
		} catch (Exception e) {
			throw new YanadoException(e);
		} finally {
			stopWatch.stop();
			timeElapsedService.logRestTime("NodeServiceImpl.executeDelete",
					stopWatch);
		}
	}

	public ActionReturn updateNode(User user,
			NodePropertyAbstraction abstraction) throws YanadoException {
		StopWatch stopWatch = null;
		try {
			stopWatch = new StopWatch();
			stopWatch.start();
			return restDao.updateNode(user, abstraction);
		} catch (RestException e) {
			throw new YanadoException(e);
		} catch (ServerNotFoundException e) {
			throw new YanadoException(e);
		} catch (WebScriptException e) {
			throw new YanadoException(e);
		} catch (ForbidenException e) {
			throw new YanadoException(e);
		} catch (Exception e) {
			throw new YanadoException(e);
		} finally {
			stopWatch.stop();
			timeElapsedService.logRestTime("NodeServiceImpl.updateNode",
					stopWatch);
		}
	}

	public ActionReturn upload(User user, NodePropertyAbstraction abstraction,
			NodeRef currentNode, String path) throws YanadoException {
		StopWatch stopWatch = null;
		try {
			stopWatch = new StopWatch();
			stopWatch.start();
			return restDao.uploadFile(user, abstraction, currentNode, path);
		} catch (RestException e) {
			throw new YanadoException(e);
		} catch (ServerNotFoundException e) {
			throw new YanadoException(e);
		} catch (WebScriptException e) {
			throw new YanadoException(e);
		} catch (ForbidenException e) {
			throw new YanadoException(e);
		} catch (Exception e) {
			throw new YanadoException(e);
		} finally {
			stopWatch.stop();
			timeElapsedService.logRestTime("NodeServiceImpl.upload", stopWatch);
		}
	}

	public String getContent(User user, Node node) throws YanadoException {
		StopWatch stopWatch = null;
		try {
			stopWatch = new StopWatch();
			stopWatch.start();
			return restDao.getContent(user, node);
		} catch (RestException e) {
			throw new YanadoException(e);
		} catch (ServerNotFoundException e) {
			throw new YanadoException(e);
		} catch (WebScriptException e) {
			throw new YanadoException(e);
		} catch (ForbidenException e) {
			throw new YanadoException(e);
		} catch (Exception e) {
			throw new YanadoException(e);
		} finally {
			stopWatch.stop();
			timeElapsedService.logRestTime("getContent", stopWatch);
		}
	}


	public List<Node> listContentVersions(NodeRef nodeRef, User user,
			RestSetsOfData setsOfData, Integer length, Integer currentPage)
			throws YanadoException {

		StopWatch stopWatch = null;
		try {
			stopWatch = new StopWatch();
			stopWatch.start();

			List<Node> list = restDao.listContentVersions(user, nodeRef,
					setsOfData, length, currentPage);

			return list;
		} catch (RestException e) {
			throw new YanadoException(e);
		} catch (ServerNotFoundException e) {
			throw new YanadoException(e);
		} catch (WebScriptException e) {
			throw new YanadoException(e);
		} catch (ForbidenException e) {
			throw new YanadoException(e);
		} catch (Exception e) {
			throw new YanadoException(e);
		} finally {
			stopWatch.stop();
			timeElapsedService.logRestTime("NodeServiceImpl.listChildren",
					stopWatch);
		}
	}
	
	public List<Node> deleteVersions(NodeRef nodeRef, User user,
			RestSetsOfData setsOfData, Integer length, Integer currentPage,String version)
			throws YanadoException {

		StopWatch stopWatch = null;
		try {
			stopWatch = new StopWatch();
			stopWatch.start();

			List<Node> list = restDao.deleteVersions(user, nodeRef,
					setsOfData, length, currentPage,version);

			return list;
		} catch (RestException e) {
			throw new YanadoException(e);
		} catch (ServerNotFoundException e) {
			throw new YanadoException(e);
		} catch (WebScriptException e) {
			throw new YanadoException(e);
		} catch (ForbidenException e) {
			throw new YanadoException(e);
		} catch (Exception e) {
			throw new YanadoException(e);
		} finally {
			stopWatch.stop();
			timeElapsedService.logRestTime("NodeServiceImpl.listChildren",
					stopWatch);
		}
	}
	

	public ActionReturn move( User user,List<Node> items,Node target	)
			throws YanadoException {

		StopWatch stopWatch = null;
		try {
			stopWatch = new StopWatch();
			stopWatch.start();

			ActionReturn actionReturn=restDao.executeMove(user, items, target);

			return actionReturn;
		} catch (RestException e) {
			throw new YanadoException(e);
		} catch (ServerNotFoundException e) {
			throw new YanadoException(e);
		} catch (WebScriptException e) {
			throw new YanadoException(e);
		} catch (ForbidenException e) {
			throw new YanadoException(e);
		} catch (Exception e) {
			throw new YanadoException(e);
		} finally {
			stopWatch.stop();
			timeElapsedService.logRestTime("NodeServiceImpl.listChildren",
					stopWatch);
		}
	}

	
	public ActionReturn moveRevert(User user, List<Node> items, Node target)
			throws YanadoException {
		StopWatch stopWatch = null;
		try {
			stopWatch = new StopWatch();
			stopWatch.start();

			ActionReturn actionReturn=restDao.executeMoveRevert(user, items, target);

			return actionReturn;
		} catch (RestException e) {
			throw new YanadoException(e);
		} catch (ServerNotFoundException e) {
			throw new YanadoException(e);
		} catch (WebScriptException e) {
			throw new YanadoException(e);
		} catch (ForbidenException e) {
			throw new YanadoException(e);
		} catch (Exception e) {
			throw new YanadoException(e);
		} finally {
			stopWatch.stop();
			timeElapsedService.logRestTime("NodeServiceImpl.moveRevert",
					stopWatch);
		}
	}
}
