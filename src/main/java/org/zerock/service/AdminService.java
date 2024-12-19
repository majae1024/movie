package org.zerock.service;

import java.util.List;

import org.zerock.domain.Criteria;
import org.zerock.domain.ReservationVO;
import org.zerock.domain.ReviewVO;
import org.zerock.domain.UsersVO;

public interface AdminService {

	// ȸ������
	public List<UsersVO> getListUsers(); // ������� ��ü ��ȸ

	public List<UsersVO> getUsersWithPaging(Criteria cri); // ������� ����¡ ó��

	// public List<UsersVO> searchTest(Map<String, Map<String, String>> map);
	public int getTotalCount(Criteria cri); // ����

	public UsersVO getUserInfoByUno(long uno); //

	// �������
	public List<ReviewVO> getListReview();

	public List<ReviewVO> getReivewsWithPaging(Criteria cri);

	public int getTotalReviewCount(Criteria cri);

	public ReviewVO getReviewInfoBy(long review_id);

	// ���Ű���
	public List<ReservationVO> getListReservation();

	public List<ReservationVO> getThreeReservation();
	
	public List<ReservationVO> getReservationWithPaging(Criteria cri);

	public int getTotalReservationCount(Criteria cri);

	public ReservationVO getReservationInfoBy(long rno);
}
