<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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



					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">제목</label>
						<div class="col-sm-10">
							<label class="control-label">${postVo.post_title}</label>
						</div>
					</div>

					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label" >글 내용</label>
						<div class="col-sm-10">

							<label class="control-label" >${postVo.post_content}</label>
						</div>
					</div>
					
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">첨부 파일</label>
						<div class="col-sm-10">
							<c:forEach items="${fileList }" var="file">
							<button type="button" class="btn btn-default profileDownBtn" name="${file.atch_file_seq }" style="margin-right: 200px; height: 30px;margin-bottom: 3px;">다운로드 : ${file.file_name }</button>
							<br>
							</c:forEach>
							<br>
							<c:if test="${S_USER.user_id == postVo.user_id }">
								<a href="${cp }/postUpdate?post_seq=${postVo.post_seq}"><button type="button" class="btn btn-default">수정</button></a>
								<a href="${cp }/postDelete?post_seq=${postVo.post_seq}"><button type="button" class="btn btn-default">삭제</button></a>
							</c:if>
								<a href="${cp }/postAnswer?post_seq=${postVo.post_seq}"><button type="button" class="btn btn-default">답글</button></a>
							<p></p>
							<br><br>
						</div>
					</div>
					<div class="form-group" style="margin-top: 20px;">
					
						<label for="userNm" class="col-sm-2 control-label" >댓글</label>
						<br><br>
						<div class="col-sm-10">
							<c:forEach items="${replyList }" var="reply">
								<c:if test="${reply.reply_yn == 'Y' }">
									<label class="control-label" >${reply.reply_content}</label>
									<label class="control-label" >[${reply.user_id}/</label>
									<label class="control-label" ><fmt:formatDate value="${reply.reply_reg_dt }" pattern="yyyy-MM-dd" />]</label>
									
									<c:if test="${reply.user_id==S_USER.user_id }">
										<input type="button" value="x" name="${reply.reply_seq }" class="btn btn-default dreply" style="padding: 3px 6px;"/>
									</c:if>
								</c:if>
								
								<c:if test="${reply.reply_yn == 'N' }">
									<label class="control-label" >[삭제된 댓글입니다.]</label>
								</c:if>
								
								<br>
							</c:forEach>
							<br>
						</div>
					</div>
					
					<div class="form-group">
						<form action="${cp }/replyRegist" method="POST" id="reform">
								<input type="hidden" value="${postVo.post_seq }" name="post_seq">
								<input type="hidden" value="${S_USER.user_id }" name="user_id">
								
						<div class="col-sm-10" style="width: 50%;">
								
								<textarea  class="form-control" id="reply_content" name="reply_content" ></textarea>
								
						</div>
								<button id="replyBtn" type="button" class="btn btn-default">댓글저장</button>
						</form>
					</div>

					
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
var cur_id = $('input[type=hidden][name=user_id]').val();

$('.dreply').on('click',function(){
	var reply_seq = $(this).attr('name');
	document.location = "/deleteReply?reply_seq="+reply_seq+"&post_seq=${postVo.post_seq}";
})

$('.profileDownBtn').on("click",function(){
	var seq = $(this).attr('name');
	document.location="/profileDownload?atch_file_seq="+seq+"";
})
$('#replyBtn').on('click',function(){
	$('#reform').submit();
})
</script>
</html>