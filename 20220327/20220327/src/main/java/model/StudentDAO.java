package model;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;

// StudentVO 또는 StudentDTO  만들어진 하나의 Row를 저장하는 객체를 관리하는 클래스
// 데이터 베이스 접속도 관리
public class StudentDAO {
	Connection conn;
	PreparedStatement pstmt;
	final String JDBC_DRIVER = "org.h2.Driver";
	final String JDBC_URL = "jdbc:h2:~/test";

	public void open() {
		try {
			Class.forName(JDBC_DRIVER); // 드라이버 로드
			// 접속
			conn = DriverManager.getConnection(JDBC_URL, "sa", "admin1234");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void close() {
		try {
			if (pstmt != null)
				pstmt.close();
			if(conn != null)
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 데이터 등록하는 method
	public void insert(StudentDTO student) {
		open();
		
		String sql = "insert into student(username, univ, birth, email) "
						+ "values(?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, student.getUSERNAME());
			pstmt.setString(2, student.getUNIV());
			pstmt.setDate(3, student.getBIRTH());
			pstmt.setString(4, student.getEMAIL());			
			pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
	}
	public List<StudentDTO> getAll(){
		open();
		List<StudentDTO> students = new ArrayList<StudentDTO>();
		try {
			pstmt =  conn.prepareStatement("select * from student");
			ResultSet rs =  pstmt.executeQuery();
			while (rs.next()) {
				StudentDTO s = new StudentDTO();
				s.setId(rs.getInt("id"));
				s.setUSERNAME(rs.getString("username"));
				s.setUNIV(rs.getString("univ"));
				s.setBIRTH(rs.getDate("birth"));
				s.setEMAIL(rs.getString("email"));
				
				students.add(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return students;
	}
}
