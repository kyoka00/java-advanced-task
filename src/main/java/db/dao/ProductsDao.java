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
	private static final String SQL_WHERE = "SELECT p.product_id, p.name AS product_name,c.id AS category_id,c.name AS category_name, p.price, p.description FROM products p JOIN categories c ON p.category_id = c.id WHERE p.name LIKE ? OR c.name LIKE ? ORDER BY ";
	private static final String SQL_INSERT = "INSERT INTO products (product_id, category_id, name, price, description, created_at) VALUES (?,?,?,?,?,?)" ;
	private static final String SQL_UPDATE ="UPDATE products SET product_id = ?,  name= ?, price = ?, category_id = ?, description= ?, updated_at = ? WHERE product_id = ?";
	private static final String SQL_DELETE ="DELETE FROM products WHERE product_id =?";
	
	
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
				Products p = new Products(result.getInt("product_id"),result.getString("product_name"), result.getInt("category_id"),
						result.getString("category_name"), result.getInt("price"),result.getString("description"));
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
	
public void update(Integer productId, Integer categoryId, String productName, Integer price,  String description) {

	try (PreparedStatement stmt = connection.prepareStatement(SQL_UPDATE)) {
		stmt.setInt(1,productId);
		stmt.setString(2, productName);
		stmt.setInt(3, price);
		stmt.setInt(4, categoryId);
		stmt.setString(5, description);
		stmt.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
		stmt.setInt(7, productId);
		
		stmt.executeUpdate();
		

	} catch (SQLException e) {
		throw new RuntimeException(e);
	}
}
public void delete(Integer productId) {

	try (PreparedStatement stmt = connection.prepareStatement(SQL_DELETE)) {
		stmt.setInt(1,productId);
		
		stmt.executeUpdate();
		

	} catch (SQLException e) {
		throw new RuntimeException(e);
	}
}
}
