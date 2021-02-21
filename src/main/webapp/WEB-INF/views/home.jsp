<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<html>
<title>Shop</title>
</head>
<div align="center">
	<!-- width of this page -->
	<div style="width:1000px;">
		<!-- header start -->
		<%@ include file="header.jsp" %>
		<!-- header end -->
		
		<!-- contents start -->
		<table id="productList">
			<tr><td colspan="4"><a href="?filter=new">신상품</a> / <a href="?filter=low">낮은 가격 순</a> / <a href="?filter=high">높은 가격 순</a></td></tr>
	
		<c:forEach items="${productList}" varStatus="status" var="ProductVO">
			<c:choose>
	            <c:when test="${status.index%4==0}"> <tr> </c:when>
	         </c:choose>
			
		        <td> 
		        	<!-- <div style="width:300px;"> -->
		        	<div>
		        		<%-- <div><img src="product_images/${ProductVO.product_img}" alt="productImg"></div> --%>
		        		<div><img src="product_images/4.jpg" onclick="location.href='/biz/Detail?productId=${ProductVO.product_id}'" alt="productImg"></div>
		        		<div>${ProductVO.product_name}</div>
		        		<div>${ProductVO.product_price}</div>
		        	</div>
		    	</td>    
		    <c:choose>
	            <c:when test="${status.index%4==3}"> </tr> </c:when>
	         </c:choose>
		</c:forEach>  
		
		</table>
		<c:forEach var="item" begin="1" end="${totalPage}" step="1" varStatus="status">
			<c:choose>
	            <c:when test="${pageNum eq status.count}"> <span style="color:red">${status.count}</span> </c:when>
	         <c:otherwise> <a href="?pagenum=${status.count}&filter=${filterString}&keyword=${keyword}">${status.count}</a> </c:otherwise>
	         </c:choose>
		</c:forEach>	
		<!-- contents end -->
	</div>
</div>
<body>
</html>
