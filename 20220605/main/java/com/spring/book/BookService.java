package com.spring.book;

import java.util.List;
import java.util.Map;

public interface BookService {

	// 입력
	String create(Map<String, Object> map);
	// 상세조회
	Map<String, Object> detail(Map<String, Object> map);
	// 업데이트
	boolean update(Map<String, Object> map);
	// 삭제
	boolean delete(Map<String, Object> map);
	
	boolean delete(BookVO vo);
	
	// 조회(전체)
	List<Map<String, Object>> selectAll(Map<String, Object> map);
	
	// 조회(전체) - vo
	List<BookVO> selectVoAll(Map<String, Object> map);
	
	List<BookVO> selectVoAllPage(Map<String, Object> map);
	
}
