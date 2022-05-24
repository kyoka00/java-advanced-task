package db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import db.entity.Products;

public class ProductsDao {
	Connection connection;
	private static final String SQL_COUNT = "SELECT count(*) AS count FROM products p JOIN categories c ON p.category_id = c.id WHERE p.name LIKE ? OR c.name LIKE ?";
	private static final String SQL_WHERE = "SELECT p.product_id, p.name AS product_name,c.name AS category_name, p.price FROM products p JOIN categories c ON p.category_id = c.id WHERE p.name LIKE ? OR c.name LIKE ? ORDER BY ";
	private static final String SQL_INSERT = "INSERT INTO products (product_id, category_id, name, price, description, created_at) VALUES (?,?,?,?,?,?)" ;
	
	
	public ProductsDao(Connection connection) {
		this.connection = connection;
	}
	
	
	public List<Products> select(String searchKey, String orderby) {

		try (PreparedStatement stmt = connection.prepareStatement(SQL_WHERE + orderby)) {
			stmt.setString(1, "%"+ searchKey +"%");
			stmt.setString(2, "%"+ searchKey +"%");
			
			ResultSet result = stmt.executeQuery();

			List<Products> allProducts = new ArrayList<Products>();

			while (result.next()) {
				Products p = new Products(result.getInt("product_id"), result.getString("product_name"),
						result.getString("category_name"), result.getInt("price"));
				allProducts.add(p);
			}
			
			return allProducts;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public int countSelect(String a) {
		Integer count = 0;
		try(PreparedStatement stmt = connection.prepareStatement(SQL_COUNT)){
			stmt.setString(1, "%"+ a +"%");
			stmt.setString(2, "%"+ a +"%");
			ResultSet result = stmt.executeQuery();
			
			while (result.next()){
				count = result.getInt("count");
			}
			return count;
			
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}

	}
	
	public void insert(Integer productId, Integer categoryId, String productName, Integer price,  String description) {

		try (PreparedStatement stmt = connection.prepareStatement(SQL_INSERT)) {
			stmt.setInt(1,productId);
			stmt.setInt(2, categoryId);
			stmt.setString(3, productName);
			stmt.setInt(4, price);
			stmt.setString(5, description);
			stmt.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
			
			stmt.executeUpdate();
			

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
