package dao;
/**
 * Feed에대한 비지니스 로직 
 * DB : mysql 
 * schema : mysns
 * table : feed
 * 
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import common.ConnectionPool;

public class FeedDAO {
	/*
	 *  데이터 추가
	 *  테이블의 pk인 no값을 읽어서 +1한 값을 신규 no으로 채번한다
	 *  json 형태로 데이터를 입력받아서 데이터 베이스에 추가한다	 *   
	 */
	public boolean insert(String jsonstr) throws Exception{
		String sql = "select max(no)+1 as no from feed2";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try(Connection conn = ConnectionPool.get();) 
		{			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			int max = (!rs.next())? 0 : rs.getInt("no");
			JSONParser parser = new JSONParser();
			JSONObject jsonobj = (JSONObject) parser.parse(jsonstr);
			jsonobj.put("no", max);			
			
			// add 'user' property....  사용자 정보를 추가로 저장
			String uid =  jsonobj.get("id").toString();
			sql = "select jsonstr from user where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String usrstr = rs.getString("jsonstr");
				JSONObject usrobj = (JSONObject)parser.parse(usrstr);
				usrobj.remove("password");
				usrobj.remove("ts");
				usrobj.put("user", usrobj);
			}
			
			sql = "insert into(no, id,jsonstr) values(?,?,?)";			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, max);
			pstmt.setString(2, jsonobj.get("id").toString());
			pstmt.setString(3, jsonobj.toJSONString());
			int count = pstmt.executeUpdate();			
			return count == 1;
		}finally {
			if(pstmt!=null) pstmt.close();
			if(rs!=null) rs.close();
		}
	}

	/**
	 * feed2에서 데이터를 가져온다
	 * no 가 최신순으로 가져온다
	 * @throws Exception 
	 * @throws SQLException 
	 */	
	public String getList() throws SQLException, Exception {
		String sql = "select jsonstr from feed2 order by no desc";
		String str= "";
		try(
			Connection conn = ConnectionPool.get();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			)
		{
			int cnt = 0;
			str= "[";
			while (rs.next()) {
				if(cnt++ > 0) str += ',';
				str += rs.getString("jsonstr");
			}
			str += "]";
		}
		return str;
	}
	
	/**
	 * 파라메터로 주어진 maxNo 보다 적은 no를 가진 n개의 레코드를 반환
	 * getList()와 유사 
	 * @throws Exception 
	 * @throws SQLException 
	 */
	public String getGroup(String maxNo) throws SQLException, Exception {
		String sql = "select jsonstr from feed2";
		if(maxNo != null) {
			sql += "where no < "+maxNo;
		}
		sql += "order by no desc limit 3";
		String str= "";
		try(
			Connection conn = ConnectionPool.get();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			)
		{
			int cnt = 0;
			str= "[";
			while (rs.next()) {
				if(cnt++ > 0) str += ',';
				str += rs.getString("jsonstr");
			}
			str += "]";
		}
		return str;
	}
	
//	public boolean insert(String uid, String jsonstr) throws Exception {
//		
//		String sql = "insert into feed2(id,jsonstr) values(?,?)";
//		try(Connection conn = ConnectionPool.get();
//				PreparedStatement pstmt = conn.prepareStatement(sql);
//			) 
//		{
//			pstmt.setString(1, uid);
//			pstmt.setString(2, jsonstr);
//			int count =  pstmt.executeUpdate(sql);
//			return count == 1;
//		}
//	}
}
