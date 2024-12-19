package org.zerock.domain;

import java.util.Date;
import lombok.Data;

@Data
public class ReviewVO {
    private Long review_id;  		 // REVIEW_ID
    
    private String user_id;			 // USER_ID
    
    private String user_name;		 // USER_NAME
    
    private int movie_id; 			 // MOVIE_ID
    
    private String movie_name;		 // MOVIE_NAME
    
    private Long review_rating;   	 // REVIEW_RATING
    
    private String review_text;      // REVIEW_TEXT
    
    private Date review_date; 		 // REVIEW_DATE
    
    private Date review_update; 	 // REVIEW_UPDATE
    
    private int review_report;		 // REVIEW_REPORT
}
