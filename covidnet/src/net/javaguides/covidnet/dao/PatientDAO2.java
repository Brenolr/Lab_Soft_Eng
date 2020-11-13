package net.javaguides.covidnet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import net.javaguides.covidnet.model.Patient;
import net.javaguides.covidnet.dao.BaseDAO;


public class PatientDAO2 extends BaseDAO{
	

	private static final String INSERT_PATIENTS_SQL = "INSERT INTO Pacientes" + "  (nome, email, cpf, sintomas, id_prontuario, id_localDeAtendimento, gravidade, telefone) VALUES "
			+ " (?, ?, ?, ?, ?, ?, ?, ?);";

	private static final String SELECT_PATIENT_BY_ID = "select id, nome, email,  cpf, sintomas, id_prontuario, id_localDeAtendimento, gravidade, telefone from Pacientes where id =?";
	private static final String SELECT_ALL_PATIENTS = "select * from Pacientes";
	private static final String DELETE_PATIENTS_SQL = "delete from Pacientes where id = ?;";
	private static final String UPDATE_PATIENTS_SQL = "update Pacientes set nome = ?,email = ?, cpf = ?, sintomas = ?, id_prontuario = ?, id_localDeAtendimento = ?, gravidade = ?, telefone = ? where id = ?;";

	public PatientDAO2() {
	}

	private void performPatientQuery (Patient patient, String query, boolean id) {
		
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(query);) {
			
			statement.setString(1, patient.getNome());
			statement.setString(2, patient.getEmail());
			statement.setString(3, patient.getCpf());
			statement.setString(4, patient.getSintomas());
			if(patient.getId_prontuario() != 0) {
				statement.setInt(5, patient.getId_prontuario());
			} else {
				statement.setNull(5,Types.NULL);
			}
			if(patient.getId_localDeAtendimento() != 0) {
				statement.setInt(6, patient.getId_localDeAtendimento());
			}else {
				statement.setNull(6,Types.NULL);
			}
			statement.setString(7, patient.getGravidade());
			statement.setString(8, patient.getTelefone());
			if (id) {
				statement.setInt(9, patient.getId());
			}
			System.out.println(statement);
			statement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	} 
	public void insertPatient(Patient patient) throws SQLException {
		System.out.println(INSERT_PATIENTS_SQL);
		performPatientQuery(patient, INSERT_PATIENTS_SQL, false);
	}

	public Patient selectPatient(int id) {
		Patient patient = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PATIENT_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String name = rs.getString("nome");
				String email = rs.getString("email");
				String cpf = rs.getString("cpf");
				String sintomas = rs.getString("sintomas");
				int id_prontuario = rs.getInt("id_prontuario");
				int id_localDeAtendimento = rs.getInt("id_localDeAtendimento");
				String gravidade = rs.getString("gravidade");
				String telefone = rs.getString("telefone");
				patient = new Patient(id, name, email, cpf, sintomas, id_prontuario, id_localDeAtendimento, gravidade, telefone);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return patient;
	}

	public List<Patient> selectAllPatients() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Patient> patients = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PATIENTS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				String email = rs.getString("email");
				String cpf = rs.getString("cpf");
				String sintomas = rs.getString("sintomas");
				int id_prontuario = rs.getInt("id_prontuario");
				int id_localDeAtendimento = rs.getInt("id_localDeAtendimento");
				String gravidade = rs.getString("gravidade");
				String telefone = rs.getString("telefone");
				patients.add(new Patient(id, nome, email, cpf, sintomas, id_prontuario, id_localDeAtendimento, gravidade, telefone));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return patients;
	}

	public boolean deletePatient(String id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_PATIENTS_SQL);) {
			statement.setString(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public void updatePatient(Patient patient) throws SQLException {
		System.out.println(UPDATE_PATIENTS_SQL);
		performPatientQuery(patient, UPDATE_PATIENTS_SQL, true);
	}
}
