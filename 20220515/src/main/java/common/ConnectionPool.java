package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionPool {
	private static DataSource _ds = null;	 
	public static Connection get() throws Exception {
		if(_ds == null)
			_ds = (DataSource) (new InitialContext()).lookup("java:comp/env/jdbc/mysql2");
		return _ds.getConnection();		
	}
}
