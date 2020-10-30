package kr.or.ddit.post.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.atchfile.model.AtchFileVo;
import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.page.model.PageVo;
import kr.or.ddit.post.model.PostVo;

public class PostDao implements PostDaoI {
	private static final Logger logger = LoggerFactory.getLogger(PostDao.class);
	

	@Override
	public List<PostVo> getPostList(int board_seq) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		List<PostVo> postList = sqlSession.selectList("post.getPostList");
		//닫기
		sqlSession.close();
		return postList;
	}

	@Override
	public int getPostTotalCnt(SqlSession sqlSession, int board_seq) {
		int cnt = 0;
		try {
			cnt = sqlSession.selectOne("post.getPostTotalCnt", board_seq);
		} catch (Exception e) {
			
		}
		logger.debug("totalcnt:{}",cnt);
		return cnt;
	}

	@Override
	public List<PostVo> getPostPage(SqlSession sqlSession, PageVo pageVo) {
		return sqlSession.selectList("post.getPostPage",pageVo);
	}

	@Override
	public int insertPost(PostVo postVo, SqlSession sqlSession) {

		int pCnt = 0;
		try {
			pCnt = sqlSession.insert("post.insertPost",postVo);
		} catch (Exception e) {
			
		}
		
		return pCnt;
	}

	
	@Override
	public PostVo getPost(int post_seq) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		PostVo postVo = sqlSession.selectOne("post.getPost",post_seq);
		
		sqlSession.close();
		return postVo;
	}

	@Override
	public List<AtchFileVo> getFile(int post_seq) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		List<AtchFileVo> fileList = sqlSession.selectList("post.getFile",post_seq);
		
		sqlSession.close();
		return fileList;
	}

	@Override
	public int deletePost(int post_seq) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		int cnt = 0;
		try {
			cnt = sqlSession.update("post.deletePost",post_seq);
		} catch (Exception e) {
			
		}
		if(cnt==1) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
		sqlSession.close();
		return cnt;
	}

	@Override
	public int insertAnswer(PostVo postVo,SqlSession sqlSession) {
		int pCnt = 0;
		try {
			pCnt = sqlSession.insert("post.insertAnswer",postVo);
		} catch (Exception e) {
			
		}
		
		return pCnt;
	}

	@Override
	public int updatePost(PostVo postVo,SqlSession sqlSession) {
		int pCnt = 0;
		try {
			pCnt = sqlSession.update("post.updatePost",postVo);
		} catch (Exception e) {
			
		}
		return pCnt;
	}
	
	

}
