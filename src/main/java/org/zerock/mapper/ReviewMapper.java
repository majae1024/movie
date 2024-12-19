package org.zerock.mapper;

import java.util.List;


import org.zerock.domain.ReviewVO;

public interface ReviewMapper {
	
	public List<ReviewVO> getAllReviews(int movie_id); // 모든 리뷰 조회
	
	public void insert(ReviewVO review); // 리뷰 쓰기
	
	public ReviewVO read(Long review_id); // 리뷰 가져오기
	
	public int delete(Long review_id);	// 리뷰 삭제
	
	public int reviewdelete(String user_id); // 특정 유저 리뷰 전부 삭제

	public int update(ReviewVO review);	// 리뷰 수정
	
	public int report(ReviewVO review); // 리뷰 신고 값 변경
	
	public int countReview(); // 신고 리뷰 수

}