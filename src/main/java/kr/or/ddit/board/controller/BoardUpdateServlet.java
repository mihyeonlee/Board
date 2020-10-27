package kr.or.ddit.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceI;
import kr.or.ddit.user.model.UserVo;


@WebServlet("/boardUpdate")
public class BoardUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(BoardUpdateServlet.class);
	private BoardServiceI boardService;
	
	
	@Override
	public void init() throws ServletException {
		boardService = new BoardService();
	}
   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("boardList", boardService.getAllBoardList());
		//인코딩
		request.setCharacterEncoding("utf-8");
		//게시판정보
		int board_seq = Integer.parseInt(request.getParameter("board_seq"));
		String board_yn = request.getParameter("board_yn");
		logger.debug("updateBoard:{},{}",board_seq,board_yn);
		
		BoardVo boardVo = new BoardVo();
		
		boardVo.setBoard_seq(board_seq);
		boardVo.setBoard_yn(board_yn);
		//db update
		int update_cnt = boardService.updateBoard(boardVo);
		logger.debug("update_cnt : {}",update_cnt);
		
		if(update_cnt==1) {
			response.sendRedirect(request.getContextPath()+"/boardList?='성공'");
		}else {
			request.getRequestDispatcher(request.getContextPath()+"/board/boardRegist.jsp").forward(request, response);
		}
		
	}

}
