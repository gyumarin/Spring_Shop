package com.human.biz.cart.impl;

import java.util.List;

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

	@Override
	public CartVO ifAlreadyCart(CartVO vo) {
		
		return cartDAO.ifAlreadyCart(vo);
	}

	@Override
	public void addToQuantity(CartVO vo) {
		
		cartDAO.addToQuantity(vo);
		
	}

	@Override
	public void deleteCart(CartVO vo) {
		
		cartDAO.deleteCart(vo);
		
	}

	@Override
	public void updateCart(CartVO vo) {

		cartDAO.updateCart(vo);
		
	}

	@Override
	public List<CartVO> cartList(String user_id) {
		
		return cartDAO.cartList(user_id);
	}

}
