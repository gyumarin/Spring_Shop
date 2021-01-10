package com.human.view.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.human.biz.cart.CartService;
import com.human.biz.cart.CartVO;
import com.human.biz.order.OrderDetailVO;
import com.human.biz.order.OrderService;
import com.human.biz.order.OrderVO;
import com.human.biz.product.ProductVO;
import com.human.biz.user.UserVO;

@Controller
public class MyPageController {
	
	@Autowired
	private CartService cartService;
	@Autowired
	private OrderService orderService;
	
	
	
	@RequestMapping(value = "/cart", method = RequestMethod.POST)
	public String AddToCart(@RequestBody CartVO vo, HttpServletRequest request, Model model){
		
		UserVO loginUser = (UserVO)request.getSession().getAttribute("loginUser");
		ProductVO productInfo = (ProductVO)request.getSession().getAttribute("product");
		
		//로그인 되어 있지 않다면?
		if(loginUser==null) {
			return "login";
		}else {
			vo.setProduct_id(productInfo.getProduct_id());
			vo.setUser_id(loginUser.getUser_id());
			CartVO cart = cartService.ifAlreadyCart(vo);
			//이미 같은 물품이 있다면?
			if(cart!=null) {
				vo.setCart_id(cart.getCart_id());
				cartService.addToQuantity(vo);
			}else {
				cartService.addToCart(vo);
			}
		}
		
		return "cart";
	}
	
	@RequestMapping(value = "cart/delete", method = RequestMethod.GET)
	public String DeleteCart(@RequestBody CartVO vo, Model model){
		
		cartService.deleteCart(vo);
		
		return "cart";
	
	}
	
	
	
	@RequestMapping(value = "/order", method = RequestMethod.POST)
	public String CreateOrderProcess(@ModelAttribute OrderVO vo, HttpServletRequest request, Model model){
		UserVO loginUser = (UserVO)request.getSession().getAttribute("loginUser");
		
		if(loginUser==null) {
			return "login";
		}else {
			vo.setUser_id(loginUser.getUser_id());
			vo.setOrder_address(loginUser.getUser_address());
		
			int orderId = orderService.insertOrder(vo);
			if(orderId < 0) {
				// 주문 하신 상품 보다 재고가 더 적습니다.
				// -1 * orderId 개를 초과되었기 때문에 수량을 조정한 후 다시 시도해주세요.
				return "/index";
			}
			
			model.addAttribute("orderId", orderId);		
			
			return "redirect:order_list";
		}
		
	}
	
	@RequestMapping(value = "/orderList", method = RequestMethod.POST)
	public String OrderList(@RequestParam(value = "orderId") int orderId, HttpServletRequest request, Model model){
		UserVO loginUser = (UserVO)request.getSession().getAttribute("loginUser");
		if (loginUser == null) {
			return "login";
		} else {
			OrderVO vo = new OrderVO();
			
			vo.setOrder_id(orderId);
			vo.setUser_id(loginUser.getUser_id());
			vo.setOrder_address(loginUser.getUser_address());
			vo.setOrder_time(orderService.getOrderTime(orderId));
			vo = orderService.getOrderList(vo);
			
			List<OrderDetailVO> orderDetailList = vo.getOrderDetailList();
			
			int totalPrice = 0;
			
			for(OrderDetailVO ODvo : orderDetailList) {
				totalPrice += ODvo.getProduct_price()*ODvo.getOt_quantity();
			}
			
			vo.setTotalAmount(totalPrice);
			model.addAttribute("order", vo);
			
			return "order_list";
		}
		
	}
	
	@RequestMapping(value = "/orderSuccess", method = RequestMethod.GET)
	public String SuccessOrder(@RequestParam(value = "orderId") int orderId, HttpServletRequest request){
		UserVO loginUser = (UserVO)request.getSession().getAttribute("loginUser");
		if (loginUser == null) {
			return "login";
		} else {
			orderService.orderSuccess(orderId);
			return "mypage";
		}
		
	}
	
	@RequestMapping(value = "/orderCancel", method = RequestMethod.GET)
	public String CancelOrder(@RequestParam(value = "orderId") int orderId, HttpServletRequest request){
		
		UserVO loginUser = (UserVO)request.getSession().getAttribute("loginUser");
		if (loginUser == null) {
			return "login";
		} else {
			orderService.orderCancel(orderId);
			return "mypage";
		}
	
	}
	
	@RequestMapping(value = "/orderListView", method = RequestMethod.POST)
	public String OrderListView(HttpServletRequest request, Model model){
		
		UserVO loginUser = (UserVO)request.getSession().getAttribute("loginUser");
		
		if (loginUser == null) {
			return "login";
		} else {
			//List<OrderVO> orderList = orderService.getOrderListId(loginUser.getUser_id());
			List<OrderVO> orderList = orderService.orderListView(loginUser.getUser_id());
			
			model.addAttribute("orderList",orderList);
			
			return "mypage";
		}
	
	}
	
	@RequestMapping(value = "/cartListView", method = RequestMethod.GET)
	public String CartListView(HttpServletRequest request, Model model){
		
		UserVO loginUser = (UserVO)request.getSession().getAttribute("loginUser");
		
		if (loginUser == null) {
			return "login";
		} else {
			
			
			return "mypage";
		}
	
	}
	
	
	
	
	

}
