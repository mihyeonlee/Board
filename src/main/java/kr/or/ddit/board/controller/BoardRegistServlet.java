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


@WebServlet("/boardRegist")
public class BoardRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(BoardRegistServlet.class);
	private BoardServiceI boardService;
	
	
	@Override
	public void init() throws ServletException {
		boardService = new BoardService();
	}
   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//인코딩
		request.setCharacterEncoding("utf-8");
		//게시판정보
		String board_name = request.getParameter("board_name");
		String board_yn = request.getParameter("board_yn");
		UserVo user = (UserVo) request.getSession().getAttribute("S_USER");
		String user_id = user.getUser_id();
		logger.debug("user_id:{}",user_id);
		
		BoardVo boardVo = new BoardVo(board_name, board_yn, user_id);
		//db insert
		int insert_cnt = boardService.insertBoard(boardVo);
		logger.debug("insert_cnt : {}",insert_cnt);
		if(insert_cnt==1) {
			response.sendRedirect(request.getContextPath()+"/boardList?='성공'");
		}else {
			request.getRequestDispatcher(request.getContextPath()+"/board/boardRegist.jsp").forward(request, response);
		}
		
	}

}
