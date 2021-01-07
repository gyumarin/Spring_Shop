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
	
	//��ǰ ��� ��ȸ
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		//����¡	
		List<ProductVO> productList = productService.getListProduct();

		model.addAttribute("productList",productList);
		return "index";
	}
	
	//��ǰ �̸� �˻� ��ȸ
	@RequestMapping(value = "/keyword", method = RequestMethod.GET)
	public String getByKeywordList(HttpServletRequest request, Locale locale, Model model) {
		String keyword = request.getParameter("keyword");
		//����¡	
		List<ProductVO> getByKeywordList = productService.getByKeywordList(keyword);
		
		model.addAttribute("getByKeywordList",getByKeywordList);
		
		return "keyword";
	}
	
	
	
	
	
}