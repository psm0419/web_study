package com.app.dto.study.api;

import com.app.dto.api.ApiResponseHeader;

import lombok.Data;

@Data
public class ApiResponseDelivery {

	ApiResponseHeader header;
	ApiDelivery body; //data 라고 쓰기도 함
}
