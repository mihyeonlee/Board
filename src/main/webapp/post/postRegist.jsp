<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Summernote</title>
<%@ include file="/layout/commonLib.jsp"%>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>

<style type="text/css">

input[type=file] {
    display: inline;
}

</style>

</head>
<body>
	<%@ include file="/layout/header.jsp"%>
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<%@include file="/layout/left.jsp"%>
			</div>
			
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="col-sm-8 blog-main">
					<h2 class="sub-header">${board_name}</h2>
					
					<div class="table-responsive">
					
						<form id="iform" action="${cp }/postRegist" method="POST" 
							  enctype="multipart/form-data" role="form">
							
							<input type="text" name="user_id" value="${S_MEMBER.user_id }" hidden="hidden">
							<input type="text" name="board_seq" value="${curboard_seq }" hidden="hidden">
							<input type="text" name="post_yn" value="${curboard_seq }" hidden="hidden">
							
							<label for="post_title" class="col-sm-2 control-label">제목</label>
							<input type="text" name="post_title" > <br><br>
							
							<textarea rows="" cols="" id="summernote" name="post_content"></textarea>
							
							<div class="form-group">
								<label for="realFilename" class="col-sm-2 control-label">첨부 파일</label>
									<input type="button" class="btn btn-default" id="addFile" value="파일 추가">
									<input type="submit" class="btn btn-default pull-right" value="작성완료"> 
									<br><br>
									<input type="hidden" name="realFilename"><input type="hidden" value="x" name="deleteFile"><br>
									<input type="hidden" name="realFilename"><input type="hidden" value="x" name="deleteFile"><br>
									<input type="hidden" name="realFilename"><input type="hidden" value="x" name="deleteFile"><br>
									<input type="hidden" name="realFilename"><input type="hidden" value="x" name="deleteFile"><br>
									<input type="hidden" name="realFilename"><input type="hidden" value="x" name="deleteFile"><br>
							</div>
						</form>
						
					</div>
				</div>
			</div>
		</div>

	</div>

</body>
<script type="text/javascript">

	$("#addFile").on("click", function(){
		$("input[type=hidden][name=realFilename]").eq(0).prop("type", "file");
// 		$("input[type=hidden][name=deleteFile]").eq(0).prop("type", "button");
		
	})
	
// 	$("input[type=button][name=deleteFile]").on("click",function(){
// 		var indexNo = $(this).index();
// 		$(this).prop("type", "hidden");
// 		$("input[type=file][name=realFilename]").eq(indexNo).prop("type", "hidden");
		
		
// 	})

	

</script>



</html>