package com.human.biz.order;

import java.util.Date;
import java.util.List;

public interface OrderService {

	int insertOrder(OrderVO vo);

	int getOrderId();
	
	public void insertOrderDetail(int orderId, int cart_quantity, int product_id);

	OrderVO getOrderList(OrderVO vo);

	Date getOrderTime(int orderId);

	void orderSuccess(int orderId);

	List<OrderVO> getOrderListId(String user_id);

	List<OrderVO> orderListView(String user_id);

	void orderCancel(int orderId );

	



	


	

}
