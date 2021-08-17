package com.lti.delegates;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lti.daos.ReimbursementStatusDao;
import com.lti.daos.ReimbursementStatusHibernate;
import com.lti.daos.UserDao;
import com.lti.daos.UserHibernate;
import com.lti.exceptions.UserNotFoundException;
import com.lti.models.Reimbursement;
import com.lti.models.ReimbursementStatus;
import com.lti.models.User;
import com.lti.services.AuthService;
import com.lti.services.AuthServiceImpl;
import com.lti.services.ReimbursementService;
import com.lti.services.ReimbursementServiceImpl;
import com.lti.services.UserService;
import com.lti.services.UserServiceImpl;

public class ReimbursementDelegate implements Delegatable{
	AuthService as = new AuthServiceImpl();
	UserDao ud = new UserHibernate();
	UserService us = new UserServiceImpl();
	ReimbursementService rsi = new ReimbursementServiceImpl();
	ReimbursementStatusDao rsd = new ReimbursementStatusHibernate();
	@Override
	public void process(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
		String method = rq.getMethod();

		switch (method) {
		case "GET":
			handleGet(rq, rs);
			break;
		case "POST":
			handlePost(rq, rs);
			break;
		case "PUT":
			handlePut(rq, rs);
			break;
		case "DELETE":
			handleDelete(rq, rs);
			break;
		default:
			rs.sendError(405);
		}
		
	}

	@Override
	public void handleGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
		String token = rq.getHeader("Authorize");
		String username = null;
		try {
			username = as.authorize(token);
			System.out.println(username);
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		User user = null;
		try {
 
			user = us.getUserByUsername(username);
System.out.println(user);
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (user != null) {
			String pathNext = (String) rq.getAttribute("pathNext");
			if (pathNext != null) {

				if (pathNext.indexOf("/") == -1 && pathNext.equals("PR")) {

					List<Reimbursement> reimbs = null;

					if (user.getRoleId().getUserRole().equals("manager")) {
						reimbs = rsi.getAllReimbursement();
					} else {
						try {
							
							System.out.println(username);
							reimbs = rsi.getReimbursementByUserAndStatus(us.getUserByUsername(username), rsd.getReimbursementStatusById(1));
							System.out.println(reimbs);
						} catch (UserNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

					rs.setStatus(200);
					try (PrintWriter pw = rs.getWriter()) {
						pw.write(new ObjectMapper().writeValueAsString(reimbs));
					}

				}else if(pathNext.indexOf("/") == -1 && pathNext.equals("RR")){
					List<Reimbursement> reimbs = null;

					if (user.getRoleId().getUserRole().equals("manager")) {
						reimbs = rsi.getAllReimbursement();
					} else {
						try {
							
							System.out.println(username);
							reimbs = rsi.getReimbursementByUserAndStatus(us.getUserByUsername(username), rsd.getReimbursementStatusById(2));
							System.out.println(reimbs);
						} catch (UserNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

					rs.setStatus(200);
					try (PrintWriter pw = rs.getWriter()) {
						pw.write(new ObjectMapper().writeValueAsString(reimbs));
					}
					
				} 
				else {
					String[] path = pathNext.split("/");
					if (!path[0].equals("view")) {
						rs.sendError(400, "Path Error");
					} else {
						int reimbId = Integer.valueOf(path[1]);
						Reimbursement reimb = rsi.getReimbursementById(reimbId);
						rs.setStatus(200);
						try (PrintWriter pw = rs.getWriter()) {
							pw.write(new ObjectMapper().writeValueAsString(reimb));
						}
					}
				}
			} else {
				rs.sendError(400, "Path not found");
			}
		} else {
			rs.sendError(400, "Bad token");
		}
		
	}

	@Override
	public void handlePut(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
		String token = rq.getHeader("Authorize");
		String username = null;
		try {
			username = as.authorize(token);
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		User user = null;
		try {
			user = us.getUserByUsername(username);
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (user != null) {
			String pathNext = (String) rq.getAttribute("pathNext");
			if (pathNext != null) {
				if (pathNext.equals("update")) {
					
					InputStream request = rq.getInputStream();
					Reimbursement reimb = new ObjectMapper().readValue(request, Reimbursement.class);
					
					reimb.setResolver(user);
					reimb.setReimbRes(Timestamp.valueOf(LocalDateTime.now()));
					
					if (rsi.updateReimbursement(reimb)) {
						rs.setStatus(200);
					}else {
						rs.sendError(400, "Could not update reimbursement");
						System.out.println("could not update");
					}
					
				}else {
					rs.sendError(400, "Path invalid");
					
				}
			}else {
				rs.sendError(400, "Path not found");
				
			}
		}else {
			rs.sendError(400, "Token Invalid");
			
		}
		
	}

	@Override
	public void handlePost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
		String token = rq.getHeader("Authorize");
		String username = null;
		try {
			username = as.authorize(token);
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		User user = null;
		try {
			user = us.getUserByUsername(username);
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (user != null) {
			String pathNext = (String) rq.getAttribute("pathNext");
			if (pathNext != null) {
				if (pathNext.equals("request")) {
					
					InputStream request = rq.getInputStream();
					Reimbursement reimb = new ObjectMapper().readValue(request, Reimbursement.class);
					
					ReimbursementStatus status = rsd.getReimbursementStatusById(1);
					
					
					reimb.setAuthor(user);
					reimb.setReimbSub(Timestamp.valueOf(LocalDateTime.now()));
					reimb.setStatId(status);
					
					if (rsi.reimbursementAdded(reimb)) {
						rs.setStatus(201);
					}else {
						rs.sendError(400, "Could not add reimbursement");
					}
					
				}else {
					rs.sendError(400, "Path invalid");
				}
			}else {
				rs.sendError(400, "Path not found");
			}
		}else {
			rs.sendError(400, "Token Invalid");
		}
		
	}

	@Override
	public void handleDelete(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
