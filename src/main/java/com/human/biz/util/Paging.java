package com.human.biz.util;

public class Paging {
	private int limit = 4;			//한 페이지에 보여줄 상품 수
	private int offset;				//페이지 별 전체 상품의 시작 점
									//1page = 0;
									//2page = 8;
	//총페이지의 수
	private int totalPage;
	
	public Paging(String pagenum, int totalProduct) {
		int Pnum = Integer.parseInt(pagenum);
		this.offset = (Pnum-1)*limit;
		this.totalPage = totalProduct / limit;
		
		if(totalProduct % limit > 0) {
			totalPage ++;
		}
	}
	
	public int getLimit() {
		return limit;
	}

	public int getOffset() {
		return offset;
	}

	public int getTotalPage() {
		return totalPage;
	}

}
