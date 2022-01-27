package com.example.demo;
	import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream; 
	import java.io.FileNotFoundException; 
	import java.io.IOException; 
	import java.io.InputStreamReader; 
	import java.io.Reader; 
	import java.util.List; 
	import org.custommonkey.xmlunit.DetailedDiff; 
	import org.custommonkey.xmlunit.Diff; 
	import org.custommonkey.xmlunit.Difference;
	import org.custommonkey.xmlunit.XMLUnit;
	import org.xml.sax.SAXException;

	public class XCCDFCompareXMLUnit {
		
		public static void XCCDFCompare(File f1,File f2) throws FileNotFoundException, SAXException, IOException {
				
				FileInputStream fis1 = new FileInputStream("src\\main\\resources\\CIS_Microsoft_Windows_Server_2016_STIG_Benchmark_v1.1.0-xccdf.xml"); 
				FileInputStream fis2 = new FileInputStream("src\\main\\\\resources\\CIS_Microsoft_Windows_10_Enterprise_Release_21H1_Benchmark_v1.11.0-xccdf.xml");

				BufferedReader source = new BufferedReader(new InputStreamReader(fis1)); 
				BufferedReader target = new BufferedReader(new InputStreamReader(fis2));

				XMLUnit.setIgnoreWhitespace(true);
				XMLUnit.setIgnoreAttributeOrder(true);
				XMLUnit.setIgnoreComments(true);
				XMLUnit.setIgnoreDiffBetweenTextAndCDATA(true);
				XMLUnit.setNormalizeWhitespace(true);
				List<?> differences = compareXML(source, target);
				printDifferences(differences); 
				
		}

				public static List<?> compareXML(Reader source, Reader target) throws SAXException, IOException{ 
					
					Diff xmlDiff = new Diff(source, target); 
					DetailedDiff detailXmlDiff = new DetailedDiff(xmlDiff); 
					return detailXmlDiff.getAllDifferences();
				}

						public static void printDifferences(List<?> differences){
					        int totalDifferences = differences.size();
					        System.out.println("Total differences : " + totalDifferences);
					        		     
					        //for(Object difference : differences){
					            //System.out.println(difference);
					  
					        
					    }
					}
	