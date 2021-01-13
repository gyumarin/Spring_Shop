package com.human.biz.product.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.human.biz.product.ProductService;
import com.human.biz.product.ProductVO;
import com.human.biz.util.Filter;
import com.human.biz.util.Paging;

@Service("ProductService")
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDAO productDAO;

	@Override
	public List<ProductVO> getListProduct(Filter filter, Paging paging, String keyword) {
		return productDAO.getListProduct(filter, paging, keyword);
	}

	@Override
	public int getTotalProduct() {
		// TODO Auto-generated method stub
		return productDAO.getTotalProduct();
	}

	@Override
	public List<ProductVO> getCategoryList(Filter filter, Paging paging, int cate_num) {
		// TODO Auto-generated method stub
		return productDAO.getCategoryList(filter, paging, cate_num);
	}

	@Override
	public ProductVO getProduct(int productId) {
		// TODO Auto-generated method stub
		return productDAO.getProduct(productId);
	}

	@Override
	public void reduceQuantity(int productId, int minusQuantity) {
		productDAO.reduceQuantity(productId, minusQuantity);
		
	}

	@Override
	public void productUpdate(ProductVO vo) {
		productDAO.productUpdate(vo);
		
	}

	@Override
	public void productInsert(ProductVO vo) {
		productDAO.productInsert(vo);
		
	}

	


	



}
