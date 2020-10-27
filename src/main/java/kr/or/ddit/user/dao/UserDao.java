package kr.or.ddit.user.dao;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.user.model.UserVo;

public class UserDao implements UserDaoI{
	private static final Logger logger = LoggerFactory.getLogger(UserDao.class);

	@Override
	public UserVo getUser(String user_id) {
		
		//mybatis 환경구성
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		UserVo userVo = sqlSession.selectOne("user.getUser",user_id);
		sqlSession.close();
		
		logger.debug("getUser userVo: {}",userVo);
		
		return userVo;
	}


}
