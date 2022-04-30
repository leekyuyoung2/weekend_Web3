package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DbCon {
	private static DataSource _ds = null;	 
	public static Connection getConnection() throws Exception {
		if(_ds == null)
			_ds = (DataSource) (new InitialContext()).lookup("java:comp/env/jdbc/mysql2");
		return _ds.getConnection();
//		if(_ds == null) {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			String url = "jdbc:mysql://localhost:3306/mysns?serverTimezone=UTC";
//			String id = "root";
//			String pw = "admin1234";
//			_ds = DriverManager.getConnection(url, id, pw);
//			
//		}
//		return _ds;
	}
}
