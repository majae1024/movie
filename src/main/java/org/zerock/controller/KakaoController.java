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
	public String kakaoCallback(String code, HttpSession session) throws IOException { // Data�� �������ִ� ��Ʈ�ѷ� �Լ�

		String access_Token = service.getAccessToken(code);

		KakaoVO kakaoUser = service.getUserInfo(access_Token, session);

		session.setAttribute("user", kakaoUser);// ȸ������ ���񽺿��� �̸���, �г��Ӱ� �̾ƿ��� ���ؼ�

		return "redirect:/user/kakaoRegister";// ���ΰ�ħ�� �α���api ��ø���� �������ؼ� �����̷�Ʈ�� ����

	}

	// ���� �غ�
	@PostMapping("/payment/ready")
	public String readyPayment(@ModelAttribute KakaopayDTO kakaopayDTO, HttpSession session, Model model) {
		try {
			String partner_order_id= UUID.randomUUID().toString();
			kakaopayDTO.setPartner_order_id(partner_order_id);
			// īī������ ���� �غ� API ȣ��
			Map<String, Object> response = payService.preparePayment(kakaopayDTO);
			log.info("---------------------------------------ù��°���� :" + response);
			
			// ���� ���� ���̵� (tid) ����
			kakaopayDTO.setTid((String) response.get("tid"));
			
			// ���ǿ� kakaopayDTO ��ü ���� (tid ����)
			session.setAttribute("kakaopayDTO", kakaopayDTO);
			log.info("----------------------------------@@@--ù��°" + kakaopayDTO);
			// īī������ ���� ���� �������� �����̷�Ʈ
			return "redirect:" + response.get("next_redirect_pc_url");
		} catch (Exception e) {
			// ���� �߻� �� ���� �������� �̵�
			e.printStackTrace();
			return "error";
		}
	}

	// ���� ����
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

				model.addAttribute("reserve", reserve); // ��ȸ�� ���� ������ �𵨿� �߰�

				int reservationCount = Reservationservice.countReservation();

				model.addAttribute("reservationCount", reservationCount);

			} else {
				model.addAttribute("isAuthenticated", false);
			}

			// ���ǿ��� tid ��������
			String tid = (String) session.getAttribute("tid");

			// īī������ ���� ���� API ȣ��
			KakaopayDTO kakaopayDTO = (KakaopayDTO) session.getAttribute("kakaopayDTO");

	        kakaopayDTO.setPgToken(pgToken);
			log.info("----------------------------------@@@--�ι�°" + kakaopayDTO);
			Map<String, Object> response = payService.approvePayment(kakaopayDTO);
			log.info("----------------------------------@@@--����°" + kakaopayDTO);
			log.info("---------------------------------------�ι�°���� :" + response);
			// ���� ����� �𵨿� ��� ������������ �̵�
			model.addAttribute("paymentResult", "success");
			model.addAttribute("response", response);
			return "/movie/mypage";
		} catch (Exception e) {
			// ���� �߻� �� ������������ �̵� (���� ���� ǥ��)
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

				model.addAttribute("reserve", reserve); // ��ȸ�� ���� ������ �𵨿� �߰�

				int reservationCount = Reservationservice.countReservation();

				model.addAttribute("reservationCount", reservationCount);

			} else {
				model.addAttribute("isAuthenticated", false);
			}
		
		
		try {
	        // ���� ���� �� ����� �𵨿� ���
	        model.addAttribute("paymentResult", "fail");  // ���� �� "fail"
	        return "/movie/mypage";
	    } catch (Exception e) {
	        e.printStackTrace();
	        model.addAttribute("paymentResult", "fail");  // ���� �� "fail"
	        return "/movie/mypage";
	    }
	}
	
	
}
