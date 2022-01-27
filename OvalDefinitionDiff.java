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

public class OvalDefinitionDiff {

	public static void main(String argv[]) {

		try

		{
			//File fileold = new File("src\\main\\resources\\CIS_Microsoft_Windows_Server_2016_Benchmark_v1.0.0-oval.xml");
			//File fileold = new File("src\\main\\resources\\CIS_Microsoft_Windows_Server_2016_Benchmark_v1.0.0-oval.xml");
			File fileold = new File("src\\main\\resources\\CIS_Microsoft_Windows_Server_2012_R2_Benchmark_v2.2.0-oval.xml");
			File filenew = new File("src\\main\\resources\\CIS_Microsoft_Windows_Server_2012_R2_Benchmark_v2.5.0-oval.xml");
			// File fileold = new File("src\\main\\resources\\CIS_Microsoft_Windows_Server_2019_Benchmark_v1.2.1-xccdf.xml");
			DocumentBuilderFactory dbfold = DocumentBuilderFactory.newInstance();
			DocumentBuilderFactory dbfnew = DocumentBuilderFactory.newInstance();
			DocumentBuilder dbold = dbfold.newDocumentBuilder();
			DocumentBuilder dbnew = dbfnew.newDocumentBuilder();
			Document docold = dbold.parse(fileold);
			Document docnew = dbnew.parse(filenew);
			docold.getDocumentElement().normalize();
			docnew.getDocumentElement().normalize();
			System.out.println("Root element: " + docold.getDocumentElement().getNodeName());
			Node nodeold1 = docold.getElementsByTagName("tests").item(0);
			Node nodenew1 = docnew.getElementsByTagName("tests").item(0);
			
			NodeList nodeListold = nodeold1.getChildNodes();
			NodeList nodeListnew = nodenew1.getChildNodes();
			System.out.println("Total number of Tests in previous version of benchmark :: " + nodeListold.getLength());
			System.out.println("Total number of Tests in current version of benchmark :: " + nodeListnew.getLength());
			List<String> unChangedTests = new ArrayList<String>();
			List<String> Testsupdated = new ArrayList<String>();
			List<String> newTests = new ArrayList<String>();
			//System.out.println(nodeListold);
			System.out.println(nodeListold.item(11));
			System.out.println(nodeListold.item(1));
			System.out.println(nodeListold.item(1).getAttributes().item(3).getTextContent());
			System.out.println(nodeListnew.item(0));
			System.out.println(nodeListnew.item(11));
			System.out.println(nodeListnew.item(15));
			
			//System.out.println(nodeListnew.item(15).getAttributes().item(3).getTextContent());
			//System.out.println(nodeListnew.item(11).getAttributes().item(3).getTextContent());
			//System.out.println(nodeListnew.item(1).getAttributes().item(3).getTextContent());
			//System.out.println(nodeListold.item(2));
			//System.out.println(nodeListold.item(3));
			String newnodeid = "";
			String oldnodeid = "";
			for (int counter1 = 1; counter1 < nodeListnew.getLength(); counter1+=2) {
				Node nodenew = nodeListnew.item(counter1);
				// if (nodenew.getNodeType() == Node.ELEMENT_NODE) {
				newnodeid=nodenew.getAttributes().getNamedItem("id").getTextContent();
				//newnodeid=((Element) nodenew).getAttribute("id");
				//System.out.println(newnodeid);
				//newnodeid = ((Element) nodenew).getAttribute("id");

				for (int counter = 1; counter < nodeListold.getLength(); counter+=2) {
					Node nodeold = nodeListold.item(counter);			
oldnodeid=nodeold.getAttributes().getNamedItem("id").getTextContent();
					//oldnodeid=((Element) nodenew).getAttribute("id");
//System.out.println(oldnodeid);
					if (oldnodeid.equalsIgnoreCase(newnodeid)) {
						
					/*if (nodeold.getAttributes().item(3).getNodeValue()
							.equalsIgnoreCase(nodenew.getAttributes().item(3).getNodeValue())) {*/
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
