package org.zerock.domain;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;


@Data
public class UsersVO implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long uno;
	private String user_id;
	private String user_pw;
	private String user_name;
	private String birth;
	private Date regdate;
	private Date updatedate;
	private String role;
}
