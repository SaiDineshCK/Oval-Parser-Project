package com.example.demo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Games")
public class Games {
	
	private String name,type;
	private int cost,year;
	
	@XmlElement
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	@XmlElement
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@XmlElement
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	@XmlElement
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public Games(String name, String type, int cost, int year) {
		super();
		this.name = name;
		this.type = type;
		this.cost = cost;
		this.year = year;
	}
	public Games() {
		super();
	}
	
	

}
