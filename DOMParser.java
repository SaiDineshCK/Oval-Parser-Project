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

public class DOMParser {	

	public static void main(String argv[])   
	{  
	try   
	{   
	File file = new File("src\\main\\resources\\CIS_Microsoft_Edge_Benchmark_v1.0.0-oval.xml"); 
	File file1 = new File("src\\main\\resources\\CIS_Microsoft_Windows_Server_2016_STIG_Benchmark_v1.1.0-oval.xml");    
	DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();  
	 
	DocumentBuilder db = dbf.newDocumentBuilder();  
	Document doc = db.parse(file);  
	Document doc1 = db.parse(file1);
	doc.getDocumentElement().normalize();  
	doc1.getDocumentElement().normalize();
	System.out.println("Root element: " + doc.getDocumentElement().getNodeName());  
	System.out.println("Root element: " + doc1.getDocumentElement().getNodeName());
	NodeList nodeList = doc.getElementsByTagName("definition");  
	NodeList nodeList1 = doc1.getElementsByTagName("definition");
	NodeList nodeList2 = doc.getElementsByTagName("reference"); 
	NodeList nodeList3 = doc.getElementsByTagName("criterion");
	List<String> id1= new ArrayList<String>();
	List<String> id2= new ArrayList<String>();
	List<String> id3 = new ArrayList<String>();
	List<String> id4 = new ArrayList<String>();
	
	for (int itr = 0; itr < Math.max(nodeList.getLength(),nodeList1.getLength()); itr++)   
	{  
	Node node = nodeList.item(itr);  
	Node node1 = nodeList1.item(itr);
	Node node2 = nodeList2.item(itr);
	Node node3 = nodeList3.item(itr);
	System.out.println("\nNode Name :" + node.getNodeName());  
	System.out.println("\nNode Name :" + node1.getNodeName());  
	if (node.getNodeType() == Node.ELEMENT_NODE)   
	{  
	Element eElement = (Element) node; 
	Element eElement1 = (Element) node1;
	Element eElement2 = (Element) node2;
	Element eElement3 = (Element) node3;
	System.out.println("Title: "+ eElement.getElementsByTagName("title").item(0).getTextContent());  
	System.out.println("Metadata: "+ eElement.getElementsByTagName("metadata").item(0).getTextContent());  
	System.out.println("Reference:ref_id: "+ eElement2.getAttribute("ref_id"));  
	System.out.println("Reference:ref_url "+ eElement2.getAttribute("ref_url"));
	System.out.println("Description: "+ eElement.getElementsByTagName("description").item(0).getTextContent());  
	System.out.println("Criterion: "+ eElement3.getAttribute("test_ref")); 	 
	
	id2.add(eElement.getAttribute("id"));
	System.out.println(id2);
	id1.add(eElement1.getAttribute("id"));
	System.out.println(id1);
	id3.add(eElement.getAttribute("id"));
	id4.add(eElement1.getAttribute("id"));
	id1.removeAll(id2);
	System.out.println("The updated id's are"+id1);
	System.out.println(id1.size());
	id4.retainAll(id3);
	System.out.println("The same id's are"+ id4);
	System.out.println(id4.size());
	
	}
	}
	}
	catch (Exception e)   
	{  
	e.printStackTrace();  
	}  
	}  
	}  


