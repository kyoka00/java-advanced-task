package db.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import db.dao.CategoryDao;
import db.entity.Categories;
import db.utility.DbUtil;

public class CategoryService {
	public static List<Categories> getAllCategory() {
		Connection connection;
		CategoryDao categoryDao;
		List<Categories> allCategory = new ArrayList<>();
		try {
			connection = DbUtil.getConnection();
			categoryDao = new CategoryDao(connection);
			allCategory =  categoryDao.selectCategory();
			
			
			return allCategory;
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return null;
	}
}
