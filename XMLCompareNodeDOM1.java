package com.example.demo;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.DocumentBuilder;  
import org.w3c.dom.Document;  
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.w3c.dom.Node;  
import org.w3c.dom.Element;  
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;  

public class XMLCompareNodeDOM1 {

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
			List<Node> id5 = new ArrayList<Node>();
			List<Node> id6 = new ArrayList<Node>();
			for (int counter = 0; counter < Math.max(nodeList.getLength(),nodeList1.getLength()); counter++)   
			{  
			Node node = nodeList.item(counter);  
			Node node1 = nodeList1.item(counter);
			Node node2 = nodeList2.item(counter);
			Node node3 = nodeList3.item(counter);
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
			id4.retainAll(id3);
			System.out.println("The same id's are"+ id4);
			
System.out.println("Attributes"+node.getAttributes().item(1));
			
			for(int a=0;a<node.getAttributes().getLength();a++)
			{
				id5.add(node.getAttributes().item(1));
				id6.add(node1.getAttributes().item(1));
			}
			System.out.println(id5);
			System.out.println(id6);
			
			System.out.println("Output"+compareXML(node, node1));
			
		
			}
			}
			}
			catch (Exception e)   
			{  
			e.printStackTrace();  
			}  
		    }
			
			@SuppressWarnings("unused")
			private static <XmlNode> boolean compareXML(XmlNode node, XmlNode node1) throws ParserConfigurationException, SAXException, IOException
		    {
				
				File file = new File("src\\main\\resources\\CIS_Microsoft_Edge_Benchmark_v1.0.0-oval.xml"); 
				File file1 = new File("src\\main\\resources\\CIS_Microsoft_Windows_Server_2016_STIG_Benchmark_v1.1.0-oval.xml");    
				DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();  
				 
				DocumentBuilder db = dbf.newDocumentBuilder();  
				Document doc = db.parse(file);  
				Document doc1 = db.parse(file1);
				doc.getDocumentElement().normalize();  
				doc1.getDocumentElement().normalize();
				
				NodeList nodeList4 = doc.getElementsByTagName("definition");  
				NodeList nodeList5 = doc1.getElementsByTagName("definition");
				
				for (int counter = 0; counter < Math.max(nodeList4.getLength(),nodeList5.getLength()); counter++)   
				{  
				Node node2 = nodeList4.item(counter);  
				Node node3 = nodeList5.item(counter);
				if (node2.getNodeType() == Node.ELEMENT_NODE)   
				{  
				Element eElement = (Element) node; 
				Element eElement1 = (Element) node1;
				
				NodeList nodeList6 = node2.getChildNodes();
				NodeList nodeList7 = node3.getChildNodes();

				if (node2.getAttributes() != node3.getAttributes()) 
				return false;
				
				if(node2.getAttributes().item(1)==node3.getAttributes().item(1))
				{
		            if (nodeList6.getLength()>0)
		            {
		                for (int counter1=0; counter1<nodeList6.getLength(); counter1++)
		                {
		                    String parentattributename = ((Node) node).getNodeName();
		                    String parentattributevalue = ((Node) node).getNodeValue();
		                    if (parentattributevalue != nodeList6.item(counter1).getNodeValue())
		                    
		                    	return false;
		                       
		                 
		                }
		            }
		            if(node2.hasChildNodes())
		            {
		            if (nodeList6.getLength() != nodeList7.getLength()) 
		            return false;
		            for(int counter1=0; counter1<nodeList4.getLength();counter1++)
		                {

		                String name = nodeList6.item(counter1).getLocalName();
		                if (compareXML(nodeList6.item(counter1), nodeList7.item(counter1)) == false) 
		                return false;
		                }
		            }
				}
				}
				
		    }
				return true;
}
}


