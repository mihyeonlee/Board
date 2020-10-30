package kr.or.ddit.reply.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.reply.model.ReplyVo;

public class ReplyDao implements ReplyDaoI {

	@Override
	public List<ReplyVo> getReply(int post_seq) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		List<ReplyVo> replyList = sqlSession.selectList("reply.getReply",post_seq);
		
		sqlSession.close();
		
		return replyList;
	}

	@Override
	public int insertReply(ReplyVo replyVo) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int insertCnt=0;
		try {
			insertCnt = sqlSession.insert("reply.insertReply",replyVo);
		} catch (Exception e) {
			
		}
		
		if(insertCnt==1) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
		sqlSession.close();
		
		return insertCnt;
	}

	@Override
	public int deleteReply(int reply_seq) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int deleteCnt = 0;
		try {
			deleteCnt = sqlSession.update("reply.deleteReply",reply_seq);
		} catch (Exception e) {
			
		}
		if(deleteCnt==1) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
		sqlSession.close();
		
		return deleteCnt;
	}

}
