package com.example.demo.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	private static final String String = null;
	//@Autowired
	private  final QuestionService questionservice;
	
	@GetMapping("/create")
	public String create() {
		return "question_form";
	}
	
	@PostMapping("/create")
	public String create(@RequestParam String subject, @RequestParam String content) {
		questionservice.creat(subject, content);
		return "redirect:/question/list";
	}
	
	
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
