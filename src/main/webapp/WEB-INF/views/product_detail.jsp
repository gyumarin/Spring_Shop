<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<html>
<title>PRODUCT_DETAIL</title>
</head>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
	function cartOn(){
		location.href='/biz/cart?productId='+${product.product_id}+'&productQuantity='+$('#product_quantity').val()
	}

</script>
<body>
<div align="center">
	<!-- width of this page -->
	<div style="width:1000px;">
		<!-- header start -->
		<%@ include file="header.jsp" %>
		<!-- header end -->
		
		<!-- contents start -->
		<div style ="width:100%;height:500px; flex-direction: column; background-color: skyblue;">
			<div style ="display:inline-flex ;width:100%; height:300px">
				<div style="width:300; height: 300px">
					<img width=100% height=100% src="product_images/4.jpg" alt="productImg" >
				</div>
				<div style="display: flex; flex-direction:column; flex-grow: 1; height: 300px;">
					<div style="width:100%; text-align: left; margin-left:30px; margin-top:20px">
						<div style="margin-bottom: 50px">상품이름 : ${product.product_name}</div>
						<div>상품가격 : ${product.product_price}</div>
					</div>
					<div style="flex-grow: 1;"></div>
					<div style="width:100%; text-align: left; margin-left:30px; margin-bottom:20px">
						수량<input type="number" id="product_quantity" value=1  min="1" max="${ product.product_quantity}">
						<button onclick="cartOn()">장바구니 담기</button>
					</div>
				</div>
			</div>
			<div style="width:100%; padding-top:30px; text-align: left">
				<div>상품 정보</div>
				<div>${product.product_desc}</div>
			</div>
		</div>
		<!-- contents end -->
	</div>
</div>
</body>
</html>
