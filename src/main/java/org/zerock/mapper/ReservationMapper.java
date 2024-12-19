package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.ReservationVO;

public interface ReservationMapper {
	
	public List<ReservationVO> getAlldata(String user_id); // ���� ����Ʈ ��������
	
	public void insert(ReservationVO reser); // ���� ���� ����
	
	public List<String> getOne(int movie_id); // Ư�� ���� ��������
	
	public boolean delete(Long rno); // ���� ���
	
	public boolean Reservationdelete(String user_id); // Ư�� ���� ���� ���
	
	public int countReservation(); // �� ���� ��
	
	public int membercountReservation(String user_id);
	
	public int payupdate(Long rno); // ���� Ȯ��
}
