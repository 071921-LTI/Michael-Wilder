package com.lntinfotech.controllers;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.lntinfotech.daos.OfferDao;
import com.lntinfotech.daos.OfferPostgres;
import com.lntinfotech.daos.UserDao;
import com.lntinfotech.daos.UserPostgres;
import com.lntinfotech.exceptions.AuthException;
import com.lntinfotech.exceptions.InvalidInputException;
import com.lntinfotech.exceptions.UserNotFoundException;
import com.lntinfotech.models.Employee;
import com.lntinfotech.models.Offers;
import com.lntinfotech.models.User;
import com.lntinfotech.models.Vehicles;
import com.lntinfotech.services.EmployeeService;
import com.lntinfotech.services.EmployeeServiceImpl;
import com.lntinfotech.services.UserService;
import com.lntinfotech.services.UserServiceImpl;
import com.lntinfotech.services.VehicleService;
import com.lntinfotech.services.VehicleServiceImpl;

public class MenuScreen {
	static Scanner sc = new Scanner(System.in);
	static UserService us = new UserServiceImpl();
	static EmployeeService es = new EmployeeServiceImpl();
	static VehicleService vs = new VehicleServiceImpl();
	private static Logger log = LogManager.getRootLogger();
	static UserDao ud = new UserPostgres();
	static OfferDao od = new OfferPostgres();
	static String input;
	static int userI;
	static int emp;
	public static void display() {
		  
		do {
		System.out.println("Enter: \n1 to login\n2 to register\n3 to exit");
		input = sc.nextLine();
		switch(input) {
		case "1":
			System.out.println("Enter: \nE For Employee Login\nC For Customer Login\n3 to exit");
			input = sc.nextLine();
			do {
			switch (input) {
			case "E":
				System.out.println("Enter email address:");
				String email = sc.nextLine();

				try {

					System.out.println("Enter password:");
					String password = sc.nextLine();
					Employee toBeChecked = new Employee(email, password);

					if(es.login(toBeChecked)) {
					System.out.println("Successfully logged in!");
					emp = es.getIdByEmail1(email);
					employeeView();
					//input = "3";
					} else {
						System.out.println("Wrong credentials");
					}
				} catch (AuthException e) {
					System.out.println("Wrong credentials");
				} catch (NullPointerException e) {
					System.out.println("Wrong credentials");
				} catch (UserNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case "C":
				System.out.println("Enter email address:");
				String email1 = sc.nextLine();

				try {

					System.out.println("Enter password:");
					String password = sc.nextLine();
					User toBeChecked = new User(email1, password);
//					if(as.login(toBeChecked)) {
//						// do something
//					}
					if(us.login(toBeChecked)) {
					System.out.println("Successfully logged in!");
					userI = us.getIdByEmail1(email1);
					userView();
				    
				    
					} else {
						System.out.println("Wrong credentials");
					}
				} catch (UserNotFoundException e) {
					System.out.println("User was not found.");
					log.warn("user not found");
				} catch (AuthException e) {
					System.out.println("Wrong credentials");
				} catch (NullPointerException e) {
					System.out.println("Wrong credentials");
				}
				input = "3";
				break;
			case "3" : System.out.println("Bye");
			int exit = 3;
			System.out.println("GoodBye");
			System.exit(exit);
			break;
			default : 
				System.out.println("invalid input");
			}
			}while(!input.equals("3"));
			
		case "2":
			
			System.out.println("Enter Your First Name: ");
			String firstName = sc.nextLine();
			
			System.out.println("Enter Your Last Name: ");
			String lastName = sc.nextLine();
			
			System.out.println("Enter a email address: ");
			String emailNew = sc.nextLine().toLowerCase();
			
			System.out.println("Enter password: ");
			String passwordNew = sc.nextLine();
			
			if(us.addUser(new User(firstName, lastName, emailNew, passwordNew)) > 0) {
				System.out.println("Register successful!");
			}else {
				System.out.println("Unable to accomplish operation.");
			}
			
			break;
		case "3": 
			int exit = 3;
			System.out.println("GoodBye");
			System.exit(exit);
		break;
			default:
				System.out.println("Invalid input");
		}
		} while(!input.equals("3"));
	}
	public static void userView() {
		
		do {
			System.out.println("Enter: \n1 to View Available Vehicles\n2 to View Previous Purchases\n3 to View Remaining Payments\n4 to Make an Offer\n5 to logout");
			input = sc.nextLine();
			switch(input) {
			case "1": 
				List<Vehicles> off = vs.getAvailableVehicle();
				for(Vehicles u : off) {
					System.out.println(u);
				}
			break;
			case "2": 
				List<Vehicles> gui = vs.getVehiclesByUser(userI);
				System.out.println(userI);
				for(Vehicles u : gui) {
					System.out.println(u);
				}
			
			break;
			case "3": 
				System.out.println(vs.getRemainingWeeklyPayments(userI));
			break;
			case "4": 
					
				System.out.println("Enter the Vehicles Vin: ");
				String vin = sc.nextLine().toUpperCase();
				
				System.out.println("Enter Your Offer Amount: ");
				double offer = sc.nextDouble();
						
				us.makeOffer(new Offers("Pending", offer, (new Vehicles(vin)), (new User(userI))));
				vs.updateVehicleOffer((new Vehicles(vin)));
				System.out.println("Your offer was submitted");
				input = "3";
				break;
			case "5" :
				int exit = 5;
				System.out.println("GoodBye");
				System.exit(exit);
				break;
			default:
				System.out.println("Invalid input");
		
			}
			
		} while((!input.equals("5")));
	}
	
	public static void employeeView() {

		do {
			System.out.println("Enter: \n1 to View All Vehicles\n2 to View All Payments\n3 to view all offers\n4 to Add an Vehicle\n5 to Remove a Vehicle\n6 to Accept or Reject an Offer\n7 to logout");
			input = sc.nextLine();
			switch(input) {
			case "1": 
				List<Vehicles> gv = vs.getVehicle();
				for(Vehicles u : gv) {
					System.out.println(u);
				}

			break;
			case "2": 
				
				List<Vehicles> gap = es.getAllPayments();
				for(Vehicles u : gap) {
					System.out.println(u);
				}
				break;
			case "3": 
				
				List<Offers> off = es.getAllOffers();
				for(Offers u : off) {
					System.out.println(u);
				}

			break;
			case "4": 
				try {
				System.out.println("Enter Vehicles VIN: ");
				String vin = sc.nextLine();
				System.out.println("Enter Vehicles Year: ");
				int year = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter Vehicles Make: ");
				String make = sc.nextLine();

				System.out.println("Enter Vehicles Model: ");
				String model = sc.nextLine(); 
				sc.nextLine();
				System.out.println("Enter Vehicles Price: ");
				double price = sc.nextDouble();
				es.addVehicles(new Vehicles(vin, year, make, model,price));
				System.out.println();
				}catch (InputMismatchException e) {
					System.out.println("Please enter a vaild year");
					log.warn("year wrong");
				}
			break;
			case "5": 
				System.out.println("Enter the VIN of the Vehicle you want to Remove");
				String vin1 = sc.nextLine();
				es.deleteVehicles(vin1);
			break;
			case "6": 

				System.out.println("Do you wish to accept or reject an offer");
				String aor = sc.nextLine();
				System.out.println(aor);
				if(aor.equals("accept")) {

					System.out.println("Enter the id of the offer you want to accept");
					int id = sc.nextInt();
					double am = od.offerAmount(id);
					int uid = od.userId(id);
					String vini = od.vinById(id);


					es.acceptedOffer((new Offers(id)), (new Vehicles(am, (new User(uid)), (new Employee(emp)), vini)));
					es.rejectOffer(vini, am);
				} else if (aor.equals("reject")) {
					System.out.println("Enter the id of the offer you want to reject");
					int id = sc.nextInt();
					es.rejectOfferById(id);
					System.out.println("Offer had been rejected");
					sc.nextLine();
				} else
					System.out.println("invalid input");
				
				
			break;
			case "7": System.out.println();
			int exit = 7;
			System.out.println("GoodBye");
			System.exit(exit);
			break;
//			default:
//				System.out.println("Invalid input");
			}

		} while(!input.equals("7"));
	}
}
