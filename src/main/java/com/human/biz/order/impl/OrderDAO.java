package com.human.biz.order.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.human.biz.order.OrderDetailVO;
import com.human.biz.order.OrderVO;

@Repository
public class OrderDAO {

	@Autowired
	private SqlSessionTemplate mybatis;

	public void insertOrder(OrderVO vo) {
		mybatis.insert("orderDAO.insertOrder", vo);
	}

	public int getOrderId() {
		
		return mybatis.selectOne("orderDAO.getOrderId");
	}

	public void insertOrderDetail(int order_id, int quantity, int product_id) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("order_id", order_id);
		map.put("quantity", quantity);
		map.put("product_id", product_id);
		
		mybatis.insert("orderDAO.insertOrderDetail", map);
		
	}

	public List<OrderDetailVO> getOrderDetailList(int order_id) {
		
		return mybatis.selectList("orderDAO.getOrderDetailList",order_id);
	}

	public Date getOrderTime(int order_id) {
		// TODO Auto-generated method stub
		return mybatis.selectOne("orderDAO.getOrderTime", order_id);
	}

	public void orderSuccess(int order_id) {
		// TODO Auto-generated method stub
		mybatis.update("orderDAO.orderSuccess", order_id);
	}
	public void orderCancel(int order_id) {	
		mybatis.delete("orderDAO.orderCancel", order_id);
	}

	public List<OrderVO> getOrderListId(String user_id) {
		// TODO Auto-generated method stub
		return mybatis.selectList("orderDAO.getOrderListId",user_id);
	}

	public List<OrderDetailVO> getOrderDetailListProcess(int order_id) {
		// TODO Auto-generated method stub
		return mybatis.selectList("orderDAO.getOrderDetailListProcess",order_id);
	}

	public OrderVO getOrder(int order_id) {
		// TODO Auto-generated method stub
		return mybatis.selectOne("orderDAO.getOrder", order_id);
	}

	public List<OrderVO> getOrderList() {
		// TODO Auto-generated method stub
		return mybatis.selectList("orderDAO.getOrderList");
	}

	public void orderProcessUpdate(OrderDetailVO vo) {
		// TODO Auto-generated method stub
		mybatis.update("orderDAO.orderProcessUpdate",vo);
	}



	

	
}
