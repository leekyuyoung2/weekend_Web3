package com.example.demo.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DynamicController {
	
	@RequestMapping(value = "/test")
	public String dynamicPage() {
		return "dynamicPage";
	}

}
