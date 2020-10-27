<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
#tt{
	font-size: 1.1em;
	width: 70%

}
#frm{
	font-size: 1.2em;
}
#ubtn{
	float: left;

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
						<h2 class="sub-header">게시판 관리</h2>
						<div class="table-responsive">
						
							<form id="frm" class="form-horizontal" role="form" action="${cp }/boardRegist" method="POST" >
								<div class="form-group">
									<span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;새 게시판생성</span>&nbsp;&nbsp;
									<input type="text" id="board_name" name="board_name" placeholder="게시판 이름" value="${param.board_name }">
									<select name="board_yn">
										<option value="Y">사용</option>
										<option value="N">미사용</option>
									</select>
									<input type="submit" name="boardRegist" value="생성">
								</div>
							</form>
							<br>
							<table class="table table-striped" id="tt">
								<tr>
									<th>게시판 이름</th>
									<th>사용 여부</th>
									<th>수정하기</th>
								</tr>
								<!--테이블내에서 가지고오려는 데이터를 나눌때 tbody많이 사용 -->
								<tbody id="boardList">
									<c:forEach items="${boardList }" var="board">
							<form id=updateform" action="${cp }/boardUpdate" method="POST">
										<tr>
											<td>${board.board_name } 
												<input type="hidden" value="${board.board_seq }" name="board_seq">
											</td>
											<td>
												<select id="board_yn" name="board_yn">
													<option value="Y" <c:if test="${board.board_yn=='Y'}">selected="selected"</c:if> >사용</option>
													<option value="N" <c:if test="${board.board_yn=='N'}">selected="selected"</c:if> >미사용</option>
												</select>
											</td>
											<td>
											<input id = "ubtn" class="btn btn-default" type="submit" id="yn" value="수정"></td>
							</form>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>

						
						
					</div>
				</div>
				
				
				
			</div>

			
		</div>
	</div>

</body>



</html>