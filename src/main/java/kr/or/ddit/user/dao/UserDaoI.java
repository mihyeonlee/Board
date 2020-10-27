package kr.or.ddit.user.dao;

import kr.or.ddit.user.model.UserVo;

public interface UserDaoI {

	UserVo getUser(String user_id);
	
	
}
