package com.app.scheduler;

import java.time.LocalDate;

import org.springframework.scheduling.annotation.Scheduled;

public class MyScheduler {
	
//	@Scheduled(cron = "0/5 * * * * *")
	@Scheduled(cron = "* * 3 * * *")
	public void schedule() {
		System.out.println("schedule"+ LocalDate.now());
		
		//api 요청
		//외부 공공데이터 API 요청 -> Service 데이터 획득
		
		//api 요청 데이터 DB 저장
		//apidata 테이블 -> insert 저장(apidataDAO)
	}
}
