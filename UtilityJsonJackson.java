package com.example.demo;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class UtilityJsonJackson {
	
	public static <T> T pojoToJson(T object ) throws IOException {

	ObjectMapper objectMapper = new ObjectMapper();
	String jsonStr = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
	System.out.println(jsonStr);
	objectMapper.writeValue(new File("src\\main\\/resources\\jsonconverter.json"), object);
	return null;
	}

	public static <T> T jsonToPojo(Class<T> class1, File pathToExcelFile) throws IOException {

	ObjectMapper mapper = new ObjectMapper();
	T obj1 = (T)mapper.readValue(pathToExcelFile, class1);
	return obj1;
	}

}
