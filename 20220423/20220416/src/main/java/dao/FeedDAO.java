package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import dto.FeedDTO;

public class FeedDAO {

	public boolean insert(String uid,String ucont,String uimages) {		
		String sql = "insert into feed(id,content,images) values(?,?,?)";
		try(
				Connection conn =  ConnectionPool.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
			) 
		{
			pstmt.setString(1, uid);
			pstmt.setString(2, ucont);
			pstmt.setString(3, uimages);
			int count = pstmt.executeUpdate();
			return count == 1;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public List<FeedDTO> getList() {
		List<FeedDTO> lists = new ArrayList<FeedDTO>();
		String sql = "select * from feed order by ts desc";		
		try(
				Connection conn = ConnectionPool.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
			) 
		{
			while(rs.next()) {
				FeedDTO dto = new FeedDTO();
				dto.setId( rs.getString("id"));
				dto.setContent(rs.getString("content"));
				dto.setTs(rs.getTimestamp("ts"));
				dto.setImages(rs.getString("images"));
				lists.add(dto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();			
		}
		return lists;
		
	}
}
