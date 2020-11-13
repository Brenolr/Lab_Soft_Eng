package net.javaguides.covidnet.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.javaguides.covidnet.dao.LoginDAO;

public class LoginController {
	
	private LoginDAO loginDAO;
	
	public LoginController () {
		loginDAO = new LoginDAO();
	}
	
	public void validate(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		String emailOrCPF = request.getParameter("emailOrCpf");
		String password = request.getParameter("password");
		// System.out.println(emailOrCPF+' '+password);
		int validLogins = loginDAO.getValidLogins(emailOrCPF, password);
		if(validLogins == 1) {

			response.sendRedirect("home?CovidnetUser="+emailOrCPF);

		} else {
			response.sendRedirect("login?erro=Algo deu errado.");
		}
	}
	protected void loginPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
		dispatcher.forward(request, response);
	}
}
