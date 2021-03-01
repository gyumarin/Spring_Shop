<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<html>
<head>
<title>PRODUCT LIST</title>
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
</style>
</head>
<body>
	<div align="center">
		<!-- width of this page -->
		<div style="width:1000px;">
			<!-- header start -->
			<%@ include file="header.jsp" %>
			<!-- header end -->
			
			<!-- contents start -->
			<div style="width:100%; display:flex; flex-direction: row;">
				<%@ include file="left_menu.jsp" %>
				<div style="flex-grow: 1">
					<table id="adminProductList" style="border: 1px solid #444444;">
					<tr> 
					    <th>상품 ID</th>
						<th>상품명</th>
						<th>판매가</th>
						<th>수량</th>
						<th>등록일</th>
						<th></th>
					</tr> 	
					<c:forEach items="${productList}" varStatus="status" var="ProductVO">
					    <tr> 
					        <td>${ProductVO.product_id}</td>
					        <td>${ProductVO.product_name}</td>
					        <td>${ProductVO.product_price}</td>
					        <td>${ProductVO.product_quantity}</td>
					        <td>${ProductVO.product_indate }</td>
					        <td>
					        	<input 
					        		type="button" 
					        		value="수정" 
					        		style="width:100%; height:100%"
					        		onclick="location.href='/biz/admin/productUpdate_form?productId=${ProductVO.product_id}'">
					        </td>
					    </tr>    
					</c:forEach>  
					
					</table>
					<c:forEach var="item" begin="1" end="${totalPage}" step="1" varStatus="status">
						<c:choose>
				            <c:when test="${pageNum eq status.count}"> <span style="color:red">${status.count}</span> </c:when>
				         <c:otherwise> <a href="?pagenum=${status.count}&filter=${filterString}&keyword=${keyword}">${status.count}</a> </c:otherwise>
				         </c:choose>
					</c:forEach>	
				</div>
			</div>
			<!-- contents end -->
		</div>
	</div>
</body>
</html>
