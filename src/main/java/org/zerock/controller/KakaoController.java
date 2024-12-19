package org.zerock.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.domain.KakaoVO;
import org.zerock.domain.KakaopayDTO;
import org.zerock.domain.ReservationVO;
import org.zerock.security.domain.CustomUser;
import org.zerock.service.KakaoPayService;
import org.zerock.service.KakaoService;
import org.zerock.service.ReservationService;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class KakaoController {

	@Autowired
	private KakaoService service;
	@Autowired
	private KakaoPayService payService;
	@Autowired
	private ReservationService Reservationservice;

	@GetMapping("/auth/kakao/callback")
	public String kakaoCallback(String code, HttpSession session) throws IOException { // Data를 리턴해주는 컨트롤러 함수

		String access_Token = service.getAccessToken(code);

		KakaoVO kakaoUser = service.getUserInfo(access_Token, session);

		session.setAttribute("user", kakaoUser);// 회원가입 서비스에서 이메일, 닉네임값 뽑아오기 위해서

		return "redirect:/user/kakaoRegister";// 새로고침시 로그인api 중첩동작 막기위해서 리다이렉트로 보냄

	}

	// 결제 준비
	@PostMapping("/payment/ready")
	public String readyPayment(@ModelAttribute KakaopayDTO kakaopayDTO, HttpSession session, Model model) {
		try {
			String partner_order_id= UUID.randomUUID().toString();
			kakaopayDTO.setPartner_order_id(partner_order_id);
			// 카카오페이 결제 준비 API 호출
			Map<String, Object> response = payService.preparePayment(kakaopayDTO);
			log.info("---------------------------------------첫번째응답 :" + response);
			
			// 결제 고유 아이디 (tid) 추출
			kakaopayDTO.setTid((String) response.get("tid"));
			
			// 세션에 kakaopayDTO 객체 저장 (tid 포함)
			session.setAttribute("kakaopayDTO", kakaopayDTO);
			log.info("----------------------------------@@@--첫번째" + kakaopayDTO);
			// 카카오페이 결제 승인 페이지로 리다이렉트
			return "redirect:" + response.get("next_redirect_pc_url");
		} catch (Exception e) {
			// 예외 발생 시 에러 페이지로 이동
			e.printStackTrace();
			return "error";
		}
	}

	// 결제 성공
	@GetMapping("/payment/success")
	public String paymentSuccess(@RequestParam("pg_token") String pgToken, HttpSession session, Model model) {
		try {
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

				model.addAttribute("reserve", reserve); // 조회된 예매 내역을 모델에 추가

				int reservationCount = Reservationservice.countReservation();

				model.addAttribute("reservationCount", reservationCount);

			} else {
				model.addAttribute("isAuthenticated", false);
			}

			// 세션에서 tid 가져오기
			String tid = (String) session.getAttribute("tid");

			// 카카오페이 결제 승인 API 호출
			KakaopayDTO kakaopayDTO = (KakaopayDTO) session.getAttribute("kakaopayDTO");

	        kakaopayDTO.setPgToken(pgToken);
			log.info("----------------------------------@@@--두번째" + kakaopayDTO);
			Map<String, Object> response = payService.approvePayment(kakaopayDTO);
			log.info("----------------------------------@@@--세번째" + kakaopayDTO);
			log.info("---------------------------------------두번째응답 :" + response);
			// 결제 결과를 모델에 담아 마이페이지로 이동
			model.addAttribute("paymentResult", "success");
			model.addAttribute("response", response);
			return "/movie/mypage";
		} catch (Exception e) {
			// 예외 발생 시 마이페이지로 이동 (결제 실패 표시)
			e.printStackTrace();
			model.addAttribute("paymentResult", "fail");
			return "/movie/mypage";
		}
	}
	
	@GetMapping("/payment/fail")
	public String paymentFail(HttpSession session, Model model) {
			
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

				model.addAttribute("reserve", reserve); // 조회된 예매 내역을 모델에 추가

				int reservationCount = Reservationservice.countReservation();

				model.addAttribute("reservationCount", reservationCount);

			} else {
				model.addAttribute("isAuthenticated", false);
			}
		
		
		try {
	        // 결제 실패 시 결과를 모델에 담기
	        model.addAttribute("paymentResult", "fail");  // 실패 시 "fail"
	        return "/movie/mypage";
	    } catch (Exception e) {
	        e.printStackTrace();
	        model.addAttribute("paymentResult", "fail");  // 실패 시 "fail"
	        return "/movie/mypage";
	    }
	}
	
	
}
