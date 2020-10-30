package kr.or.ddit.post.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.atchfile.dao.AtchFileDao;
import kr.or.ddit.atchfile.dao.AtchFileDaoI;
import kr.or.ddit.atchfile.model.AtchFileVo;
import kr.or.ddit.db.MybatisUtil;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.page.model.PageVo;
import kr.or.ddit.post.dao.PostDao;
import kr.or.ddit.post.dao.PostDaoI;
import kr.or.ddit.post.model.PostVo;

public class PostService implements PostServiceI {
	private PostDaoI postDao;
	private AtchFileDaoI atchFileDao;
	private static final Logger logger = LoggerFactory.getLogger(PostService.class);
	public PostService() {
		postDao = new PostDao();
		atchFileDao = new AtchFileDao();
	}

	@Override
	public List<PostVo> getPostList(int board_seq) {

		return postDao.getPostList(board_seq);
	}

	@Override
	public Map<String, Object> getPostPage(PageVo pageVo) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();

		Map<String, Object> map = new HashMap<String, Object>();
		List<PostVo> postList = postDao.getPostPage(sqlSession, pageVo);
		map.put("postList", postList);
		map.put("pageVo", pageVo);

		// pageSize = 10
		Double totalCnt = (double) postDao.getPostTotalCnt(sqlSession, pageVo.getBoard_seq());
		int pages = (int) Math.ceil(totalCnt / 10);
		map.put("pages", pages);

		sqlSession.close();
		return map;
	}

	@Override
	public int insertPost(Map<String, Object> insertMap) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int cnt = 0;
		int fCnt = 0;

		PostVo postVo = (PostVo) insertMap.get("postVo");
		List<AtchFileVo> fileList = (List<AtchFileVo>) insertMap.get("fileList");

		int pCnt = postDao.insertPost(postVo, sqlSession);
		// selectKey
		int post_seq = postVo.getPost_seq();

		for (AtchFileVo fileVo : fileList) {
			fileVo.setPost_seq(post_seq);
			fCnt = atchFileDao.insertFile(fileVo, sqlSession);

			if (fCnt != 1) {
				break;
			}
		}
		int fileListSize = (int) insertMap.get("fileListSize");
		if(fileListSize==0) {
			fCnt = 1;
		}
		if (pCnt == 1 && fCnt == 1) {
			cnt = 1;
		}

		if (cnt == 1) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		sqlSession.close();

		return cnt;
	}

	@Override
	public PostVo getPost(int post_seq) {
		return postDao.getPost(post_seq);
	}

	@Override
	public List<AtchFileVo> getFile(int post_seq) {
		return postDao.getFile(post_seq);
	}

	@Override
	public int deletePost(int post_seq) {

		return postDao.deletePost(post_seq);
	}

	@Override
	public int insertAnswer(Map<String, Object> insertMap) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int cnt = 0;
		int fCnt = 0;

		PostVo postVo = (PostVo) insertMap.get("postVo");
		List<AtchFileVo> fileList = (List<AtchFileVo>) insertMap.get("fileList");

		int pCnt = postDao.insertAnswer(postVo, sqlSession);
		// selectKey
		int post_seq = postVo.getPost_seq();

		for (AtchFileVo fileVo : fileList) {
			fileVo.setPost_seq(post_seq);
			fCnt = atchFileDao.insertFile(fileVo, sqlSession);

			if (fCnt != 1) {
				break;
			}
		}
		
		int fileListSize = (int) insertMap.get("fileListSize");
		if(fileListSize==0) {
			fCnt = 1;
		}

		if (pCnt == 1 && fCnt == 1) {
			cnt = 1;
		}

		if (cnt == 1) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		sqlSession.close();

		return cnt;
	}

	@Override
	public int updatePost(Map<String, Object> updateMap) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int cnt = 0;
		int fCnt = 0;
		int dCnt = 0;

		PostVo postVo = (PostVo) updateMap.get("postVo");
		List<AtchFileVo> fileList = (List<AtchFileVo>) updateMap.get("fileList");

		int pCnt = postDao.updatePost(postVo, sqlSession);
		// selectKey
		
		for (AtchFileVo fileVo : fileList) {
			fCnt = atchFileDao.insertFile(fileVo, sqlSession);

			if (fCnt != 1) {
				break;
			}
		}
		if((int)updateMap.get("insertFileRe")==0) {
			fCnt = 1;
		}
		
		int[] file_seq = (int[]) updateMap.get("file_seq");
		
		for (int i = 0; i < file_seq.length; i++) {
			if (file_seq[i] == 0) {
				continue;
			}
			dCnt = atchFileDao.deleteFile(file_seq[i], sqlSession);
			if (dCnt != 1) {
				break;
			}
		}
		
		int count = 0;
		for(int files : file_seq) {
			if(files==0) {
				count++;
			}
		}
		if(count==5) {
			dCnt = 1;
		}
		
		logger.debug("pCnt:{}",pCnt);
		logger.debug("fCnt:{}",fCnt);
		logger.debug("dCnt:{}",dCnt);
		
		if (pCnt == 1 && fCnt == 1 && dCnt ==1) {
			cnt = 1;
		}

		if (cnt == 1) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		sqlSession.close();

		return cnt;
	}

}
