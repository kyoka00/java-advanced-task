package db.service;

import java.sql.Connection;
import java.util.List;

import db.dao.ProductsDao;
import db.entity.Products;
import db.utility.DbUtil;

public class Search {
	
	
	public static List<Products> select(String searchKey, String orderby) {
		Connection connection;
		ProductsDao productsDao;
		List<Products> allProducts;
		try {
			connection = DbUtil.getConnection();
			productsDao = new ProductsDao(connection);
			allProducts = productsDao.select(searchKey, orderby);
			//int count = productsDao.count();
			
			//List<Object> result = new ArrayList<>();
			//result.add(allProducts);
			//result.add(count);
			
			return allProducts;
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static int count(String a) {
		Connection connection;
		ProductsDao productsDao;
		try {
			connection = DbUtil.getConnection();
			productsDao = new ProductsDao(connection);
			int count = productsDao.countSelect(a);
			
			return count;
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return 0;
	}
	
	
	
//	public static void main(String[] args) {
//		String order = "p.created_at";
//		List<Products> newObject = select("", order);
//		//int count = count("");
//		for(Products p: newObject) {
//			System.out.println(p.getName());
//		
//	}
		//System.out.println(count);
		//}
}
