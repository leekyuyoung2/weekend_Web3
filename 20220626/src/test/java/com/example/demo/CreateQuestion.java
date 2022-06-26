package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.service.QuestionService;

@SpringBootTest
class CreateQuestion {		
	@Autowired
	private QuestionService questionService;
		
	
	@Test
	void makeQuestion() {
		for (int i = 1; i < 300; i++) {
			questionService.create("subject"+i, "content"+i);
		}
	}
	

}
