package org.zerock.service;

import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class MovieService {

	 public String convertCertification(String certification) {
	        switch (certification) {
	            case "ALL":
	                return "��ü�̿밡";
	            case "12":
	                return "12���̿밡";
	            case "15":
	                return "15���̿밡";
	            case "19":
	                return "19���̿밡";
	            default:
	                return "��������";
	        }
	}
	
}
