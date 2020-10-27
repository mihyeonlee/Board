package kr.or.ddit.post.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.page.model.PageVo;
import kr.or.ddit.post.service.PostService;
import kr.or.ddit.post.service.PostServiceI;

/**
 * Servlet implementation class BoardListServlet
 */
@WebServlet("/postList")
public class PostListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(PostListServlet.class);
	private PostServiceI postService;
	
	@Override
		public void init() throws ServletException {
			postService = new PostService(); 
		}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//board_name
		String board_name =  request.getParameter("board_name");
		
		//board_seq
		String board_seq_str = request.getParameter("board_seq");
		request.getSession().setAttribute("curboard_seq", board_seq_str);
		int board_seq = board_seq_str == null ? 5 : Integer.parseInt(board_seq_str);
		logger.debug("board_seq:{}",board_seq);
		
		//page
		String page_str = request.getParameter("page");
		int page = page_str == null ? 1 : Integer.parseInt(page_str);
		request.setAttribute("page", page);
		
		
		//pageSize
		String pageSize_str = request.getParameter("pageSize");
		int pageSize = pageSize_str ==null?7:Integer.parseInt(pageSize_str);
		request.setAttribute("pageSize", pageSize);
		
		//pageVo
		PageVo pageVo = new PageVo(page, pageSize, board_seq,board_name);
		
		//서비스호출, 결과저장
		Map<String, Object> map = postService.getPostPage(pageVo);
		request.setAttribute("pageVo", map.get("pageVo"));
		request.setAttribute("postList", map.get("postList"));
		request.setAttribute("pages", map.get("pages"));
		
		logger.debug("postList:{}",map.get("postList"));
		
		//jsp
		request.getRequestDispatcher(request.getContextPath()+"post/postList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
