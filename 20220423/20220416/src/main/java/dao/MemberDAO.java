package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dto.MemberDTO;

/**
 * 데이터베이스의 member talble을 관리하는 객체 - DB 접속 member table select insert update
 * delete CRUD
 */
public class MemberDAO {
	// 이미 가입한 회원
	// 회원 가입 성공하면 true를 리턴하도록 함수를 작성
	public boolean insert(String uid, String upsw, String uname) {
		// DB의 접속 객체 가져와서 사용 -
		String sql = "insert into user(id,password,name,ts) values(?,?,?,now())"; // stmt를통해 바인딩
		try
		(
			Connection conn = ConnectionPool.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);				
		) 
		{			
			stmt.setString(1, uid);
			stmt.setString(2, upsw);
			stmt.setString(3, uname);

			int count = stmt.executeUpdate();
			return count == 1;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	// 회원 존재여부를 체크하는 함수
	// 회원 uid를 member테이블에서 조회해서 있으면 true 없으면 false
	// resultset 객체로 결과를 받아들임
	// executeQuery()
	public boolean exists(String uid) {
		
		ResultSet rs = null;
		String sql = "select * from user where id = ?";
		try
		(
			Connection conn = ConnectionPool.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);		
		)		
		{
			pstmt.setString(1, uid);
			rs = pstmt.executeQuery();
			return rs.next();				
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public int exists(String uid, String upsw) {
		ResultSet rs = null;
		String sql = "select * from member where uid = ?";
		try 
		{
			Connection conn = ConnectionPool.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uid);
			rs = pstmt.executeQuery();
			if(!rs.next()) return 1; 
			if(!rs.getString("upsw").equals(upsw)) return 2;							
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}finally {
			try {
				if(rs != null) rs.close();				
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return 3; // 정상 처리
	}
	// delete from member where uid = ?
	// executeUpdate
	public boolean delete(String uid) {
		String sql = "delete from member where uid = ?";
		try(
				Connection conn = ConnectionPool.getConnection();				
				PreparedStatement pstmt = conn.prepareStatement(sql); 
			) 
		{
			int count = pstmt.executeUpdate();
			return count == 1;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
