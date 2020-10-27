package kr.or.ddit.board.dao;


import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.db.MybatisUtil;

public class BoardDao implements BoardDaoI {

	@Override
	public List<BoardVo> getAllBoardList() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		List<BoardVo> boardList = sqlSession.selectList("board.getAllBoardList");
		sqlSession.close();
		return boardList;
	}

	@Override
	public int insertBoard(BoardVo boardVo) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int insert_cnt = 0;
		try {
			insert_cnt = sqlSession.insert("board.insertBoard",boardVo);
			
		}catch (Exception e) {
		}
		
		if(insert_cnt == 1) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
		sqlSession.close();
		
		return insert_cnt;
	}

	@Override
	public int updateBoard(BoardVo boardVo) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		int update_cnt = sqlSession.update("board.updateBoard",boardVo);
		
		if(update_cnt==1) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
		sqlSession.close();
		
		return update_cnt;
	}

}
