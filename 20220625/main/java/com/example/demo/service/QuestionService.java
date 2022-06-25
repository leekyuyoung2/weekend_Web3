package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Question;
import com.example.demo.repository.QuestionRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class QuestionService {
	
	 private final QuestionRepository questionRepository;
	
	public List<Question> getLists(){
		return questionRepository.findAll();
	}
	
    public Question getQuestion(Integer id) {
        Optional<Question> question = this.questionRepository.findById(id);
        if (question.isPresent()) {
            return question.get();
        } else {
            throw new DataNotFoundException("question not found");
        }
    }

	public void create(String subject, String content) {
		Question q = new Question();
		q.setContent(content);
		q.setSubject(subject);
		q.setCreateDate(LocalDateTime.now());
		questionRepository.save(q);		
	}
	
	public Page<Question> getList(int page){
		Pageable pageable = PageRequest.of(page, 10);
		return questionRepository.findAll(pageable);
	}
	
}
