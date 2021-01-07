package com.human.biz.cart;

public class CartVO {
	private int cart_id;			//CartID
	private int product_id;			//ProductID
	private String user_id;			//UserID
	private int cart_quantity;		// 카트에 담긴 수량
	private int cart_process;		// 0 : 주문 전		1 : 주문 완료
	
	
	public int getCart_id() {
		return cart_id;
	}
	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getCart_quantity() {
		return cart_quantity;
	}
	public void setCart_quantity(int cart_quantity) {
		this.cart_quantity = cart_quantity;
	}
	public int getCart_process() {
		return cart_process;
	}
	public void setCart_process(int cart_process) {
		this.cart_process = cart_process;
	}

}
