package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.catalina.Context;

public class ConnectionPool {
	private static DataSource _ds = null;
	public static Connection getConnection() throws NamingException, SQLException {
		if(_ds == null)
//			_ds = (DataSource) (new InitialContext()).lookup("java:comp/env/jdbc/myfeed");
			_ds = (DataSource) (new InitialContext()).lookup("java:comp/env/jdbc/mysql");
		return _ds.getConnection();
		
		
//		final String JDBC_DRIVER = "org.h2.Driver";
//		final String JDBC_URL = "jdbc:h2:tcp://localhost/~/test";
//		final String ID = "sa";
//		final String PSW = "admin1234";
//		// DB 연결	
//		Connection conn = null;
//		try {			
//			Class.forName(JDBC_DRIVER); // 드라이버 로드			
//			conn = DriverManager.getConnection(JDBC_URL, ID, PSW); // Db 연결
//		} catch (Exception e) {
//			e.printStackTrace();
//		}		
//		return conn;
	}
}
