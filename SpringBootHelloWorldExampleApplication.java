package com.example.demo;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.mitre.oval.xmlschema.oval_common_5.GeneratorType;
import org.mitre.oval.xmlschema.oval_definitions_5.DefinitionsType;
import org.mitre.oval.xmlschema.oval_definitions_5.ObjectsType;
import org.mitre.oval.xmlschema.oval_definitions_5.OvalDefinitions;
import org.mitre.oval.xmlschema.oval_definitions_5.StatesType;
import org.mitre.oval.xmlschema.oval_definitions_5.TestsType;
import org.mitre.oval.xmlschema.oval_definitions_5.VariablesType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.w3._2000._09.xmldsig_.SignatureType;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import org.w3c.dom.Document;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

@SpringBootApplication
public class SpringBootHelloWorldExampleApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SpringBootHelloWorldExampleApplication.class, args);
		//System.out.println("Hello World");
		//EmployeeJAXB obj=new EmployeeJAXB();
		//obj.marshall();
		//obj.unmarshall();
		//Marshallable m=new Marshallable();
		//m.marshal();
		//m.unmarshal(null);
		
		//File file=new File("src\\main\\resources\\Gamesinfo.xml");
		
		File file2=new File("src\\main\\resources\\CIS_Microsoft_Edge_Benchmark_v1.0.0-oval.xml");
		File file3=new File("src\\main\\resources\\CIS_Microsoft_Windows_Server_2016_STIG_Benchmark_v1.1.0-oval.xml");
		//Employee emp=new Employee("123","Sport","Games",12345);
		//Games obj1 = Utility.unMarshalXML(file,Games.class);
		//System.out.println(obj1.getYear());
		//Utility.marshalXML(Employee.class,emp);
		
		OvalDefinitions os= Utility.unMarshalXML(file2, OvalDefinitions.class);
		
		OvalDefinitions os1= Utility.unMarshalXML(file3, OvalDefinitions.class);
		//System.out.println(os1.getDefinitions().getDefinition());
		
		//String[] fieldsOfModelsType= {"DefinitionsType","TestsType","ObjectsType","StatesType","VariablesType"};
		//OvalComparison.compareObjects(os, os1, null ,fieldsOfModelsType);
		
		File file4=new File("src\\main\\resources\\CIS_Microsoft_Windows_Server_2016_STIG_Benchmark_v1.1.0-xccdf.xml");
		File file5=new File("src\\main\\resources\\CIS_Microsoft_Windows_10_Enterprise_Release_21H1_Benchmark_v1.11.0-xccdf.xml");
		
		OvalCompareXMLUnit.OvalCompare(file2,file3);
		XCCDFCompareXMLUnit.XCCDFCompare(file4, file5);
	
		String file6= "src\\main\\resources\\CIS_Microsoft_Edge_Benchmark_v1.0.0-oval.xml";
		String file7= "src\\main\\resources\\CIS_Microsoft_Windows_Server_2016_STIG_Benchmark_v1.1.0-oval.xml";
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        
        DocumentBuilder builder = null;
      
            builder = factory.newDocumentBuilder();
		Document xmlDocument = builder.parse(new File(file6));
		Document xmlDocument1 = builder.parse(new File(file7));
		String a=XMLToString.toXmlString(xmlDocument);
		String b=XMLToString.toXmlString(xmlDocument1);
        
		//OvalCompare.compareObjects(os, os1);
		
		List<String> c= new ArrayList<String>();
		OvalCompareJDK.diff(a,b,c);
		
		XMLCompareArch.AssertXml.assertEqualXmls(a, b);
		
		
		//System.out.println(os.getGenerator().getProductName());
		//System.out.println(os.getSignature().getSignatureValue());
		//System.out.println(os.getDefinitions().getClass());
		//System.out.println(os.getDefinitions().getDefinition());
		//System.out.println(os.getVariables().getVariable());
		//System.out.println(os.getObjects().getObject());
		//System.out.println(os.getStates().getState());
		//System.out.println(os.getTests().getTest());
		

		//File file1=new File("src\\main\\resources\\info.json");
		//User u=new User(123,"SaiDinesh","CK",22,"M");
		//UtilityJSON.JsonToPojo(file1,User.class);	
		//UtilityJSON.JsonToPojo(file1,Student.class);
		//Student obj2=UtilityJSON.JsonToPojo(file1,Student.class);	
		//System.out.println(obj2.getFirstName());
		//UtilityJSON.PojoToJson(Student.class);
		//UtilityJSON.PojoToJson(User.class);
		//UtilityJSON.PojoToJson(OvalDefinitions.class);
		
		
		Student s=new Student("SaiDinesh","CK","saidin");
		UtilityJsonJackson.pojoToJson(s);
		//UtilityJsonJackson.pojoToJson(os);
		//UtilityJsonJackson.pojoToJson(os1);
		//File file4 = new File("src\\main\\resources\\info.json");
		//Student obj3 = UtilityJsonJackson.jsonToPojo(Student.class, file4);
		//System.out.println(obj3.getFirstName());
		//System.out.println(obj3.getLastName());
		//System.out.println(obj3.getEmail());
		
		
		
	}

	private static Document writeXmlDocumentToXmlFile(String xmlFilePath) {
		// TODO Auto-generated method stub
		return null;
	}

}
