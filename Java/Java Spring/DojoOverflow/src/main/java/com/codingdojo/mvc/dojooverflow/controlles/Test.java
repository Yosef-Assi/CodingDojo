package com.codingdojo.mvc.dojooverflow.controlles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.mvc.dojooverflow.models.Question;
import com.codingdojo.mvc.dojooverflow.models.Tag;
import com.codingdojo.mvc.dojooverflow.services.AllServices;


@Controller
public class Test {
	@Autowired
	AllServices service;
	
	@GetMapping("/")
	public String home() {
		return "redirect:/home";
	}
	@GetMapping("/home")
	public String index() {
			return "addq.jsp";
	}
	@PostMapping("/add")
    public String createnew(@RequestParam("question") String question,@RequestParam("tag") Tag taga,  Model model) {
//        Question product = service.findLookify(id);
//        Tag category = service.findCat(catId);
		Question quest = new Question(question);
//		Tag tag = new Tag(taga);
		service.createQues(quest);
		service.createTag(taga);
		Question product = service.findQues(quest.getId());
		Tag category = service.findTag(taga.getId());
		List<Question> querts = category.getQuestions();
		System.out.println(querts);
//		querts.add(product);
//		category.setQuestions(querts);
//		service.updateTag(category);
        return "redirect:/home";   
	}
	
}
