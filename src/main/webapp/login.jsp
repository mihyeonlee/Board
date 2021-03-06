<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Signin Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="<%=request.getContextPath() %>/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<%=request.getContextPath() %>/css/signin.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/js.cookie-2.2.1.min.js"></script>
	
	<script>
		$(function(){
			// 1. REMEMBERME쿠키값이 Y로 설정되어 있는지 확인
			// 2. REMEMBERME체크박스를 체크상태로 변경
			// 3. USERNM쿠키값을 확인하여 inputEmail아이디값을 가진 input태그에 추가
			if(Cookies.get('REMEMBERME')=='Y'){
				$('input[name="remember"]').attr('checked',true);
				
				var usernm = Cookies.get("USERID");
				
				$('#inputEmail').val(usernm);
			}

			//signin 버튼이 클릭되었을때  
			$('#signIn').on('click',function(){
				
				//1. Remember Me 체크박스가 체크되어 있으면
				//2. USERNM쿠키를 inputMail input 태그에 입력된 값으로 설정
				//3. REMEMBERME쿠키값을 Y로 설정
				if($('input[name="remember"]').prop('checked')){
					
					var userid = $('#inputEmail').val();
					Cookies.set("USERID",userid);
					Cookies.set("REMEMBERME","Y");

				//4. Remember me 체크박스가 체크안되어 있으면 
				//5. RMEMBERME, USERNM 쿠키를 삭제 
				}else{
					Cookies.remove("USERID");
					Cookies.remove("REMEMBERME");
				}
				
				//6. form태크에 대한 submit처리 (추후에)
				$('form').submit();

			})//signin버튼
			
		})//function
		
	
		//쿠키값 가져오기
		function getCookieValue(cookieName){
	    	var cookieValue;
			var cookies = document.cookie.split("; ")
			
			for(i=0;i<cookies.length;i++){
				var cookie = cookies[i].split("=");
				
				if(cookie[0]==cookieName){
					cookieValue = cookie[1];
					return cookieValue;
				}
			}
			return "없는 쿠키입니다";
		}

		//쿠키 추가(값 설정)
		function setCookie(cookieName, cookieValue, expires){
			var today = new Date();

			//현재날짜에서 미래로 + expires만큼 한 날짜 구하기
			today.setDate(today.getDate()+expires);

			//넣고싶은걸 쿠키에 대입하면 들어간다.
// 			document.cookie = cookieName + "=" + endcodeURIComponent(cookieValue) + "; path=/; expires=" + today.toGMTString();
			document.cookie = cookieName + "=" + cookieValue + "; path=/; expires=" + today.toGMTString();
			console.log(document.cookie);

		}

		//쿠키 삭제 - 해당쿠키의 expires속성을 과거날짜로 변경 
		function deleteCookie(cookieName){
			setCookie(cookieName,"",-1);
		}

	</script>
  </head>

  <body>

    <div class="container">

      <form class="form-signin" action="<%=request.getContextPath() %>/login" method="post">
        <h2 class="form-signin-heading">Please sign in</h2>
        <label for="inputEmail" class="sr-only">Email address</label>
        <input type="email" id="inputEmail" name="user_id" class="form-control" value="brown" placeholder="Email address" required autofocus>
        <label for="inputPassword" class="sr-only"  >Password</label>
        <input type="password" id="inputPassword" class="form-control" value="brownPass" name="password" placeholder="Password" required>
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me" name="remember" > Remember me
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="button" id="signIn">Sign in</button>
      </form>

    </div> <!-- /container -->


  </body>
</html>
    