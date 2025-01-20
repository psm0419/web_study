package com.app.controller.study.quiz09;

import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDAO {
	public int registerCustomer(CustomerDTO customerDTO);
}
