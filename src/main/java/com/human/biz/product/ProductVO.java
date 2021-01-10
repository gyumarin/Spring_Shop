package com.human.biz.product;

import java.util.Date;

public class ProductVO {
	private int product_id;             // 상품 id primary key, automatic
	private String product_name;        // 상품 이름
    private int product_price;          // 상품 가격
    private String product_desc;        // 상품 정보
    private String product_img;         // 상품 이미지
    private int product_category;       // 상품카테고리
    private int product_quantity;       // 상품 수량
    private Date product_indate;       // 상품 등록일
    
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
	public int getProduct_price() {
		return product_price;
	}
	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}
	public String getProduct_desc() {
		return product_desc;
	}
	public void setProduct_desc(String product_desc) {
		this.product_desc = product_desc;
	}
	public String getProduct_img() {
		return product_img;
	}
	public void setProduct_img(String product_img) {
		this.product_img = product_img;
	}
	public int getProduct_category() {
		return product_category;
	}
	public void setProduct_category(int product_category) {
		this.product_category = product_category;
	}
	public int getProduct_quantity() {
		return product_quantity;
	}
	public void setProduct_quantity(int product_quantity) {
		this.product_quantity = product_quantity;
	}
	public Date getProduct_indate() {
		return product_indate;
	}
	public void setProduct_indate(Date product_indate) {
		this.product_indate = product_indate;
	}

   
	
	
}
