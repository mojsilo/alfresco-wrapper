package rs.e75.alfrescowrapper.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Returned after action has been executed
 * 
 * @author Savic Prvoslav
 * @revision r1
 */
public class ActionReturn implements Serializable {

	private static final long serialVersionUID = 8626904329702407786L;
	private List<Node> nodes = new ArrayList<Node>();
	
	private String message = "";
	private String messageCode = "";

	
	
	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public String getMessageCode() {
		return messageCode;
	}

	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}

	public List<Node> getNodes() {
		return nodes;
	}

	public void setNodes(List<Node> nodes) {
		this.nodes = nodes;
	}

	/**
	 * returns first @Node from result or null if nodes is empty
	 * 
	 * @return
	 */
	public Node getFistNode() {
		if (getNodes().size() > 0) {
			return getNodes().get(0);
		} else {
			return null;
		}
	}

}
