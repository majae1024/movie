package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.Criteria;
import org.zerock.domain.ReservationVO;
import org.zerock.domain.ReviewVO;
import org.zerock.domain.UsersVO;

public interface AdminMapper {
	// public List<UsersVO> searchTest(Map<String, Map<String, String>> map);
	// 雀盔包府
	public List<UsersVO> getListUsers();

	public List<UsersVO> getSearchUsersWithPaging(Criteria cri);

	public int getTotalCount(Criteria cri);

	public UsersVO getUserInfoByUno(long uno);

	// 府轰包府
	public List<ReviewVO> getListReview();

	public List<ReviewVO> getSearchReivewsWithPaging(Criteria cri);

	public int getTotalReviewCount(Criteria cri);

	public ReviewVO getReviewInfoBy(long review_id);

	// 抗概 包府
	public List<ReservationVO> getListReservation();	
	
	public List<ReservationVO> getThreeReservation();

	public List<ReservationVO> getSearchReservationWithPaging(Criteria cri);

	public int getTotalReservationCount(Criteria cri);

	public ReservationVO getReservationInfoBy(long rno);
}
