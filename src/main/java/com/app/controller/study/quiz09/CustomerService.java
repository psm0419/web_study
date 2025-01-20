package com.app.controller.study.quiz09;

import org.springframework.stereotype.Service;


@Service
public interface CustomerService {

	public int registerCustomer(CustomerDTO customerDTO);
}
