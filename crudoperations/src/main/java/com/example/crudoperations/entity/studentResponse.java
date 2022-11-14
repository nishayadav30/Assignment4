package com.example.crudoperations.entity;

import java.util.List;

public class studentResponse {

	public String message;
	public List<Student> list;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<Student> getList() {
		return list;
	}
	public void setList(List<Student> list) {
		this.list = list;
	}
	
}
