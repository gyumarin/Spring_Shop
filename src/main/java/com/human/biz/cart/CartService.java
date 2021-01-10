package com.human.biz.cart;

import java.util.List;

public interface CartService {

	void addToCart(CartVO vo);

	CartVO ifAlreadyCart(CartVO vo);

	void addToQuantity(CartVO vo);

	void deleteCart(CartVO vo);
	
	void updateCart(CartVO vo);

	List<CartVO> cartList(String user_id);

}
