package com.Leta.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Leta.DAO.QuizDAO;
import com.Leta.Model.FeignInterface;
import com.Leta.Model.Question;
import com.Leta.Model.QuestionWrapper;
import com.Leta.Model.Quiz;
import com.Leta.Model.Response;

@Service
public class QuizService {

	@Autowired
	QuizDAO quiz_dao;
	@Autowired
	FeignInterface feign;
	
	public List<Question> create(String category, String title,Integer num) {
//		Quiz quiz=new Quiz();
//		quiz.setTitle(title);
//		List<Integer> questions=feign.generate(category, num).getBody();
//		quiz.setQuestions(questions);
//		quiz_dao.save(quiz);
//		return questions;
		
		return feign.getAllQuestions().getBody();
		
	}

	public ResponseEntity<List<Quiz>> getAll() {
		
	return	new ResponseEntity<>(quiz_dao.findAll(),HttpStatus.OK);
		
	}

	public List<QuestionWrapper> getById(Long id) {
		Quiz quiz=quiz_dao.findById(id).get();
		List<Integer> ids=quiz.getQuestions();
		List<QuestionWrapper> wrapper=feign.getQuestions(ids).getBody();
		
		return wrapper;
		
		}

	public Integer getResult(Long id, List<Response> responses) {
		
		return feign.getScore(responses).getBody();
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
