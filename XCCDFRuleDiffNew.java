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

public class XCCDFRuleDiffNew {

	public static void main(String argv[]) {

		try

		{
			// File filenew = new
			// File("src\\main\\resources\\CIS_Microsoft_Windows_Server_2019_Benchmark_v1.2.1-xccdf.xml");
			// File fileold = new
			// File("src\\main\\resources\\CIS_Microsoft_Windows_Server_2016_STIG_Benchmark_v1.1.0-xccdf.xml");
			File filenew = new File(
				"C:\\Manu\\Java_Workspace\\Sample\\src\\main\\resources\\centos_latest\\CIS_CentOS_Linux_7_Benchmark_v3.1.2-xccdf.xml");
			File fileold = new File(
					"C:\\Manu\\Java_Workspace\\Sample\\src\\main\\resources\\centos_7_3\\CIS_CentOS_Linux_7_Benchmark_v3.0.0-xccdf.xml");
			 //File filenew = new
			// File("C:\\Manu\\Java_Workspace\\Sample\\src\\main\\resources\\centos_7_3\\CIS_CentOS_Linux_7_Benchmark_v3.0.0-xccdf2.xml");
			// File fileold = new
			// File("src\\main\\resources\\CIS_Microsoft_Windows_Server_2019_Benchmark_v1.2.1-xccdf.xml");
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
				for (int counter = 0; counter < nodeListold.getLength(); counter++) {
					Node nodeold = nodeListold.item(counter);

					if (((Element) nodeold).getAttribute("id")
							.equalsIgnoreCase(((Element) nodenew).getAttribute("id"))) {
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
