package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.domain.ReservationVO;

@Service
public interface ReservationService {

	public List<ReservationVO> getAlldata(String user_id); // 예매 리스트 가져오기

	public void insert(ReservationVO reser); // 예매 내용 삽입

	public List<String> getOne(int movie_id); // 특정 예매 가져오기

	public boolean delete(Long rno); // 예매 취소
	
	public boolean Reservationdelete(String user_id);

	public int countReservation(); // 총 예매 수
	
	public int membercountReservation(String user_id);
	
	public int payupdate(Long rno); // 결제 확인

}
