package com.human.biz.product.impl;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.human.biz.product.ProductVO;
import com.human.biz.util.Filter;
import com.human.biz.util.Paging;



@Repository
public class ProductDAO {

	@Autowired
	private SqlSessionTemplate mybatis;

	
	public int getTotalProduct() {
		return mybatis.selectOne("productDAO.getTotalProduct");
	}

	public List<ProductVO> getListProduct(Filter filter, Paging paging, String keyword) {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		// TODO Auto-generated method stub
		map.put("filter", filter);
		map.put("paging", paging);
		map.put("keyword", keyword);
		return mybatis.selectList("productDAO.getListProduct", map);
	}

	public List<ProductVO> getCategoryList(Filter filter, Paging paging, int cate_num) {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("filter", filter);
		map.put("paging", paging);
		map.put("cate_num", cate_num);
		return mybatis.selectList("productDAO.getCategoryList", map);
	}

	public ProductVO getProduct(int productId) {
		// TODO Auto-generated method stub
		return mybatis.selectOne("productDAO.getProduct", productId);
	}

	

	

}
