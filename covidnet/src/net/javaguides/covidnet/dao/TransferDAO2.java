package net.javaguides.covidnet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import net.javaguides.covidnet.model.Transfer;
import net.javaguides.covidnet.dao.BaseDAO;


public class TransferDAO2 extends BaseDAO{
	

	private static final String INSERT_TRANSFERS_SQL = "INSERT INTO Solicitacoes" + "  (id_local_origem, id_local_destino, id_paciente, data_e_hora, aberto) VALUES "
			+ " (?, ?, ?, ?, ?);";

	private static final String SELECT_TRANSFER_BY_ID = "select id_local_origem, id_local_destino, id_paciente, data_e_hora, aberto from Solicitacoes where id =?";
	private static final String SELECT_ALL_TRANSFERS = "select * from Solicitacoes";
	private static final String DELETE_TRANSFERS_SQL = "delete from Solicitacoes where id = ?;";
	private static final String UPDATE_TRANSFERS_SQL = "update Solicitacoes set id_local_destino = ?, aberto = ? where id = ?;";

	public TransferDAO2() {}

	private void performUpdateTransferQuery(Transfer transfer) {
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_TRANSFERS_SQL)) {
			if(transfer.getId_local_destino() != 0) {
				preparedStatement.setInt(1, transfer.getId_local_destino());
			} else {
				preparedStatement.setNull(1,Types.NULL);
			}
			preparedStatement.setBoolean(2, transfer.isAberto());
			preparedStatement.setInt(3, transfer.getId());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	private void performInsertTransferQuery(Transfer transfer) {
		
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TRANSFERS_SQL)) {
			// In case this data didn't come from front-end
			if(transfer.getId_local_origem() != 0) {
				preparedStatement.setInt(1, transfer.getId_local_origem());
			} else {
				preparedStatement.setNull(1,Types.NULL);
			}
			// destination always unkown at the time of insertion
			preparedStatement.setNull(2,Types.NULL);
			if(transfer.getId_paciente() != 0) {
				preparedStatement.setInt(3, transfer.getId_paciente());
			} else {
				preparedStatement.setNull(3,Types.NULL);
			}
			preparedStatement.setTimestamp(4, Timestamp.valueOf(transfer.getData_e_hora()));
			preparedStatement.setBoolean(5, transfer.isAberto());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}
	
	public void insertTransfer(Transfer transfer) throws SQLException {
		System.out.println(INSERT_TRANSFERS_SQL);
		// try-with-resource statement will auto close the connection.
		performInsertTransferQuery(transfer);
	}

	private Transfer getTransferFromResultSet (int id, ResultSet rs) throws SQLException{
		if(id == 0) {
			id = rs.getInt("id");
		}
		int id_local_origem = rs.getInt("id_local_origem");
		int id_local_destino = rs.getInt("id_local_destino");
		int id_paciente = rs.getInt("id_paciente");
		String dataEHora = rs.getString("data_e_hora").split(" ")[0] + "T" + rs.getString("data_e_hora").split(" ")[1]; 
		LocalDateTime data_e_hora = LocalDateTime.parse(dataEHora);
		boolean aberto = false;
		if(rs.getString("aberto").equals("1")) {
			aberto = true;
		}
		return new Transfer(id, id_local_origem, id_local_destino, id_paciente, data_e_hora, aberto);
	}
	
	public Transfer selectTransfer(int id) {
		Transfer transfer = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TRANSFER_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				transfer = getTransferFromResultSet(id,rs);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return transfer;
	}

	public List<Transfer> selectAllTransfers() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Transfer> transfers = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_TRANSFERS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				transfers.add(getTransferFromResultSet(0,rs));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return transfers;
	}

	public boolean deleteTransfer(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_TRANSFERS_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public void updateTransfer(Transfer transfer) throws SQLException {
		System.out.println(UPDATE_TRANSFERS_SQL);
		performUpdateTransferQuery(transfer);
		
	}
	
}