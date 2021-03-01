<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<html>
<head>
<title>Shop</title>
    <style>
	  table {
	    width: 100%;
	    border: 1px solid #444444;
	    border-collapse: collapse;
	  }
	  th, td {
	    border: 1px solid #444444;
	    padding: 10px;
	  }
	  td {
	  	width:250;
	  }
    </style>
</head>
<body>
	<div align="center">
		<!-- width of this page -->
		<div style="width:1000px; display: block; flex-direction: column;">
			<!-- header start -->
			<%@ include file="header.jsp" %>
			<!-- header end -->
			
			<!-- contents start -->
			<div align="left">
				<table id="productList">
					<tr><td colspan="4"><a href="home?filter=new">신상품</a> / <a href="home?filter=low">낮은 가격 순</a> / <a href="home?filter=high">높은 가격 순</a></td></tr>
			
				<c:forEach items="${productList}" varStatus="status" var="ProductVO">
					<c:choose>
			            <c:when test="${status.index%4==0}"> <tr> </c:when>
			         </c:choose>
					
				        <td> 
				        	<!-- <div style="width:300px;"> -->
				        	<div>
				        		<div style="height:250px">
				        			<img
				        				style="width:100%;height:100%;object-fit: cover;"
				        				src="product_images/${ProductVO.product_img}" 
				        				onclick="location.href='/biz/Detail?productId=${ProductVO.product_id}'"
				        				alt="productImg">
				        		</div>
				        		<%-- <div><img src="product_images/4.jpg" onclick="location.href='/biz/Detail?productId=${ProductVO.product_id}'" alt="productImg"></div> --%>
				        		<div>${ProductVO.product_name}</div>
				        		<div>${ProductVO.product_price}</div>
				        	</div>
				    	</td>    
				    <c:choose>
			            <c:when test="${status.index%4==3}"> </tr> </c:when>
			         </c:choose>
				</c:forEach>  
				
				</table>
			</div>
			<!-- pageNumber -->
			<div style="width:100%;padding-top: 30px">
				<c:forEach var="item" begin="1" end="${totalPage}" step="1" varStatus="status">
					<c:choose>
			            <c:when test="${pageNum eq status.count}"> <span style="color:red">${status.count}</span> </c:when>
			         <c:otherwise> <a href="?pagenum=${status.count}&filter=${filterString}&keyword=${keyword}">${status.count}</a> </c:otherwise>
			         </c:choose>
				</c:forEach>	
			</div>
			<!-- contents end -->
		</div>
	</div>
<body>
</html>
