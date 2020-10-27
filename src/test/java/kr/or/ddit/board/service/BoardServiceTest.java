package kr.or.ddit.board.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.board.model.BoardVo;

public class BoardServiceTest {
	
	private BoardServiceI boardService;
	
	@Before
	public void setup() {
		boardService = new BoardService();
	}
	
	@Test
	public void getAllBoardListTest() {
		/***Given***/

		
		/***When***/
		List<BoardVo> boardList = boardService.getAllBoardList();
		/***Then***/
		assertEquals(2, boardList.size());
	}
	
	@Test
	public void insertBoardTest() {
		/***Given***/
		BoardVo boardVo = new BoardVo("미현게시판2", "Y", "brown");
		
		/***When***/
		int insert_cnt = boardService.insertBoard(boardVo);
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
		int update_cnt = boardService.updateBoard(boardVo);
		/***Then***/
		assertEquals(1,update_cnt);
	}
	

}
