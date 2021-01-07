package com.human.view.controller;

import java.util.List;
import java.util.Locale;

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
import com.human.view.controller.HomeController;

@Controller
@SessionAttributes("product")
public class HomeController {

	@Autowired
	private ProductService productService;

	/**
	 * Simply selects the home view to render by returning its name.
	 * afasf
	 */

	// 상품 목록 조회
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String home(HttpServletRequest request, Model model) {

		//페이지 수, 필터링, 검색으로 상품 조회
		int totalProduct = productService.getTotalProduct();
				
		String filterString;
		String pagenum;
		String keyword;
		
		if (request.getParameter("filter") == null) {
			filterString = "new";
		} else {
			filterString = request.getParameter("filter");
		}
		if (request.getParameter("pagenum") == null) {
			pagenum = "1";
		} else {
			pagenum = request.getParameter("pagenum");
		}
		if (request.getParameter("keyword") == null) {
			keyword = "";
		} else {
			keyword = request.getParameter("keyword");
		}
		
		
		Filter filter = new Filter(filterString);
		Paging paging = new Paging(pagenum, totalProduct);
		
		
		// 페이징
		List<ProductVO> productList = productService.getListProduct(filter, paging, keyword);
		
		model.addAttribute("totalPage", paging.getTotalPage());
		model.addAttribute("productList", productList);
		
		return "index";
	}


}