package org.zerock.domain;

import java.util.Date;

import lombok.Data;
@Data
public class NoticeVO {
	
	private Long nno;
	private String title;
	private String notice_text;
	private String user_name;
	private String show_notice;
	private Date regdate;
	private Date updatedate;
}
