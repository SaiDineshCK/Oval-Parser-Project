package com.example.demo;

import java.io.StringWriter;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

public class XMLToString {
	
	static String toXmlString(Document document) throws TransformerException {
	    TransformerFactory transformerFactory = TransformerFactory.newInstance();
	    Transformer transformer = transformerFactory.newTransformer();
	    DOMSource source = new DOMSource(document);
	    StringWriter strWriter = new StringWriter();
	    StreamResult result = new StreamResult(strWriter);
	  
	    transformer.transform(source, result);
	    
	    return strWriter.getBuffer().toString();
	    
	  }

}
