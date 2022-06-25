package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Question;
import com.example.demo.repository.QuestionRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class QuestionService {
	
	private final QuestionRepository questionrepository;
	
	public List<Question> getLists(){
		return questionrepository.findAll();
	}
	
	public Question findById(Integer id) {
		Optional<Question> question = questionrepository.findById(id);
		if(question.isPresent())
			return question.get();
		else
			throw new DataNotFoundException("question not found");
	}

	public void create(String subject, String content) {
		Question q = new Question();
		q.setContent(content);
		q.setSubject(subject);
		q.setCreateDate(LocalDateTime.now());
		questionrepository.save(q);		
	}
}
