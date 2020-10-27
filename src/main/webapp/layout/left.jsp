<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!-- <ul class="nav nav-sidebar"> -->
<%-- 	<li class="active"><a href="${pageContext.request.contextPath }/main.jsp">Main <span class="sr-only">(current)</span></a></li> --%>
<%-- 	<li class="active"><a href="${pageContext.request.contextPath }/boardList">게시판 관리</a></li> --%>

<div class="sidenav">
	<a href="${cp }/main.jsp">Main</a> 
	<a href="${cp }/boardList">게시판 관리</a>
	<button class="dropdown-btn active">
		게시판 목록 <i class="fa fa-caret-down"></i>
	</button>

	<div class="dropdown-container active">
		<c:forEach items="${boardList }" var="board">
		<c:if test="${board.board_yn == 'Y' }">
			<li class="active"><a
				href="${pageContext.request.contextPath }/postList?board_seq=${board.board_seq}&board_name=${board.board_name }">
					${board.board_name }<br>
			</a></li>
		</c:if>
		</c:forEach>
	</div>
</div>


</ul>

