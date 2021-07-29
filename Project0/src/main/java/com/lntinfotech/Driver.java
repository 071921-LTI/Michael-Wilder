package com.lntinfotech;

import java.util.List;

import com.lntinfotech.controllers.MenuScreen;
import com.lntinfotech.daos.EmployeeDao;
import com.lntinfotech.daos.EmployeePostgres;
import com.lntinfotech.models.Employee;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//MenuScreen.display();
		EmployeeDao ed = new EmployeePostgres();
//		System.out.println(ed.getEmployeeById(1));
//		List<Employee> emps = ed.getEmployees();
//		for(Employee e : emps) {
//			System.out.println(e);
//		}
//		Employee e = new Employee();
//		e.setFirstName("Bob");
//		e.setLastName("Eats");
//		e.setRole("Jester");
//		e.setSalary(20000.00);
//		e.setEmail("bBDHD.DFHCH");
//		e.setPassword("badPass1");
//		
//		int genId = ed.addEmployee(e);
//		System.out.println("The generated id is:" + genId);
//		System.out.println(ed.getEmployeeById(genId));
//		System.out.println("Number of rows changed:" + ed.deleteEmployee(14));
//		System.out.println(ed.getEmployeeByEmail("nturnock9@unicef.org"));
//		Employee e = new Employee();
//		e.setFirstName("Bob");
//		e.setLastName("Forapples");
//		e.setRole("teacher2");
//		e.setSalary(100.0);
//		e.setEmail("J@gmail.com");
//		e.setPassword("thisismypass");
//		e.setId(12);
//		
//		System.out.println(ed.updateEmployee(e));
		
	}

}
