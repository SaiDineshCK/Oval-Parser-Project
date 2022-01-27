package com.example.demo;

import java.io.File;
import javax.xml.bind.JAXBException;
import org.mitre.oval.xmlschema.oval_definitions_5.DefinitionsType;

		class OvalDefinitions {
		    
		    protected DefinitionsType definitions;

		    public DefinitionsType getDefinitions() {
		        return definitions;
		    }

		    public void setDefinitions(DefinitionsType value) {
		        this.definitions = value;
		    }

		  
			@Override public boolean equals(Object obj)
			{

				if (this == obj)
					return true;

				if (obj == null
					|| this.getClass() != obj.getClass())
					return false;

				OvalDefinitions p1 = (OvalDefinitions)obj;
			
				return this.getDefinitions().getDefinition().equals(p1.getDefinitions().getDefinition());
					
			}
		}

		public class ObjectCompareHashcode {
			public static void main(String args[]) throws JAXBException
			{
				File file2=new File("src\\main\\resources\\CIS_Microsoft_Edge_Benchmark_v1.0.0-oval.xml");
				File file3=new File("src\\main\\resources\\CIS_Microsoft_Windows_Server_2016_STIG_Benchmark_v1.1.0-oval.xml");
				OvalDefinitions os= Utility.unMarshalXML(file2, OvalDefinitions.class);
				
				OvalDefinitions os1= Utility.unMarshalXML(file3, OvalDefinitions.class);
				
				System.out.println(os.equals(os1));
			}
		}
