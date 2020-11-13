package net.javaguides.covidnet.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.javaguides.covidnet.dao.TransferDAO2;
import net.javaguides.covidnet.dao.PatientDAO2;
import net.javaguides.covidnet.dao.LocalDAO2;
import net.javaguides.covidnet.model.Transfer;
import net.javaguides.covidnet.model.Patient;
import net.javaguides.covidnet.model.Local;

public class TransferController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TransferDAO2 requestDAO;
	private PatientDAO2 patientDAO;
	private LocalDAO2 localDAO;
	
	public TransferController() {
		requestDAO = new TransferDAO2();
		patientDAO = new PatientDAO2();
		localDAO = new LocalDAO2();
	}

	public void listTransfer(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Transfer> listTransfer = requestDAO.selectAllTransfers();
		request.setAttribute("listTransfer", listTransfer);
		RequestDispatcher dispatcher = request.getRequestDispatcher("transfer-list.jsp");
		dispatcher.forward(request, response);
	}

	private HttpServletRequest setOtherParameters (HttpServletRequest request) {
		List<Patient> listaPacientes = patientDAO.selectAllPatients();
		request.setAttribute("listaPacientes", listaPacientes);
		List<Local> listaLocais = localDAO.selectAllLocals();
		request.setAttribute("listaLocais", listaLocais);
		return request;
	}
	
	public void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request = setOtherParameters(request);
		RequestDispatcher dispatcher = request.getRequestDispatcher("transfer-form.jsp");
		dispatcher.forward(request, response);
	}

	public void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Transfer existingTransfer = requestDAO.selectTransfer(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("transfer-form.jsp");
		request = setOtherParameters(request);
		request.setAttribute("transfer", existingTransfer);
		dispatcher.forward(request, response);

	}
	
	public void insertTransfer(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		
		int id_local_origem = 0;
		try {
			id_local_origem = Integer.parseInt(request.getParameter("id_local_origem"));
		} catch(Exception e) {}
		int id_patient = 0; 
		try {
			id_patient = Integer.parseInt(request.getParameter("id_paciente"));
		} catch(Exception e) {}
		Transfer newTransfer = new Transfer(id_local_origem, id_patient);
		requestDAO.insertTransfer(newTransfer);
		response.sendRedirect("list-transfer");
	}

	public void updateTransfer(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		int id_local_origem = 0;
		try {
			id_local_origem = Integer.parseInt(request.getParameter("id_local_origem"));
		} catch(Exception e) {}
		int id_local_destino = 0;
		try {
			id_local_destino = Integer.parseInt(request.getParameter("id_local_destino"));
		} catch(Exception e) {}
		boolean aberto = false;
		if(request.getParameter("aberto").equals("Aberto")) {
			aberto = true;
		}
		System.out.println("ficou"+aberto);
		Transfer transfer = new Transfer(id, id_local_origem, id_local_destino, aberto);
		requestDAO.updateTransfer(transfer); 
		response.sendRedirect("list-transfer");
	}

/*	public void setDestination(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String destination = request.getParameter("destination");
		
		requestDAO.updateDestination(id, destination);
		response.sendRedirect("list-transfer");
	}*/
	
/*	public void closeTransfer(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String id = request.getParameter("id");
		
		requestDAO.closeTransfer(id);
		response.sendRedirect("list-transfer");
	}*/
	
	public void deleteTransfer(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		requestDAO.deleteTransfer(id);
		response.sendRedirect("list-transfer");

	}
/*	public boolean updateDestination(String id, String destination) {
		boolean rowUpdated = false;
		
		for(Transfer f_request : this.requests) { 
			if(f_request.getId() == id) { 
				
				f_request.setDestination(destination);
				
				rowUpdated = true;
				break;
			}
		}
		
		return rowUpdated;
	}
	
	public boolean closeRequest(int id) {
		boolean rowUpdated = false;
		
		for(Transfer f_request : this.requests) { 
			if(f_request.getId() == id) { 
				
				f_request.closeRequest();
				
				rowUpdated = true;
				break;
			}
		}
		
		return rowUpdated;
	}*/
}
