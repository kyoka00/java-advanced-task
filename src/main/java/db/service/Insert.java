package db.service;

import java.sql.Connection;

import db.dao.ProductsDao;
import db.utility.DbUtil;

public class Insert {
	public static boolean insert(Integer productId, Integer categoryId, String productName, Integer price,  String description) {
		Connection connection;
		ProductsDao productsDao;
		try {
			connection = DbUtil.getConnection();
			productsDao = new ProductsDao(connection);
			productsDao.insert(productId, categoryId, productName, price,  description);
			
			return true;
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return false;
	}
	
//	public static void main (String [] args) {
//		boolean test = insert(10011, 1,"SARASA", 90,"");
//		System.out.println(test);
//	}
}
