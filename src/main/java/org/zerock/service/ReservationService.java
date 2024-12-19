package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.domain.ReservationVO;

@Service
public interface ReservationService {

	public List<ReservationVO> getAlldata(String user_id); // ���� ����Ʈ ��������

	public void insert(ReservationVO reser); // ���� ���� ����

	public List<String> getOne(int movie_id); // Ư�� ���� ��������

	public boolean delete(Long rno); // ���� ���
	
	public boolean Reservationdelete(String user_id);

	public int countReservation(); // �� ���� ��
	
	public int membercountReservation(String user_id);
	
	public int payupdate(Long rno); // ���� Ȯ��

}
