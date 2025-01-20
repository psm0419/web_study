package com.app.controller.study.quiz09;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Quiz09CustomerServiceImpl implements Quiz09CustomerService{
	
	@Autowired
	Quiz09CustomerDAO customerDAO;

    @Override
    public int registerCustomer(Quiz09CustomerDTO customerDTO) {
    	//컨트롤러 -> quizcustomer 객체 저장해줘
    	//받은 데이터로 저장 -> 결과 리턴
        System.out.println("고객 등록 서비스 시작");
        int result = customerDAO.registerCustomer(customerDTO);
        System.out.println("고객 등록 서비스 완료");
        
        return result;
    }

}
