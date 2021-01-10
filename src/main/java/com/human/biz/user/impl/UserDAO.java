package com.human.biz.user.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.human.biz.user.UserVO;


@Repository
public class UserDAO {

	@Autowired
	private SqlSessionTemplate mybatis;

	public UserVO loginUser(UserVO vo) {
		// TODO Auto-generated method stub
		return mybatis.selectOne("userDAO.loginUser", vo);
	}


	public void joinUser(UserVO vo) {
		// TODO Auto-generated method stub
		mybatis.insert("userDAO.joinUser", vo);
	}


	public int idCheck(UserVO vo) {
		// TODO Auto-generated method stub
		return mybatis.selectOne("userDAO.idCheck", vo);
	}
}
