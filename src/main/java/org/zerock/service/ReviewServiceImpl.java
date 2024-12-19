package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.ReviewVO;
import org.zerock.mapper.ReviewMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private ReviewMapper mapper;

	@Override
	public List<ReviewVO> getAllReviews(int movie_id) {
		List<ReviewVO> reviews = mapper.getAllReviews(movie_id);

		for (ReviewVO review : reviews) {
			if (review.getUser_name() == null) {
				review.setUser_name("Unknown");
			}
		}
		return reviews;
	}
	
	@Override
	public ReviewVO get(Long review_id) {
		log.info("get....." + review_id);
		return mapper.read(review_id);
	}

	@Override
	public boolean modify(ReviewVO review) {
		log.info("府轰 荐沥: " + review);
		return mapper.update(review) == 1;
	}

	@Override
	public boolean remove(Long review_id) {
		log.info("府轰 昏力: " + review_id);
		return mapper.delete(review_id) == 1;
	}
	
	@Override
	public boolean reviewdelete(String user_id) {
		log.info("府轰 昏力: " + user_id);
		return mapper.reviewdelete(user_id) == 1;
	}

	@Override
	public void register(ReviewVO review) {
		log.info("府轰 累己: " + review);
		mapper.insert(review);
	}

	@Override
	public boolean Reviewreport(ReviewVO review) {
		log.info("府轰 脚绊: " + review);
		return mapper.report(review) == 1;
	}
	
	@Override
	public int countReview() {
		// TODO Auto-generated method stub
		return mapper.countReview();
	};
		
}