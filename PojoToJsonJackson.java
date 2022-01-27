package com.example.demo;
import java.io.File;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PojoToJsonJackson {
	 
	    public static void main(String[] args) throws Exception {

	        ObjectMapper mapperObj = new ObjectMapper();
	 
	        Student1 student = new Student1();
	        student.setId(5);
	        student.setName("SaiDinesh");
	        student.setSkill("Electronics");
	 
	        mapperObj.writeValue(new File("src\\main\\/resources\\student1.json"), student);
	 
	        String json2 = mapperObj.writerWithDefaultPrettyPrinter().writeValueAsString(student);
	        System.out.println(json2);
	 
	    }
	}
	 
	 
	class Student1 {
	 
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


