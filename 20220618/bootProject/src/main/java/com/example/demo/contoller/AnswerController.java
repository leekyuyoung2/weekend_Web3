package com.example.demo.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Question;
import com.example.demo.service.QuestionService;

import lombok.RequiredArgsConstructor;


@RequestMapping("/answer")
@RequiredArgsConstructor
@Controller
public class AnswerController {

	private final QuestionService questionservice;
	
	@PostMapping("/create/{id}")
	public String createAnswer(Model model, @PathVariable("id") Integer id, @RequestParam String content) {
		Question q =  questionservice.findById(id);
		// 저장....
		return String.format("redirect:/question/detail/%s", q.getId());
	}
}
