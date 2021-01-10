package com.human.biz.cart;


public interface CartService {

	void addToCart(CartVO vo);

	CartVO ifAlreadyCart(CartVO vo);

	void addToQuantity(CartVO vo);

	void deleteCart(CartVO vo);
	
	void updateCart(CartVO vo);

}
