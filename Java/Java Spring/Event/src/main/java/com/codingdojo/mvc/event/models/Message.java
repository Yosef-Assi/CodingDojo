package com.codingdojo.mvc.event.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;



@Entity
@Table(name="messages")
public class Message {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @NotEmpty(message="Username is required!")
	    @Size(min=3, max=150, message="comment must be between 3 and 150 characters")
	    private String comment;
	    
	    @Column(updatable=false)
	    @DateTimeFormat(pattern="yyyy-MM-dd")
	    private Date createdAt;
	    @DateTimeFormat(pattern="yyyy-MM-dd")
	    private Date updatedAt;
	    
	    
		@PrePersist
	    protected void onCreate(){
	        this.createdAt = new Date();
	    }
	    @PreUpdate
	    protected void onUpdate(){
	        this.updatedAt = new Date();
	    }
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name="user_id")
		private User users;
	    
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name="event_id")
		private Event event;


		public Message() {
			
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getComment() {
			return comment;
		}
		public void setComment(String comment) {
			this.comment = comment;
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
		public User getUsers() {
			return users;
		}
		public void setUsers(User users) {
			this.users = users;
		}
		public Event getEvent() {
			return event;
		}
		public void setEvent(Event event) {
			this.event = event;
		}
	    
		
	    
	    
}
