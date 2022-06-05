package com.spring.book;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookDAO {

	@Autowired
	SqlSessionTemplate sqlsessiontemplate;
	
	public int insert(Map<String, Object> map) {
		return sqlsessiontemplate.insert("book.insert",map);
	}
	
	public Map<String, Object> selectDetail(Map<String, Object> map){
		return sqlsessiontemplate.selectOne("book.select_detail", map);
	}

	public int update(Map<String, Object> map) {		
		return sqlsessiontemplate.update("book.update", map);
	}
	
	public int delete(Map<String, Object> map) {
		return sqlsessiontemplate.delete("book.delete", map);
	}
	
	public List<Map<String, Object>> selectAll(Map<String, Object> map){
		return sqlsessiontemplate.selectList("book.selectAll",map);		
	}
	
	public List<BookVO> selectVoAll(Map<String, Object> map){
		return sqlsessiontemplate.selectList("book.selectVoAll",map);		
	}
	
	public List<BookVO> selectVoAllPage(Map<String, Object> map){
//		map.put("page", 10);
		return sqlsessiontemplate.selectList("book.selectVoAllPage",map);		
	}

	public int delete(BookVO vo) {		
		return sqlsessiontemplate.delete("book.deletevo", vo);
	}
	
}
