package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.domain.ReviewVO;

@Service
public interface ReviewService {
	
	public void register(ReviewVO review); // 리뷰 작성
	
	public ReviewVO get(Long review_id);  // 특정 리뷰ID 가져오기
	
	public boolean modify(ReviewVO review); // 리뷰 수정
	
	public boolean Reviewreport(ReviewVO review); // 리뷰 신고

	public boolean remove(Long review_id); // 리뷰 삭제
	
	public boolean reviewdelete(String user_id); // 특정 유저 리뷰 전부 삭제

	public List<ReviewVO> getAllReviews(int movie_id); // 모든 리뷰 조회
	
	public int countReview();

}