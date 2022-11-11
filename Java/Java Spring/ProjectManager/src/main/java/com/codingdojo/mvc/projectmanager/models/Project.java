package com.codingdojo.mvc.projectmanager.models;

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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="projects")

public class Project {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull(message="Title  must be provided")
	@Size(min = 5 , max = 20,message="Title  must be at least 5 characters.")
	private String title ;
	@NotNull
	@Size(min = 3,message="Description  must be at least 3 characters.")
	private String description ;
    @Future
    @DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dueDate;
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
    @JoinColumn(name="team_lead")
	private User user;
	
	
	@Column(updatable=false)
    @OneToMany(mappedBy="projects", fetch = FetchType.LAZY)
    private List<Task> projecttasks;
	

	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "project_users", 
        joinColumns = @JoinColumn(name = "project_id"), 
        inverseJoinColumns = @JoinColumn(name = "user_id")
    )     
    private List<User> users;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<User> getProjects() {
		return users;
	}
	public void setProjects(List<User> projects) {
		this.users = projects;
	}
	public List<Task> getProjecttasks() {
		return projecttasks;
	}
	public void setProjecttasks(List<Task> projecttasks) {
		this.projecttasks = projecttasks;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	
}
