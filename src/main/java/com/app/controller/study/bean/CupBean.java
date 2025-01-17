package com.app.controller.study.bean;

import lombok.Data;

@Data
public class CupBean {

	CoffeeBean coffeeBean;
	
	public CupBean(CoffeeBean coffeeBean) {
		this.coffeeBean = coffeeBean;
	}
}


