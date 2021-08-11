package com.lti.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lti.controllers.FrontController;
import com.lti.exceptions.UserNotFoundException;
import com.lti.models.User;
import com.lti.services.AuthService;
import com.lti.services.AuthServiceImpl;


public class AuthServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	AuthService as = new AuthServiceImpl();

	protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
		FrontController.addCorsHeader(rq.getRequestURI(), rs);
		
		String username = rq.getParameter("username");
		String password = rq.getParameter("password");

		try {
			User user = as.login(username, password);
			if (user != null) {
//				HttpSession session = rq.getSession();
//				session.setAttribute("user", username);

				String token = user.getUserId() + ":" + user.getRoleId();
				rs.setHeader("Authorization", token);
				rs.setStatus(200);
			} else {

			}
		} catch (UserNotFoundException e) {
			rs.sendError(404);
		}
	}
	
}
