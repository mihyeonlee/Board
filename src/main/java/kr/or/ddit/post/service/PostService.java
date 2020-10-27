package kr.or.ddit.post.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.db.MybatisUtil;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.page.model.PageVo;
import kr.or.ddit.post.dao.PostDao;
import kr.or.ddit.post.dao.PostDaoI;
import kr.or.ddit.post.model.PostVo;

public class PostService implements PostServiceI {
	private PostDaoI postDao;
	
	public PostService() {
		postDao = new PostDao();
	}
	@Override
	public List<PostVo> getPostList(int board_seq) {
		
		return postDao.getPostList(board_seq);
	}
	@Override
	public Map<String, Object> getPostPage(PageVo pageVo) {
		
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		Map<String, Object> map = new HashMap<String,Object>();
		List<PostVo> postList = postDao.getPostPage(sqlSession,pageVo);
		map.put("postList", postList);
		map.put("pageVo", pageVo);
		
		//pageSize = 10 
		Double totalCnt = (double) postDao.getPostTotalCnt(sqlSession,pageVo.getBoard_seq());
		int pages = (int)Math.ceil(totalCnt/10);
		map.put("pages", pages);
		
		sqlSession.close();
		return map;
	}
	@Override
	public int insertPost(PostVo postVo) {
		
		return postDao.insertPost(postVo);
	}
	
}
