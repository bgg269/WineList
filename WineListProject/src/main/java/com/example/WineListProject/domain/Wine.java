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
	private long id;

	private String name, region;
	private Integer year, price;
	private double alcohol;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "categoryid")
	private Category category;


	public Wine() {}
	
	public Wine(String name, String region, Integer year, Integer price, double alcohol, Category category) {
		super();
		this.price = price;
		this.category = category;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public double getAlcohol() {
		return alcohol;
	}

	public void setAlcohol(double alcohol) {
		this.alcohol = alcohol;
	}
	
	@Override
	public String toString() {
		if (this.category != null)
			return "Wine [id=" + id + ", name=" + name + ", type=" + region + ", year=" + year + ", alcohol=" + alcohol
					+ ", price=" + price + "category= " + this.getCategory() + "]";
		else

			return "Wine [id=" + id + ", name=" + name + ", type=" + region + ", year=" + year + ", alcohol=" + alcohol
					+ ", price=" + price + "]";
	}

}
