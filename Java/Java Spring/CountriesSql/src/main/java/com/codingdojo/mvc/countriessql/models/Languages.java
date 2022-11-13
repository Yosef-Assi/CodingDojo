package com.codingdojo.mvc.countriessql.models;

import java.util.Date;

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
@Table(name="languages")
public class Languages {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	 @NotEmpty(message="language is required!")
	 @Size(min=3, max=30, message="language must be between 3 and 30 characters")
	    private Character language;
	 @NotEmpty(message="code is required!")
	 @Size(min=1, max=4, message="code must be between 1 and 3 characters")
	 private Character code;
	 @NotEmpty(message="percentage is required!")
	 @Size(min=1, max=4, message="percentage must be between 1 and 3 characters")
	 private Float percentage;
	 @NotEmpty(message="official is required!")
	 @Size(min=1, max=4, message="official must be between 1 and 3 characters")
	 private String official;
	   
	 	@ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name="country_id")
		private Country country ;
//-----------------------------------------------------------------
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
	public Languages() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Character getLanguage() {
		return language;
	}

	public void setLanguage(Character language) {
		this.language = language;
	}

	public Character getCode() {
		return code;
	}

	public void setCode(Character code) {
		this.code = code;
	}

	public Float getPercentage() {
		return percentage;
	}

	public void setPercentage(Float percentage) {
		this.percentage = percentage;
	}

	public String getOfficial() {
		return official;
	}

	public void setOfficial(String official) {
		this.official = official;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	
}