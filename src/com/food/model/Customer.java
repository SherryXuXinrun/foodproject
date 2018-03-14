package com.food.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Customer entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_customer", catalog = "food")
public class Customer implements java.io.Serializable {

	// Fields

	private Integer customerid;
	private String name;
	private String address;
	private String password;

	// Constructors

	/** default constructor */
	public Customer() {
	}

	/** minimal constructor */
	public Customer(Integer customerid, String name) {
		this.customerid = customerid;
		this.name = name;
	}

	/** full constructor */
	public Customer(Integer customerid, String name, String address) {
		this.customerid = customerid;
		this.name = name;
		this.address = address;
		this.password = password;
	}

	// Property accessors
	@Id
	@Column(name = "customerid", unique = true, nullable = false)
	public Integer getCustomerid() {
		return this.customerid;
	}

	public void setCustomerid(Integer customerid) {
		this.customerid = customerid;
	}

	@Column(name = "name", nullable = false, length = 20)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "address", length = 40)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "password", length = 16)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}