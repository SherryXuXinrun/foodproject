package com.food.model;

import com.food.model.Order;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Food entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_food", catalog = "food")
public class Food implements java.io.Serializable {

	// Fields

	private Integer foodid;
	private String foodname;
	private Double unitprice;

	// Constructors

	/** default constructor */
	public Food() {
	}

	/** minimal constructor */
	public Food(Integer foodid, String foodname) {
		this.foodid = foodid;
		this.foodname = foodname;
	}

	/** full constructor */
	public Food(Integer foodid, String foodname, Double unitprice) {
		this.foodid = foodid;
		this.foodname = foodname;
		this.unitprice = unitprice;
	}

	// Property accessors
	@Id
	@Column(name = "foodid", unique = true, nullable = false)
	public Integer getFoodid() {
		return this.foodid;
	}

	public void setFoodid(Integer foodid) {
		this.foodid = foodid;
	}

	@Column(name = "foodname", nullable = false, length = 40)
	public String getFoodname() {
		return this.foodname;
	}

	public void setFoodname(String foodname) {
		this.foodname = foodname;
	}

	@Column(name = "unitprice", precision = 22, scale = 0)
	public Double getUnitprice() {
		return this.unitprice;
	}

	public void setUnitprice(Double unitprice) {
		this.unitprice = unitprice;
	}


}