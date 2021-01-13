package com.human.view.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.human.biz.order.OrderDetailVO;
import com.human.biz.order.OrderService;
import com.human.biz.order.OrderVO;
import com.human.biz.product.ProductService;
import com.human.biz.product.ProductVO;
import com.human.biz.user.UserService;
import com.human.biz.user.UserVO;
import com.human.biz.util.Filter;
import com.human.biz.util.Paging;

@Controller
public class AdminController {

	@Autowired
	private OrderService orderService;
	@Autowired
	private ProductService productService;

	@RequestMapping(value = "admin/productList")
	public String ProductListView(HttpServletRequest request, Model model) {

		UserVO loginUser = (UserVO) request.getSession().getAttribute("loginUser");

		if (loginUser != null && loginUser.getUser_role()==2) {

			// 페이지 수, 필터링, 검색으로 상품 조회
			int totalProduct = productService.getTotalProduct();

			String pagenum;
			String keyword;

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

			Filter filter = new Filter("new");
			Paging paging = new Paging(pagenum, totalProduct);

			// 페이징
			List<ProductVO> productList = productService.getListProduct(filter, paging, keyword);

			model.addAttribute("totalPage", paging.getTotalPage());
			model.addAttribute("productList", productList);

			return "admin/productList";

		} else {
			return "fail";
		}

	}

	@RequestMapping(value = "admin/product_insert_form")
	public String ProductInsertForm(Model model, HttpServletRequest request) {
		UserVO loginUser = (UserVO) request.getSession().getAttribute("loginUser");

		if (loginUser != null && loginUser.getUser_role()==2) {

			return "admin/product_insert";

		} else {
			return "fail";
		}

	}
	

	@RequestMapping(value = "admin/product_insert")
	public String ProductInsert(@RequestParam(value = "product_img") MultipartFile uploadFile, ProductVO vo,
			HttpServletRequest request, Model model) {

		UserVO loginUser = (UserVO) request.getSession().getAttribute("loginUser");

		if (loginUser != null && loginUser.getUser_role()==2) {

			String fileName = "";
			if (!uploadFile.isEmpty()) {
				String root_path = request.getSession().getServletContext()
						.getRealPath("WEB-INF/resources/product_images/");
				System.out.println("ROOT경로 = " + root_path);
				// 업로드된 파일명을 가져온다.
				fileName = uploadFile.getOriginalFilename();

				try {
					File file = new File(root_path + fileName);
					uploadFile.transferTo(file);
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

			vo.setProduct_img(fileName); // Product에 이미지 저장
			productService.productInsert(vo);

			return "redirect:admin/productList";

		} else {
			return "fail";
		}

	}

	@RequestMapping(value = "admin/productUpdate_form")
	public String ProductUpdateForm(ProductVO vo, Model model, HttpServletRequest request) {
		UserVO loginUser = (UserVO) request.getSession().getAttribute("loginUser");

		if (loginUser != null && loginUser.getUser_role()==2) {

			ProductVO productVO = productService.getProduct(vo.getProduct_id());

			model.addAttribute("productVO", productVO);

			return "admin/productUpdate";

		} else {
			return "fail";
		}

	}

	@RequestMapping(value = "admin/productUpdate")
	public String ProductUpdate(@RequestParam(value = "product_img") MultipartFile uploadFile, ProductVO vo,
			HttpServletRequest request, Model model) {

		UserVO loginUser = (UserVO) request.getSession().getAttribute("loginUser");

		if (loginUser != null && loginUser.getUser_role()==2) {

			String fileName = "";
			if (!uploadFile.isEmpty()) {
				String root_path = request.getSession().getServletContext()
						.getRealPath("WEB-INF/resources/product_images/");
				System.out.println("ROOT경로 = " + root_path);
				// 업로드된 파일명을 가져온다.
				fileName = uploadFile.getOriginalFilename();

				try {
					File file = new File(root_path + fileName);
					uploadFile.transferTo(file);
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

			vo.setProduct_img(fileName); // Product에 이미지 저장

			productService.productUpdate(vo);

			return "redirect:admin/productList";

		} else {
			return "fail";
		}

	}
	
	@RequestMapping(value = "admin/orderList")
	public String OrderListView(HttpServletRequest request, Model model) {

		UserVO loginUser = (UserVO) request.getSession().getAttribute("loginUser");

		if (loginUser != null && loginUser.getUser_role()==2) {
			
			List<OrderVO> orderList = orderService.getOrderList();
			orderList = orderService.orderListView(orderList);
			
			model.addAttribute("orderList",orderList);
			
			return "admin/orderList";

		} else {
			return "fail";
		}

	}
	
	@RequestMapping(value = "admin/orderProcessUpdate")
	public String orderProcessUpdate(List<OrderDetailVO> vo, HttpServletRequest request, Model model) {

		UserVO loginUser = (UserVO) request.getSession().getAttribute("loginUser");

		if (loginUser != null && loginUser.getUser_role()==2) {
			
			orderService.orderProcessUpdate(vo);
			
			return "admin/orderList";

		} else {
			return "fail";
		}

	}
	
	
	

}
