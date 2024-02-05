package com.Leta.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Leta.Model.Question;
import com.Leta.Model.QuestionWrapper;
import com.Leta.Model.Quiz;
import com.Leta.Model.QuizDTO;
import com.Leta.Model.Response;
import com.Leta.Service.QuizService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("quiz")
public class QuizController {
	
	@Autowired
	QuizService service;
	
	@GetMapping("create/{category}/{title}/{num}")
	public List<Question> create(@PathVariable String category,@PathVariable String title,@PathVariable Integer num) {
		System.out.println("Entered .. . .");
		return service.create(category,title,num);
		
	}
	
	
	@GetMapping("getAll")
	public ResponseEntity<List<Quiz>>  getAll() {
		return service.getAll();
	}
	
	@GetMapping("get/{id}")
	public List<QuestionWrapper>  getById(@PathVariable Long id) {
		return service.getById(id);
		
	} 
	
	@PostMapping("getResult/{id}")
	public Integer getResult(@PathVariable("id") Long id,@RequestBody List<Response> response) {
		return service.getResult(id,response);
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
