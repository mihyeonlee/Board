package kr.or.ddit.user.service;

import kr.or.ddit.user.dao.UserDao;
import kr.or.ddit.user.dao.UserDaoI;
import kr.or.ddit.user.model.UserVo;

public class UserService implements UserServiceI{
	private UserDaoI userDao;
	
	public UserService() {
		userDao = new UserDao();
	}

	@Override
	public UserVo getUser(String user_id) {
		
		return userDao.getUser(user_id);
	}

}
