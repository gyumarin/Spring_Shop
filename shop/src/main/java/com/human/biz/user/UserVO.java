package com.human.biz.user;

public class UserVO {
	
	private String id;              //사용자 ID
    private String name;            //사용자 이름
    private String password;        //사용자 비밀번호
    private String address;         //사용자 주소
    private int role;               //사용자 권한
    
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
