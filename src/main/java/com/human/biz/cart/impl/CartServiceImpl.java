package com.human.biz.cart.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.human.biz.cart.CartService;
import com.human.biz.cart.CartVO;

@Service("CartService")
public class CartServiceImpl implements CartService{

	@Autowired
	private CartDAO cartDAO;
	
	@Override
	public void addToCart(CartVO vo) {
		cartDAO.addToCart(vo);
		
	}

}
