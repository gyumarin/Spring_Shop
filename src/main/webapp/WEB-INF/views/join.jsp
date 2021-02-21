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

function check_validation(){
	var test1 = $('#pass_success').val()
	var test2 = $('#id_success').val()
	var test3 = $('#pass_success').val() === 'true'
	var test4 = $('#id_success').val() === 'true'
	if($('#pass_success').val() ==='true' && $('#id_success').val() === 'true'){
		$("#submit").removeAttr("disabled"); 	
	}else{
		$("#submit").attr("disabled", "disabled");
	}	

}

function checkPassWord(){
	var pwd1=$(".user_password").val(); 
	var pwd2=$(".confirm_password").val(); 
	if(pwd1 != "" || pwd2 != ""){ 
		if(pwd1 == pwd2){
			$("#pass-success").show(); 
			$("#pass-danger").hide(); 
			$('#pass_success').val(true)
			check_validation()
		}else{ 
			$("#pass-success").hide(); 
			$("#pass-danger").show(); 
			$('#pass_success').val(false)
			check_validation()
	
		} 
	} 
}

$(function(){ 
	
	$("#id-success").hide(); 
	$("#id-danger").hide(); 
	$("#pass-success").hide(); 
	$("#pass-danger").hide(); 
	$(".user_password").keyup(function(){ 
		checkPassWord()
	}); 
	$(".confirm_password").keyup(function(){ 
		checkPassWord()
	});
	$(".user_id").keyup(function(){ 
		$.ajax({
			async: true,
		    type: "POST",                             // HTTP 요청 방식(GET, POST)
		    data: { user_id: $('.user_id').val() },                // HTTP 요청과 함께 서버로 보낼 데이터
		    url: "idCheck", // 클라이언트가 요청을 보낼 서버의 URL 주소
		    dataType: "json" ,                        // 서버에서 보내줄 데이터의 타입
		})
		// HTTP 요청이 성공하면 요청한 데이터가 done() 메소드로 전달됨.
		.done(function(res) {
			if(res.msg==1){
				$("#id-success").hide(); 
				$("#id-danger").show(); 
				$('#id_success').val(false);
				check_validation();
			}else if(res.msg==-1){
				$("#id-success").show(); 
				$("#id-danger").hide(); 
				$('#id_success').val(true);
				check_validation();
			}
		    /* $("<h1>").text(json.title).appendTo("body");
		
		    $("<div class=\"content\">").html(json.html).appendTo("body"); */
		
		})
		// HTTP 요청이 실패하면 오류와 상태에 관한 정보가 fail() 메소드로 전달됨.
		.fail(function(xhr, status, errorThrown) {
			alert(errorThrown);
		   /*  $("#text").html("오류가 발생했습니다.<br>")
		
		    .append("오류명: " + errorThrown + "<br>")
		
		    .append("상태: " + status); */
		
		})
		// HTTP 요청이 성공하거나 실패하는 것에 상관없이 언제나 always() 메소드가 실행됨.
		.always(function(xhr, status) {
			/* alert("요청이 완료되었습니다!"); */

		   /*  $("#text").html("요청이 완료되었습니다!"); */
		
		});


	});
}); 
</script>


<body>
	<input type="hidden" id="id_success" value=false>
	<input type="hidden" id="pass_success" value=false>
	<div align="center">
		<!-- width of this page -->
		<div style="width:1000px;">
			<!-- header start -->
			<%@ include file="header.jsp" %>
			<!-- header end -->
	
			<!-- contents start -->
			<form
				action="join"
				method="post"
				id="join_form"
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
					<input class="user_id" name="user_id" style="margin-bottom:15px; height:30px" required>
					<div class="alert id-success" id="id-success">존재하지않는 아이디 입니다.</div> 
					<div class="alert id-danger" id="id-danger">존재하는 아이디 입니다.</div>
					<input class="user_password" name="user_password" type="password" style="margin-bottom:15px; height:30px" required>
					<input class="confirm_password" name="confirm_password" type="password" style="margin-bottom:15px; height:30px" required>
					<div class="alert pass-success" id="pass-success">비밀번호가 일치합니다.</div> 
					<div class="alert pass-danger" id="pass-danger">비밀번호가 일치하지 않습니다.</div>​
					<input name="user_address" style="margin-bottom:15px; height:30px" required>
					<input id="submit" value="회원가입" type ="submit">
				</div>
					
			</form>
			<!-- contents end -->
		</div>
	</div>
</body>
</html>
