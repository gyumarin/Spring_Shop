package com.human.view.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.human.biz.cart.CartService;
import com.human.biz.cart.CartVO;

@Controller
public class MyPageController {
	
	@Autowired
	private CartService cartService;
	
	@RequestMapping(value = "/cart", method = RequestMethod.POST)
	public String AddToCart(@RequestBody CartVO vo, HttpServletRequest request, Model model){
		
		cartService.addToCart(vo);
		
		return "cart";
		
	}

}
