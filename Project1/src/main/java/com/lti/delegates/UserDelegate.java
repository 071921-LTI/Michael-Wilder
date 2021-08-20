package com.lti.delegates;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lti.daos.UserDao;
import com.lti.daos.UserHibernate;
import com.lti.exceptions.UserNotFoundException;
import com.lti.models.User;
import com.lti.services.AuthService;
import com.lti.services.AuthServiceImpl;
import com.lti.services.UserService;
import com.lti.services.UserServiceImpl;

public class UserDelegate implements Delegatable{
	AuthService as = new AuthServiceImpl();
	UserDao ud = new UserHibernate();
	UserService us = new UserServiceImpl();
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
		System.out.println("In handleGet");
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
				if (pathNext.indexOf("/") == -1 && pathNext.equals("info")) {
					
					rs.setStatus(200);
					try (PrintWriter pw = rs.getWriter()) {
						pw.write(new ObjectMapper().writeValueAsString(user));
					}

				} else if (pathNext.indexOf("/") == -1 && pathNext.equals("emp")) {
					rs.setStatus(200);
					List<User> u = null;
					u = us.getUsers();
					try (PrintWriter pw = rs.getWriter()) {
						pw.write(new ObjectMapper().writeValueAsString(u));
					}
				}else {
					
					rs.sendError(400, "Path not found");
					log.warn("Path Not Found");
				}
			} else {
				rs.sendError(400, "Path not found");
				log.warn("Path Not Found");
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
		User user = null;
		try {
			username = as.authorize(token);
		} catch (UserNotFoundException e1) {
			log.warn("User Not Found");
			e1.printStackTrace();
		}
		try {
			user = us.getUserByUsername(username);
		} catch (UserNotFoundException e) {
			log.warn("User Not Found");
			e.printStackTrace();
		}
		if (user != null) {
			String pathNext = (String) rq.getAttribute("pathNext");
			if (pathNext != null) {
				if (pathNext.indexOf("/") == -1 && pathNext.equals("info")) {

					InputStream request = rq.getInputStream();
					User userTemp = new ObjectMapper().readValue(request, User.class);
					
					userTemp.setUserId(user.getUserId());
					userTemp.setRoleId(user.getRoleId());
					if (us.update(userTemp)) {
						rs.setStatus(200);
						token = AuthServiceImpl.createToken(userTemp);
						rs.addHeader("Authorize", token);
					}else {
						rs.sendError(400, "Update failed");
						log.warn("Update Failed");
					}

				} else {
					
					rs.sendError(400, "Path not found");
					log.warn("Path Not Found");
				}
			} else {
				rs.sendError(400, "Path not found");
				log.warn("Path Not Found");
			}
		} else {
			rs.sendError(400, "Token Invalid");
			log.warn("Token Invalid");
		}
	}

	@Override
	public void handlePost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
		

	}

	@Override
	public void handleDelete(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
		System.out.println("In handleDelete");

	}
}
