package com.tbc.courses.gui;

public class UserBoImpl implements UserBo{
	 
	String name;
 
	public void setName(String name) {
		this.name = name;
	}
 
	@Override
	public String getMessage() {
 
		return "JSF 2 + Spring Integration saying : " + name;
 
	}
 
}