package net.javaguides.covidnet.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginController {
	public void validate(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		String emailOrCPF = request.getParameter("emailOrCPF");
		String password = request.getParameter("password");
		System.out.println(emailOrCPF+' '+password);
	}
	protected void loginPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
		dispatcher.forward(request, response);
	}
}
