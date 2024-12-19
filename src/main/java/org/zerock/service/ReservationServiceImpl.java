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
	
	
	@Override // Ư�� ������ ���� ���� ��������
	public List<ReservationVO> getAlldata(String user_id) {
		// TODO Auto-generated method stub
		return mapper.getAlldata(user_id);
	}
	
	@Override // �¼� �����ϱ�
	public void insert(ReservationVO reser) {
		// TODO Auto-generated method stub
		mapper.insert(reser);
	}
	
	@Override // Ư�� ��ȭ�� ���ŵ� �¼� ���� ��������
	public List<String> getOne(int movie_id) {
		// TODO Auto-generated method stub
		return mapper.getOne(movie_id);
	}

	@Override // ���ų��� ���
	public boolean delete(Long rno) {
		log.info("���� ���: " + rno);
		return mapper.delete(rno) == true;
	}
	
	@Override // ���ų��� ���
	public boolean Reservationdelete(String user_id) {
		log.info("���� ���: " + user_id);
		return mapper.Reservationdelete(user_id) == true;
	}
	
	@Override // �� ���� ���� ��
	public int membercountReservation(String user_id) {
		// TODO Auto-generated method stub
		return mapper.membercountReservation(user_id);
	}
	
	@Override // �� ���� ���� ��
	public int countReservation() {
		// TODO Auto-generated method stub
		return mapper.countReservation();
	}
	
	@Override // ���� Ȯ��
	public int payupdate(Long rno) {
		// TODO Auto-generated method stub
		return mapper.payupdate(rno);
	}
}
