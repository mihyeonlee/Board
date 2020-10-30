package kr.or.ddit.reply.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.reply.model.ReplyVo;
import kr.or.ddit.reply.service.ReplyService;
import kr.or.ddit.reply.service.ReplyServiceI;

@WebServlet("/replyRegist")
public class ReplyRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReplyServiceI replyService;

	@Override
	public void init() throws ServletException {
		replyService = new ReplyService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int post_seq = Integer.parseInt(request.getParameter("post_seq"));
		String reply_content = request.getParameter("reply_content");
		String user_id = request.getParameter("user_id");
		
		ReplyVo replyVo = new ReplyVo(reply_content, post_seq, user_id);
		int insertCnt = replyService.insertReply(replyVo);
		
		response.sendRedirect(request.getContextPath()+"/post?post_seq="+post_seq);
	}
}
