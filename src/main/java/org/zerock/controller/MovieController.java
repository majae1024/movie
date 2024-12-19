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
		return "/movie/index"; // JSP ���� �̸�
	}

	
	
	@GetMapping("/showNotices")
	public @ResponseBody ResponseEntity<List<Map<String, String>>> showNotices(HttpSession session) {
	    List<Map<String, String>> notices = noticeService.getText("1");
	    session.setAttribute("notices", notices); // ���ǿ� �������� ��� ����
	    log.info(notices);  // �������� ��� �α� (���� ����)
	    return ResponseEntity.ok(notices); // JSON ���·� �������� ��� ����
	}

	@GetMapping("/showNoticePage")
	public String showNoticePage() {
	    return "/movie/showNotice"; // showNotice.jsp ������ �̵�
	}
	
	
	
	@PreAuthorize("isAuthenticated()")
	@PostMapping("/sub")
	public String goSubWithData(@ModelAttribute MovieInfoDTO movieInfoDTO, Model model, HttpSession session) {

		movieInfoDTO.setCertification(MovieAge.convertCertification(movieInfoDTO.getCertification()));
		System.out.println("���ɵ�� ���� �� : " + movieInfoDTO);
		// movie�������� movie������ ���ǿ� ����
		session.setAttribute("movie", movieInfoDTO);
		System.out.println("���ǿ� �ִ� movie : " + (MovieInfoDTO) session.getAttribute("movie"));

		// �̿��ڰ� �α����� �������� �ƴ� �͸��� �������� Ȯ��
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

		model.addAttribute("reviews", reviews); // ��ȸ�� ���並 �𵨿� �߰�

		return "/movie/sub";
	}

	/****************** �� �� ���� ******************/
	// ���� ��ȭ ���� ��ȸ
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/sub")
	public String listReviews(Model model, HttpSession session) {

		// �̿��ڰ� �α����� �������� �ƴ� �͸��� �������� Ȯ��
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

		// movie�������� ���ǿ��� �ҷ���
		MovieInfoDTO movie = (MovieInfoDTO) session.getAttribute("movie");
		log.info("**************************************************************" + movie);
		int movie_id = movie.getMovieId();

		log.info("---------------Review List---------------");

		List<ReviewVO> reviews = reviewservice.getAllReviews(movie_id);
		log.info("******************************************************" + movie_id);
		reviews.forEach(review -> log.info("Review Data: " + review));

		model.addAttribute("reviews", reviews); // ��ȸ�� ���並 �𵨿� �߰�
		model.addAttribute("movie", movie);

		return "/movie/sub";
	}

	// ���� �ۼ�
	@PostMapping("/register")
	public String registerReview(@ModelAttribute ReviewVO reviewVO) {
		System.out.print("��޿��� ���޹��� form����" + reviewVO);

		log.info("��� ��� -> ����Ʈ �������� ����");

		reviewservice.register(reviewVO);

		return "redirect:/movie/sub";
	}

	@GetMapping("/register")
	public void register() {

	}

	// Ư�� ���� ��������
	@GetMapping("/getReview")
	@ResponseBody
	public ResponseEntity<?> getReview(@RequestParam("review_id") Long review_id) {
		log.info("���� ���� ��û: " + review_id);

		var review = reviewservice.get(review_id);
		if (review == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("���並 ã�� �� �����ϴ�.");
		}

		return ResponseEntity.ok(review); // JSON �������� ��ȯ
	}

	// ���� ����
	@PostMapping("/modify")
	@ResponseBody
	public ResponseEntity<?> modify(@RequestBody ReviewVO review) {
		log.info("*********************���� ���� ��û: " + review);

		boolean isModified = reviewservice.modify(review);
		if (!isModified) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("���� ����");
		}

		return ResponseEntity.ok("���� ����");
	}

	// ���� �Ű�
	@PostMapping("/report")
	@ResponseBody
	public ResponseEntity<?> report(@RequestParam("review_id") Long review_id) {
		log.info("���� �Ű� ��û: " + review_id);

		var review = reviewservice.get(review_id);
		if (review == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("���並 ã�� �� �����ϴ�.");
		}

		boolean isReported = reviewservice.Reviewreport(review);
		if (!isReported) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("�Ű� ó�� ����");
		}

		return ResponseEntity.ok("�Ű� ����");
	}

	// ���� ����
	@PostMapping("/remove")
	@ResponseBody
	public ResponseEntity<?> remove(@RequestParam("review_id") Long review_id) {
		log.info("���� ���� ��û: " + review_id);

		boolean isRemoved = reviewservice.remove(review_id);
		if (!isRemoved) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("���� ����");
		}

		return ResponseEntity.ok("���� ����");
	}

	/****************** �� �� �� ******************/

	/****************** �� ���� ��ȭ ******************/
	@GetMapping("/more")
	public String goMorePage(Model model) {

		// �̿��ڰ� �α����� �������� �ƴ� �͸��� �������� Ȯ��
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

	/****************** �� ���� ��ȭ �� ******************/

	/****************** �� �� �� �� �� ******************/
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/mypage")
	public String goMyPage(Model model) {
		// �̿��ڰ� �α����� �������� �ƴ� �͸��� �������� Ȯ��
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

			model.addAttribute("reserve", reserve); // ��ȸ�� ���� ������ �𵨿� �߰�

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

	// ���� ���� ����
	@PostMapping("/delete")
	@ResponseBody
	public ResponseEntity<?> delete(@RequestBody Map<String, Long> payload) {
		Long rno = payload.get("rno"); // JSON���� rno ����
		log.info("���� ���� ��û: " + rno);

		boolean isRemoved = Reservationservice.delete(rno);
		if (!isRemoved) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("���� ����");
		}

		return ResponseEntity.ok("���� ��� ����");
	}

	/****************** ���� ******************/
	// ���� �������γѾ�°�
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

		// movie�������� ���ǿ��� �ҷ���
		MovieInfoDTO movie = (MovieInfoDTO) session.getAttribute("movie");
		int movie_id = movie.getMovieId();
		log.info("******************************************************" + movie_id);

		// getOne �޼���� ��ȭ���� ���ŵ� �¼����� ��������
		List<String> seatInfo = Reservationservice.getOne(movie_id);
		log.info("******************************************************" + seatInfo);

		ObjectMapper objectMapper = new ObjectMapper();
		String seatInfoJson = null;
		try {
			seatInfoJson = objectMapper.writeValueAsString(seatInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}

		model.addAttribute("reserv", seatInfoJson); // ��ȸ�� ���並 �𵨿� �߰�
		model.addAttribute("movie", movie);

		return "/movie/reservation";

	}

	// ���� ���� �Է�
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
		// insert DB����
		Reservationservice.insert(vo);

		return "redirect:/movie/mypage";

	}

	/****************** ���� ******************/

	/****************** �¼� ******************/

}
