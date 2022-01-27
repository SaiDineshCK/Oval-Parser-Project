package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;
import static org.junit.Assert.*;
import java.lang.String;
import static org.junit.Assert.assertEquals;
class test {

		    final String xmlHeader = "<firstname>Sai Dinesh</firstname>";
		 
		    @Test
		    public void testing() throws Exception {
		        final Student type = new Student();
		       
		        type.setFirstName("SaiDinesh");
		        type.setLastName("CK");
		        type.setEmail("saidin");
		
		        final JAXBElement element = new JAXBElement( new QName("Meta"), Student.class, type);
		 
		        JAXBContext context = JAXBContext.newInstance(Student.class);
		        final ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		        context.createMarshaller().marshal(element, outStream);
		 
		        final String xmlContent = "";
		        assertEquals(xmlHeader + xmlContent ,outStream.toString());
		    }
		
	}
