package com.human.biz.order;

import java.util.Date;
import java.util.List;

import com.human.biz.cart.CartVO;

public class OrderVO {

	private int order_id;
	private String user_id;
	private Date order_time;
	private String order_address;
	private int totalAmount;
	private List<CartVO> cartList;
	private List<OrderDetailVO> orderDetailList;
	
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public Date getOrder_time() {
		return order_time;
	}
	public void setOrder_time(Date order_time) {
		this.order_time = order_time;
	}
	public String getOrder_address() {
		return order_address;
	}
	public void setOrder_address(String order_address) {
		this.order_address = order_address;
	}
	public List<CartVO> getCartList() {
		return cartList;
	}
	public void setCartList(List<CartVO> cartList) {
		this.cartList = cartList;
	}
	public List<OrderDetailVO> getOrderDetailList() {
		return orderDetailList;
	}
	public void setOrderDetailList(List<OrderDetailVO> orderDetailList) {
		this.orderDetailList = orderDetailList;
	}
	public int getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
	
}
