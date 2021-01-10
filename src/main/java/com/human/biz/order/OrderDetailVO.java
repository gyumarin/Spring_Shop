package com.human.biz.order;

public class OrderDetailVO {
	private int odetail_id;
	private int order_id;
	private int ot_process;
	private int ot_quantity;
	private int product_id;
	private String product_name;
	private String product_img;
	private int product_price;
	
	public int getOdetail_id() {
		return odetail_id;
	}
	public void setOdetail_id(int odetail_id) {
		this.odetail_id = odetail_id;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getOt_process() {
		return ot_process;
	}
	public void setOt_process(int ot_process) {
		this.ot_process = ot_process;
	}
	public int getOt_quantity() {
		return ot_quantity;
	}
	public void setOt_quantity(int ot_quantity) {
		this.ot_quantity = ot_quantity;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getProduct_img() {
		return product_img;
	}
	public void setProduct_img(String product_img) {
		this.product_img = product_img;
	}
	public int getProduct_price() {
		return product_price;
	}
	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}
	
	
}
