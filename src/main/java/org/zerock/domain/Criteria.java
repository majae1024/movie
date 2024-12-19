package org.zerock.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class Criteria {
	  private int pageNum;    // 페이지 번호
	  private int amount;      // 페이지당 보여줄 개수
	  private String type;
	  private String keyword;
	 
	  public Criteria() {
	    this(1, 10);   // 디폴트로 1페이지에 10개씩 보여주도록 설정
	  }

	  public Criteria(int pageNum, int amount) {
	    this.pageNum = pageNum;
	    this.amount = amount;
	  }
	
	  public String[] getTypeArr() {
		  return type == null? new String[] {} : type.split("");
	  }
	  
	  
}