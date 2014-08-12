package rs.e75.alfrescowrapper.exceptions;

import org.apache.log4j.Logger;


/**
 * Alfresco responded with HTTP 403
 * 
 * @author Savic Prvoslav
 * @revision r1
 */
public class ForbidenException extends AbstractException {

	private static final long serialVersionUID = 2673354021641776650L;
	private static final Logger LOGGER=Logger.getLogger(ForbidenException.class);

	public ForbidenException(String message) {
		super(message);
		LOGGER.debug("ForbidenException");
		
	}
}
