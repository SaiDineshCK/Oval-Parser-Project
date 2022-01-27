package com.example.demo;
import java.io.FileInputStream;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonToPojoJackson {

	    public static void main(String[] args) throws Exception {

	        ObjectMapper mapperObj = new ObjectMapper();

	        FileInputStream fileInputStreamObj = new FileInputStream("src\\main\\resources\\student1.json");
	        Student1 student = mapperObj.readValue(fileInputStreamObj, Student1.class);

	        System.out.println("Student ID : " + student.getId());
	        System.out.println("Student Name : " + student.getName());
	        System.out.println("Student Skill : " + student.getSkill());

	        fileInputStreamObj.close();

	    }
	}



	class Student2 {

	    int id;
	    String name;
	    String skill;

	    public int getId() {
	        return id;
	    }
	    public void setId(int id) {
	        this.id = id;
	    }
	    public String getName() {
	        return name;
	    }
	    public void setName(String name) {
	        this.name = name;
	    }
	    public String getSkill() {
	        return skill;
	    }
	    public void setSkill(String skill) {
	        this.skill = skill;
	    }

	}


