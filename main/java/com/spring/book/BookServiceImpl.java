package com.spring.book;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookDAO bookdao;	
	
	@Override
	public String create(Map<String, Object> map) {
		int cnt =  bookdao.insert(map);
		if(cnt == 1)
			return map.get("book_id").toString();
		return null;
	}

	@Override
	public Map<String, Object> detail(Map<String, Object> map) {		
		return bookdao.selectDetail(map);
	}

	@Override
	public boolean update(Map<String, Object> map) {		
		return bookdao.update(map) == 1;
	}

	@Override
	public boolean delete(Map<String, Object> map) {		
		return bookdao.delete(map) == 1;
	}

	@Override
	public List<Map<String, Object>> selectAll(Map<String, Object> map) {		
		return bookdao.selectAll(map);
	}

	@Override
	public List<BookVO> selectVoAll(Map<String, Object> map) {		
		return bookdao.selectVoAll(map);
	}

	@Override
	public boolean delete(BookVO vo) {		
		return bookdao.delete(vo)==1;
	}

	@Override
	public List<BookVO> selectVoAllPage(Map<String, Object> map) {		
		return bookdao.selectVoAllPage(map);
	}

}
