package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

	@RequestMapping("/demo")
	@ResponseBody
	public String index() {
//		System.out.println("index");
		return "index.. 안녕하세요.ㅇㅇㅇㅇ";
	}
}
