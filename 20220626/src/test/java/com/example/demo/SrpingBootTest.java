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
class SrpingBootTest {
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
		q.setSubject("������!!");
		q.setContent("���� ���� �Գ���?");
		q.setCreateDate(LocalDateTime.now());
		
		questionrepository.save(q);
		
		Question q2 = new Question();
		q2.setSubject("���ǵ帳�ϴ�.");
		q2.setContent("��������� ���۵ǳ���.. ������ ���޾Ҿ��");
		q2.setCreateDate(LocalDateTime.now());
		questionrepository.save(q);
		
	}
	
	@Test
	void selectAll() {
		List<Question> list =  questionrepository.findAll();
		assertEquals(2, list.size());
		
		Question q =  list.get(0);
		assertEquals("���ǵ帳�ϴ�.", q.getSubject());
	}	
	
	@Test
	void findById() {
		Optional<Question> question = questionrepository.findById(0);
		if(question.isPresent()) {  // null�̾ƴ��� Ȯ����
			Question q =  question.get();
			assertEquals("���ǵ帳�ϴ�.", q.getSubject());
		}
	}
	
	@Test
	void findBySubject() {
		Question q =  questionrepository.findBySubject("���ǵ帳�ϴ�.");
		assertEquals("���ǵ帳�ϴ�.", q.getSubject());		
	}
	
	@Test
	void findBySubjectAndContent() {
		Question q =  questionrepository.findBySubjectAndContent("���ǵ帳�ϴ�.", "����");
		assertNotEquals(null, q);
	}
	
	@Test
	void findBySubjectLike() {
		List<Question> list = questionrepository.findBySubjectLike("%��%");
		assertNotEquals(null, list);		
	}
	
	@Test
	void updateFindById() {
		Optional<Question> q =  questionrepository.findById(1);
		if(q.isPresent()) {
			Question qq =  q.get();
			qq.setSubject("ù��° ����");
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
		q.setSubject("����1");
		q.setContent("����1");
		q.setCreateDate(LocalDateTime.now());
		questionrepository.save(q);
		
		Answer a = new Answer();
		a.setContent("����1������ ����");
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
	
	// ������ ã�� �� ������ ��� ������ ���Ѱ���?
	@Test
	void findQuestionbyAnswer() {
		Optional<Answer> an = answerrepository.findById(1);
		assertEquals(true, an.isPresent() );
		Answer a =  an.get();
		Question q =  a.getQuestion();
		assertEquals(3, q.getId());
	}
	
	// ������ �ش��ϴ� ������ ã��
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
