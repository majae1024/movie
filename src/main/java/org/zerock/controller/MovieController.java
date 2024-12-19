package org.zerock.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.domain.MovieInfoDTO;
import org.zerock.domain.ReservationVO;
import org.zerock.domain.ReviewVO;
import org.zerock.security.domain.CustomUser;
import org.zerock.service.MovieAgeChanger;
import org.zerock.service.NoticeService;
import org.zerock.service.ReservationService;
import org.zerock.service.ReviewService;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/movie/*")
@RequiredArgsConstructor
public class MovieController {

	@Autowired
	private MovieAgeChanger MovieAge;

	@Autowired
	private ReviewService reviewservice;

	@Autowired
	private ReservationService Reservationservice;
	
	@Autowired
	private NoticeService noticeService;

	// index
	@GetMapping("/index")
	public String home(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null && auth.getPrincipal() instanceof CustomUser) {
			CustomUser user = (CustomUser) auth.getPrincipal();
			log.info(user);
			model.addAttribute("isAuthenticated", true);
			model.addAttribute("userName", user.getUser().getUser_name());

		} else {
			model.addAttribute("isAuthenticated", false);
		}
		return "/movie/index"; // JSP 파일 이름
	}

	
	
	@GetMapping("/showNotices")
	public @ResponseBody ResponseEntity<List<Map<String, String>>> showNotices(HttpSession session) {
	    List<Map<String, String>> notices = noticeService.getText("1");
	    session.setAttribute("notices", notices); // 세션에 공지사항 목록 저장
	    log.info(notices);  // 공지사항 목록 로깅 (정보 레벨)
	    return ResponseEntity.ok(notices); // JSON 형태로 공지사항 목록 응답
	}

	@GetMapping("/showNoticePage")
	public String showNoticePage() {
	    return "/movie/showNotice"; // showNotice.jsp 페이지 이동
	}
	
	
	
	@PreAuthorize("isAuthenticated()")
	@PostMapping("/sub")
	public String goSubWithData(@ModelAttribute MovieInfoDTO movieInfoDTO, Model model, HttpSession session) {

		movieInfoDTO.setCertification(MovieAge.convertCertification(movieInfoDTO.getCertification()));
		System.out.println("연령등급 변경 후 : " + movieInfoDTO);
		// movie상세정보를 movie변수로 세션에 저장
		session.setAttribute("movie", movieInfoDTO);
		System.out.println("세션에 있는 movie : " + (MovieInfoDTO) session.getAttribute("movie"));

		// 이용자가 로그인한 유저인지 아님 익명의 유저인지 확인
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null && auth.getPrincipal() instanceof CustomUser) {
			CustomUser user = (CustomUser) auth.getPrincipal();
			log.info(user);
			model.addAttribute("isAuthenticated", true);
			model.addAttribute("userName", user.getUser().getUser_name());
			model.addAttribute("userId", user.getUser().getUser_id());
			model.addAttribute("userBirth", user.getUser().getBirth());
		} else {
			model.addAttribute("isAuthenticated", false);
		}

		List<ReviewVO> reviews = reviewservice.getAllReviews(movieInfoDTO.getMovieId());
		reviews.forEach(review -> log.info("Review Data: " + review));

		model.addAttribute("reviews", reviews); // 조회된 리뷰를 모델에 추가

		return "/movie/sub";
	}

	/****************** 리 뷰 시작 ******************/
	// 선택 영화 리뷰 조회
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/sub")
	public String listReviews(Model model, HttpSession session) {

		// 이용자가 로그인한 유저인지 아님 익명의 유저인지 확인
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null && auth.getPrincipal() instanceof CustomUser) {
			CustomUser user = (CustomUser) auth.getPrincipal();
			log.info(user);
			model.addAttribute("isAuthenticated", true);
			model.addAttribute("userName", user.getUser().getUser_name());
			model.addAttribute("userId", user.getUser().getUser_id());
		} else {
			model.addAttribute("isAuthenticated", false);
		}

		// movie상세정보를 세션에서 불러옴
		MovieInfoDTO movie = (MovieInfoDTO) session.getAttribute("movie");
		log.info("**************************************************************" + movie);
		int movie_id = movie.getMovieId();

		log.info("---------------Review List---------------");

		List<ReviewVO> reviews = reviewservice.getAllReviews(movie_id);
		log.info("******************************************************" + movie_id);
		reviews.forEach(review -> log.info("Review Data: " + review));

		model.addAttribute("reviews", reviews); // 조회된 리뷰를 모델에 추가
		model.addAttribute("movie", movie);

		return "/movie/sub";
	}

	// 리뷰 작성
	@PostMapping("/register")
	public String registerReview(@ModelAttribute ReviewVO reviewVO) {
		System.out.print("모달에서 전달받은 form정보" + reviewVO);

		log.info("등록 모달 -> 포스트 레지스터 지남");

		reviewservice.register(reviewVO);

		return "redirect:/movie/sub";
	}

	@GetMapping("/register")
	public void register() {

	}

	// 특정 리뷰 가져오기
	@GetMapping("/getReview")
	@ResponseBody
	public ResponseEntity<?> getReview(@RequestParam("review_id") Long review_id) {
		log.info("리뷰 수정 요청: " + review_id);

		var review = reviewservice.get(review_id);
		if (review == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("리뷰를 찾을 수 없습니다.");
		}

		return ResponseEntity.ok(review); // JSON 형식으로 반환
	}

	// 리뷰 수정
	@PostMapping("/modify")
	@ResponseBody
	public ResponseEntity<?> modify(@RequestBody ReviewVO review) {
		log.info("*********************리뷰 수정 요청: " + review);

		boolean isModified = reviewservice.modify(review);
		if (!isModified) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("수정 실패");
		}

		return ResponseEntity.ok("수정 성공");
	}

	// 리뷰 신고
	@PostMapping("/report")
	@ResponseBody
	public ResponseEntity<?> report(@RequestParam("review_id") Long review_id) {
		log.info("리뷰 신고 요청: " + review_id);

		var review = reviewservice.get(review_id);
		if (review == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("리뷰를 찾을 수 없습니다.");
		}

		boolean isReported = reviewservice.Reviewreport(review);
		if (!isReported) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("신고 처리 실패");
		}

		return ResponseEntity.ok("신고 성공");
	}

	// 리뷰 삭제
	@PostMapping("/remove")
	@ResponseBody
	public ResponseEntity<?> remove(@RequestParam("review_id") Long review_id) {
		log.info("리뷰 삭제 요청: " + review_id);

		boolean isRemoved = reviewservice.remove(review_id);
		if (!isRemoved) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("삭제 실패");
		}

		return ResponseEntity.ok("삭제 성공");
	}

	/****************** 리 뷰 끝 ******************/

	/****************** 더 많은 영화 ******************/
	@GetMapping("/more")
	public String goMorePage(Model model) {

		// 이용자가 로그인한 유저인지 아님 익명의 유저인지 확인
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null && auth.getPrincipal() instanceof CustomUser) {
			CustomUser user = (CustomUser) auth.getPrincipal();
			log.info(user);
			model.addAttribute("isAuthenticated", true);
			model.addAttribute("userName", user.getUser().getUser_name());
			model.addAttribute("userId", user.getUser().getUser_id());
			model.addAttribute("userBirth", user.getUser().getBirth());
		} else {
			model.addAttribute("isAuthenticated", false);
		}

		return "/movie/more";
	}

	/****************** 더 많은 영화 끝 ******************/

	/****************** 마 이 페 이 지 ******************/
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/mypage")
	public String goMyPage(Model model) {
		// 이용자가 로그인한 유저인지 아님 익명의 유저인지 확인
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null && auth.getPrincipal() instanceof CustomUser) {
			CustomUser user = (CustomUser) auth.getPrincipal();
			log.info(user);
			model.addAttribute("isAuthenticated", true);
			model.addAttribute("userName", user.getUser().getUser_name());
			model.addAttribute("userId", user.getUser().getUser_id());
			model.addAttribute("userBirth", user.getUser().getBirth());

			var user_id = user.getUser().getUser_id();

			List<ReservationVO> reserve = Reservationservice.getAlldata(user_id);
			log.info("******************************************************" + user_id);
			reserve.forEach(reser -> log.info("Review Data: " + reser));

			model.addAttribute("reserve", reserve); // 조회된 예매 내역을 모델에 추가

			int membercountReservation = Reservationservice.membercountReservation(user_id);

			model.addAttribute("membercountReservation", membercountReservation);

		} else {
			model.addAttribute("isAuthenticated", false);
		}

		return "/movie/mypage";
	}

	@GetMapping("/insert")
	public void insert() {

	}

	// 예매 정보 삭제
	@PostMapping("/delete")
	@ResponseBody
	public ResponseEntity<?> delete(@RequestBody Map<String, Long> payload) {
		Long rno = payload.get("rno"); // JSON에서 rno 추출
		log.info("리뷰 삭제 요청: " + rno);

		boolean isRemoved = Reservationservice.delete(rno);
		if (!isRemoved) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("삭제 실패");
		}

		return ResponseEntity.ok("예약 취소 성공");
	}

	/****************** 예매 ******************/
	// 예매 페이지로넘어가는거
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/reservation")
	public String reservePage(Model model, HttpSession session) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null && auth.getPrincipal() instanceof CustomUser) {
			CustomUser user = (CustomUser) auth.getPrincipal();
			log.info(user);
			model.addAttribute("isAuthenticated", true);
			model.addAttribute("userName", user.getUser().getUser_name());
			model.addAttribute("userId", user.getUser().getUser_id());
		}

		// movie상세정보를 세션에서 불러옴
		MovieInfoDTO movie = (MovieInfoDTO) session.getAttribute("movie");
		int movie_id = movie.getMovieId();
		log.info("******************************************************" + movie_id);

		// getOne 메서드로 영화마다 예매된 좌석정보 가져오기
		List<String> seatInfo = Reservationservice.getOne(movie_id);
		log.info("******************************************************" + seatInfo);

		ObjectMapper objectMapper = new ObjectMapper();
		String seatInfoJson = null;
		try {
			seatInfoJson = objectMapper.writeValueAsString(seatInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}

		model.addAttribute("reserv", seatInfoJson); // 조회된 리뷰를 모델에 추가
		model.addAttribute("movie", movie);

		return "/movie/reservation";

	}

	// 예매 정보 입력
	@PreAuthorize("isAuthenticated()")
	@PostMapping("/reservate")
	public String reservate(@ModelAttribute ReservationVO vo, Model model) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null && auth.getPrincipal() instanceof CustomUser) {
			CustomUser user = (CustomUser) auth.getPrincipal();
			log.info(user);
			model.addAttribute("isAuthenticated", true);
			model.addAttribute("userName", user.getUser().getUser_name());
			model.addAttribute("userId", user.getUser().getUser_id());

		}
		log.info(vo);
		// insert DB저장
		Reservationservice.insert(vo);

		return "redirect:/movie/mypage";

	}

	/****************** 예매 ******************/

	/****************** 좌석 ******************/

}
