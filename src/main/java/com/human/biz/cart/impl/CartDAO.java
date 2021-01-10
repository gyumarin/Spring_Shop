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

	public CartVO ifAlreadyCart(CartVO vo) {
		// TODO Auto-generated method stub
		return mybatis.selectOne("cartDAO.ifAlreadyCart", vo);
	}

	public void addToQuantity(CartVO vo) {
		mybatis.update("cartDAO.addToQuantity", vo);
		
	}

	public void deleteCart(CartVO vo) {
		mybatis.delete("cartDAO.deleteCart", vo);
	}

	public void updateCart(CartVO vo) {
		mybatis.update("cartDAO.updateCart", vo);
		
	}

}
