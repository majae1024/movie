package org.zerock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.UsersVO;
import org.zerock.service.UsersService;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/user/*")
public class UsersController {

	@Autowired
	private UsersService usersService;
	@Autowired
	private BCryptPasswordEncoder encoder;

	@GetMapping("/kakaoRegister")
	public void registerInput() {

	}
	
	@GetMapping("/terms")
	public String terms() {
		
		return "/user/terms";
	}

	@GetMapping("/login")
	public String loginInput(String error, String logout, Model model) {

		log.info("error >>>>>>>>>>>>>>>>>>>>>>>" + error);
		log.info("logout>>>>>>>>>>>>>>>>>>>" + logout);

		if (error != null) {
			model.addAttribute("error", "Login error check your account");
		}

		if (logout != null) {
			model.addAttribute("logout", "Logout!!!!!!!");
		}
		return "/user/login";
	}

	@PostMapping("/register")
	public String registerPost(UsersVO vo, RedirectAttributes rttr, Model model) {
		String encodedPassword = encoder.encode(vo.getUser_pw());
		vo.setUser_pw(encodedPassword);

		usersService.insert(vo);

		rttr.addFlashAttribute("result", vo.getUser_id());
		model.addAttribute("msg", "회원가입을 축하드립니다.");

		return "redirect:/user/login";
	}

	@GetMapping("/idCheck")
	public void idCheck(@RequestParam("id") String id, Model model) {
		int result = usersService.countById(id);

		model.addAttribute("id", id);
		model.addAttribute("result", result);
	}

}
