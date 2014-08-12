package rs.e75.alfrescowrapper.exceptions;

/**
 * When server is not responding , 404.
 * 
 * @author Savic Prvoslav
 * @revision r1
 * 
 */
public class ServerNotFoundException extends AbstractException {

	private static final long serialVersionUID = -3015851629074252593L;

	// private static final Logger
	// LOGGER=Logger.getLogger(ForbidenException.class);

	public ServerNotFoundException(String message) {
		super(message);

	}

	public ServerNotFoundException(String message, Throwable throwable) {
		super(message, throwable);

	}
}
