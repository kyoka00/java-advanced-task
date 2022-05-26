package db.service;

import java.sql.Connection;

import db.dao.ProductsDao;
import db.utility.DbUtil;

public class UpdateDelete {
	public static boolean update(Integer productId, Integer categoryId, String productName, Integer price,  String description) {
		Connection connection;
		ProductsDao productsDao;
		try {
			connection = DbUtil.getConnection();
			productsDao = new ProductsDao(connection);
			productsDao.update(productId, categoryId, productName, price,  description);
			
			return true;
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return false;
	}
	public static boolean delete(Integer productId) {
		Connection connection;
		ProductsDao productsDao;
		try {
			connection = DbUtil.getConnection();
			productsDao = new ProductsDao(connection);
			productsDao.delete(productId);
			
			return true;
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return false;
	}
}
