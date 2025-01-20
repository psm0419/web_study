package com.app.controller.study.quiz09;

import org.springframework.stereotype.Repository;

@Repository
public class CustomerDAOImpl implements CustomerDAO{

	public int registerCustomer(CustomerDTO customerDTO) {
		//DB 저장
        System.out.println("고객 정보 등록: " + customerDTO.getName() + ", " + customerDTO.getAge() + ", " + customerDTO.getPhone());
        return 1;
    }
}
