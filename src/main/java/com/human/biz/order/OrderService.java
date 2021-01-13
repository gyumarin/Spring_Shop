package com.human.biz.order;

import java.util.Date;
import java.util.List;

public interface OrderService {

	int insertOrder(OrderVO vo);

	int getOrderId();
	
	public void insertOrderDetail(int orderId, int cart_quantity, int product_id);

	OrderVO getOrder(OrderVO vo);

	Date getOrderTime(int orderId);

	void orderSuccess(int orderId);

	List<OrderVO> getOrderListId(String user_id);
	
	List<OrderVO> getOrderList();
	
	List<OrderVO> orderListView(List<OrderVO> orderList);

	void orderCancel(int orderId );

	void orderProcessUpdate(List<OrderDetailVO> OrderDetailList);



	

	



	


	

}
