package com.codingdojo.mvc.dojooverflow.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;


@Entity
@Table(name="questions")
public class Question {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String text;
	 @Column(updatable=false)
	private Date createdAt;
	private Date updatedAt;
	
	
	 @ManyToMany(fetch = FetchType.LAZY)
	    @JoinTable(
	        name = "tags_questions", 
	        joinColumns = @JoinColumn(name = "question_id"), 
	        inverseJoinColumns = @JoinColumn(name = "tag_id")
	    )     
	    private List<Tag> tags;
	
	 @OneToMany(mappedBy="question", fetch = FetchType.LAZY)
	    private List<Answer> answers;

    @PrePersist
 	protected void onCreate(){
 	    this.createdAt = new Date();
 	}
 	@PreUpdate
 	protected void onUpdate(){
 	    this.updatedAt = new Date();

 }
 	public Question() {
 		
 	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public Question(Long id, String text) {
		super();
		this.id = id;
		this.text = text;
	}
	public Question(String text) {
		this.text=text;
		// TODO Auto-generated constructor stub
	}
	public List<Tag> getTags() {
		return tags;
	}
	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
	public List<Answer> getAnswers() {
		return answers;
	}
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
	
 	
}
