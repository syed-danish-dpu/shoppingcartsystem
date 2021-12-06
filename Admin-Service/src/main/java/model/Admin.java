package model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "admins")
public class Admin {
	
	
	@Id
	private int aId;
	private String aName;
	
	//non parameterised constructor
	public Admin() {
		
	}
	//to string
	@Override
	public String toString() {
		return "Admin [aId=" + aId + ", aName=" + aName + "]";
	}
	//parameterised constructor
	public Admin(int aId, String aName) {
		super();
		this.aId = aId;
		this.aName = aName;
	}
	//getters and setters
	public int getaId() {
		return aId;
	}
	public void setaId(int aId) {
		this.aId = aId;
	}
	public String getaName() {
		return aName;
	}
	public void setaName(String aName) {
		this.aName = aName;
	}
	

}
