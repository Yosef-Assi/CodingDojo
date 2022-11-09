package com.codingdojo.mvc.dojooverflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.mvc.dojooverflow.models.Question;
import com.codingdojo.mvc.dojooverflow.models.Tag;
import com.codingdojo.mvc.dojooverflow.repositories.QuestionRepo;
import com.codingdojo.mvc.dojooverflow.repositories.TagRepo;


@Service
public class AllServices {

	@Autowired
	TagRepo tagRepo;
	@Autowired
	QuestionRepo questionRepo;
	public List<Tag> findAll(){
		return tagRepo.findAll();
	}
	public Tag createTag(Tag tag) {
		return tagRepo.save(tag);
	}
	public Question createQues(Question qestion) {
		return questionRepo.save(qestion);
	}
	public Tag findTag(Long id) {
		Optional<Tag> tag = tagRepo.findById(id);
		if(tag.isPresent()) {
			return tag.get();
		}
		else {
			return null;
		}
	}
	public Question findQues(Long id) {
		Optional<Question> ques = questionRepo.findById(id);
		if(ques.isPresent()) {
			return ques.get();
		}
		else {
			return null;
		}
	}
	public Tag updateTag(Tag tag) {
		return tagRepo.save(tag);
	}
	public Question updateQues(Question ques) {
		return questionRepo.save(ques);
	}
	public List<Tag> questionTag(Question ques){
		return tagRepo.findAllByQuestions(ques);
	}
	public List<Question> tagQuestion(Tag tag){
		return questionRepo.findAllByTags(tag);
	}
	
	public void addQuestionTag(Question question, Tag tag) {
		question.getTags().add(tag);
		questionRepo.save(question);
		tagRepo.save(tag);
	}
	
	
}
