package com.app.controller.study.quiz09;

import lombok.Data;

@Data
public class Quiz09CustomerDTO {
     String name;
     int age;
     String phone;
     
	public Quiz09CustomerDTO(String name, int age, String phone) {
		super();
		this.name = name;
		this.age = age;
		this.phone = phone;
	}
     
     
}
