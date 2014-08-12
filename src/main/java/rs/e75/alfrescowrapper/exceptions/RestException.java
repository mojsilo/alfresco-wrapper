package rs.e75.alfrescowrapper.exceptions;

import org.apache.log4j.Logger;


/**
 * Exception in restService , for isntance url is wrong...
 * 
 * @author Savic Prvoslav
 * @revision r1
 */
public class RestException extends AbstractException {

	private static final long serialVersionUID = -2476846989415332461L;
	private static final Logger LOGGER=Logger.getLogger(ForbidenException.class);
	
	public RestException(String message, Throwable throwable) {
		super(message, throwable);
		LOGGER.debug("RestException");
//		if (YNSession.get().getCurrentUser().getLoggedIn()) {
//			WicketApplication.get().sessionUnbound(YNSession.get().getId());
//			YNSession.get().clear();
//			RequestCycle.get().setResponsePage(LoginPage.class);
//		}
	}

}
