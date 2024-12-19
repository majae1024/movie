package org.zerock.mapper;

import java.util.List;


import org.zerock.domain.ReviewVO;

public interface ReviewMapper {
	
	public List<ReviewVO> getAllReviews(int movie_id); // ��� ���� ��ȸ
	
	public void insert(ReviewVO review); // ���� ����
	
	public ReviewVO read(Long review_id); // ���� ��������
	
	public int delete(Long review_id);	// ���� ����
	
	public int reviewdelete(String user_id); // Ư�� ���� ���� ���� ����

	public int update(ReviewVO review);	// ���� ����
	
	public int report(ReviewVO review); // ���� �Ű� �� ����
	
	public int countReview(); // �Ű� ���� ��

}