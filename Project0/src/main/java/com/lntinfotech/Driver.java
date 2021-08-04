package com.lntinfotech;

import java.util.List;

import com.lntinfotech.controllers.MenuScreen;
import com.lntinfotech.daos.EmployeeDao;
import com.lntinfotech.daos.EmployeePostgres;
import com.lntinfotech.daos.OfferDao;
import com.lntinfotech.daos.OfferPostgres;
import com.lntinfotech.daos.UserDao;
import com.lntinfotech.daos.UserPostgres;
import com.lntinfotech.daos.VehicleDao;
import com.lntinfotech.daos.VehiclePostgres;
import com.lntinfotech.models.Employee;
import com.lntinfotech.models.Offers;
import com.lntinfotech.models.User;
import com.lntinfotech.models.Vehicles;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		MenuScreen.display();
//		OfferDao od = new OfferPostgres();
//		System.out.println(od.offerAmount(1));
		EmployeeDao ed = new EmployeePostgres();
		System.out.println(ed.getEmployeeByEmail("mm.com"));
//		UserDao ud = new UserPostgres();
//		VehicleDao vd = new VehiclePostgres();
//		System.out.println(od.getOffersByVIN("KL4CJESBXFB218315"));
//		System.out.println(vd.getVehiclesByVIN("WBAYB6C58DC544318"));
//		System.out.println(vd.getVehiclesByVIN("2G4GN5EC0B9472638"));
//		List<Offers> off = od.getOffersByUserId(2);
//		for(Offers u : off) {
//			System.out.println(u);
//		}
//		List<Vehicles> off = vd.getVehiclesByYear(2007);
//		for(Vehicles u : off) {
//			System.out.println(u);
//		}
//		List<Vehicles> off = vd.getVehiclesByMakeAndModel("Ford", "Mustang");
//		for(Vehicles u : off) {
//			System.out.println(u);
//		}
//		List<Vehicles> off = vd.getVehiclesByMake("Ford");
//		for(Vehicles u : off) {
//			System.out.println(u);
//		}
//		List<Vehicles> off = vd.getVehiclesByUser(11);
//		for(Vehicles u : off) {
//			System.out.println(u);
//		}
//		List<Vehicles> off = vd.getVehiclesByEmployee(3);
//		for(Vehicles u : off) {
//			System.out.println(u);
//		}
//		List<Vehicles> off = vd.getVehiclesByOffers(true);
//		for(Vehicles u : off) {
//			System.out.println(u);
//		}
//		List<Vehicles> off = vd.getVehicle();
//		for(Vehicles u : off) {
//			System.out.println(u);
//		}
//		List<Offers> off1 = od.getOffersByVIN("1N6AA0EC7EN783443");
//		for(Offers u : off1) {
//			System.out.println(u);
//		}
//		List<Offers> off1 = od.getOffersByStatus("Pending");
//		for(Offers u : off1) {
//			System.out.println(u);
//		}
//		Offers o = new Offers();
//		Vehicles v = new Vehicles();
//		o.setOffer(90000.00);
//		o.setVin(new Vehicles("1GKKRNED7CJ914482"));
//		o.setUserId(new User(8));
//		int genId = od.addOffer(o);
//		System.out.println("The generated id is:" + genId);
//		System.out.println(od.getOffersByUserId(8));
		//System.out.println(od.getOffersByUserId(2));
//		System.out.println(ed.getEmployeeById(1));
//		System.out.println(ud.getUserById(1));
//		List<Employee> emps = ed.getEmployees();
//		for(Employee e : emps) {
//			System.out.println(e);
//		}
//		List<User> emps = ud.getUser();
//		for(User u : emps) {
//			System.out.println(u);
//		}
//		
//		User e = new User();
//		e.setFirstName("Bob");
//		e.setLastName("Eats");
//		e.setEmail("tom.net");
//		e.setPassword("badPass1");
//		e.setUserId(11);
//		System.out.println(ud.updateUser(e));
//		int genId = ud.addUser(e);
//		System.out.println("The generated id is:" + genId);
//		System.out.println(ud.getUserById(genId));
//		Vehicles v = new Vehicles();
//		User u = new User(2);
//		Employee e = new Employee(3);
//		v.setVin("19UUA76617A789090");
//		v.setYear(2007);
//		v.setMake("Chevrolet");
//		v.setModel("Colorado");
//		v.setPrice(79803.06);
//		v.setOffers(false);
//		v.setRemBal(0);
//		v.setLenRem(0);
//		v.setUserId(u);
//		v.setEmplId(e);
//		v.setVin("19UUA76617A789090");
		//		vd.addVehicles(v);
//		vd.updateVehicles(v);
//		System.out.println(vd.getVehiclesByVIN("19UUA76617A789090"));
//		System.out.println("Number of rows changed:" + vd.deleteVehicles("19UUA76617A789090"));
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
//		e.setId(1);
//		
//		System.out.println(ed.updateEmployee(e));
		//System.out.println();
	}

}
