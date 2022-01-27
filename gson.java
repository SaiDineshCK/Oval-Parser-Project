package com.example.demo;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.lang.reflect.Type;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class gson {
	
		public static void main(String[] args) throws FileNotFoundException {
			Users user = new Users();
			user.setFirstName("SaiDinesh");
			user.setLastName("CK");
			user.setGender("Male");
			user.setAge(22);
			user.setId(100);
			
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			String result = gson.toJson(user);
			System.out.println(result);
			
			Reader input = new FileReader("./src/main/resources/info.json");
			Type type = new TypeToken<Student>(){}.getType();
			Student details = gson.fromJson(input, type);
			System.out.println(details);

		}

		public static User fromJson(Reader input, Type type) {
			// TODO Auto-generated method stub
			return null;
		}
	}

	class Users {

		
		private int id;

		private String firstName;
		private String lastName;

		
		private int age;

		
		private String gender;

		public int getId() {
			return id;
		}

		public void setId(int i) {
			this.id = i;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		@Override
		public String toString() {
			return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", gender="
					+ gender + "]";
		}
	}

