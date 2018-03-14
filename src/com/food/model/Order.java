package com.food.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Order entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_order", catalog = "food")
public class Order implements java.io.Serializable {

	// Fields

	private Integer orderid;
	private Customer customer;
	private Food food;
	private Integer foodnum;
	private Double total;

	// Constructors

	/** default constructor */
	public Order() {
	}

	/** minimal constructor */
	public Order(Integer orderid) {
		this.orderid = orderid;
	}

	/** full constructor */
	public Order(Integer orderid, Customer customer, Food food,
			Integer foodnum, Double total) {
		this.orderid = orderid;
		this.customer = customer;
		this.food = food;
		this.foodnum = foodnum;
		this.total = total;
	}

	// Property accessors
	@Id
	@Column(name = "orderid", unique = true, nullable = false)
	public Integer getOrderid() {
		return this.orderid;
	}

	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer")
	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "food")
	public Food getFood() {
		return this.food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	@Column(name = "foodnum")
	public Integer getFoodnum() {
		return this.foodnum;
	}

	public void setFoodnum(Integer foodnum) {
		this.foodnum = foodnum;
	}

	@Column(name = "total", precision = 22, scale = 0)
	public Double getTotal() {
		return this.total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

}