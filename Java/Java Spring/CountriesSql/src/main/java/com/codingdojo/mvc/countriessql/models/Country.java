package com.codingdojo.mvc.countriessql.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;



@Entity
@Table(name="countries")
public class Country {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id", nullable = false)
	    private Long id;

	    @NotNull
	    private String code;

	    @NotNull
	    private String name;


	    @NotNull
	    private String region;

	    @NotNull
	    private double surfaceArea;

	    @NotNull
	    private short indepYear;

	    @NotNull
	    private int population;

	    @NotNull
	    private double lifeExpectancy;

	    @NotNull
	    private double gnp;

	    @NotNull
	    private double gnpOld;
	    
	    
	    
	    @NotNull
	    private enum continent {
	        Asia, Africa, NorthAmerica, SouthAmerica, Antarctica, Europe, Australia
	    };
	    
	    @NotNull
	    private String localName;

	    @NotNull
	    private String govermentForm;

	    @NotNull
	    private String headOfState;

	    @NotNull
	    private int capital;

	    @NotNull
	    private String code2;

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

		@Column(updatable=false)
	    @OneToMany(mappedBy="country", fetch = FetchType.LAZY)
	    private List<City> cities;
		
		@Column(updatable=false)
	    @OneToMany(mappedBy="language", fetch = FetchType.LAZY)
	    private List<Languages> language;
		
		
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getRegion() {
			return region;
		}
		public void setRegion(String region) {
			this.region = region;
		}
		public double getSurfaceArea() {
			return surfaceArea;
		}
		public void setSurfaceArea(double surfaceArea) {
			this.surfaceArea = surfaceArea;
		}
		public short getIndepYear() {
			return indepYear;
		}
		public void setIndepYear(short indepYear) {
			this.indepYear = indepYear;
		}
		public int getPopulation() {
			return population;
		}
		public void setPopulation(int population) {
			this.population = population;
		}
		public double getLifeExpectancy() {
			return lifeExpectancy;
		}
		public void setLifeExpectancy(double lifeExpectancy) {
			this.lifeExpectancy = lifeExpectancy;
		}
		public double getGnp() {
			return gnp;
		}
		public void setGnp(double gnp) {
			this.gnp = gnp;
		}
		public double getGnpOld() {
			return gnpOld;
		}
		public void setGnpOld(double gnpOld) {
			this.gnpOld = gnpOld;
		}
		public String getLocalName() {
			return localName;
		}
		public void setLocalName(String localName) {
			this.localName = localName;
		}
		public String getGovermentForm() {
			return govermentForm;
		}
		public void setGovermentForm(String govermentForm) {
			this.govermentForm = govermentForm;
		}
		public String getHeadOfState() {
			return headOfState;
		}
		public void setHeadOfState(String headOfState) {
			this.headOfState = headOfState;
		}
		public int getCapital() {
			return capital;
		}
		public void setCapital(int capital) {
			this.capital = capital;
		}
		public String getCode2() {
			return code2;
		}
		public void setCode2(String code2) {
			this.code2 = code2;
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
		public List<City> getCities() {
			return cities;
		}
		public void setCities(List<City> cities) {
			this.cities = cities;
		}
		public Country() {
			super();
		}
		public List<Languages> getLanguage() {
			return language;
		}
		public void setLanguage(List<Languages> language) {
			this.language = language;
		}
		
		
		
	
}
