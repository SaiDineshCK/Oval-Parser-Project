package com.example.demo;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import javax.xml.namespace.NamespaceContext;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Xccdf {

	public static void main(String argv[]) {

		try

		{
			//File filenew = new File("src\\main\\resources\\CIS_Microsoft_Windows_Server_2019_Benchmark_v1.2.1-xccdf.xml");
			File filenew = new File("src\\main\\resources\\win10_1st_Failure.xml");
			//File fileold = new File("src\\main\\resources\\CIS_Microsoft_Windows_Server_2016_STIG_Benchmark_v1.1.0-xccdf.xml");
			File fileold = new File("src\\main\\resources\\CIS_Microsoft_Windows_10_Enterprise_Release_21H1_Benchmark_v1.11.0-xccdf.xml");
			DocumentBuilderFactory dbfold = DocumentBuilderFactory.newInstance();
			DocumentBuilderFactory dbfnew = DocumentBuilderFactory.newInstance();
			DocumentBuilder dbold = dbfold.newDocumentBuilder();
			DocumentBuilder dbnew = dbfnew.newDocumentBuilder();
			Document docold = dbold.parse(fileold);
			Document docnew = dbnew.parse(filenew);
			docold.getDocumentElement().normalize();
			docnew.getDocumentElement().normalize();
			System.out.println("Root element: " + docold.getDocumentElement().getNodeName());
			NodeList nodeListold = docold.getElementsByTagName("xccdf:Rule");
			NodeList nodeListnew = docnew.getElementsByTagName("xccdf:Rule");
			System.out.println("Total number of Rules in previous version of benchmark :: " +nodeListold.getLength());
			System.out.println("Total number of Rules in current version of benchmark :: " +nodeListnew.getLength());
			List<String> unChangedRules = new ArrayList<String>();
			List<String> idupdated = new ArrayList<String>();
			List<String> newRules = new ArrayList<String>();
			String newnodeid = "";
			for (int counter1 = 0; counter1 < nodeListnew.getLength(); counter1++) {
				Node nodenew = nodeListnew.item(counter1);
				// if (nodenew.getNodeType() == Node.ELEMENT_NODE) {
				newnodeid = ((Element) nodenew).getAttribute("id").toString();
				Node currentNode2=null;
				currentNode2 = getNodeWithRuleId(newnodeid,nodeListold);
				System.out.println( currentNode2);
				System.out.println(((Element) currentNode2).getAttribute("id"));
				/*for (int counter = 0; counter < nodeListold.getLength(); counter++) {
					Node nodeold = nodeListold.item(counter);

					if (((Element) currentNode).getAttribute("id")
							.equalsIgnoreCase(((Element) nodenew).getAttribute("id"))) {*/
						if (((Element) nodenew).isEqualNode((Element) currentNode2)) {
							unChangedRules.add(newnodeid);
						} else {
							idupdated.add(newnodeid);
						}
				if (unChangedRules.contains(newnodeid) || idupdated.contains(newnodeid)) {
					continue;
				} else
					newRules.add(newnodeid);
			}
			// }

			// }
			// System.out.println(idexisting);
			// System.out.println(idupdated);
			System.out.println("Un Changed rules:: " + unChangedRules.size());
			System.out.println("Updated rules:: " + idupdated.size());
			System.out.println("New rules :: " + newRules.size());
			// System.out.println("Updated rules\n" +
			// (nodeListnew.getLength()-idexisting.size()));
		}

		 catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static Node getNodeWithRuleId(String newnodeid, NodeList nodeListold) throws XPathExpressionException, ParserConfigurationException, FileNotFoundException, SAXException, IOException {
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true);
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(new FileInputStream(new File("src//main//resources//CIS_Microsoft_Windows_10_Enterprise_Release_21H1_Benchmark_v1.11.0-xccdf.xml")));		
		XPathFactory xpathfactory = XPathFactory.newInstance();
		XPath xpath = xpathfactory.newXPath();
		xpath.setNamespaceContext(new NamespaceContext() {
		    public String getNamespaceURI(String prefix) {
		        return prefix.equals("xccdf") ? "http://checklists.nist.gov/xccdf/1.2" : null;
		    }

		    public Iterator<String> getPrefixes(String val) {
		        return null;
		    }

		    public String getPrefix(String uri) {
		        return null;
		    }
		});
		XPathExpression expr = xpath.compile("//xccdf:Rule");
		Object result = expr.evaluate(doc, XPathConstants.NODESET);
		NodeList nodes = (NodeList) result;
		nodeListold = (NodeList) result;
		Node currentNode1 = null;
		//System.out.println(((Element) nodeListold.item(0)).getAttributes());
		for(int i=0;i<nodeListold.getLength();i++)
		{
			if(newnodeid.equalsIgnoreCase(((Element) nodeListold.item(i)).getAttribute("id"))){
				currentNode1= nodeListold.item(i);
				
				break;
			}
			else 
				continue;
		}
		
		/*for (int i = 0; i < nodes.getLength(); i++) {
		    Node currentNode = nodes.item(i);
		    Element eElement = (Element) currentNode;
		    //System.out.println(eElement.getAttribute("id"));
		    if(newnodeid.equalsIgnoreCase(eElement.getAttribute("id")))
		    {
		    	currentNode1=currentNode;
		    	break;
		    }
		    else continue;
		}*/
		return currentNode1;
	}
}
