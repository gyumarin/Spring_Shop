package com.human.view.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.human.biz.product.ProductService;
import com.human.biz.product.ProductVO;
import com.human.view.controller.HomeController;

@Controller
@SessionAttributes("product")
public class HomeController {
	
	@Autowired
	private ProductService productService;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	//상품 목록 조회
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		//페이징	
		List<ProductVO> productList = productService.getListProduct();

		model.addAttribute("productList",productList);
		return "index";
	}
	
	//상품 이름 검색 조회
	@RequestMapping(value = "/keyword", method = RequestMethod.GET)
	public String getByKeywordList(HttpServletRequest request, Locale locale, Model model) {
		String keyword = request.getParameter("keyword");
		//페이징	
		List<ProductVO> getByKeywordList = productService.getByKeywordList(keyword);
		
		model.addAttribute("getByKeywordList",getByKeywordList);
		
		return "keyword";
	}
	
	
	
	
	
}