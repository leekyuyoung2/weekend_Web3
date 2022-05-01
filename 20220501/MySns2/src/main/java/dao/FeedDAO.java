package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import common.DbCon;
import dto.FeedDTO;

public class FeedDAO {
	
	
	
	public List<FeedDTO> getAllFeed(){
		List<FeedDTO> lists = new ArrayList<FeedDTO>();
		String sql = "select * from feed order by ts desc";
		ResultSet rs = null;
		try(Connection conn =DbCon.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);				
				) 
		{
			rs = stmt.executeQuery();
			while(rs.next()) {
				FeedDTO dto = new FeedDTO();
				dto.setContent(rs.getString("content"));
				dto.setId(rs.getString("id"));
				dto.setImages(rs.getString("images"));
				dto.setTs(rs.getTimestamp("ts"));
				lists.add(dto);
			}
			return lists;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lists;
	}
	
	public void insertFeed(FeedDTO dto) throws Exception {
		String sql = "insert into feed(id,content,images) values(?,?,?)";
		try(Connection conn = DbCon.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				) 
		{
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getContent());
			pstmt.setString(3, dto.getImages());
			pstmt.executeUpdate();			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}
}
