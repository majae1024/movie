package org.zerock.service;

import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class MovieService {

	 public String convertCertification(String certification) {
	        switch (certification) {
	            case "ALL":
	                return "전체이용가";
	            case "12":
	                return "12세이용가";
	            case "15":
	                return "15세이용가";
	            case "19":
	                return "19세이용가";
	            default:
	                return "정보없음";
	        }
	}
	
}
