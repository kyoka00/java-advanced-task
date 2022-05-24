package db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.entity.Users;

public class UsersDao {
	private Connection connection;
		private static final String SQL_LOGINSEARCH="SELECT login_id, password, name FROM users WHERE login_id = ? AND password= ?";
		
	
	public UsersDao(Connection connection) {
		this.connection = connection;
	}
	
	
	public Users loginSearch(String loginId, String password) {
		try(PreparedStatement stmt = connection.prepareStatement(SQL_LOGINSEARCH)){
			stmt.setString(1, loginId);
			stmt.setString(2, password);
			ResultSet result =stmt.executeQuery();
			Users u = new Users();
			while (result.next()) {
			u = new Users(result.getString("login_id"), result.getString("password"),result.getString("name"));
			}
			return u;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
}
