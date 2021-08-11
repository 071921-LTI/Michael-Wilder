package com.lti.delegates;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Delegatable {
void process(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException;
	
	/*
	 * Delegates should provide behavior for each http method as required
	 */
	void handleGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException;
	void handlePut(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException;
	void handlePost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException;
	void handleDelete(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException;
}
