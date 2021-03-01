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
		width:200px; 
		display: flex; 
		align-items: center; 
		justify-content: center
	">
	</div>
	<div style="
		flex-grow:1; 
		display: flex; 
		align-items: center; 
		justify-content: center
	">
		관리자페이지
	</div>
	<div style="
		width:200px; 
		display: flex; 
		align-items: center; 
		justify-content: center
	">
		<a href="../logout?type=admin">LOGOUT</a>		
	</div>
</div>
</body>
</html>