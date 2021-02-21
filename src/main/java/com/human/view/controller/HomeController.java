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
public class HomeController {

	@Autowired
	private ProductService productService;

	/*��ǰ ��� ��ȸ
	 * 
	 *  filter 	: new(����ǰ) , low(���� ���ݼ�), high(���� ���ݼ�) default �� : "new"
	 *  pagenum	: ������ �ѹ�  									default �� : 1
	 *  keyword : �˻��� 	 									default �� : ""
	 *  
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(HttpServletRequest request, Model model) {

		return "index";
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(HttpServletRequest request, Model model) {

		//������ ��, ���͸�, �˻����� ��ǰ ��ȸ
				
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
		int totalProduct = productService.getTotalProduct(keyword);
		
		
		Filter filter = new Filter(filterString);
		Paging paging = new Paging(pagenum, totalProduct);
		
		List<ProductVO> productList = productService.getListProduct(filter, paging, keyword);
		
		model.addAttribute("totalPage", paging.getTotalPage());
		model.addAttribute("productList", productList);
		
		model.addAttribute("pageNum", pagenum);
		model.addAttribute("filterString", filterString);
		model.addAttribute("keyword", keyword);
		
		return "home";
	}
	
	
	/*
	 * ī�װ��� ��ǰ ��� ��ȸ
	 *  
	 *  filter 	: new(����ǰ) , low(���� ���ݼ�), high(���� ���ݼ�) default �� : "new"
	 *  pagenum	: ������ �ѹ�  									default �� : 1
	 *  catenum : �˻��� 	 									default �� : 1
	 *  
	 */
	
	@RequestMapping(value = "/category", method = RequestMethod.GET)
	public String CategoryList(HttpServletRequest request, Model model){
	
		
		
		String filterString;
		String pagenum;
		int catenum  = Integer.parseInt(request.getParameter("catenum"));
		int totalProduct = productService.getTotalCategoryProduct(catenum);
		
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
		
		Filter filter = new Filter(filterString);
		Paging paging = new Paging(pagenum, totalProduct);
		
		List<ProductVO> productList = productService.getCategoryList(filter, paging, catenum);
		
		model.addAttribute("totalPage", paging.getTotalPage());
		model.addAttribute("productList", productList);
		
		
		return "home";
	}


}