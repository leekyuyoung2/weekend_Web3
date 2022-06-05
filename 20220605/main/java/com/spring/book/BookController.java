package com.spring.book;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookController {
	
	@Autowired
	BookService bookservice;
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView create() {
		return new ModelAndView("book/create"); // book/create.jsp
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createPost(@RequestParam Map<String,Object> map) {
		ModelAndView ma = new ModelAndView();
		String book_id = bookservice.create(map);
		if(book_id == null)
			ma.setViewName("redirect:/create");
		else
//			ma.setViewName("redirect:/detail?bookId="+book_id);  // get방식
			ma.setViewName("redirect:/list");
		return ma;
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public ModelAndView detail(@RequestParam Map<String,Object> map) {
		Map<String, Object> detailMap =  bookservice.detail(map);
		
		ModelAndView ma = new ModelAndView();
		ma.addObject("data",detailMap);
//		ma.addObject("bookId",map.get("bookId").toString());
		ma.setViewName("/book/detail");
		return ma;
	}
	// update?bookId=1
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public ModelAndView update(@RequestParam Map<String,Object> map ) {
		// 서비스 연결
		Map<String, Object> detailMap = bookservice.detail(map);
		
		
		ModelAndView ma = new ModelAndView();
		ma.addObject("data",detailMap);
		ma.setViewName("/book/update");
		return ma;
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView updatePoist(@RequestParam Map<String,Object> map ) {		// 서비스 연결		
		ModelAndView ma = new ModelAndView();
		boolean isSuccess =  bookservice.update(map);
		
		if(isSuccess) {
			// 상세하면을 호출할때
//			String bookId = map.get("bookId").toString();
//			ma.setViewName("redirect:/detail?bookId="+bookId);
			// 리스트를 호출하도록 변경
//			ma =  list();
			ma.setViewName("redirect:/list");  // 새로운 주소로 변경됨
		}
		else {
			ma = update(map); // 주소가 변경되지 않음
		}		
		return ma;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView delete(
//			@RequestParam Map<String, Object> map
			@ModelAttribute BookVO vo
			) {
		ModelAndView ma = new ModelAndView();
//		boolean isSuccess =  bookservice.delete(map);
		boolean isSuccess =  bookservice.delete(vo);
		if(isSuccess) {
			ma.setViewName("redirect:/list");
		}else {
//			String bookId =  map.get("bookID").toString();
			String bookId =  vo.getBook_id();
			ma.setViewName("redirect:/detail?bookId="+bookId);
		}
		
		return ma;
	}
	
	@RequestMapping(value = "/list")
	public ModelAndView list(
			@RequestParam Map<String, Object> map
			) {
		ModelAndView ma = new ModelAndView();
		if(map.containsKey("keyword")) {
			ma.addObject("keyword", map.get("keyword"));
		}
		
//		List<Map<String, Object>> list = bookservice.selectAll(map);
//		List<BookVO> list = bookservice.selectVoAll(map);
		if(map.containsKey("page")) {
			int page =  Integer.valueOf(map.get("page").toString());
			map.put("page", page);
		}
		List<BookVO> list = bookservice.selectVoAllPage(map);
		System.out.println("=======================" + list);
		ma.addObject("dataList",list);
		ma.setViewName("book/list");
		return ma;
		
	}
	
}
