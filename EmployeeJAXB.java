



//import jaxb.Employee;
//import jaxb.JAXBContext;
//import jaxb.Marshaller;
//import jaxb.Unmarshaller;
package com.example.demo;
import javax.xml.bind.*;
import java.io.File;
public class EmployeeJAXB {
	public void marshall()
	{
		try {
			
			Employee emp=new Employee("121","Sai Dinesh","CK",560022);
			JAXBContext jc=JAXBContext.newInstance(Employee.class);
			Marshaller ms=jc.createMarshaller();
			ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
			ms.marshal(emp,System.out);
			ms.marshal(emp,new File("src\\main\\resources\\Employeeinfo.xml"));
			
		
		} catch(Exception e) {
			System.out.println(""+e.getMessage());
	}

}
public void unmarshall()
{
	try {
		JAXBContext jc=JAXBContext.newInstance(Employee.class);
		Unmarshaller ums=jc.createUnmarshaller();
		Employee emp=(Employee)ums.unmarshal(new File("src\\main\\resources\\Employeeinfo.xml"));
		System.out.println("Employee info");
		System.out.println("id:"+emp.getId());
		System.out.println("name"+emp.getFirstname());
		System.out.println("address"+emp.getLastname());
		System.out.println("code"+emp.getCode());
		
	} catch(Exception e) {
		System.out.println(""+e.getMessage());
	}
	
}

}
