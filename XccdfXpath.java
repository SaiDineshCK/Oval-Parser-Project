package com.example.demo;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import javax.xml.namespace.NamespaceContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XccdfXpath {

	public static void main(String[] args) throws Exception {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true);
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(new FileInputStream(new File("src//main//resources//win10_1st_Failure.xml")));

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
		for (int i = 0; i < nodes.getLength(); i++) {
		    Node currentItem = nodes.item(i);
		    Element eElement = (Element) currentItem;
		    System.out.println(eElement.getAttribute("id"));
		    System.out.println("found node " + currentItem.getLocalName() + " (namespace: " + currentItem.getNamespaceURI() + ")");
		}
	}
}