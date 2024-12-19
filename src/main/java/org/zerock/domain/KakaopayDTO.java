package org.zerock.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class KakaopayDTO {
	private String userId;
	private String movieName;
	private int quantity;
	private int price;
	private String partner_order_id;
	private String tid;              
    private String pgToken;         
    
    @Builder
    public KakaopayDTO(String userId, String movieName, int quantity, int price, String partner_order_id, String tid, String pgToken) {
        this.userId = userId;
        this.movieName = movieName;
        this.quantity = quantity;
        this.price = price;
        this.partner_order_id = partner_order_id;
        this.tid = tid;
        this.pgToken = pgToken;
    }
}
