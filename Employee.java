
package com.example.demo;
import javax.xml.bind.annotation.*;
@XmlRootElement(name="Employee")
public class Employee {
	private String id,firstname,lastname;
	private int code;
	
	@XmlElement
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@XmlElement
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	@XmlElement
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public Employee(String id, String firstname, String lastname, int code) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.code = code;
	}
	public Employee() {
		super();
	}

}





