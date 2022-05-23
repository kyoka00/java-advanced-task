package db.service;

import java.sql.Connection;

import db.dao.UsersDao;
import db.entity.Users;
import db.utility.DbUtil;


public class passCheck {
	
	
	public static Users loginUser(String loginId, String password) {
		Connection connection;
		UsersDao usersDao;	
		try {
			connection = DbUtil.getConnection();
			usersDao = new UsersDao(connection);
			Users u = usersDao.loginSearch(loginId, password);
			return u;
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return null;
	}
	public static boolean loginCheck(String loginId, String password) {
		Users u = new Users();
		try {
			u = loginUser(loginId, password);
			if(u.getPassword()!= null) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
		
	}
}
