<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<html>
<head>
<title>ORDER LIST</title>
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
					    <th>주문 ID</th>
						<th>세부주문 ID(입금여부)</th>
						<th>구매자ID</th>
						<th>상품명</th>
						<th>주문수량</th>
						<th>주문일</th>
					</tr> 	
					<c:forEach items="${orderList}" varStatus="status" var="OrderVo">
						<c:forEach items="${OrderVo.orderDetailList}" varStatus="status" var="OrderDetailVo">
						    <tr> 
			 			        <td>${OrderVo.order_id}</td>
						        <td>${OrderDetailVo.odetail_id}</td>
						        <td>${OrderVo.user_id}</td>
						        <td>${OrderDetailVo.product_name}</td>
						        <td>${OrderDetailVo.ot_quantity}</td>
						        <td>${OrderVo.formatted_order_time }</td>
						    </tr> 
						</c:forEach>   
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
