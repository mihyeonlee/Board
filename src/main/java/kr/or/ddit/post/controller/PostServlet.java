package kr.or.ddit.post.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.atchfile.model.AtchFileVo;
import kr.or.ddit.post.model.PostVo;
import kr.or.ddit.post.service.PostService;
import kr.or.ddit.post.service.PostServiceI;
import kr.or.ddit.reply.model.ReplyVo;
import kr.or.ddit.reply.service.ReplyService;
import kr.or.ddit.reply.service.ReplyServiceI;

@WebServlet("/post")
public class PostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(PostServlet.class);
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
		PostVo postVo = postService.getPost(post_seq);
		
		List<AtchFileVo> fileList = postService.getFile(post_seq);
		List<ReplyVo> replyList = replyService.getReply(post_seq);
		
		request.setAttribute("postVo", postVo);
		request.setAttribute("fileList", fileList);
		request.setAttribute("replyList", replyList);
		logger.debug("postVo:{}",postVo);
		logger.debug("fileList:{}",fileList);
		//jsp
		request.getRequestDispatcher(request.getContextPath()+"post/post.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
