<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<!DOCTYPE html>
<html>
<header>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
	function keywordSearch(){
		location.href="/biz/home?keyword="+$("#keyword").val()
	}
/* 	$(function() {
 		$("#categoryMenu").mouseover(function(){
			$('#categorys').show();
		})
		$("#categoryMenu").mouseleave(function(){
			$('#categorys').hide();
		})
	}); */
</script>




</header>
<style>
	.dropmenu{
		border:none;
		border:0px;
		margin:0px;
		padding:0px;
		font: "sans-serif";
		font-size:18px;
	}
	
	.dropmenu ul{
		background: #666;
		height:50px;
		width:100%;
		list-style:none;
		margin:0;
		padding:0;
	}
	
	.dropmenu li{
		height:50px;
		float:left;
		padding:0px;
		margin:0px;
	}
	
	.dropmenu li a{
		height:50px;
		background: #666;
		color:#fff;
		margin:0px;
		text-align:center;
		text-decoration:none;
		line-height: 50px;		
	}
	
	.dropmenu li a:hover, .dropmenu ul li:hover a{
		color:#FFFFFF;
		text-decoration:none;
	}
	
	.dropmenu li ul{
		background: gray;
		display:none; 
		height:auto;
		border:0px;
		position:absolute;
		width:300px;
		z-index:200;
		/*top:1em;
		/*left:0;*/
	}
	
	.dropmenu li:hover ul{
		display:block;
	}
	
	.dropmenu li li {
		background: gray;
		display:block;
		float:none;
		margin:0px;
		padding:0px;
		width:200px;
	}
	
	.dropmenu li:hover li a{
		background:none;
	}
	
	.dropmenu li ul a{
		display:block;
		height:50px;
		font-size:14px;
		margin:0px;
		padding:0px 10px 0px 15px;
		text-align:left;
		}
	
	.dropmenu li ul a:hover, .dropmenu li ul li:hover a{
		background: rgb(171,171,171);
		border:0px;
		color:#ffffff;
		text-decoration:none;
	}
	
	.dropmenu p{
		clear:left;
	}
</style>
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
<div class="dropmenu"
	style = "
	width:100%;
	height:50px;
	margin-bottom: 200px;
	border:1px solid black;
	position: relative;
">
	<ul>
		<li style="width:200"><a href="#" id="current">카테고리목록</a>
			<ul>
				<li><a href="/biz/category?catenum=1">카테고리1</a></li>
				<li><a href="/biz/category?catenum=2">카테고리2</a></li>
				<li><a href="/biz/category?catenum=3">카테고리3</a></li>
				<li><a href="/biz/category?catenum=4">카테고리4</a></li>
		    </ul>
		</li>
		<li style="width:600">
			<div style="background: #666;
				color:#fff;
				margin:0px;
				text-align:center;
				text-decoration:none;
				line-height: 50px;">
		 		<input style="width:300px; "type="text" id="keyword" value="">
				<input type="button" value="검색" onclick="keywordSearch()">
			</div>
		</li>
	 	<li style="width:200">
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
	 	</li>
	</ul>
<!-- 	<div
		id="categoryMenu" 
		style="
		width:200px; 
		display: flex; 
		align-items: center; 
		justify-content: center;
		background-color: red
	">
		목록
	</div> -->
<!-- 	<div style="
		flex-grow: 1; 
		display: flex; 
		align-items: center; 
		justify-content: center;
		display: inline-flex;
	">
		<input style="width:300px; "type="text" id="keyword" value="">
		<input type="button" value="검색" onclick="keywordSearch()">
	</div> -->
<%-- 	<div style="
		width:200px; 
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
		
	</div> --%>
<!-- 	<div
		id="categorys" 
		style = "
			display:none;
			top:50px;
			left:0px;
			position: absolute;
		">
		<div style="width:300px;height:50px;border:1px solid black;"
			onclick="location.href='/biz/category?catenum=1'">카테고리1</div>
		<div style="width:300px;height:50px;border:1px solid black;"
			onclick="location.href='/biz/category?catenum=2'">카테고리2</div>
		<div style="width:300px;height:50px;border:1px solid black;"
			onclick="location.href='/biz/category?catenum=3'">카테고리3</div>
		<div style="width:300px;height:50px;border:1px solid black;"
			onclick="location.href='/biz/category?catenum=4'">카테고리4</div>
	</div> -->
</div>
</body>
</html>