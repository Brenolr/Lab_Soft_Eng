package net.javaguides.covidnet.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.javaguides.covidnet.web.PatientController;
import net.javaguides.covidnet.web.TransferController;
import net.javaguides.covidnet.web.LocalController;
import net.javaguides.covidnet.web.LoginController;

@WebServlet("/")
public class CovidNetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private PatientController patientController;
	private TransferController requestController;
	private LocalController localController;
	private LoginController loginController;
	
	public void init() {
		patientController = new PatientController();
		requestController = new TransferController();
		localController = new LocalController();
		loginController = new LoginController();
	}

	protected void homePage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			// Patient Module
			case "/new-patient":
				patientController.showNewPatientForm(request, response);
				break;
			case "/insert-patient":
				patientController.insertPatient(request, response);
				break;
			case "/delete-patient":
				patientController.deletePatient(request, response);
				break;
			case "/edit-patient":
				patientController.showPatientEditForm(request, response);
				break;
			case "/update-patient":
				patientController.updatePatient(request, response);
				break;
			case "/list-patient":
				patientController.listPatient(request, response);
				break;
				
			// Request Module
			case "/new-transfer":
				requestController.showNewForm(request, response);
				break;
			case "/insert-transfer":
				requestController.insertTransfer(request, response);
				break;
			case "/delete-transfer":
				requestController.deleteTransfer(request, response);
				break;
			case "/edit-transfer":
				requestController.showEditForm(request, response);
				break;
			case "/update-transfer":
				requestController.updateTransfer(request, response);
				break;
			/*case "/destination-transfer":
				requestController.setDestination(request, response);
				break;
			case "/close-transfer":
				requestController.closeTransfer(request, response);
				break;*/
			case "/list-transfer":
				requestController.listTransfer(request, response);
				break;
				
			// Local Module
			case "/new-local":
				localController.showNewForm(request, response);
				break;
			case "/insert-local":
				localController.insertLocal(request, response);
				break;
			case "/delete-local":
				localController.deleteLocal(request, response);
				break;
			case "/edit-local":
				localController.showEditForm(request, response);
				break;
			case "/update-local":
				localController.updateLocal(request, response);
				break;
			case "/list-local":
				localController.listLocal(request, response);
				break;
				
			// General
			case "/login":
				loginController.loginPage(request, response);
				break;
			case "/validate-login":
				loginController.validate(request, response);
				break;
			default:
				homePage(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

}
