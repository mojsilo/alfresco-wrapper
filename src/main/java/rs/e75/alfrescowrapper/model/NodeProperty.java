package rs.e75.alfrescowrapper.model;

import java.io.Serializable;



/**
 * This class represents nodeproperty and its value, also backups old value.
 * 
 * @author Savic Prvoslav
 * @revision r1
 */
public class NodeProperty implements Serializable {

	private static final long serialVersionUID = 6683942380409571828L;
	private String name;
	private Object value;
	private Object valueBackup;

	public NodeProperty(String name, Object value) {
		super();
		this.name = name;
		this.value = value;
		this.valueBackup = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Object getValue() {

		return value;
	}

	public String getStringValue() {

		return (String) value;
	}

	public void setValue(Object value) {

		this.value = value;
	}

	/**
	 * Checks if value when object is created is the same as now.
	 * 
	 * @return
	 */
	public boolean isValueChanged() {
		if (value != null) {
			return !((String) value).equals((String) valueBackup);
		} else {
			return false;
		}
	}

}
