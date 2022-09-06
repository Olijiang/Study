package com.snion.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("User")
public class User {
	@Value("1")
	private Integer uid;
	@Value("�¶�")
	private String name;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(Integer uid, String name) {
		super();
		this.uid = uid;
		this.name = name;
	}
	
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", name=" + name + "]";
	}
	
}