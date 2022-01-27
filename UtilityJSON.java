package com.example.demo;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
 
import javax.xml.bind.JAXBException;
 
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
 
import java.io.File;
import java.io.FileNotFoundException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
 
@SuppressWarnings("unused")
public class UtilityJSON <T>{

    @SuppressWarnings("unchecked")
    public static <T> T PojoToJson(Class<T> obj) throws JAXBException{
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String result = gson.toJson(obj);
        System.out.println(result);
        return (T) result;
    }

    public static  <T, class1> T JsonToPojo(File file1,Class<T> class1) throws IOException,JAXBException{
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    Reader input = new FileReader(file1);
    Type type = new TypeToken<class1>(){}.getType();
    User details = gson.fromJson(input, type);
    System.out.println(details);
    return null;
    }
 
}