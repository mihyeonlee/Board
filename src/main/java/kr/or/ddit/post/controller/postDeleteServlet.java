package kr.or.ddit.post.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.post.service.PostService;
import kr.or.ddit.post.service.PostServiceI;
import kr.or.ddit.reply.service.ReplyService;
import kr.or.ddit.reply.service.ReplyServiceI;

@WebServlet("/postDelete")
public class postDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(postDeleteServlet.class);
	private PostServiceI postService;
	private ReplyServiceI replyService;
	
	@Override
		public void init() throws ServletException {
			postService = new PostService();
			replyService = new ReplyService();
		}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int post_seq = Integer.parseInt(request.getParameter("post_seq"));
		BoardVo boardVo = (BoardVo) request.getSession().getAttribute("S_BOARD");
		
		String board_name = boardVo.getBoard_name();
		int board_seq = boardVo.getBoard_seq();
		
		int cnt = postService.deletePost(post_seq);
		
		request.getRequestDispatcher("postList?board_name="+board_name+"&board_seq="+board_seq).forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
