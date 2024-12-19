package org.zerock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.Criteria;
import org.zerock.domain.NoticeVO;
import org.zerock.domain.PageDTO;
import org.zerock.domain.ReservationVO;
import org.zerock.domain.ReviewVO;
import org.zerock.domain.UsersVO;
import org.zerock.service.AdminService;
import org.zerock.service.EmailReviewService;
import org.zerock.service.NoticeService;
import org.zerock.service.ReservationService;
import org.zerock.service.ReviewService;
import org.zerock.service.UsersService;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/admin/*")
public class AdminController {

	@Autowired
	private AdminService adminService;
	@Autowired
	private UsersService userService;
	@Autowired
	private ReviewService reviewService;
	@Autowired
	private ReservationService Reservationservice;
	@Autowired
	private NoticeService notice;
	@Autowired
    private EmailReviewService emailReviewService;

	@GetMapping("/adminDashboard")
	public String adminMain(Model model) {

		int usersCount = userService.countUsers();

		model.addAttribute("usersCount", usersCount);

		int reviewCount = reviewService.countReview();

		model.addAttribute("reviewCount", reviewCount);
		
		int reservationCount = Reservationservice.countReservation();

		model.addAttribute("reservationCount", reservationCount);
		
		List<ReservationVO> list = adminService.getThreeReservation();
		
		model.addAttribute("list", list);

		return "/admin/adminDashboard";
	}

	@GetMapping("/login")
	public String adminLogin() {

		return "/admin/adminLogin";
	}

	@PostMapping("/login")
	public String PostAdminLogin(@RequestParam("id") String id, @RequestParam("password") String password) {

		return "redirect:/admin/Dashboard";
	}

	@GetMapping("/logout")
	public String getAdminLogout() {

		return "/admin/adminLogout";
	}

	// 공지사항
	@GetMapping("/noticeList")
	public String noticeList(Model model, Criteria cri) {
		
		List<NoticeVO> list = notice.getList(cri);
		int total = notice.countAll();
		model.addAttribute("pageMaker", new PageDTO(cri, total));
		model.addAttribute("list", list);
		
		return "/admin/notice/noticeList";
	}

	@GetMapping("/noticeView")
	public String noticeView(@RequestParam("nno") long nno, @ModelAttribute("cri") Criteria cri, Model model) {
		
		model.addAttribute("vo", notice.read(nno));
		model.addAttribute(cri);
		return "/admin/notice/noticeView";
	}

	@GetMapping("/noticeWrite")
	public String noticeWrite(@ModelAttribute("cri") Criteria cri) {
		
		return "/admin/notice/noticeWrite";
	}
	
	@PostMapping("/noticeWrite")
	public String PostnoticeWrite(NoticeVO vo, @ModelAttribute("cri") Criteria cri ,RedirectAttributes rttr) {
		notice.register(vo);
		rttr.addFlashAttribute("message", vo.getNno() +"번 게시물 등록 성공!");
		
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		return "redirect:/admin/noticeList";

	}

	@GetMapping("/noticeModify")
	public String noticeModify(@RequestParam("nno") long nno, @ModelAttribute("cri") Criteria cri, Model model) {
		model.addAttribute("vo", notice.read(nno));
		model.addAttribute(cri);
		return "/admin/notice/noticeModify";
	}

	@PostMapping("/noticeModify")
	public String PostNoticeModify(@ModelAttribute("cri") Criteria cri, NoticeVO vo, RedirectAttributes rttr) {
		log.info(vo);
		int result = notice.update(vo);
		if(result == 1) {
			rttr.addFlashAttribute("message", vo.getNno() +"번 게시물 수정 성공!");
		}
		
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		
		return "redirect:/admin/noticeList";
	}

	
	@PostMapping("/noticeDelete")
	public String PostnoticeDelete(@RequestParam("nno") long nno, @ModelAttribute("cri") Criteria cri,
			RedirectAttributes rttr) {
		
		int result = notice.delete(nno);
		if (result == 1 ) {
		       rttr.addFlashAttribute("message", "게시물 삭제 성공.");
	    } else {
	        rttr.addFlashAttribute("message", "게시물 삭제 실패...");
		}
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		
		return "redirect:/admin/noticeList";
	}


	/*****************************************
	 * 리 뷰
	 ******************************************/

	// 신고 리뷰 목록 가져오기
	@GetMapping("/reviewList")
	public String reviewList(Model model, Criteria cri) {
		log.info("list...............");
		List<ReviewVO> reviewList = adminService.getReivewsWithPaging(cri);

		reviewList.forEach(users -> log.info(users));
		model.addAttribute("reviewList", reviewList);
		// model.addAttribute("pageMaker", new PageDTO(cri,123)); //레코드 전체갯수 123개,
		// 13page

		int total = adminService.getTotalReviewCount(cri);
		model.addAttribute("pageMaker", new PageDTO(cri, total));

		return "/admin/review/reviewList";
	}

	// 신고 리뷰 상세 보기
	@GetMapping("/reviewView")
	public String reviewView(@RequestParam("review_id") long review_id, @ModelAttribute("cri") Criteria cri,
			Model model) {
		System.out.println("reviewId: " + review_id);
		System.out.println("Page: " + cri.getPageNum());
		System.out.println("Amount: " + cri.getAmount());
		model.addAttribute("review", adminService.getReviewInfoBy(review_id));
		log.info(model);
		return "/admin/review/reviewView";
	}

	// 신고 리뷰 지우기, 해당 계정으로 이메일 발송
	@PostMapping("/reviewDelete")
	public String reviewDelete(@RequestParam("review_id") Long review_id, RedirectAttributes rttr) {

		try{
			emailReviewService.deleteReview(review_id);
			rttr.addFlashAttribute("message", "리뷰가 성공적으로 삭제되었습니다.");
			}catch(IllegalArgumentException e) {
				rttr.addFlashAttribute("message", "리뷰 정보를 찾을 수 없습니다...");
			}

		return "redirect:/admin/reviewList";
	}

	/*****************************************
	 * 리 뷰
	 ******************************************/


	// 예매 리스트 가져오기
	@GetMapping("/reservationList")
	public String reservationList(Model model, Criteria cri) {
		log.info("list...............");
		List<ReservationVO> reservationList = adminService.getReservationWithPaging(cri);

		reservationList.forEach(reservation -> log.info(reservation));
		model.addAttribute("reservationList", reservationList);
		

		int total = adminService.getTotalReservationCount(cri);
		model.addAttribute("pageMaker", new PageDTO(cri, total));

		return "/admin/reservation/reservationList";
	}

	// 예매 상세 보기
	@GetMapping("/reservationView")
	public String reservationView(@RequestParam("rno") long rno, @ModelAttribute("cri") Criteria cri,
			Model model) {
		System.out.println("Rno: " + rno);
		System.out.println("Page: " + cri.getPageNum());
		System.out.println("Amount: " + cri.getAmount());
		model.addAttribute("reservation", adminService.getReservationInfoBy(rno));
		log.info(model);
		return "/admin/reservation/reservationView";
	}

	// 예매 내역 지우기
	@PostMapping("/reservationDelete")
	public String reservationDelete(@RequestParam("rno") Long rno, RedirectAttributes rttr) {

		boolean result = Reservationservice.delete(rno);

		if (result) {
			rttr.addFlashAttribute("message", "삭제되었습니다.");
		} else {
			rttr.addFlashAttribute("message", "삭제에 실패하였습니다..");
		}

		return "redirect:/admin/reviewList";
	}
	
	/********** 예매 끝 **********/

	@GetMapping("/movieList")
	public String movieList() {
		return "/admin/movie/movieList";
	}

	@GetMapping("/usersList")
	public String usersList(Model model, Criteria cri) {
		log.info("list...............");
		List<UsersVO> list = adminService.getUsersWithPaging(cri);

		list.forEach(rievew -> log.info(rievew));
		model.addAttribute("list", list);
		// model.addAttribute("pageMaker", new PageDTO(cri,123)); //레코드 전체갯수 123개,
		// 13page

		int total = adminService.getTotalCount(cri);
		model.addAttribute("pageMaker", new PageDTO(cri, total));

		return "/admin/users/usersList";
	}

	@GetMapping("/usersView")
	public String usersView(@RequestParam("uno") long uno, @ModelAttribute("cri") Criteria cri, Model model) {
		System.out.println("Uno: " + uno);
		System.out.println("Page: " + cri.getPageNum());
		System.out.println("Amount: " + cri.getAmount());
		model.addAttribute("user", adminService.getUserInfoByUno(uno));
		log.info(model);
		return "/admin/users/usersView";
	}

	@PostMapping("/usersDelete")
	public String usersDelete(@RequestParam("uno") long uno, @RequestParam("id") String user_id, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {

		boolean isRemove = reviewService.reviewdelete(user_id);
		log.info("특정 유저 리뷰 전부 삭제하기>>>>>>>>>>>>>>>>>>" + isRemove);
		
		boolean isDelete = Reservationservice.Reservationdelete(user_id);
		log.info("특정 유저 예매 전부 삭제하기>>>>>>>>>>>>>>>>>>" + isDelete);
		
		int result = userService.delete(uno);

		if (result == 1) {
			rttr.addFlashAttribute("message", "삭제되었습니다.");
			
		} else {
			rttr.addFlashAttribute("message", "삭제에 실패하였습니다..");
		}
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		
		return "redirect:/admin/usersList";
	}

	
}
