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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
	private static Logger log = LogManager.getRootLogger();
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

		} catch (UserNotFoundException e) {
			e.printStackTrace();
		}
		User user = null;
		try {
			user = us.getUserByUsername(username);

		} catch (UserNotFoundException e) {

			e.printStackTrace();
		}
		if (user != null) {
			String pathNext = (String) rq.getAttribute("pathNext");
			if (pathNext != null) {

				if (pathNext.indexOf("/") == -1 && pathNext.equals("PR")) {

					List<Reimbursement> reimbs = null;

					if (user.getRoleId().getUserRole().equals("Manager")) {
						reimbs = rsi.getReimbursementByStatus(rsd.getReimbursementStatusById(1));

					} else {
						try {
							reimbs = rsi.getReimbursementByUserAndStatus(us.getUserByUsername(username), rsd.getReimbursementStatusById(1));
						} catch (UserNotFoundException e) {
							log.warn("User Not Found");
							e.printStackTrace();
						}
					}

					rs.setStatus(200);
					try (PrintWriter pw = rs.getWriter()) {
						pw.write(new ObjectMapper().writeValueAsString(reimbs));
					}

				}
				else if(pathNext.indexOf("/") == -1 && pathNext.equals("RR")){
					List<Reimbursement> reimbs = null;

					if (user.getRoleId().getUserRole().equals("Manager")) {
						reimbs = rsi.getReimbursementByStatus2(rsd.getReimbursementStatusById(2), rsd.getReimbursementStatusById(3));
					} else {
						try {
							

							reimbs = rsi.getReimbursementByUserAndStatus2(us.getUserByUsername(username), rsd.getReimbursementStatusById(2), rsd.getReimbursementStatusById(3));
						} catch (UserNotFoundException e) {
							log.warn("User Not Found");
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
					if (!path[0].equals("SR")) {
						rs.sendError(400, "Path Error");
					} else {
						List<Reimbursement> reimbs = null;
						String userN = String.valueOf(path[1]);
						try {
							reimbs = rsi.getReimbursementByUser(us.getUserByUsername(userN));
						} catch (UserNotFoundException e) {
							log.warn("User Not Found");
							e.printStackTrace();
						}
						rs.setStatus(200);
						try (PrintWriter pw = rs.getWriter()) {
							pw.write(new ObjectMapper().writeValueAsString(reimbs));
						}
					}
				}
			} else {
				rs.sendError(400, "Path not found");
				log.warn("Path not found");
			}
		} else {
			rs.sendError(400, "Token Invalid");
			log.warn("Token Invalid");
		}
		
	}

	@Override
	public void handlePut(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
		String token = rq.getHeader("Authorize");
		String username = null;
		try {
			username = as.authorize(token);
		} catch (UserNotFoundException e) {
			log.warn("User Not Found");
			e.printStackTrace();
		}
		User user = null;
		try {
			user = us.getUserByUsername(username);
		} catch (UserNotFoundException e) {
			log.warn("User Not Found");
			e.printStackTrace();
		}
		
		if (user != null) {
			String pathNext = (String) rq.getAttribute("pathNext");
			if (pathNext != null) {
				if (pathNext.equals("updateApprove")) {
					System.out.println("Am I here");
					InputStream request = rq.getInputStream();
					Reimbursement reimb = new ObjectMapper().readValue(request, Reimbursement.class);
					int id = reimb.getReimbId();
					System.out.println(id);
					ReimbursementStatus status = rsd.getReimbursementStatusById(2);
					Reimbursement reimbursement = rsi.getReimbursementById(id);
					reimbursement.setResolver(user);
					reimbursement.setReimbRes(Timestamp.valueOf(LocalDateTime.now()));
					reimbursement.setStatId(status);
					
					if (rsi.updateReimbursement(reimbursement)) {
						rs.setStatus(200);
					}else {
						rs.sendError(400, "Could not update reimbursement");
						System.out.println("could not update");
					}
					
				}else if (pathNext.equals("updateDeny")) {
					System.out.println("Am I here");
					InputStream request = rq.getInputStream();
					Reimbursement reimb = new ObjectMapper().readValue(request, Reimbursement.class);
					int id = reimb.getReimbId();
					System.out.println(id);
					ReimbursementStatus status = rsd.getReimbursementStatusById(3);
					Reimbursement reimbursement = rsi.getReimbursementById(id);
					reimbursement.setResolver(user);
					reimbursement.setReimbRes(Timestamp.valueOf(LocalDateTime.now()));
					reimbursement.setStatId(status);
					
					if (rsi.updateReimbursement(reimbursement)) {
						rs.setStatus(200);
					}else {
						rs.sendError(400, "Update Not Successful");
						log.warn("Update Failed");
					}
					
				}
				else {
					rs.sendError(400, "Path invalid");
					log.warn("Path Invalid");
				}
			}else {
				rs.sendError(400, "Path not found");
				log.warn("Path not found");
			}
		}else {
			rs.sendError(400, "Token Invalid");
			log.warn("Token Invalid");
		}
		
	}

	@Override
	public void handlePost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
		String token = rq.getHeader("Authorize");
		String username = null;
		try {
			username = as.authorize(token);

		} catch (UserNotFoundException e) {
			log.warn("User Not Found");
			e.printStackTrace();
		}
		User user = null;
		try {
 
			user = us.getUserByUsername(username);

		} catch (UserNotFoundException e) {
			log.warn("User Not Found");
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
						rs.sendError(400, "Add Not Successful");
						log.warn("Add Fail");
					}
					
				}
				else {
					rs.sendError(400, "Path invalid");
					log.warn("Path Invalid");
				}
			}else {
				rs.sendError(400, "Path not found");
				log.warn("Path not found");
			}
		}else {
			rs.sendError(400, "Token Invalid");
			log.warn("Token Invalid");
		}
		
	}

	@Override
	public void handleDelete(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
