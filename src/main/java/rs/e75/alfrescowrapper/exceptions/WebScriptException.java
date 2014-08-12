package rs.e75.alfrescowrapper.exceptions;

/**
 * When rest service receives HTTP 500 responce, witch means that webscript has
 * a error
 * 
 * @author Savic Prvoslav
 * @revision r1
 */
public class WebScriptException extends AbstractException {

	public WebScriptException(String message) {
		super(message);

	}

	private static final long serialVersionUID = 400474868978218847L;

}
