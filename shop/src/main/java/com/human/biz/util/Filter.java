package com.human.biz.util;

public class Filter {

	private String quary_name;			//Order by name
	private String order;				//Order by name asc(오름)/desc(내림)
	
	public Filter(String filter) {
		if(filter.equals("new")) {
			this.quary_name = "product_id";
			this.order = "desc";
		}else if(filter.equals("low")) {
			this.quary_name = "product_price";
			this.order = "asc";
		}else if(filter.equals("high")) {
			this.quary_name = "product_price";
			this.order = "desc";
		}
		
		System.out.println("filter는 =>"+ filter);
	}
	
	public String getQuary_name() {
		return quary_name;
	}

	public String getOrder() {
		return order;
	}
}
