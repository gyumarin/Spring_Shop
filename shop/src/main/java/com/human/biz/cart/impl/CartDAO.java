package com.human.biz.cart.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.human.biz.cart.CartVO;

public class CartDAO {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	public void addToCart(CartVO vo) {
		mybatis.insert("cartDAO.addToCart", vo);
	}

}
