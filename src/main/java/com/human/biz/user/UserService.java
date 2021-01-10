package com.human.biz.user;

public interface UserService {

	UserVO loginUser(UserVO vo);

	void joinUser(UserVO vo);

	int idCheck(UserVO vo);

}
