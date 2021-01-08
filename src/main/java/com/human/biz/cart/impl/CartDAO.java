package com.human.biz.cart.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.human.biz.cart.CartVO;

@Repository
public class CartDAO {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	public void addToCart(CartVO vo) {
		mybatis.insert("cartDAO.addToCart", vo);
	}

}
