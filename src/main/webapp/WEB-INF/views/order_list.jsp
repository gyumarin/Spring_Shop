<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<html>
<head>
<title>ORDER</title>
</head>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>


<body>
	<div align="center">
		<!-- width of this page -->
		<div style="width:1000px;">
			<!-- header start -->
			<%@ include file="header.jsp" %>
			<!-- header end -->
	
			<!-- contents start -->
			<div style="width:100%; background-color: skyblue; flex-direction:column; display: flex">
				<div style ="width:100%; height:50">주문 페이지</div>

				<div style ="flex-grow:1; padding-left: 50;padding-right: 50">
					<!-- cartPage -->
					<div>
						<div style ="width:100%; height:50; display:flex">
							주문하기
						</div>
						
					<!-- 	<form
							action="orderSuccess"
							method="post"
						> -->
							<c:forEach items="${order.orderDetailList}" varStatus="status" var="OrderVO">
								<!-- 물품카드 -->
								<div style="box-sizing: border-box; padding:10px;width:100%;display:inline-flex; border:1px solid black; ">
									
									<div>
										<img src="product_images/4.jpg" alt="productImg">
									</div>
									<div style="flex-grow: 1">
										<div>이름 : ${OrderVO.product_name}</div>
										<div>가격 : ${OrderVO.product_price}</div>
										<div>수량 : ${OrderVO.ot_quantity}</div>
									</div>
								</div>
							</c:forEach>  
							<!-- user info -->
							<div style ="width:100%; height:50; display:flex; margin-top: 30px">
								<div 
									id = "cart_tab" 
									style ="width:300px; 
										border:1px solid black;">
									주문자명
								</div>
								<div 
									id = "order_tab" 
									style ="flex-grow: 1 ; 
										border:1px solid black;">
									${sessionScope.loginUser.user_name}
								</div>
							</div>
							<div style ="width:100%; height:50; display:flex; margin-top: 30px">
								<div 
									id = "cart_tab" 
									style ="width:300px; 
										border:1px solid black;">
									주소
								</div>
								<div 
									id = "order_tab" 
									style ="flex-grow: 1 ; 
										border:1px solid black;">
									${order.order_address}
								</div>
							</div>
							
							<!-- bottom -->
							<div>
								총금액 ${order.totalAmount }
							</div>
							<div>
								<input 
									type="button" 
									value="주문취소" 
									onclick="location.href='/biz/orderCancel?orderId=${order.order_id}'"
								> 
								<input 
									type="button" 
									value="구매하기" 
									onclick="location.href='/biz/orderSuccess?orderId=${order.order_id}'"
								>
								 
							</div>
						<!-- </form> -->
					</div>
					
				</div>
			</div>
			<!-- contents end -->
		</div>
	</div>
</body>
</html>
