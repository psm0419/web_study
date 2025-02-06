package com.app.dto.user;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class User {

//	public static final String USERTYPE_CUSTOMER = "CUS";
//	public static final String USERTYPE_ADMIN = "ADM";
	@NotBlank(message="이거 필수 입력이라니까")
	String id;
	
	@NotBlank
	@Size(min =8, max=12, message="8자리 이상 쓰고 12자리까지만 가능")
	String pw;
	String name;
	String userType;
	
//	@Email
}
