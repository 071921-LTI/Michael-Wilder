package com.lntinfotech.controllers;

import java.util.Scanner;

import com.lntinfotech.exceptions.AuthException;
import com.lntinfotech.exceptions.UserNotFoundException;
import com.lntinfotech.models.Employee;
import com.lntinfotech.models.User;
import com.lntinfotech.services.AuthService;
import com.lntinfotech.services.AuthServiceImpl;
import com.lntinfotech.services.EmployeeService;
import com.lntinfotech.services.EmployeeServiceImpl;
import com.lntinfotech.services.UserService;
import com.lntinfotech.services.UserServiceImpl;

public class MenuScreen {
	static Scanner sc = new Scanner(System.in);
	static UserService us = new UserServiceImpl();
	static EmployeeService es = new EmployeeServiceImpl();
	static AuthService as = new AuthServiceImpl();
	static String input;
	public static void display() {
		 
		do {
		System.out.println("Enter: \n1 to login\n2 to register\n3 to exit");
		input = sc.nextLine();
		switch(input) {
		case "1":
			System.out.println("Enter: \nE For Employee Login\nC For Customer Login\n3 to exit");
			input = sc.nextLine();
			switch (input) {
			case "E":
				System.out.println("Enter email address:");
				String email = sc.nextLine();

				try {
					Employee emp = es.getEmployeeByEmail(email);
					System.out.println("Enter password:");
					String password = sc.nextLine();
					Employee toBeChecked = new Employee(email, password);
//					if(as.login(toBeChecked)) {
//						// do something
//					}
					if(es.login(toBeChecked)) {
					System.out.println("Successfully logged in!");
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
					User user = us.getUserByEmail(email1);
					System.out.println("Enter password:");
					String password = sc.nextLine();
					User toBeChecked = new User(email1, password);
//					if(as.login(toBeChecked)) {
//						// do something
//					}
					if(us.login(toBeChecked)) {
					System.out.println("Successfully logged in!");
					userView();
					//input = "3";
					} else {
						System.out.println("Wrong credentials");
					}
				} catch (UserNotFoundException e) {
					System.out.println("User was not found.");
				} catch (AuthException e) {
					System.out.println("Wrong credentials");
				} catch (NullPointerException e) {
					System.out.println("Wrong credentials");
				}
				break;
			}
			
		case "2":
			System.out.println("Enter Your Driver's License Number: ");
			int dlNum = sc.nextInt();
			
			System.out.println("Enter Your First Name: ");
			String firstName = sc.nextLine();
			
			System.out.println("Enter Your Last Name: ");
			String lastName = sc.nextLine();
			
			System.out.println("Enter a email address: ");
			String emailNew = sc.nextLine();
			
			System.out.println("Enter password: ");
			String passwordNew = sc.nextLine();
			
//			if(us.addUser(new User(dlNum, firstName, lastName, emailNew, passwordNew))) {
//				System.out.println("Register successful!");
//			}else {
//				System.out.println("Unable to accomplish operation.");
//			}
			break;
		case "3": System.out.println("Goodbye");
		break;
			default:
				System.out.println("Invalid input");
		}
		} while(!input.equals("3"));
	}
	public static void userView() {

		do {
			System.out.println("Enter: \n1 to View Available Vehicles\n2 to View Previous Purchases\n3 to View Remaining Payments\4 to Make an Offer");
			input = sc.nextLine();
			switch(input) {
			case "1": System.out.println();
			break;
			case "2": System.out.println();
			break;
			case "3": System.out.println();
			break;
			case "4": System.out.println();
			break;
			
			}

		} while(input.equals(""));
	}
	
	public static void employeeView() {

		do {
			System.out.println("Enter: \n1 to View Available Vehicles\n2 to View All Payments\n3 to Add an Vehicle\4 to Remove a Vehicle\5 to Accept or Reject an Offer");
			input = sc.nextLine();
			switch(input) {
			case "1": System.out.println();
			break;
			case "2": System.out.println();
			break;
			case "3": System.out.println();
			break;
			case "4": System.out.println();
			break;
			case "5": System.out.println();
			break;
			
			}

		} while(input.equals(""));
	}
}
