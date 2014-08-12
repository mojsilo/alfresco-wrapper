package rs.e75.alfrescowrapper.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.time.StopWatch;




import rs.e75.alfrescowrapper.constants.ContentModel;
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
import rs.e75.alfrescowrapper.model.User;

/**
 * 
 * @author Savic Prvoslav
 * 
 */
public class MemberServiceImpl implements MemberService {

	private RestDao restDao;

	private TimeElapsedService timeElapsedService;

	public MemberServiceImpl(RestDao restDao,
			TimeElapsedService timeElapsedService) {
		this.restDao = restDao;
		this.timeElapsedService = timeElapsedService;

	}

	public String login(User user) throws ForbidenException, YanadoException {

		try {
			String ticket = restDao.login(user);
			user.setTicket(ticket);
			user.setLoggedIn(true);
			return ticket;
		} catch (RestException e) {

			throw new YanadoException(e);
		} catch (ServerNotFoundException e) {

			throw new YanadoException(e);
		} catch (WebScriptException e) {
			throw new YanadoException(e);
		}

	}

	

	public ActionReturn createGroup(User user, String newGroupName,
			String currentNodeGroup) throws YanadoException {
		StopWatch stopWatch = null;
		try {
			stopWatch = new StopWatch();
			stopWatch.start();
			return restDao.createGroup(user, newGroupName, currentNodeGroup);
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
			timeElapsedService.logRestTime("NodeServiceImpl.createGroup", stopWatch);
		}
	}
	
	
	
	public List<Node> listGroups(Node group, User user, Integer length,
			Integer currentPage) throws YanadoException {
		StopWatch stopWatch = null;
		try {
			stopWatch = new StopWatch();
			stopWatch.start();
			return restDao.listGroups(group, user, length, currentPage);
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
			timeElapsedService.logRestTime("NodeServiceImpl.listGroups", stopWatch);
		}
	}
	


	

	

	public ActionReturn executeAddUser(NodePropertyAbstraction node, User user)
			throws YanadoException {
		StopWatch stopWatch = null;
		try {
			stopWatch = new StopWatch();
			stopWatch.start();

			ActionReturn actionReturn = restDao.executeAddUser(user, node);

			return actionReturn;

		} catch (RestException e) {
			throw new YanadoException(e);
		} catch (ServerNotFoundException e) {
			throw new YanadoException(e);
		} catch (WebScriptException e) {
			throw new YanadoException(e);
		} catch (ForbidenException e) {
			throw new YanadoException(e);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new YanadoException(ex);
		} finally {
			stopWatch.stop();
			timeElapsedService.logRestTime("MemberServiceImpl.executeAddUser",
					stopWatch);
		}
	}
	
	
	public ActionReturn saveAuthoritiesToGroup(User currentUser,
			Node currentGroup, List<Node> users) throws YanadoException {
		StopWatch stopWatch = null;
		try {
			stopWatch = new StopWatch();
			stopWatch.start();
			
		
			
			return restDao.saveAuthoritiesToGroup(currentUser,
					currentGroup, users);

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
			timeElapsedService.logRestTime("NodeServiceImpl.saveAuthoritiesToGroup",
					stopWatch);
		}
	}
	

	/**
	 * Change password
	 */
	public ActionReturn changePassword(User user, String userName, String passWord) throws YanadoException {
		StopWatch stopWatch = null;
		try {
			stopWatch = new StopWatch();
			stopWatch.start();
			 return restDao.changePass(user,userName, passWord);
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
			timeElapsedService.logRestTime("NodeServiceImpl.changePassword",
					stopWatch);
		}
	}
}
