package org.zerock.domain;

import lombok.Data;

@Data
public class ReservationVO {
	
	private Long rno;
	
	private String user_id;
	
	private String user_name;
	
	private int movie_id;
	
	private String movie_name;
	
	private String movie_img;
	
	private String seat_info;
	
	private int price;
	
	private int reser_pay;

}
