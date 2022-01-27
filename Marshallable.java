package com.example.demo;

import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.bind.*;

public class Marshallable {

	public String marshal() throws MarshalException{
	       return marshal(this);
	    }

	    public Object unmarshal(String xml) throws JAXBException{
	        return unmarshal(xml,this.getClass());
	    }

	    public static String marshal(Object obj) throws MarshalException{
	        try {
	            StringWriter sw = new StringWriter();
	            JAXBContext jc = JAXBContext.newInstance(obj.getClass());
	            Marshaller m = jc.createMarshaller();
	            m.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
	            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
	            m.marshal(obj, sw);
	            return sw.toString();
	        } catch( JAXBException jbe ){
	            throw new MarshalException("Error when marshalling " +obj.getClass().getCanonicalName(),jbe);
	        }
	    }

	    public static Object unmarshal(String xml,Class<? extends Marshallable> clazz) throws JAXBException{
	        JAXBContext jc = JAXBContext.newInstance(clazz);
	        Unmarshaller u = jc.createUnmarshaller();
	        return u.unmarshal(new StringReader(xml));
	    }
	}
