package com.human.biz.util;

public class Paging {
	private int limit = 4;			//�� �������� ������ ��ǰ ��
	private int offset;				//������ �� ��ü ��ǰ�� ���� ��
									//1page = 0;
									//2page = 8;
	//���������� ��
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
