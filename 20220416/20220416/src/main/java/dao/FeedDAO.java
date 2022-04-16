package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import dto.FeedDTO;

public class FeedDAO {

	public boolean insert(String uid,String ucont) {		
		String sql = "insert into feed(id,content) values(?,?)";
		try(
				Connection conn =  ConnectionPool.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
			) 
		{
			pstmt.setString(1, uid);
			pstmt.setString(2, ucont);
			int count = pstmt.executeUpdate();
			return count == 1;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public List<FeedDTO> getList() {
		String sql = "select * from feed order by ts desc";
		List<FeedDTO> lists = new ArrayList();
		try(
				Connection conn = ConnectionPool.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
			) 
		{
			while (rs.next()) {
				FeedDTO dto = new FeedDTO();
				String id = rs.getString("id");
				String content = rs.getString("content");
				Timestamp ts = rs.getTimestamp("ts");
				dto.setId(id);
				dto.setContent(content);
				dto.setTs(ts);
				lists.add(dto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lists;
	}
}
