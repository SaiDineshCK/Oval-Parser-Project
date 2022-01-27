package com.example.demo;

import com.google.gson.Gson;

public class JSONCONVERT {
	public void json()
	{
	
	try {
	Student abc = new Student("Sai", "Dinesh", "saidin");
	Student def = new Student("Abhi", "Reddy", "abhireddy");

	Gson gson = new Gson();

	String abcJson = gson.toJson(abc);
	String defJson = gson.toJson(def);

	System.out.println(abcJson);
	System.out.println(defJson);
	
	}
	
	catch(Exception e) {
		System.out.println(""+e.getMessage());
	}

	}

}
