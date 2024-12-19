package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.domain.ReviewVO;

@Service
public interface ReviewService {
	
	public void register(ReviewVO review); // ���� �ۼ�
	
	public ReviewVO get(Long review_id);  // Ư�� ����ID ��������
	
	public boolean modify(ReviewVO review); // ���� ����
	
	public boolean Reviewreport(ReviewVO review); // ���� �Ű�

	public boolean remove(Long review_id); // ���� ����
	
	public boolean reviewdelete(String user_id); // Ư�� ���� ���� ���� ����

	public List<ReviewVO> getAllReviews(int movie_id); // ��� ���� ��ȸ
	
	public int countReview();

}