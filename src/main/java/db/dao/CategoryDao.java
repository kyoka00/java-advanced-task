package db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.entity.Categories;

public class CategoryDao {
	private Connection connection;
	private static final String SQL_SELECTALL_CATEGORY= "SELECT * FROM categories";
	
	public CategoryDao(Connection connection) {
		this.connection = connection;
	}
	
	public List<Categories> selectCategory() {
		try(PreparedStatement stmt = connection.prepareStatement(SQL_SELECTALL_CATEGORY)){
		
			ResultSet result =stmt.executeQuery();
			List<Categories> list = new ArrayList<>();
			Categories c = new Categories();
			while (result.next()) {
				c = new Categories(result.getInt("id"), result.getString("name"));
				list.add(c);
			}
			return list;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
