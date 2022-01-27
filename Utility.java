package com.example.demo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class Utility <T> {
		public static <T> T unMarshalXML(File pathToExcelFile, Class<T> obj ) throws JAXBException{
		JAXBContext jaxbContext = JAXBContext.newInstance(obj);
		Unmarshaller um = jaxbContext.createUnmarshaller();
		T info = (T) um.unmarshal(pathToExcelFile);
		//System.out.print(info);
		return info;
		}


public static  <T> T marshalXML(Class <T> class1,T emp) throws IOException,JAXBException{
	
	JAXBContext jc=JAXBContext.newInstance(class1);
	Marshaller ms=jc.createMarshaller();
	ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
	ms.marshal(emp,new FileOutputStream("empinfo.xml"));
	return null;
}
}

