package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionPool {
	public static Connection getConnection() {
		final String JDBC_DRIVER = "org.h2.Driver";
		final String JDBC_URL = "jdbc:h2:tcp://localhost/~/test";
		final String ID = "sa";
		final String PSW = "admin1234";
		// DB 연결	
		Connection conn = null;
		try {			
			Class.forName(JDBC_DRIVER); // 드라이버 로드			
			conn = DriverManager.getConnection(JDBC_URL, ID, PSW); // Db 연결
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return conn;
	}
}
