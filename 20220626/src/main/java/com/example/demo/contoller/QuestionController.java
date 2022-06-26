package com.example.demo.contoller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.AnswerForm;
import com.example.demo.entity.Question;
import com.example.demo.entity.QuestionForm;
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
	private  final QuestionService questionService;
	
	@GetMapping("/create")
	public String create(QuestionForm questionForm) {
		return "question_form";
	}
	
	@PostMapping("/create")
    public String questionCreate(@Valid QuestionForm questionForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "question_form";
        }
        this.questionService.create(questionForm.getSubject(), questionForm.getContent());
        return "redirect:/question/list";
    }
	
	
	@RequestMapping("/pagelist")
	public String pagelist(Model model, @RequestParam(value = "page", defaultValue = "0") int page)
	{
		Page<Question> paging =  questionService.getList(page);		
		model.addAttribute("paging",paging);
		return "question_list";
	}
	
	@RequestMapping("/list")
//	@ResponseBody
	public String list(Model model) {
//		return "<h1>question list</h1>";
		
		//List<Question> questionList = questionrepository.findAll();
		List<Question> questionList = questionService.getLists();
		model.addAttribute("questionList", questionList);
		return "qeustionList";
	}
	
	@RequestMapping("/detail/{id}")
	public String detail(Model model, @PathVariable("id") Integer id,AnswerForm answerForm) {
		Question question =  questionService.getQuestion(id);
		model.addAttribute("question",question);
		return "question_detail";
	}
	
	
	
	
	
	
}
