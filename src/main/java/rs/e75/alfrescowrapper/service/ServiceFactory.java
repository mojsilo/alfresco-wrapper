package rs.e75.alfrescowrapper.service;

import rs.e75.alfrescowrapper.dao.RestDao;
import rs.e75.alfrescowrapper.dao.RestDaoImpl;

/**
 * 
 * @author Savic Prvoslav
 * 
 */
public class ServiceFactory {

	private static ServiceFactory factory = null;
	private String serverPath=null;

	private ServiceFactory(String serverPath) {
		this.serverPath=serverPath;
		

	}

	public static ServiceFactory getFactory(String serverPat) {
		if (factory == null) {
			factory = new ServiceFactory(serverPat);
		}
		return factory;
	}

	private RestDao restService = null;

	private TimeElapsedService elapsedService = null;

	private MemberService memberService = null;

	private NodeService nodeService = null;

	public TimeElapsedService getElapsedService() {
		if (elapsedService == null) {
			elapsedService = new TimeElapsedServiceImpl();

		}
		return elapsedService;
	}

	protected RestDao getRestService() {

		if (restService == null) {
			restService = new RestDaoImpl(getElapsedService(),serverPath);

		}
		return restService;
	}

	public MemberService getMemberService() {
		if (memberService == null) {
			memberService = new MemberServiceImpl(getRestService(),getElapsedService());

		}
		return memberService;

	}

	public NodeService getNodeService() {
		if (nodeService == null) {
			nodeService = new NodeServiceImpl(getRestService(),
					getElapsedService());

		}
		return nodeService;

	}

}
