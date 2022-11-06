package com.codingdojo.mvc.languages.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="Language")
public class language {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
@NotNull
@Size(min = 2 , max = 20,message="name must be at least 2 characters.")
private String name;
@NotNull
@Size(min = 2 , max = 20,message="creator must be at least 2 characters.")
private String creator;
@NotNull(message="version not must be null")
@Min(value=0,message="version must be at least 1")
private Double version;

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

public language() {
	
}
public language(Long id, @NotNull @Size(min = 2, max = 20, message = "name must be at least 2 characters.") String name,
		@NotNull @Size(min = 2, max = 20, message = "creator must be at least 2 characters.") String creator,
		@NotNull(message = "version not must be null") @Min(value = 0, message = "version must be at least 1") Double version) {
	super();
	this.id = id;
	this.name = name;
	this.creator = creator;
	this.version = version;
}
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
public String getCreator() {
	return creator;
}
public void setCreator(String creator) {
	this.creator = creator;
}
public Double getVersion() {
	return version;
}
public void setVersion(Double version) {
	this.version = version;
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



}
