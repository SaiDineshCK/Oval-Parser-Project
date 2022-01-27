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
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class XCCDFRuleDiff {

	public static void main(String argv[]) {

		try

		{
			Document docold = readXMLFile(
					"src//main//resources//CIS_Microsoft_Windows_Server_2012_R2_Benchmark_v2.3.0-xccdf.xml");
			Document docnew = readXMLFile(
					"src//main//resources//CIS_Microsoft_Windows_Server_2012_R2_Benchmark_v2.5.0-xccdf.xml");

			NodeList nodeListold = ruleExtraction(docold);
			System.out.println("Total number of Rules in previous version of benchmark :: " + nodeListold.getLength());
			NodeList nodeListnew = ruleExtraction(docnew);
			System.out.println("Total number of Rules in latest version of benchmark :: " + nodeListnew.getLength());

			comparison(nodeListold, nodeListnew);
			// comparisonTests(nodeListold, nodeListnew);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param nodeListold
	 * @param nodeListnew
	 */

	public static void comparison(NodeList nodeListold, NodeList nodeListnew) {
		List<String> unChangedRules = new ArrayList<String>();
		List<String> idupdated = new ArrayList<String>();
		List<String> newRules = new ArrayList<String>();
		String newnodeid = "";
		for (int counter1 = 0; counter1 < nodeListnew.getLength(); counter1++) {
			Node nodenew = nodeListnew.item(counter1);
			// if (nodenew.getNodeType() == Node.ELEMENT_NODE) {
			newnodeid = ((Element) nodenew).getAttribute("id").toString();
			for (int counter = 0; counter < nodeListold.getLength(); counter++) {
				Node nodeold = nodeListold.item(counter);

				if (((Element) nodeold).getAttribute("id").equalsIgnoreCase(((Element) nodenew).getAttribute("id"))) {
					// System.out.println(((Element) nodeold).getAttribute("id") +"::"+((Element)
					// nodenew).getAttribute("id")) ;

					if (((Element) nodenew).isEqualNode((Element) nodeold)) {
						unChangedRules.add(newnodeid);
						break;
					} else {
						idupdated.add(newnodeid);
					}
				} else {
					continue;
				}
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

	/**
	 * @param docold
	 * @return
	 * @throws XPathExpressionException
	 */
	public static NodeList ruleExtraction(Document docold) throws XPathExpressionException {
		System.out.println("Root element: " + docold.getDocumentElement().getNodeName());
		String root = docold.getDocumentElement().getNodeName();
		NodeList nodeListold = null;

		if (root.equalsIgnoreCase("xccdf:Benchmark")) {
			nodeListold = docold.getElementsByTagName("xccdf:Rule");
		} else {
			nodeListold = docold.getElementsByTagName("Rule");
		}
		return nodeListold;

	}

	/**
	 * @return
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	public static Document readXMLFile(String filePath) throws ParserConfigurationException, SAXException, IOException {
		File filenew = new File(filePath);
		DocumentBuilderFactory dbfnew = DocumentBuilderFactory.newInstance();
		DocumentBuilder dbnew = dbfnew.newDocumentBuilder();
		Document docnew = dbnew.parse(filenew);
		docnew.getDocumentElement().normalize();
		return docnew;
	}

	/**
	 * @param docold
	 * @return
	 */
	public static NodeList definitionExtracted(Document docold) {
		System.out.println("Root element: " + docold.getDocumentElement().getNodeName());
		NodeList nodeListold = docold.getElementsByTagName("definition");

		System.out
				.println("Total number of Definitions in previous version of benchmark :: " + nodeListold.getLength());
		return nodeListold;
	}

	/**
	 * @param docold
	 * @return
	 */
	public static NodeList testsExtraction(Document docold) {
		System.out.println("Root element: " + docold.getDocumentElement().getNodeName());
		Node nodeold1 = docold.getElementsByTagName("tests").item(0);
		NodeList nodeListold = nodeold1.getChildNodes();
		System.out.println("Total number of Tests in previous version of benchmark :: " + nodeListold.getLength());
		return nodeListold;
	}

	/**
	 * @param nodeListold
	 * @param nodeListnew
	 */
	public static void comparisonTests(NodeList nodeListold, NodeList nodeListnew) {
		List<String> unChangedTests = new ArrayList<String>();
		List<String> Testsupdated = new ArrayList<String>();
		List<String> newTests = new ArrayList<String>();
		// System.out.println(nodeListold);
		System.out.println(nodeListold.item(0));
		System.out.println(nodeListold.item(1).getAttributes().getNamedItem("id").getTextContent());
		// System.out.println(nodeListold.item(2));
		// System.out.println(nodeListold.item(3));
		String newnodeid = "";
		for (int counter1 = 1; counter1 < nodeListnew.getLength(); counter1 += 2) {
			Node nodenew = nodeListnew.item(counter1);
			// if (nodenew.getNodeType() == Node.ELEMENT_NODE) {
			newnodeid = nodenew.getAttributes().getNamedItem("id").getTextContent();
			// newnodeid = ((Element) nodenew).getAttribute("id");

			for (int counter = 1; counter < nodeListold.getLength(); counter += 2) {
				Node nodeold = nodeListold.item(counter);

				if (nodeold.getAttributes().getNamedItem("id").getTextContent()
						.equalsIgnoreCase(nodenew.getAttributes().getNamedItem("id").getTextContent())) {
					if (((Element) nodenew).isEqualNode((Element) nodeold)) {
						unChangedTests.add(newnodeid);
						break;
					} else {
						Testsupdated.add(newnodeid);
					}
				} else {
					continue;
				}
			}
			if (unChangedTests.contains(newnodeid) || Testsupdated.contains(newnodeid)) {
				continue;
			} else
				newTests.add(newnodeid);
		}
		// }

		// }
		// System.out.println(idexisting);
		// System.out.println(idupdated);
		System.out.println("Un Changed rules:: " + unChangedTests.size());
		System.out.println("Updated rules:: " + Testsupdated.size());
		System.out.println("New rules :: " + newTests.size());
		// System.out.println("Updated rules\n" +
		// (nodeListnew.getLength()-idexisting.size()));
	}
}
