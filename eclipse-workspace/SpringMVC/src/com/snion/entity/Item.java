package com.snion.entity;

import java.util.Date;

public class Item {
	
	private Integer id;
	private String name;
	private Integer price;
	private String detail;
	private Date creattime;
	
	public Item(Integer id, String name, Integer price, Date creattime, String detail) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.detail = detail;
		this.creattime = creattime;
	}
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public Date getCreattime() {
		return creattime;
	}
	public void setCreattime(Date creattime) {
		this.creattime = creattime;
	}

	
}
