package rs.e75.alfrescowrapper.model;

import java.io.Serializable;



/**
 * Represents Content from document
 * 
 * @author Savic Prvoslav
 * @revision r1
 */
public class Content implements Serializable {

	private static final long serialVersionUID = 4848802433948225715L;
	private String url;
	private String mimetype;
	private String size;
	private String encoding;


	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMimetype() {
		return mimetype;
	}

	public void setMimetype(String mimetype) {
		this.mimetype = mimetype;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getEncoding() {
		return encoding;
	}

	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

}
