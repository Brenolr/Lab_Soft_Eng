package net.javaguides.covidnet.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.javaguides.covidnet.dao.PatientDAO2;
import net.javaguides.covidnet.model.Patient;
import net.javaguides.covidnet.dao.LocalDAO2;
import net.javaguides.covidnet.model.Local;

public class PatientController {
	private PatientDAO2 patientDAO;
	private LocalDAO2 localDAO;
	
	public PatientController() {
		patientDAO = new PatientDAO2();
		localDAO = new LocalDAO2();
	}
	
	public void listPatient(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Patient> listPatient = patientDAO.selectAllPatients();
		request.setAttribute("listPatient", listPatient);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/patient-list.jsp");
		dispatcher.forward(request, response);
	}
	
	private HttpServletRequest setOtherParameters (HttpServletRequest request) {
		List<Local> listaLocais = localDAO.selectAllLocals();
		request.setAttribute("listaLocais", listaLocais);
		return request;
	}
	public void showNewPatientForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request = setOtherParameters(request);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/patient-form.jsp");
		dispatcher.forward(request, response);
	}

	public void showPatientEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Patient existingPatient = patientDAO.selectPatient(id);
		request = setOtherParameters(request);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/patient-form.jsp");
		request.setAttribute("patient", existingPatient);
		dispatcher.forward(request, response);

	}
	
	public void showProntuarioEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Patient existingPatient = patientDAO.selectPatient(id);
		request = setOtherParameters(request);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/patient-form.jsp");
		request.setAttribute("patient", existingPatient);
		dispatcher.forward(request, response);
	}
	
	private Patient getPatientFromRequest(HttpServletRequest request) {
		// For when optional parameters are added.
		/*Map<String, Boolean> parameters = new HashMap<String, Boolean>(); 
		parameters.put("nome", true);
		parameters.put("email", false);
		parameters.put("cpf", true);
		parameters.put("sintomas", false);
		parameters.put("gravidade", false);
		parameters.put("id_prontuario", false);
		parameters.put("id_localDeAtendimento", false);
		parameters.put("telefone", false);
		
		for (Map.Entry<String, Boolean> entry : parameters.entrySet()) {
			System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
		}*/
		String name = request.getParameter("nome");
		String email = request.getParameter("email");
		String cpf = request.getParameter("cpf");
		String sintomas = request.getParameter("sintomas");
		String gravidade = request.getParameter("gravidade");
		int id_localDeAtendimento = 0;
		int id_prontuario = 0;
		try {
			id_prontuario = Integer.parseInt(request.getParameter("id_prontuario"));
		} catch (Exception e) {}
		try {
			id_localDeAtendimento = Integer.parseInt(request.getParameter("id_localDeAtendimento"));
		} catch (Exception e) {}
		String telefone = request.getParameter("telefone");
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			return new Patient(id, name, email, cpf, sintomas, id_prontuario, id_localDeAtendimento, gravidade, telefone);
		} catch(Exception e) {
			return new Patient(name, email, cpf, sintomas, id_prontuario, id_localDeAtendimento, gravidade, telefone);
		}
	}
	
	public void insertPatient(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		
		patientDAO.insertPatient(getPatientFromRequest(request));
		response.sendRedirect("list-patient?message=Paciente%20inserido%20com%20sucesso!");
	}

	public void updatePatient(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		
		patientDAO.updatePatient(getPatientFromRequest(request));
		response.sendRedirect("list-patient?message=Paciente%20atualizado%20com%20sucesso!");
	}

	public void deletePatient(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String id = request.getParameter("id");
		int deleted = patientDAO.deletePatient(id);
		if(deleted > 0) {
			response.sendRedirect("list-patient?message=Paciente removido com sucesso!");
		} else if(deleted == -1) {
			response.sendRedirect("list-patient?message=Nao eh possivel remover este paciente. Por favor, remova sua solicitacao de transferencia primeiro.");
		}
	}
	
}