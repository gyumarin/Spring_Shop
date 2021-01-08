package com.buman.biz.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.human.biz.user.UserService;
import com.human.biz.user.UserVO;

@Service("UserService")
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDAO userDAO;

	@Override
	public UserVO loginUser(UserVO vo) {
		// TODO Auto-generated method stub
		return userDAO.loginUser(vo);
	}

}
