package com.codingdojo.mvc.event.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="evnets")
public class Event {

	
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    @NotEmpty(message="name is required!")
	    @Size(min=3, max=30, message="name must be between 3 and 30 characters")
	    private String name;
	    
	    @Future
	    @DateTimeFormat(pattern="yyyy-MM-dd")
		private Date dueDate;
	    
	    @NotNull
	    private String state;
	    
	    @NotNull
	    private String location;
	    
	    
	
	    private Double avgRate;
	    
	    
	    private Integer capcity;
	    
		@ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name="event_host")
		private User user;


		public Long getId() {
			return id;
		}


		public void setId(Long id) {
			this.id = id;
		}


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


		public Date getDueDate() {
			return dueDate;
		}


		public void setDueDate(Date dueDate) {
			this.dueDate = dueDate;
		}


		public String getState() {
			return state;
		}


		public void setState(String state) {
			this.state = state;
		}


		public String getLocation() {
			return location;
		}


		public void setLocation(String location) {
			this.location = location;
		}


		public User getUser() {
			return user;
		}


		public void setUser(User user) {
			this.user = user;
		}


		public Event() {
			super();
		}
		
		
		 @ManyToMany(fetch = FetchType.LAZY)
	     @JoinTable(
	         name = "event_users", 
	         joinColumns = @JoinColumn(name = "event_id"), 
	         inverseJoinColumns = @JoinColumn(name = "user_id")
	     )     
	    private List<User> users;


		public List<User> getUsers() {
			return users;
		}


		public void setUsers(List<User> users) {
			this.users = users;
		}
		
		
	    @OneToMany(mappedBy="event", fetch = FetchType.LAZY)
	    private List<Message> me;


		public List<Message> getMe() {
			return me;
		}


		public void setMe(List<Message> me) {
			this.me = me;
		}
		
		 @ManyToMany(fetch = FetchType.LAZY)
	     @JoinTable(
	         name = "events_rate", 
	         joinColumns = @JoinColumn(name = "event_id"), 
	         inverseJoinColumns = @JoinColumn(name = "user_id")
	     ) 
		 private List<User> userRate;


		public List<User> getUserRate() {
			return userRate;
		}


		public void setUserRate(List<User> userRate) {
			this.userRate = userRate;
		}


		public Double getAvgRate() {
			return avgRate;
		}


		public void setAvgRate(Double avgRate) {
			this.avgRate = avgRate;
		}


		public Integer getCapcity() {
			return capcity;
		}


		public void setCapcity(Integer capcity) {
			this.capcity = capcity;
		}
		 
		 
}
