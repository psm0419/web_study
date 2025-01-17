package com.app.controller.study.bean;

import lombok.Data;

@Data
public class PlateBean {
	DessertBean dessertBean;
	
	public void setDessertBean(DessertBean dessertBean) {
		this.dessertBean = dessertBean;
	}
}
