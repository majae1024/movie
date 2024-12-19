package org.zerock.mapper;

import java.util.List;
import java.util.Map;

import org.zerock.domain.Criteria;
import org.zerock.domain.NoticeVO;

public interface NoticeMapper {
	
	public void noticeInsert(NoticeVO vo);

	public List<NoticeVO> getListNoticeWithPaging(Criteria cri);

	public NoticeVO getOneByNno(long nno);
	
	public int noticeDelete(long nno);

	public int noticeUpdate(NoticeVO notice);

	public int countNotice();
	
	public List<Map<String, String>> getTextByShowNotice(String show_notice);
}
