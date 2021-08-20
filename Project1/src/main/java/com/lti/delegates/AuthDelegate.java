package com.lti.delegates;

import java.io.IOException;
import java.io.InputStream;

import javax.persistence.NoResultException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lti.daos.UserDao;
import com.lti.daos.UserHibernate;
import com.lti.exceptions.LoginException;
import com.lti.exceptions.UserNotFoundException;
import com.lti.models.User;
import com.lti.services.AuthService;
import com.lti.services.AuthServiceImpl;

public class AuthDelegate implements Delegatable{
	AuthService as = new AuthServiceImpl();
	UserDao ud = new UserHibernate();
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
		
		
	}

	@Override
	public void handlePut(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handlePost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {


		String pathNext = (String) rq.getAttribute("pathNext");
		if (pathNext != null) {
			if (pathNext.equals("login")) {
				
				InputStream request = rq.getInputStream();
				User userTemp = new ObjectMapper().readValue(request, User.class);

				String token = null;
				String t2 = null;
				
				try {
					token = as.login(userTemp.getUsername(), userTemp.getPassword());
					String[] tokens = token.split(":", 2);

					
					t2 = tokens[1];

					if(t2.equals("Manager")) {
						log.info("Manager Logged In");
						log.info("Succesful login with token: " + token);
						rs.setStatus(200);
					}else {
						log.info("Succesful login with token: " + token);
						rs.setStatus(209);
					}
					
				} catch (NoResultException e) {
					token = "username";
					log.warn("wrong username");
					rs.setStatus(400);
				} catch (UserNotFoundException e) {
					token = "username";
					log.warn("wrong username");
					rs.setStatus(400);
				} catch (LoginException e) {
					token = "password";
					log.warn("wrong password");
					rs.setStatus(400);
				}
				
				rs.addHeader("Authorize", token);
				
			}
				else {
				rs.sendError(400, "Path invalid");
				log.warn("Path invalid");
				
			}
		}else {
			rs.sendError(400, "Path not found");
			log.warn("Path not found");
		}
	}

	@Override
	public void handleDelete(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
}
