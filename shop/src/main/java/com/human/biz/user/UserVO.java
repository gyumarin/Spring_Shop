package com.human.biz.user;

public class UserVO {
	
	private String id;              //����� ID
    private String name;            //����� �̸�
    private String password;        //����� ��й�ȣ
    private String address;         //����� �ּ�
    private int role;               //����� ����
    
    public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}

}
