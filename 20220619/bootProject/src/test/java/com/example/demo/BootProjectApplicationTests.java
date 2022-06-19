package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Answer;
import com.example.demo.entity.Question;
import com.example.demo.repository.AnswerRepository;
import com.example.demo.repository.QuestionRepository;

@SpringBootTest
class BootProjectApplicationTests {
	@Autowired
	private QuestionRepository questionrepository;
	
	@Autowired
	private AnswerRepository answerrepository;
	
	
	private String name;
	@Test
	void contextLoads() {
		assertNotEquals(null, questionrepository);
	}
	
	@Test
	void testName() {
		assertNotEquals(null, name);
	}

	@Test
	void testCreateQuestion() {
		Question q = new Question();
		q.setSubject("질문요!!");
		q.setContent("밥은 언제 먹나요?");
		q.setCreateDate(LocalDateTime.now());
		
		questionrepository.save(q);
		
		Question q2 = new Question();
		q2.setSubject("문의드립니다.");
		q2.setContent("배송은언제 시작되나요.. 아직도 못받았어요");
		q2.setCreateDate(LocalDateTime.now());
		questionrepository.save(q);
		
	}
	
	@Test
	void selectAll() {
		List<Question> list =  questionrepository.findAll();
		assertEquals(2, list.size());
		
		Question q =  list.get(0);
		assertEquals("문의드립니다.", q.getSubject());
	}	
	
	@Test
	void findById() {
		Optional<Question> question = questionrepository.findById(0);
		if(question.isPresent()) {  // null이아닌지 확인함
			Question q =  question.get();
			assertEquals("문의드립니다.", q.getSubject());
		}
	}
	
	@Test
	void findBySubject() {
		Question q =  questionrepository.findBySubject("문의드립니다.");
		assertEquals("문의드립니다.", q.getSubject());		
	}
	
	@Test
	void findBySubjectAndContent() {
		Question q =  questionrepository.findBySubjectAndContent("문의드립니다.", "몰라");
		assertNotEquals(null, q);
	}
	
	@Test
	void findBySubjectLike() {
		List<Question> list = questionrepository.findBySubjectLike("%드%");
		assertNotEquals(null, list);		
	}
	
	@Test
	void updateFindById() {
		Optional<Question> q =  questionrepository.findById(1);
		if(q.isPresent()) {
			Question qq =  q.get();
			qq.setSubject("첫번째 질문");
			questionrepository.save(qq);
		}
		
	}
	@Test
	void deleteFindById() {
		Optional<Question> q =  questionrepository.findById(1);
		if(q.isPresent()) {
			Question qq =  q.get();			
			questionrepository.delete(qq);
		}
	}
	
	@Test
	void deleteAll() {
		questionrepository.deleteAll();
	}
	
	@Test
	void makeQuestionAndAnswer() {
		Question q = new Question();
		q.setSubject("질문1");
		q.setContent("내용1");
		q.setCreateDate(LocalDateTime.now());
		questionrepository.save(q);
		
		Answer a = new Answer();
		a.setContent("질문1에대한 답장");
		a.setQuestion(q);
		a.setCreateDate(LocalDateTime.now());
		answerrepository.save(a);
	}
	
	@Test
	void findAnswerAll() {
		List<Answer> list = answerrepository.findAll();
		assertNotEquals(null, list);
		assertEquals(true, list.size()>0);
	}
	
	// 답장을 찾고 그 답장이 어느 질문에 대한건지?
	@Test
	void findQuestionbyAnswer() {
		Optional<Answer> an = answerrepository.findById(1);
		assertEquals(true, an.isPresent() );
		Answer a =  an.get();
		Question q =  a.getQuestion();
		assertEquals(3, q.getId());
	}
	
	// 질문에 해당하는 답장을 찾기
	@Transactional
	@Test
	void findAnswerByQuestion() {
		Optional<Question> qq = questionrepository.findById(3);
		assertEquals(true, qq.isPresent());
		Question q =  qq.get();
		List<Answer> answerList = q.getAnswerList();
		assertNotEquals(null, answerList);
		assertEquals(true, answerList.size()>0);
		
	}

}
