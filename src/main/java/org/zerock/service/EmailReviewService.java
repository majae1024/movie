package org.zerock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.ReviewVO;
import org.zerock.domain.UsersVO;

import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class EmailReviewService {

	@Autowired
	private EmailService emailService;

	@Autowired
	private UsersService userService;

	@Autowired
	private ReviewService reviewService;

	public void deleteReview(long reviewId) {
		ReviewVO review = reviewService.get(reviewId);
		log.info("삭제하려는 리뷰 정보: " + review);

		if (review == null) {
			throw new IllegalArgumentException("리뷰 정보를 찾을 수 없습니다.");
		}

		UsersVO user = userService.getOne(review.getUser_id());
		if (user == null) {
			throw new IllegalArgumentException("유저 정보를 찾을 수 없습니다.");
		}

		String subject = "[영화 어때 관리자] : 신고 접수된 리뷰 검토완료";
		String body = user.getUser_name() + "님, 해당 리뷰가 신고 접수되어 관리자 검토 후 삭제되었습니다." 
					+"<br>--------------------------------"
					+ "<br><br>삭제된 리뷰 내용: " + review.getReview_text() 
					+ "<br><br>추가적인 신고 누적으로 인해 회원 계정이 영구 삭제될 수 있으니 주의하시기 바랍니다.";

		emailService.sendEmail(user.getUser_id(), subject, body);
		log.info(body);

		reviewService.remove(reviewId);
	}
}
