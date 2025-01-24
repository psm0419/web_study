package com.app.dto.study.api;

import java.util.List;

import lombok.Data;

@Data
public class ApiDelivery {
	String staffName; //배달기사 이름
	String detination; //배달 목적지
	String phone; //배달기사 번호
	
	ApiStore apistore;
	List<ApiMenu> menuList;
}
