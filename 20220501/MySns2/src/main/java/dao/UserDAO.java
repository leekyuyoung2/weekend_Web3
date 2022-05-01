package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import common.DbCon;
import dto.UserDTO;

public class UserDAO {
	
	public int deleteById(String id) {
		String sql = "delete from user where id = ?";		
		try(Connection conn = DbCon.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				)
		{
			pstmt.setString(1, id);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public List<UserDTO> getAllUsers(){
		List<UserDTO> lists= new ArrayList<UserDTO>();
		String sql = "select * from user";
		ResultSet rs = null;
		try(Connection conn = DbCon.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				) 
		{
			rs = pstmt.executeQuery();
			while (rs.next()) {
				UserDTO dto = new UserDTO();
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setTIMESTAMP(rs.getTimestamp("ts"));
				lists.add(dto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lists;
	}
	
	
	public int insert(UserDTO dto) {
		String sql = "insert into user(id, password, name) values(?, ?, ?) ";
		try (Connection conn = DbCon.getConnection(); PreparedStatement pstmt = conn.prepareCall(sql);) {
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPassword());
			pstmt.setString(3, dto.getName());
			return pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public boolean findByUserId(String id) {
		String sql = "select * from user where id = ?";		
		try (Connection conn = DbCon.getConnection();
				PreparedStatement pstmt = conn.prepareCall(sql);
			) {			
			pstmt.setString(1, id);
			return (pstmt.executeQuery()).next();			
		} catch (Exception e) {
			e.printStackTrace();			
			return false;
		}
	}
	
	public UserDTO getUserById(String id) {
		
		String sql = "select * from user where id = ?";
		ResultSet rs = null;
		try (Connection conn = DbCon.getConnection();
				PreparedStatement pstmt = conn.prepareCall(sql);
			) {			
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			rs.next();
			
			UserDTO dto = new UserDTO();
			dto.setId( rs.getString("id") );
			dto.setPassword( rs.getString("password"));
			dto.setName( rs.getString("name") );
			dto.setTIMESTAMP(rs.getTimestamp("ts"));
			return dto;			
		} catch (Exception e) {
			e.printStackTrace();			
			return null;
		}finally {
			try {
				if(rs !=null) rs.close();
			}catch (Exception e) {}
		}
		
	}

	public void updateById(UserDTO dto) {
		String sql = "udate user set password = ? where id = ?";
		
		
	}
	public int login(String id, String psw) throws SQLException {
		String sql = "select * from user where id = ?";
		ResultSet rs = null;
		try(Connection conn = DbCon.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				) 
		{
			pstmt.setString(1, id);			
			rs =  pstmt.executeQuery();
			if(!rs.next()) return 1;  // 해당아이디가 없을때 리턴하는 값
			else if(!rs.getString("password").equals(psw)) return 2;
			else return 0;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) rs.close();
		}
		return -1;  // 예외발생
	}
	
//	회원탈퇴
	public void withdraw(String id, String psw) {

	}
}
