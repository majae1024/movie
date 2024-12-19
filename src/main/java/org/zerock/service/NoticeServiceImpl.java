package org.zerock.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.Criteria;
import org.zerock.domain.NoticeVO;
import org.zerock.mapper.NoticeMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
@Log4j
@Service
@AllArgsConstructor
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	NoticeMapper mapper;
	
	@Override
	public void register(NoticeVO vo) {
		// TODO Auto-generated method stub
		mapper.noticeInsert(vo);
		log.info(vo);
	}


	@Override
	public NoticeVO read(long nno) {
		// TODO Auto-generated method stub
		
		return mapper.getOneByNno(nno);
	}

	@Override
	public int delete(long nno) {
		// TODO Auto-generated method stub
		return mapper.noticeDelete(nno);
	}

	@Override
	public int update(NoticeVO notice) {
		// TODO Auto-generated method stub
		return mapper.noticeUpdate(notice);
	}

	@Override
	public int countAll() {
		// TODO Auto-generated method stub
		return mapper.countNotice();
	}


	@Override
	public List<NoticeVO> getList(Criteria cri) {
		// TODO Auto-generated method stub
		return mapper.getListNoticeWithPaging(cri);
	}


	@Override
	public List<Map<String, String>> getText(String show_notice) {
		// TODO Auto-generated method stub
		return mapper.getTextByShowNotice(show_notice);
	}


}
