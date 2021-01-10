package com.human.view.controller;

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
	
	@RequestMapping(value = "/Detail", method = RequestMethod.GET)
	public String ProductDetail(HttpServletRequest request, Model model){
		
		int productId = Integer.parseInt(request.getParameter("product_id"));
		
		ProductVO product = productService.getProduct(productId);
		model.addAttribute("product", product);
		
		return "product_detail";
	}

}
