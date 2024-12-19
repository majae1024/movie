package org.zerock.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.zerock.domain.Criteria;
import org.zerock.domain.NoticeVO;

public interface NoticeService {
	public void register(NoticeVO vo);

	public List<NoticeVO> getList(Criteria cri);

	public NoticeVO read(long nno);
	
	public int delete(long nno);

	public int update(NoticeVO notice);

	public int countAll();
	
	public List<Map<String, String>> getText(String show_notice);

}
