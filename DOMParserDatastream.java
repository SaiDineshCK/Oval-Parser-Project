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

public class DOMParserDatastream {
   
	public static void main(String argv[])   
	{  
	try   
	{  
	File fileNew = new File("src//main//resources//CIS_Microsoft_Windows_Server_2012_R2_Benchmark_v2.3.0-oval.xml");  
	File fileOld = new File("src//main//resources//U_MS_Windows_Server_2016_V1R12_STIG_SCAP_1-2_Benchmark.xml");
	DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();    
	DocumentBuilder db = dbf.newDocumentBuilder();  
	Document docNew = db.parse(fileNew); 
	Document docOld = db.parse(fileOld);
	docNew.getDocumentElement().normalize();  
	docOld.getDocumentElement().normalize(); 
	System.out.println("Root element: " + docNew.getDocumentElement().getNodeName());
	List<String> id=new ArrayList<String>();
	List<String> id1=new ArrayList<String>();
	List<String> id2=new ArrayList<String>();
	List<String> id3=new ArrayList<String>();
	List<String> id4=new ArrayList<String>();
	List<String> idexisting=new ArrayList<String>();
	List<String> idupdated=new ArrayList<String>();
	int count=0;
	int count1=0;
	
	NodeList nodeListNew = docNew.getElementsByTagName("userright_test");  
	NodeList nodeListOld = docOld.getElementsByTagName("file_test");
	for (int itr = 0; itr < nodeListNew.getLength(); itr++)   
	{  
	Node node = nodeListNew.item(itr);  
	//System.out.println("\nNode Name :" + node.getNodeName());  
	if (node.getNodeType() == Node.ELEMENT_NODE)   
	{  
	Element eElement = (Element) node; 
	//System.out.println("id: "+ eElement.getAttribute("id"));
	id.add(eElement.getAttribute("id"));
	System.out.println(eElement.getAttribute("id"));
	}	
	}
	NodeList nodeList1 = docNew.getElementsByTagName("lockoutpolicy_test");
	for (int itr = 0; itr < nodeList1.getLength(); itr++)   
	{   
	Node node1 = nodeList1.item(itr);
	//System.out.println("\nNode Name :" + node1.getNodeName());  
	if (node1.getNodeType() == Node.ELEMENT_NODE)   
	{  
	Element eElement1 = (Element) node1;
	//System.out.println("id: "+ eElement1.getAttribute("id"));
	id.add(eElement1.getAttribute("id"));
	}  
	}
	NodeList nodeList2 = docNew.getElementsByTagName("passwordpolicy_test");
	for (int itr = 0; itr < nodeList2.getLength(); itr++)   
	{   
	Node node2 = nodeList2.item(itr);
	//System.out.println("\nNode Name :" + node2.getNodeName());  
	if (node2.getNodeType() == Node.ELEMENT_NODE)   
	{  
	Element eElement2 = (Element) node2;
	//System.out.println("id: "+ eElement2.getAttribute("id"));
	id.add(eElement2.getAttribute("id"));
	}  
	}
	NodeList nodeList3 = docNew.getElementsByTagName("auditeventpolicysubcategories_test");
	for (int itr = 0; itr < nodeList3.getLength(); itr++)   
	{   
	Node node3 = nodeList3.item(itr);
	//System.out.println("\nNode Name :" + node3.getNodeName());  
	if (node3.getNodeType() == Node.ELEMENT_NODE)   
	{  
	Element eElement3 = (Element) node3;
	//System.out.println("id: "+ eElement3.getAttribute("id"));
	id.add(eElement3.getAttribute("id"));
	}  
	}
	NodeList nodeList4 = docNew.getElementsByTagName("registry_test");
	for (int itr = 0; itr < nodeList4.getLength(); itr++)   
	{   
	Node node4 = nodeList4.item(itr);
	//System.out.println("\nNode Name :" + node4.getNodeName());  
	if (node4.getNodeType() == Node.ELEMENT_NODE)   
	{  
	Element eElement4 = (Element) node4;
	//System.out.println("id: "+ eElement4.getAttribute("id"));
	id.add(eElement4.getAttribute("id"));
	}  
	}
	NodeList nodeList5 = docNew.getElementsByTagName("accesstoken_test");
	for (int itr = 0; itr < nodeList5.getLength(); itr++)   
	{   
	Node node5 = nodeList5.item(itr);
	//System.out.println("\nNode Name :" + node5.getNodeName());  
	if (node5.getNodeType() == Node.ELEMENT_NODE)   
	{  
	Element eElement5 = (Element) node5;
	//System.out.println("id: "+ eElement5.getAttribute("id"));
	id.add(eElement5.getAttribute("id"));
	}  
	}
	NodeList nodeList6 = docNew.getElementsByTagName("wmi_test");
	for (int itr = 0; itr < nodeList6.getLength(); itr++)   
	{   
	Node node6 = nodeList6.item(itr);
	//System.out.println("\nNode Name :" + node6.getNodeName());  
	if (node6.getNodeType() == Node.ELEMENT_NODE)   
	{  
	Element eElement6 = (Element) node6;
	//System.out.println("id: "+ eElement6.getAttribute("id"));
	id.add(eElement6.getAttribute("id"));
	}  
	}
	NodeList nodeList7 = docNew.getElementsByTagName("fileeffectiverights53_test");
	for (int itr = 0; itr < nodeList7.getLength(); itr++)   
	{   
	Node node7 = nodeList7.item(itr);
	//System.out.println("\nNode Name :" + node7.getNodeName());  
	if (node7.getNodeType() == Node.ELEMENT_NODE)   
	{  
	Element eElement7 = (Element) node7;
	//System.out.println("id: "+ eElement7.getAttribute("id"));
	id.add(eElement7.getAttribute("id"));
	}  
	}
	NodeList nodeList8 = docNew.getElementsByTagName("wmi57_test");
	for (int itr = 0; itr < nodeList8.getLength(); itr++)   
	{   
	Node node8 = nodeList8.item(itr);
	//System.out.println("\nNode Name :" + node8.getNodeName());  
	if (node8.getNodeType() == Node.ELEMENT_NODE)   
	{  
	Element eElement8 = (Element) node8;
	//System.out.println("id: "+ eElement8.getAttribute("id"));
	id.add(eElement8.getAttribute("id"));
	}  
	}
	NodeList nodeList9 = docNew.getElementsByTagName("sid_sid_test");
	for (int itr = 0; itr < nodeList9.getLength(); itr++)   
	{   
	Node node9 = nodeList9.item(itr);
	//System.out.println("\nNode Name :" + node8.getNodeName());  
	if (node9.getNodeType() == Node.ELEMENT_NODE)   
	{  
	Element eElement9 = (Element) node9;
	//System.out.println("id: "+ eElement8.getAttribute("id"));
	id.add(eElement9.getAttribute("id"));
	}  
	}
	NodeList nodeList10 = docNew.getElementsByTagName("user_sid55_test");
	for (int itr = 0; itr < nodeList10.getLength(); itr++)   
	{   
	Node node10 = nodeList10.item(itr);
	//System.out.println("\nNode Name :" + node8.getNodeName());  
	if (node10.getNodeType() == Node.ELEMENT_NODE)   
	{  
	Element eElement10 = (Element) node10;
	//System.out.println("id: "+ eElement8.getAttribute("id"));
	id.add(eElement10.getAttribute("id"));
	}  
	}
	System.out.println(id.size());
	
	for (int itr = 0; itr < nodeListOld.getLength(); itr++)   
	{  
	Node node = nodeListNew.item(itr);  
	//System.out.println("\nNode Name :" + node.getNodeName());  
	if (node.getNodeType() == Node.ELEMENT_NODE)   
	{  
	Element eElement = (Element) node; 
	//System.out.println("id: "+ eElement.getAttribute("id"));
	id1.add(eElement.getAttribute("id"));
	}	
	}
	NodeList nodeList11 = docOld.getElementsByTagName("lockoutpolicy_test");
	for (int itr = 0; itr < nodeList11.getLength(); itr++)   
	{   
	Node node1 = nodeList11.item(itr);
	//System.out.println("\nNode Name :" + node1.getNodeName());  
	if (node1.getNodeType() == Node.ELEMENT_NODE)   
	{  
	Element eElement1 = (Element) node1;
	//System.out.println("id: "+ eElement1.getAttribute("id"));
	id1.add(eElement1.getAttribute("id"));
	}  
	}
	NodeList nodeList21 = docOld.getElementsByTagName("passwordpolicy_test");
	for (int itr = 0; itr < nodeList21.getLength(); itr++)   
	{   
	Node node2 = nodeList21.item(itr);
	//System.out.println("\nNode Name :" + node2.getNodeName());  
	if (node2.getNodeType() == Node.ELEMENT_NODE)   
	{  
	Element eElement2 = (Element) node2;
	//System.out.println("id: "+ eElement2.getAttribute("id"));
	id1.add(eElement2.getAttribute("id"));
	}  
	}
	NodeList nodeList31 = docOld.getElementsByTagName("auditeventpolicysubcategories_test");
	for (int itr = 0; itr < nodeList31.getLength(); itr++)   
	{   
	Node node3 = nodeList31.item(itr);
	//System.out.println("\nNode Name :" + node3.getNodeName());  
	if (node3.getNodeType() == Node.ELEMENT_NODE)   
	{  
	Element eElement3 = (Element) node3;
	//System.out.println("id: "+ eElement3.getAttribute("id"));
	id1.add(eElement3.getAttribute("id"));
	}  
	}
	NodeList nodeList41 = docOld.getElementsByTagName("registry_test");
	for (int itr = 0; itr < nodeList41.getLength(); itr++)   
	{   
	Node node4 = nodeList41.item(itr);
	//System.out.println("\nNode Name :" + node4.getNodeName());  
	if (node4.getNodeType() == Node.ELEMENT_NODE)   
	{  
	Element eElement4 = (Element) node4;
	//System.out.println("id: "+ eElement4.getAttribute("id"));
	id1.add(eElement4.getAttribute("id"));
	}  
	}
	NodeList nodeList51 = docOld.getElementsByTagName("accesstoken_test");
	for (int itr = 0; itr < nodeList51.getLength(); itr++)   
	{   
	Node node5 = nodeList51.item(itr);
	//System.out.println("\nNode Name :" + node5.getNodeName());  
	if (node5.getNodeType() == Node.ELEMENT_NODE)   
	{  
	Element eElement5 = (Element) node5;
	//System.out.println("id: "+ eElement5.getAttribute("id"));
	id1.add(eElement5.getAttribute("id"));
	}  
	}
	NodeList nodeList61 = docOld.getElementsByTagName("wmi_test");
	for (int itr = 0; itr < nodeList61.getLength(); itr++)   
	{   
	Node node6 = nodeList61.item(itr);
	//System.out.println("\nNode Name :" + node6.getNodeName());  
	if (node6.getNodeType() == Node.ELEMENT_NODE)   
	{  
	Element eElement6 = (Element) node6;
	//System.out.println("id: "+ eElement6.getAttribute("id"));
	id1.add(eElement6.getAttribute("id"));
	}  
	}
	NodeList nodeList71 = docOld.getElementsByTagName("fileeffectiverights53_test");
	for (int itr = 0; itr < nodeList71.getLength(); itr++)   
	{   
	Node node7 = nodeList71.item(itr);
	//System.out.println("\nNode Name :" + node7.getNodeName());  
	if (node7.getNodeType() == Node.ELEMENT_NODE)   
	{  
	Element eElement7 = (Element) node7;
	//System.out.println("id: "+ eElement7.getAttribute("id"));
	id1.add(eElement7.getAttribute("id"));
	}  
	}
	NodeList nodeList81 = docOld.getElementsByTagName("wmi57_test");
	for (int itr = 0; itr < nodeList81.getLength(); itr++)   
	{   
	Node node8 = nodeList81.item(itr);
	//System.out.println("\nNode Name :" + node8.getNodeName());  
	if (node8.getNodeType() == Node.ELEMENT_NODE)   
	{  
	Element eElement8 = (Element) node8;
	//System.out.println("id: "+ eElement8.getAttribute("id"));
	id1.add(eElement8.getAttribute("id"));
	}  
	}
	NodeList nodeList91 = docOld.getElementsByTagName("sid_sid_test");
	for (int itr = 0; itr < nodeList91.getLength(); itr++)   
	{   
	Node node9 = nodeList91.item(itr);
	//System.out.println("\nNode Name :" + node8.getNodeName());  
	if (node9.getNodeType() == Node.ELEMENT_NODE)   
	{  
	Element eElement9 = (Element) node9;
	//System.out.println("id: "+ eElement8.getAttribute("id"));
	id1.add(eElement9.getAttribute("id"));
	}  
	}
	NodeList nodeList101 = docOld.getElementsByTagName("user_sid55_test");
	for (int itr = 0; itr < nodeList101.getLength(); itr++)   
	{   
	Node node10 = nodeList101.item(itr);
	//System.out.println("\nNode Name :" + node8.getNodeName());  
	if (node10.getNodeType() == Node.ELEMENT_NODE)   
	{  
	Element eElement10 = (Element) node10;
	//System.out.println("id: "+ eElement8.getAttribute("id"));
	id1.add(eElement10.getAttribute("id"));
	}  
	}
	id2=id1;
	id3=id;
	System.out.println(id1.size());
	id.removeAll(id1);
	System.out.println("updated rules \n"+id1.size());
	id3.retainAll(id2);
	System.out.println("existing rules \n"+id3.size());
	String newnodeid="";
	for (int counter1 = 0; counter1 < count; counter1++) {
		Node nodenew = nodeListNew.item(counter1);
		//if (nodenew.getNodeType() == Node.ELEMENT_NODE) {
			newnodeid = ((Element) nodenew).getAttribute("id").toString();
			for (int counter = 0; counter < count1; counter++) {
				Node nodeold = nodeListOld.item(counter);
				
				//if (nodeold.getNodeType() == Node.ELEMENT_NODE) {
				//System.out.println(((Element) nodeold).getAttribute("id"));
				//System.out.println(((Element) nodenew).getAttribute("id"));
				if (((Element) nodeold).getAttribute("id").equalsIgnoreCase(((Element) nodenew).getAttribute("id")))
					{
						if (((Element)nodenew).isEqualNode((Element)nodeold)) {
							idexisting.add(newnodeid);
							break;
						} 
						else
							idupdated.add(newnodeid);							
					}						
				else
					continue;
				}
			if(idexisting.contains(newnodeid)||idupdated.contains(newnodeid))
			{
					continue;			
			}
			else
				idupdated.add(newnodeid);
	}
	//System.out.println("existing rules"+idexisting.size());
	//System.out.println("updated rules"+idupdated.size());
	
	NodeList nodeListNew1 = docNew.getElementsByTagName("tests");
	for (int itr = 0; itr < nodeListNew1.getLength(); itr++)   
	{ 	
	Node nodenew = nodeListNew1.item(itr);
	//System.out.println("\nNode Name :" + node1.getNodeName()); 
	newnodeid = ((Element) nodenew).getAttribute("id").toString();
	if (nodenew.getNodeType() == Node.ELEMENT_NODE)   
	{  
	Element eElement1 = (Element) nodenew;
	//System.out.println("id: "+ eElement1.getAttribute("id"));
	NodeList nodeListNew2 = eElement1.getChildNodes();
	
	}  
	}
	NodeList nodeListOld1 = docOld.getElementsByTagName("tests");
	for (int itr = 0; itr < nodeListOld1.getLength(); itr++)   
	{   
	Node node1 = nodeListOld1.item(itr);
	//System.out.println("\nNode Name :" + node1.getNodeName());  
	if (node1.getNodeType() == Node.ELEMENT_NODE)   
	{  
	Element eElement1 = (Element) node1;
	//System.out.println("id: "+ eElement1.getAttribute("id"));
	NodeList nodeListOld2 = eElement1.getChildNodes();
	count1++;
	}  
	}
	}   
	catch (Exception e)   
	{  
	e.printStackTrace();  
	}  
	}  
	}  


