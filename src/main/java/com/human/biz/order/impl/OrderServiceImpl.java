package com.human.biz.order.impl;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.human.biz.cart.CartService;
import com.human.biz.cart.CartVO;
import com.human.biz.order.OrderDetailVO;
import com.human.biz.order.OrderService;
import com.human.biz.order.OrderVO;
import com.human.biz.product.ProductService;
import com.human.biz.product.ProductVO;

@Service("OrderService")
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderDAO orderDAO;
	@Autowired
	private CartService cartService;
	@Autowired
	private ProductService productService;

	@Override
	public int getOrderId() {
		// TODO Auto-generated method stub
		return orderDAO.getOrderId();
	}

	@Override
	public int insertOrder(OrderVO vo) {
		
		//orders 생성
		orderDAO.insertOrder(vo);
		
		//orders에서 생성한 id
		int orderId = getOrderId();
		vo.setOrder_id(orderId);
		
		//order_Detail 생성
		List<CartVO> cartList = vo.getCartList();
		
		System.out.println("여기까지옴");
		
		for(CartVO cartVO : cartList){
			ProductVO productVO = productService.getProduct(cartVO.getProduct_id());
			int P_quan = productVO.getProduct_quantity();
			int C_quan = cartVO.getCart_quantity();
			//  상품 남은 수량 < 주문 수량이 더 많은 경우
			if( P_quan < C_quan) {
				//주문 취소 돌아가기?
				// 주문 하신 상품 보다 재고가 더 적습니다.
				return P_quan - C_quan;
			}else {
				insertOrderDetail(orderId, cartVO.getCart_quantity(), cartVO.getProduct_id());
				//카트 상태 수정
				cartService.updateCart(cartVO);
			}
			
			
		}
		
		return orderId;
	}

	public void insertOrderDetail(int order_id, int quantity, int product_id) {
		
		orderDAO.insertOrderDetail(order_id, quantity, product_id);
		
	}

	@Override
	public OrderVO getOrderList(OrderVO vo) {
		
		vo.setOrderDetailList(getOrderDetailList(vo.getOrder_id()));
		
		return vo;
	}

	private List<OrderDetailVO> getOrderDetailList(int order_id) {
		
		return orderDAO.getOrderDetailList(order_id);
	}

	@Override
	public Date getOrderTime(int order_id) {
		
		return orderDAO.getOrderTime(order_id);
	}

	
	@Override
	public void orderCancel(int orderId) {
		
		orderDAO.orderCancel(orderId);
		
	}

	@Override
	public List<OrderVO> getOrderListId(String user_id) {
		// TODO Auto-generated method stub
		return orderDAO.getOrderListId(user_id);
	}

	@Override
	public List<OrderVO> orderListView(String user_id) {
		
		List<OrderVO> orderList = getOrderListId(user_id);
		
		Iterator<OrderVO> orderListIterator = orderList.iterator();
		while(orderListIterator.hasNext()) {     
		    OrderVO orderVO = orderListIterator.next();
		    orderVO.setOrderDetailList(orderDAO.getOrderDetailListProcess(orderVO.getOrder_id()));
		    if (orderVO.getOrderDetailList().isEmpty()) {
		    	orderListIterator.remove();
		    }else {
		    	List<OrderDetailVO> orderDetailList = orderVO.getOrderDetailList();
				
				int totalPrice = 0;
				
				for(OrderDetailVO ODvo : orderDetailList) {
					totalPrice += ODvo.getProduct_price()*ODvo.getOt_quantity();
				}
				orderVO.setTotalAmount(totalPrice);
		    }
		}
		
		return orderList;
	}

	@Override
	public void orderSuccess(int order_id) {
		// TODO Auto-generated method stub
		//productService.reduceQuantity(productVO.getProduct_id(), C_quan);
		OrderVO orderVO = orderDAO.getOrder(order_id);
		List<OrderDetailVO> odVO = orderDAO.getOrderDetailListProcess(orderVO.getOrder_id());
		//int P_quan = productVO.getProduct_quantity();
		//int C_quan = cartVO.getCart_quantity();
		
		for(OrderDetailVO vo : odVO){
			int O_quan = vo.getOt_quantity();
			ProductVO Pvo= productService.getProduct(vo.getProduct_id());
			productService.reduceQuantity(Pvo.getProduct_id(), O_quan);
		}
		
		orderDAO.orderSuccess(order_id);
	}
	


	



	
	

	

}
