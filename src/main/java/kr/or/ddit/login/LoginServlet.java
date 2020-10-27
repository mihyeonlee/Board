package kr.or.ddit.login;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceI;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceI;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(LoginServlet.class);
	private UserServiceI userService;
	private BoardServiceI boardService;

	@Override
	public void init() throws ServletException {
		userService = new UserService();
		boardService = new BoardService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher(request.getContextPath() + "/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String user_id = request.getParameter("user_id");
		String password = request.getParameter("password");
		
		//일치하는 사용자
		UserVo userVo = userService.getUser(user_id);
		logger.debug("loginServlet userVo : {}", userVo);
		
		//boardList
		List<BoardVo> boardList = boardService.getAllBoardList();
		
		//db에 일치하는 사용자가 없거나 비밀번호가 일치하지 않으면 login page
		if (userVo == null || !userVo.getPassword().equals(password)) {
			request.getRequestDispatcher(request.getContextPath() + "/login.jsp").forward(request, response);
		}
		//비밀번호가 일치하면 main으로
		else if (userVo.getPassword().equals(password)) {
			request.getSession().setAttribute("S_USER", userVo);
			ServletContext application = this.getServletContext();
			application.setAttribute("boardList", boardList);
//			request.getSession().setAttribute("S_BOARD", boardList);
			request.getRequestDispatcher(request.getContextPath() + "/main.jsp").forward(request, response);
		}

		// 쿠키정보
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			logger.debug("cookieName: {}, cookieValue: {}", cookie.getName(), cookie.getValue());
		}

		Cookie cookie = new Cookie("SERVERCOOKIE", "COOKIEVALUE");
		cookie.setMaxAge(60 * 60 * 24);

		response.addCookie(cookie);

	}

}
