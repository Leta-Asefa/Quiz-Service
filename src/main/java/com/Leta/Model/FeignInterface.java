package com.Leta.Model;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("Question-Service")
public interface FeignInterface {

	@GetMapping("question/generate/{category}/{num}")
	public ResponseEntity<List<Integer>> generate(@PathVariable String category,@PathVariable Integer num);
	
	@PostMapping("question/getQuestions")
	public ResponseEntity<List<QuestionWrapper>> getQuestions (@RequestBody List<Integer> questionsId);
	
	
	@PostMapping("question/getScore")
	public ResponseEntity<Integer> getScore (@RequestBody List<Response> responses);
	
	
	
	@GetMapping("allQuestions")
	public ResponseEntity<List<Question> >getAllQuestions() ;
}
