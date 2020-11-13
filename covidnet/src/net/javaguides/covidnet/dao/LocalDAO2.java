package net.javaguides.covidnet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.javaguides.covidnet.model.Local;
import net.javaguides.covidnet.dao.BaseDAO;


public class LocalDAO2 extends BaseDAO{
	

	private static final String INSERT_LOCALS_SQL = "INSERT INTO Locais_de_Atendimento" + "  (nome, endereco, camas_disponiveis, camas_ocupadas, latitude, longitude) VALUES "
			+ " (?, ?, ?, ?, ?, ?);";

	private static final String SELECT_LOCAL_BY_ID = "select id, nome, endereco, camas_disponiveis, camas_ocupadas from Locais_de_Atendimento where id =?";
	private static final String SELECT_ALL_LOCALS = "select * from Locais_de_Atendimento";
	private static final String DELETE_LOCALS_SQL = "delete from Locais_de_Atendimento where id = ?;";
	private static final String UPDATE_LOCALS_SQL = "update Locais_de_Atendimento set nome = ?, endereco = ?, camas_disponiveis = ?, camas_ocupadas = ?, latitude = ?, longitude = ?  where id = ?;";

	public LocalDAO2() {
	}

	private void performLocalQuery (Local local, String query, boolean id) {
		
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setString(1, local.getNome());
			preparedStatement.setString(2, local.getEndereco());
			preparedStatement.setString(3, Integer.toString(local.getCamas_disponiveis()));
			preparedStatement.setString(4, Integer.toString(local.getCamas_ocupadas()));
			preparedStatement.setString(5, Integer.toString(local.getLatitude()));
			preparedStatement.setString(6, Integer.toString(local.getLongitude()));
			if(id) {
				preparedStatement.setInt(7, local.getId());
			}
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}
	public void insertLocal(Local local) throws SQLException {
		System.out.println(INSERT_LOCALS_SQL);	
		performLocalQuery(local, INSERT_LOCALS_SQL, false);
	}

	private Local getLocalFromResultSet (int id, ResultSet rs) throws SQLException{
		if(id == 0) {
			id =rs.getInt("id");
		}
		String nome = rs.getString("nome");
		String address = rs.getString("endereco");
		String av_beds = rs.getString("camas_disponiveis");
		String oc_beds = rs.getString("camas_ocupadas");
		return new Local(id, nome, address, Integer.parseInt(av_beds), Integer.parseInt(oc_beds));
	}
	
	public Local selectLocal(int id) {
		Local local = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_LOCAL_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				local = getLocalFromResultSet(id,rs);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return local;
	}

	public List<Local> selectAllLocals() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Local> locals = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_LOCALS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				locals.add(getLocalFromResultSet(0,rs));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return locals;
	}

	public int deleteLocal(String id) throws SQLException {
		int rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_LOCALS_SQL);) {
			statement.setString(1, id);
			try {
				rowDeleted = statement.executeUpdate();
			} catch(SQLException e) {}
				rowDeleted = -1;
		}
		return rowDeleted;
	}

	public void updateLocal(Local local) throws SQLException {
		System.out.println(UPDATE_LOCALS_SQL);
		performLocalQuery(local, UPDATE_LOCALS_SQL, true);
	}
}