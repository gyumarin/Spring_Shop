package com.human.view.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.human.biz.user.UserService;
import com.human.biz.user.UserVO;


@Controller
@SessionAttributes("loginUser")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//로그인 
	@SuppressWarnings("unused")
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String login(@RequestBody UserVO vo, Model model) {
		
		UserVO loginUser = userService.loginUser(vo);
		
		if(loginUser.getUser_role()==2) {
			System.out.println("어드민 계정임");
			model.addAttribute("loginUser", loginUser);
			return "admin/productList";
		}else if(loginUser != null) {
			model.addAttribute("loginUser", loginUser);
			return "redirect:/";
		}else {
			return "fail";
		}
		
		
	}
	
	//로그아웃
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(SessionStatus sessionStatus, HttpServletRequest request) {
		
		sessionStatus.setComplete();
		
		return "redirect:/";
		
	}
	
	//회원가입
	@RequestMapping(value="/join", method = RequestMethod.POST)
	public String join(@RequestBody UserVO vo) {
		
		userService.joinUser(vo);
		
		return "join";
		
	}
	
	//아이디 중복 체크
	@RequestMapping(value="/idCheck", method = RequestMethod.POST)
	public String idCheck(@RequestBody UserVO vo, Model model) {
		
		int idCheck = userService.idCheck(vo);
		
		if(idCheck == 1) {
			model.addAttribute("msg", 1);
		}else {
			model.addAttribute("msg", -1);
		}
		return "idCheck";
		
	}

}
