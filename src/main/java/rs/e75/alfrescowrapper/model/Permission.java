package rs.e75.alfrescowrapper.model;

import java.io.Serializable;

/**
 * 
 * @author Savic Prvoslav
 * 
 */
public class Permission implements Serializable{

	
	private static final long serialVersionUID = -8280905137079552469L;
	
	String allowed;
	String who;
	String role;

	public String getAllowed() {
		return allowed;
	}

	public void setAllowed(String allowed) {
		this.allowed = allowed;
	}

	public String getWho() {
		return who;
	}

	public void setWho(String who) {
		this.who = who;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	@Override
	public boolean equals(Object obj) {

		if(obj instanceof Permission)
		{
			Permission permission=(Permission)obj;
			
			if(permission.getAllowed().equals(getAllowed()))
			{
				if(permission.getWho().equals(getWho())){
					if(permission.getRole().equals(getRole()))
					{
						return true;
					}
				}
				
			}
		}
		return false;
	}

}
