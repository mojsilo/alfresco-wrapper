package rs.e75.alfrescowrapper.exceptions;

/**
 * Represents abstract representation of exception in Yanado
 * 
 * @author Savic Prvoslav
 * @revision r1
 */
public class AbstractException extends Exception {

	private static final long serialVersionUID = -7823913117529500959L;

	public AbstractException(String message) {
		super(message);
	}

	public AbstractException(String message, Throwable throwable) {
		super(message, throwable);
	}

}
