package net.javaguides.covidnet.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.javaguides.covidnet.dao.BaseDAO;

public class LoginDAO extends BaseDAO{
	private static final String GET_USERS_BY_LOGIN_AND_PASSWORD = "select count(*) AS count from Usuarios where emailOrCpf = ? and password = ?";
	
	public LoginDAO() {}
	
	public int getValidLogins (String emailOrCpf, String password) {
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(GET_USERS_BY_LOGIN_AND_PASSWORD)) {
			
			preparedStatement.setString(1, emailOrCpf);
			preparedStatement.setString(2, password);
			ResultSet rs = preparedStatement.executeQuery();
			rs.first();
			return rs.getInt("count");
			
		} catch (SQLException e) {
			printSQLException(e);
			return 0;
		}
		
	}
}
