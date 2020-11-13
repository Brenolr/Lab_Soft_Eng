package net.javaguides.covidnet.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.javaguides.covidnet.dao.LocalDAO2;
import net.javaguides.covidnet.model.Local;


public class LocalController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LocalDAO2 localDAO;
	
	public LocalController() {
		localDAO = new LocalDAO2();
	}

	public void listLocal(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Local> listLocal = localDAO.selectAllLocals();
		request.setAttribute("listLocal", listLocal);
		RequestDispatcher dispatcher = request.getRequestDispatcher("local-list.jsp");
		dispatcher.forward(request, response);
	}

	public void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("local-form.jsp");
		dispatcher.forward(request, response);
	}

	public void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Local existinglocal = localDAO.selectLocal(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("local-form.jsp");
		request.setAttribute("local", existinglocal);
		dispatcher.forward(request, response);

	}

	public Local getLocalFromRequest(HttpServletRequest request) {
		
		String name = request.getParameter("nome");
		String address = request.getParameter("endereco");
		int avaibleBeds = Integer.parseInt(request.getParameter("camas_disponiveis"));
		int occupiedBeds = Integer.parseInt(request.getParameter("camas_ocupadas"));
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			return new Local(id,name, address,  avaibleBeds, occupiedBeds);
		} catch(Exception e) {}
		
		return new Local(name, address,  avaibleBeds, occupiedBeds);
	}
	
	public void insertLocal(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		
		localDAO.insertLocal(getLocalFromRequest(request));
		response.sendRedirect("list-local");
	}

	public void updateLocal(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {

		localDAO.updateLocal(getLocalFromRequest(request));
		response.sendRedirect("list-local");
	}

	public void deleteLocal(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String id = request.getParameter("id");
		int deleted = localDAO.deleteLocal(id);
		if(deleted > 0) {
			response.sendRedirect("list-patient?message=Local removido com sucesso!");
		} else if(deleted == -1) {
			response.sendRedirect("list-patient?message=Nao eh possivel remover este local no momento, pois ha pacientes aqui.");
		}

	}

}