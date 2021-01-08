package com.human.view.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.human.biz.user.UserService;
import com.human.biz.user.UserVO;


@Controller
@SessionAttributes("loginUser")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//로그인 체크 
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String login(@RequestBody UserVO vo, Model model) {
		
		UserVO loginUser = userService.loginUser(vo);
		
		if(loginUser == null) {
			model.addAttribute("loginUser", loginUser);
			return "fail";
		}else {
			return "redirect:/index";
		}
		
		
	}

}
