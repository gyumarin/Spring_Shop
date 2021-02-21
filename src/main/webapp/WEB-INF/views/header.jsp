<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<!DOCTYPE html>
<html>
<body>
<div style = "
	width:100%;
	height:50px;
	border:1px solid black;
	border-bottom:0px solid black;
	display: flex; 
	align-items: center; 
	justify-content: center
">SHOP</div>
<div style = "
	width:100%;
	height:50px;
	margin-bottom: 200px;
	display: inline-flex;
	border:1px solid black;
">
	<div style="
		flex-grow: 1; 
		display: flex; 
		align-items: center; 
		justify-content: center
	">
		목록
	</div>
	<div style="
		flex-grow: 1; 
		display: flex; 
		align-items: center; 
		justify-content: center
	">
		검색
	</div>
	<div style="
		flex-grow: 1; 
		display: flex; 
		align-items: center; 
		justify-content: center
	">
	<c:choose>
       <c:when test="${empty sessionScope.loginUser}">
       	<a href="login">로그인</a>        
       /
       <a href="join">회원가입</a>
       </c:when>
		<c:otherwise>
		<a href="myPage">${sessionScope.loginUser.user_name}(${sessionScope.loginUser.user_id})</a>  
		/
		<a href="logout">LOGOUT</a>
		</c:otherwise>       
       </c:choose>
		
	</div>
</div>
</body>
</html>