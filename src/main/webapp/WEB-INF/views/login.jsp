<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<html>
<head>
<title>LOGIN</title>
</head>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript">

$(function() {

   /*  $("#requestBtn").on("click", function() {
    	alert("됨");

    	$.ajax({
    	    url: "login", // 클라이언트가 요청을 보낼 서버의 URL 주소
    	    data: { user_id: "admin" , user_password : "1234"},                // HTTP 요청과 함께 서버로 보낼 데이터
    	    type: "POST",                             // HTTP 요청 방식(GET, POST)
    	    dataType: "json"                         // 서버에서 보내줄 데이터의 타입

    	})
    	// HTTP 요청이 성공하면 요청한 데이터가 done() 메소드로 전달됨.

    	.done(function(json) {

    	    $("<h1>").text(json.title).appendTo("body");

    	    $("<div class=\"content\">").html(json.html).appendTo("body");

    	})

    	// HTTP 요청이 실패하면 오류와 상태에 관한 정보가 fail() 메소드로 전달됨.

    	.fail(function(xhr, status, errorThrown) {

    	    $("#text").html("오류가 발생했습니다.<br>")

    	    .append("오류명: " + errorThrown + "<br>")

    	    .append("상태: " + status);

    	})

    	// HTTP 요청이 성공하거나 실패하는 것에 상관없이 언제나 always() 메소드가 실행됨.

    	.always(function(xhr, status) {

    	    $("#text").html("요청이 완료되었습니다!");

    	});

      
    }); */

});

</script>

<body>
	<div align="center">
		<!-- width of this page -->
		<div style="width:1000px;">
			<!-- header start -->
			<%@ include file="header.jsp" %>
			<!-- header end -->
	
			<!-- contents start -->
			<form
				action="login"
				method="post"
				id="login_form"
				style = "
					width:100%;
					height:500;
					background-color: skyblue;
					display: inline-flex; 
					justify-content: center;
					align-items: center; 
			">
				<div style = "
					display: inline-flex; 
					flex-direction: column;
					width:250px;
				">
					<input name="user_id" style="margin-bottom:15px; height:30px">
					<input name="user_password" type="password" style="margin-bottom:15px; height:30px">
					<input value="로그인" type ="submit">
					<div style="text-align: right">회원가입</div>
				</div>
					
			</form>
			<!-- contents end -->
		</div>
	</div>
</body>
</html>
