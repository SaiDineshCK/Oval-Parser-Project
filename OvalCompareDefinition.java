package com.example.demo;

import javax.xml.parsers.DocumentBuilderFactory;  
import javax.xml.parsers.DocumentBuilder;  
import org.w3c.dom.Document;  
import org.w3c.dom.NodeList;  
import org.w3c.dom.Node;  
import org.w3c.dom.Element;  
import java.io.File;
import java.util.ArrayList;
import java.util.List;  
public class OvalCompareDefinition {
	

	

	public static class XCCDFRuleDiff {

			public static void main(String args[])   
			{  
			try   
			{   
			File file = new File("src\\main\\resources\\CIS_Microsoft_Windows_Server_2019_Benchmark_v1.2.1-xccdf.xml"); 
			File file1 = new File("src\\main\\resources\\CIS_Microsoft_Windows_Server_2016_STIG_Benchmark_v1.1.0-xccdf.xml");
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();  
			 
			DocumentBuilder db = dbf.newDocumentBuilder();  
			Document doc = db.parse(file); 
			Document doc1 = db.parse(file1);
			doc.getDocumentElement().normalize();  
			doc1.getDocumentElement().normalize();
			System.out.println("Root element: " + doc.getDocumentElement().getNodeName());  
			NodeList nodeList = doc.getElementsByTagName("xccdf:Rule"); 
			NodeList nodeList1 = doc1.getElementsByTagName("xccdf:Rule"); 
			List<String> id=new ArrayList<String>();
			List<String> id1=new ArrayList<String>();
			List<String> id2=new ArrayList<String>();
			for (int counter = 0; counter < nodeList.getLength(); counter++)   
			{  
			Node node = nodeList.item(counter);  
			//System.out.println("\nNode Name :" + node.getNodeName());   
			if (node.getNodeType() == Node.ELEMENT_NODE)   
			{  
			Element eElement = (Element) node; 
			//System.out.println("ID: "+ eElement.getAttribute("id"));  
			id.add(eElement.getAttribute("id"));
			}
			}		
			System.out.println(id);
			for (int counter1 = 0; counter1 < nodeList1.getLength(); counter1++)   
			{  
			Node node1 = nodeList1.item(counter1);  
			//System.out.println("\nNode Name :" + node1.getNodeName());   
			if (node1.getNodeType() == Node.ELEMENT_NODE)   
			{  
			Element eElement1 = (Element) node1; 
			//System.out.println("ID: "+ eElement1.getAttribute("id"));  
			id1.add(eElement1.getAttribute("id"));
			}
			}		
			System.out.println(id1);
			for(String rule:id1)
			{
				int i=0;
				if(rule==id.get(i))
				{
					//if(node.isEqualNode(node1)) {
					
						id.add(rule);
				}	
					
					else
					{
						id1.removeAll(id);
					}	
					++i;
			
			/*	else {
					id2.add(rule);
			}*/
			}
			System.out.println("Existing rules\n"+id.size());
			System.out.println("Updated rules\n"+id1.size());
			//System.out.println(id2.size());
			}
			catch (Exception e)   
			{  
			e.printStackTrace();  
			}
			}
	}
}
