package model;
/**
 * DB 접속
 * DB 테이블 조회(news) 및 데이터 추출 및 가공(CRUD)
 * News 객체를 이용해서 데이터를 저장
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NewsDAO {
	private final String JDBC_DRIVER = "org.h2.Driver";
	private final String JDBC_URL = "jdbc:h2:~/test";
	private final String ID  = "sa";
	private final String PSW = "admin1234";
	// DB 연결
	public Connection open() {
		Connection conn = null;
		try {
			// 드라이버 로드
			Class.forName(JDBC_DRIVER);
			// Db 연결
			conn = DriverManager.getConnection(JDBC_URL, ID, PSW);		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	// news 테이블에 데이터를 insert
	// CURRENT_TIMESTAMP( )를 이용해 현재 날짜/시간 정보가 등록
	// try(conn; pstmt) 부분은 try-with-resource 기법이 적용된 부분으로 
	// 예외 발생 시 해당 리소스를 자동으로 close함

	public void addNews(News news) throws Exception {
		System.out.println(news);
		Connection conn = open();
		// insert sql
		String sql = "insert into news(title,img,date,content) values(?,?,current_timestamp(),?)";
		// preparestatement
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		try(conn; pstmt){
			pstmt.setString(1, news.getTitle());
			pstmt.setString(2, news.getImg());
			pstmt.setString(3, news.getContent());
			pstmt.executeUpdate();
		}
	}
	
	// 전체 뉴스 리스트
	public List<News> getAll() throws Exception{
		List<News> lists = new ArrayList<News>();
		Connection conn = open();
		String sql = "select  aid,title,PARSEDATETIME(date,'yyyy-MM-dd hh:mm:ss') as cdate  from news";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		try(conn;pstmt;rs) 
		{
			while (rs.next()) {
				News n = new News();
				n.setAid(rs.getInt("aid"));
				n.setTitle(rs.getString("title"));
				n.setDate(rs.getString("cdate"));
				lists.add(n);
			}
		}		
		return lists;
	}
	// 뉴스 목록에서 뉴스를 선택했을때 늑정 뉴스의 기사의 세부 내용을 보여주는 메서드
	// pk인 aid를 인자로 받아서 News객체를 리턴
	// getAll()과 유사하지만... Resultset은 while이 아니라. 한건이라서 ns.next()로 데이터를 가져온다.
	// 기사가 없 으면 예외를 발생시킴
	public News getNews(int aid) throws Exception {
		Connection conn = open();
		News n = new News();
		String sql = "select  "
				+ " aid,title,img,content,"
				+ " PARSEDATETIME(date,'yyyy-MM-dd hh:mm:ss') as cdate   "
				+ " from news where aid=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, aid);
		ResultSet rs = pstmt.executeQuery();
		
		try(conn;pstmt;rs)
		{
			if(!rs.next()) throw new Exception("DB 에러");
			n.setAid( rs.getInt("aid"));
			n.setContent(rs.getString("content"));
			n.setDate(rs.getString("cdate"));
			n.setImg(rs.getString("img"));
			n.setTitle(rs.getString("title"));
		}
		return n;
	}
	
	// 기사 삭제
	// 삭제할 기사의 pk인 aid를 받아서 삭제
	public void delNews(int aid) throws Exception{
		Connection conn = open();
		String sql = "delete from news where aid = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		try(conn;pstmt){
			pstmt.setInt(1, aid);
			if(pstmt.executeUpdate() == 0)
				throw new Exception("DB 에러");
		}		
		
	}
	
}
