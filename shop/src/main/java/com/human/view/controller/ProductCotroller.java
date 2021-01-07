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
	
	@RequestMapping(value = "/category", method = RequestMethod.GET)
	public String CategoryList(HttpServletRequest request, Model model){
	
		int totalProduct = productService.getTotalProduct();
		
		String filterString;
		String pagenum;
		int cate_num  = Integer.parseInt(request.getParameter("cate_num"));
		
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
		
		List<ProductVO> productList = productService.getCategoryList(filter, paging, cate_num);
		
		model.addAttribute("totalPage", paging.getTotalPage());
		model.addAttribute("productList", productList);
		
		
		return "category";
	}
	
	@RequestMapping(value = "/Detail", method = RequestMethod.GET)
	public String ProductDetail(HttpServletRequest request, Model model){
		
		int productId = Integer.parseInt(request.getParameter("product_id"));
		
		ProductVO product = productService.getProduct(productId);
		model.addAttribute("product", product);
		
		return "Detail";
	}

}
