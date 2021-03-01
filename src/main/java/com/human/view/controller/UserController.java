package com.human.view.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login(SessionStatus sessionStatus, HttpServletRequest request) {
			
		return "login";
	}
	
	//로그인 
	@SuppressWarnings("unused")
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String loginForm(HttpServletRequest request, Model model) {
		UserVO vo = new UserVO();
		vo.setUser_id(request.getParameter("user_id"));
		vo.setUser_password(request.getParameter("user_password"));

		UserVO loginUser = userService.loginUser(vo);
		
		if(loginUser.getUser_role()==2) {
			model.addAttribute("loginUser", loginUser);
			return "redirect:/admin/productList";
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
	@RequestMapping(value="/join", method = RequestMethod.GET)
	public String join(HttpServletRequest request) {
		
		return "join";
		
	}
	
	//회원가입
	@RequestMapping(value="/join", method = RequestMethod.POST)
	public String joinForm(HttpServletRequest request, Model model) {
		UserVO vo = new UserVO();
		vo.setUser_id(request.getParameter("user_id"));
		vo.setUser_password(request.getParameter("user_password"));
		vo.setUser_address(request.getParameter("user_address"));
		userService.joinUser(vo);
		
		//회원가입 완료후 완료되었습니다 라는 메세지 추가
		return "login";
		
	}
	
	//아이디 중복 체크
	@RequestMapping(value="/idCheck", method = RequestMethod.POST)
	@ResponseBody
	public Map<Object, Object> idCheck(HttpServletRequest request, Model model) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		UserVO vo = new UserVO();
		vo.setUser_id(request.getParameter("user_id"));
		/*
		 * String test = request.getParameter("user_id"); vo.setUser_id(test);
		 */
		
		int idCheck = userService.idCheck(vo);
		
		if(idCheck == 1) {
			map.put("msg", 1);
		}else {
			map.put("msg", -1);
		}
		return map;
	}

}
