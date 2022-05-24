package db.service;

import java.sql.Connection;
import java.util.List;

import db.dao.ProductsDao;
import db.entity.Products;
import db.utility.DbUtil;

public class Search {
	//public static List<Object> selectAll() {
	public static List<Products> selectAll() {
		Connection connection;
		ProductsDao productsDao;
		List<Products> allProducts;
		try {
			connection = DbUtil.getConnection();
			productsDao = new ProductsDao(connection);
			allProducts = productsDao.selectAll();
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
	public static int countAll() {
		Connection connection;
		ProductsDao productsDao;
		List<Products> allProducts;
		try {
			connection = DbUtil.getConnection();
			productsDao = new ProductsDao(connection);
			int count = productsDao.count();
			
			return count;
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return 0;
	}
//	public static void main(String[] args) {
//		List<Products> newObject = selectAll();
//		int count = countAll();
//		for(Products p: newObject) {
//			System.out.println(p.getPrice());
//		System.out.println(count);
//	}
//		}
}
