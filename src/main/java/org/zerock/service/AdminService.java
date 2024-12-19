package org.zerock.service;

import java.util.List;

import org.zerock.domain.Criteria;
import org.zerock.domain.ReservationVO;
import org.zerock.domain.ReviewVO;
import org.zerock.domain.UsersVO;

public interface AdminService {

	// 雀盔包府
	public List<UsersVO> getListUsers(); // 蜡历格废 傈眉 炼雀

	public List<UsersVO> getUsersWithPaging(Criteria cri); // 蜡历格废 其捞隆 贸府

	// public List<UsersVO> searchTest(Map<String, Map<String, String>> map);
	public int getTotalCount(Criteria cri); // 蜡历

	public UsersVO getUserInfoByUno(long uno); //

	// 府轰包府
	public List<ReviewVO> getListReview();

	public List<ReviewVO> getReivewsWithPaging(Criteria cri);

	public int getTotalReviewCount(Criteria cri);

	public ReviewVO getReviewInfoBy(long review_id);

	// 抗概包府
	public List<ReservationVO> getListReservation();

	public List<ReservationVO> getThreeReservation();
	
	public List<ReservationVO> getReservationWithPaging(Criteria cri);

	public int getTotalReservationCount(Criteria cri);

	public ReservationVO getReservationInfoBy(long rno);
}
