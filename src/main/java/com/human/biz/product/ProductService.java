package com.human.biz.product;

import java.util.List;

import com.human.biz.util.Filter;
import com.human.biz.util.Paging;

public interface ProductService {

	int getTotalProduct(String keyword);
	
	int getTotalCategoryProduct(int category);

	List<ProductVO> getListProduct(Filter filter, Paging paging, String keyword);

	List<ProductVO> getCategoryList(Filter filter, Paging paging, int cate_num);

	ProductVO getProduct(int productId);
	
	void reduceQuantity(int productId, int minusQuantity);

	void productUpdate(ProductVO vo);

	void productInsert(ProductVO vo);

	
	
		
}
