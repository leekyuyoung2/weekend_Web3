package common;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DbCon {
	private static DataSource _ds = null;
	public static Connection getConnection() throws NamingException, SQLException {
		if(_ds == null)
			_ds = (DataSource) (new InitialContext()).lookup("java:comp/env/jdbc/mysql");
		return _ds.getConnection();
	}
}
