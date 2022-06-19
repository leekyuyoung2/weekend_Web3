package com.example.demo.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.Question;
import com.example.demo.repository.QuestionRepository;
import com.example.demo.service.QuestionService;

import lombok.RequiredArgsConstructor;

/**
 * 
 * Controller -> Service ->Reposioty
 *
 */


@RequiredArgsConstructor
@Controller
@RequestMapping("/question")
public class QuestionController {
//	@Autowired
//	private QuestionRepository questionrepository; 
	
	//@Autowired
	private  final QuestionService questionservice;
	
	@RequestMapping("/list")
//	@ResponseBody
	public String list(Model model) {
//		return "<h1>question list</h1>";
		
		//List<Question> questionList = questionrepository.findAll();
		List<Question> questionList = questionservice.getLists();
		model.addAttribute("questionList", questionList);
		return "qeustionList";
	}
	
	@RequestMapping("/detail/{id}")
	public String detail(Model model, @PathVariable("id") Integer id) {
		Question question =  questionservice.findById(id);
		model.addAttribute("question",question);
		return "question_detail";
	}
	
	
}
