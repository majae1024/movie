package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.mapper.ReservationMapper;
import org.zerock.domain.ReservationVO;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class ReservationServiceImpl implements ReservationService {
	
	@Autowired 
	private ReservationMapper mapper;
	
	
	@Override // 특정 유저의 예매 내역 가져오기
	public List<ReservationVO> getAlldata(String user_id) {
		// TODO Auto-generated method stub
		return mapper.getAlldata(user_id);
	}
	
	@Override // 좌석 예매하기
	public void insert(ReservationVO reser) {
		// TODO Auto-generated method stub
		mapper.insert(reser);
	}
	
	@Override // 특정 영화의 예매된 좌석 정보 가져오기
	public List<String> getOne(int movie_id) {
		// TODO Auto-generated method stub
		return mapper.getOne(movie_id);
	}

	@Override // 예매내역 취소
	public boolean delete(Long rno) {
		log.info("예매 취소: " + rno);
		return mapper.delete(rno) == true;
	}
	
	@Override // 예매내역 취소
	public boolean Reservationdelete(String user_id) {
		log.info("예매 취소: " + user_id);
		return mapper.Reservationdelete(user_id) == true;
	}
	
	@Override // 총 예매 내역 수
	public int membercountReservation(String user_id) {
		// TODO Auto-generated method stub
		return mapper.membercountReservation(user_id);
	}
	
	@Override // 총 예매 내역 수
	public int countReservation() {
		// TODO Auto-generated method stub
		return mapper.countReservation();
	}
	
	@Override // 결제 확인
	public int payupdate(Long rno) {
		// TODO Auto-generated method stub
		return mapper.payupdate(rno);
	}
}
