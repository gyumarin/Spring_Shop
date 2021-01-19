package com.human.view.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.human.biz.product.ProductService;
import com.human.biz.product.ProductVO;
import com.human.biz.util.Filter;
import com.human.biz.util.Paging;


@Controller
@SessionAttributes("product")
public class ProductCotroller {
	
	@Autowired
	private ProductService productService;
	/*
	 *  상품 상세 조회
	 *  
	 *  productId : 상품ID
	 *  
	 *  product 구성
	 *  
	 *  product_id;             // 상품 id 
	 *  product_name;        	// 상품 이름
     *	product_price;          // 상품 가격
     *	product_desc;        	// 상품 정보
     *	product_img;         	// 상품 이미지
     *	product_category;       // 상품카테고리
     *	product_quantity;       // 상품 수량
     *	product_indate;       	// 상품 등록일
	 *  
	 */
	@RequestMapping(value = "/Detail", method = RequestMethod.GET)
	public String ProductDetail(HttpServletRequest request, Model model){
		
		int productId = Integer.parseInt(request.getParameter("productId"));
		
		ProductVO product = productService.getProduct(productId);
		model.addAttribute("product", product);
		
		return "product_detail";
	}

}
