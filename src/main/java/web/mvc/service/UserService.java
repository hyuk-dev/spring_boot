package web.mvc.service;

import web.mvc.domain.User;

public interface UserService {
	/**
	 * �로그인하기
	 * */
   User loginCheck(User user);
}
