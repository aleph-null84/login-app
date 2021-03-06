package com.yuriy.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yuriy.dto.User;
import com.yuriy.service.LoginService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(description = "Login Servlet", urlPatterns = { "/Login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = "";
		String password = "";
		
		userId = request.getParameter("userId");
		password = request.getParameter("password");
		
		LoginService loginService = new LoginService();
		boolean result = loginService.authenticate(userId, password);
		
		if (result) {
			User user = loginService.getUserDetails(userId);
			//request.getSession().setAttribute("user", user);
			request.setAttribute("user", user);
			//response.sendRedirect("success.jsp");
			//RequestDispatcher dispatcher = request.getRequestDispatcher("success.jsp");
			RequestDispatcher dispatcher = request.getRequestDispatcher("success-jstl.jsp");
			dispatcher.forward(request, response);
			return;
		}
		else {
			response.sendRedirect("login.jsp");
			return;
		}
	}

}
