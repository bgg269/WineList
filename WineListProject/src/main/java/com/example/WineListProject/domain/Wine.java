package com.example.WineListProject.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Wine {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name, region, review;
	private Integer year;
	private double price, alcohol;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "categoryid")
	private Category category;

	//Constructors
	public Wine() {}
	
	public Wine(String name, String region, Integer year, double price, double alcohol, Category category, String review) {
		super();
		this.name = name;
		this.region = region;
		this.year = year;
		this.price = price;
		this.alcohol = alcohol;
		this.category = category;
		this.review = review;
		
	}
	
	//Getters and setters:

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

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public double getAlcohol() {
		return alcohol;
	}

	public void setAlcohol(double alcohol) {
		this.alcohol = alcohol;
	}
	
	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		if (this.category != null)
			return "Wine [id=" + id + ", name=" + name + ", region=" + region + ", review=" + review + ", year=" + year
				+ ", price=" + price + ", alcohol=" + alcohol + ", category=" + this.getCategory() + "]";
		else
			return "Wine [id=" + id + ", name=" + name + ", region=" + region + ", review=" + review + ", year=" + year
					+ ", price=" + price + ", alcohol=" + alcohol + "]";
	}
	
	

	

}
