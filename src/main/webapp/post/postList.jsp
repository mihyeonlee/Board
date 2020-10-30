<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
#tt{
	font-size: 1.1em;


}
#frm{
	font-size: 1.2em;
}
#ubtn{
	float: left;

}
.ptitle{
	width: 47%;
	
}
#re{
	font-size: 0.8em;
	color: gray;

}
</style>
<%@ include file="/layout/commonLib.jsp" %> 
</head>
<body>
<%@ include file="/layout/header.jsp" %>
<div class="container-fluid">
		<div class="row">

			<div class="col-sm-3 col-md-2 sidebar">
				<%@include file="/layout/left.jsp"%>
			</div>
			
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

				
				<div class="row">
					<div class="col-sm-8 blog-main">
						<h2 class="sub-header">${S_BOARD.board_name}</h2>
						<div class="table-responsive">
						
							<br>
							<form id=updateform" action="${cp }/boardUpdate" method="POST">
							<table class="table table-striped" id="tt">
								<tr>
									<th>글 번호</th>
									<th>제	목</th>
									<th>작성자</th>
									<th>작성일자</th>
								</tr>
								<!--테이블내에서 가지고오려는 데이터를 나눌때 tbody많이 사용 -->
								<tbody id="postList">
									<c:forEach items="${postList }" var="post">
										<tr data-post_seq="${post.post_seq }">
											<td>${post.post_seq}</td>
											<td class="ptitle">
											<c:if test=""></c:if>
											<c:choose>
											<c:when test="${post.post_p_seq != null && post.post_yn =='Y'}">
												<span id="re">&nbsp;&nbsp;&nbsp;ㄴ 답 : ${post.post_title} </span>
											</c:when>
											
											<c:when test="${post.post_yn == 'N' }">
												<span class="depost">&nbsp;&nbsp;&nbsp;[삭제된 게시글 입니다.] </span>
											</c:when>
											
											<c:otherwise>
												${post.post_title}
											</c:otherwise>
											</c:choose>
											</td>
											
<%-- 											<c:if test="${post.post_p_seq != 0 }"><span>&nbsp;&nbsp;&nbsp;ㄴ 답 :</span></c:if> --%>
<%-- 											${post.post_title}</td> --%>
											
											<td>${post.user_id}</td>
											<td><fmt:formatDate value="${post.post_reg_dt }" pattern="yyyy-MM-dd" /></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							</form>
						</div>
							<a class="btn btn-default pull-right" href="${cp }/postRegist?board_name=${S_BOARD.board_name}">게시글 작성</a>
						
						page:${page }
						<div class="text-center">
							<ul class="pagination">
								<li><a href="${pageContext.request.contextPath }/postList?page=1&board_seq=${pageVo.board_seq}&board_name=${S_BOARD.board_name}" >&lt;&lt;</a></li>
								
								<c:if test="${page-1  > 0 }">
								<li><a href="${pageContext.request.contextPath }/postList?page=${page-1 }&board_seq=${pageVo.board_seq}&board_name=${S_BOARD.board_name}" >&lt;</a></li>
								</c:if>
								
								<c:if test="${page-1  == 0 }">
								<li><a>&lt;</a></li>
								</c:if>
								
								
								<c:forEach begin="1" end="${pages }" var="i">
									<c:choose>
									
										<c:when test="${i== page}">
											<li class="active"><span>${i }</span></li>
										</c:when>
										
										<c:otherwise>
											<li><a href="${pageContext.request.contextPath }/postList?page=${i}&board_seq=${pageVo.board_seq}&board_name=${S_BOARD.board_name}" >${i }</a></li>
										</c:otherwise>
										
									</c:choose>
								</c:forEach>
								<c:if test="${page < pages }">
								<li><a href="${pageContext.request.contextPath }/postList?page=${page+1 }&board_seq=${pageVo.board_seq}&board_name=${S_BOARD.board_name}" >&gt;</a></li>
								</c:if>
								
								<c:if test="${page  == pages }">
								<li><a>&gt;</a></li>
								</c:if>
								<li><a href="${pageContext.request.contextPath }/postList?page=${pages }&board_seq=${pageVo.board_seq}&board_name=${S_BOARD.board_name}" >&gt;&gt;</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
<script>

$(".depost").on('click', function(e){

	alert("삭제된 게시글입니다.")
	e.stopPropagation();
});

	
	$('#postList tr').on('click',function(){
		// data-userid <tr>태그에 적어놓음
		var post_seq = $(this).data("post_seq");
		console.log("post_seq : "+ post_seq);

		document.location = "/post?post_seq=" + post_seq;
		
	});

</script>
</body>




</html>