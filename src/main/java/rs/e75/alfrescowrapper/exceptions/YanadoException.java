package rs.e75.alfrescowrapper.exceptions;

/**
 * This exception is holder exception for rest of yanado exceptions
 * 
 * @author Savic Prvoslav
 * @revision r1
 */
public class YanadoException extends Exception {

	private static final long serialVersionUID = -1327018266165531856L;

	/**
	 * This will be called for rest of exceptions
	 * 
	 * @param throwable
	 */
	public YanadoException(Throwable throwable) {
		super(throwable);
		throwable.printStackTrace();
	}

	/**
	 * This will be called for yanado exceptions
	 * 
	 * @param throwable
	 */
	public YanadoException(AbstractException throwable) {
		super(throwable);
		throwable.printStackTrace();
	}

}
