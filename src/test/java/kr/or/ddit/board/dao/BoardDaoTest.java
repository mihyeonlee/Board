package kr.or.ddit.board.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.board.model.BoardVo;

public class BoardDaoTest {
	
	private BoardDaoI boardDao;
	
	@Before
	public void setup() {
		boardDao = new BoardDao();
	}
	
	@Test
	public void getAllBoardListTest() {
		/***Given***/

		
		/***When***/
		List<BoardVo> boardList = boardDao.getAllBoardList();
		/***Then***/
		assertEquals(2, boardList.size());
	}
	
	@Test
	public void insertBoardTest() {
		/***Given***/
		BoardVo boardVo = new BoardVo("미현게시판", "Y", "brown");
		
		/***When***/
		int insert_cnt = boardDao.insertBoard(boardVo);
		/***Then***/
		assertEquals(1,insert_cnt);
	}
	
	@Test
	public void updateBoardTest() {
		/***Given***/
		BoardVo boardVo = new BoardVo();
		boardVo.setBoard_seq(8);
		boardVo.setBoard_yn("N");
		
		/***When***/
		int update_cnt = boardDao.updateBoard(boardVo);
		/***Then***/
		assertEquals(1,update_cnt);
	}
	
	

}
