package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReservationVO;
import org.zerock.domain.ReviewVO;
import org.zerock.domain.UsersVO;
import org.zerock.mapper.AdminMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminMapper mapper;

	/************** User **************/
	@Override
	public List<UsersVO> getListUsers() {
		// TODO Auto-generated method stub
		return mapper.getListUsers();
	}

	@Override
	public List<UsersVO> getUsersWithPaging(Criteria cri) {
		// TODO Auto-generated method stub
		return mapper.getSearchUsersWithPaging(cri);
	}

	@Override
	public int getTotalCount(Criteria cri) {
		// TODO Auto-generated method stub
		return mapper.getTotalCount(cri);
	}

	@Override
	public UsersVO getUserInfoByUno(long uno) {
		// TODO Auto-generated method stub
		return mapper.getUserInfoByUno(uno);
	}
	
	/************** Review **************/
	@Override
	public List<ReviewVO> getListReview() {
		
		return mapper.getListReview();
	}

	@Override
	public List<ReviewVO> getReivewsWithPaging(Criteria cri) {
		
		return mapper.getSearchReivewsWithPaging(cri);
	}
	
	@Override
	public int getTotalReviewCount(Criteria cri) {
		
		return mapper.getTotalReviewCount(cri);
	}
	
	@Override
	public ReviewVO getReviewInfoBy(long review_id) {
		
		return mapper.getReviewInfoBy(review_id);
	}
	
	/************** Reservation **************/
	@Override
	public List<ReservationVO> getListReservation() {
		
		return mapper.getListReservation();
	}

	@Override
	public List<ReservationVO> getReservationWithPaging(Criteria cri) {
		
		return mapper.getSearchReservationWithPaging(cri);
	}
	
	@Override
	public int getTotalReservationCount(Criteria cri) {
		
		return mapper.getTotalReservationCount(cri);
	}
	
	@Override
	public ReservationVO getReservationInfoBy(long rno) {
		
		return mapper.getReservationInfoBy(rno);
	}

	@Override
	public List<ReservationVO> getThreeReservation() {
		
		return mapper.getThreeReservation();
	}
	
	
	
}
