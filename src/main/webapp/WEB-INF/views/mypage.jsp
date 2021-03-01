<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<html>
<head>
<title>MYPAGE</title>
</head>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
	function countTotalPrice(){
		var totalQuantity=0;
		$(".cartCard").each(function(){
			var price = Number($(this).find(".cart_quantity").val()) * Number($(this).find(".cart_price").val());
	
			totalQuantity = totalQuantity + price;
		});
		document.getElementById('totalCartPrice').innerHTML = "총금액 "+totalQuantity;
	}
	
	/* function order(){
		var data=[]
		$(".cartCard").each(function(){
			data.push({
				cart_quantity : $(this).find(".cart_quantity").val(),
				product_id : $(this).find(".cart_quantity").attr('id')
			})
		});
		console.log(data)
	} */
	
	function showCart(){
		$("#orderContainer").hide(); 
		$("#cartContainer").show();
	}
	
	function showOrder(){
		$("#cartContainer").hide();
		$("#orderContainer").show(); 
	}
	
	
	function deleteCartCard(card_id, cart_id) {
		$('#' + card_id).remove()
		// ajax delete
		$.ajax({
			async: true,
		    type: "POST",                             // HTTP 요청 방식(GET, POST)
		    data: { cartId: cart_id },                // HTTP 요청과 함께 서버로 보낼 데이터
		    url: "cart/delete", // 클라이언트가 요청을 보낼 서버의 URL 주소
		    dataType: "json" ,                        // 서버에서 보내줄 데이터의 타입
		})
		// HTTP 요청이 성공하면 요청한 데이터가 done() 메소드로 전달됨.
		.done(function(res) {
			alert('삭제완료')
		})
		// HTTP 요청이 실패하면 오류와 상태에 관한 정보가 fail() 메소드로 전달됨.
//		.fail(function(xhr, status, errorThrown) {
//			alert(errorThrown);
//			/*  $("#text").html("오류가 발생했습니다.<br>")
//			
//			 .append("오류명: " + errorThrown + "<br>")
//			
//			 .append("상태: " + status); */
//		})
		// HTTP 요청이 성공하거나 실패하는 것에 상관없이 언제나 always() 메소드가 실행됨.
		/*  */
		countTotalPrice();
	}

	$(function() {
		// 탭 초기화
		if ("${tab}" == "cart") {
			$("#orderContainer").hide();
		} else {
			$("#cartContainer").hide();
		}
		$(".cart_quantity").change(function() {
			// ajax update

			/* 두가지 항목을 이용해서 update를 날린다.
			alert($(this).attr('id'));
			alert($(this).val();
			 */

			countTotalPrice();
		})
	});
</script>

<body>
	<div align="center">
		<!-- width of this page -->
		<div style="width:1000px;">
			<!-- header start -->
			<%@ include file="header.jsp" %>
			<!-- header end -->
	
			<!-- contents start -->
			<div style="width:100%; background-color: skyblue; flex-direction:column; display: flex">
				<div style ="width:100%; height:50">MY PAGE</div>
				<div style ="width:100%; height:50; display:flex">
					<div 
						onclick="showCart()"
						id = "cart_tab" 
						style ="flex-grow: 1; 
							border:1px solid black;">
						CART
					</div>
					<div 
						onclick="showOrder()"
						id = "order_tab" 
						style ="flex-grow: 1 ; 
							border:1px solid black;">
						ORDER
					</div>
				</div>
				<div style ="flex-grow:1; padding-left: 50;padding-right: 50">
					<!-- cartPage -->
					<div id="cartContainer">
						<div style="height:30;">
							장바구니목록
						</div>
						<!-- 물품카드 -->
						<form
							action="order"
							method="post"
						>
							<c:forEach items="${cartList}" varStatus="status" var="CartVO">
								<div class="cartCard" id="cart${status.count}" style="box-sizing: border-box; padding:10px;width:100%;display:inline-flex; border:1px solid black; ">
									<input type="hidden" name="cartList[${status.index}].cart_id" class="cart_id" value="${CartVO.cart_id}">
									<input type="hidden" class="cart_price" value="${CartVO.product_price}">
									<input type="hidden" name="cartList[${status.index}].product_id" value="${CartVO.product_id}">
									
									<div>
										<img src="product_images/4.jpg" alt="productImg">
									</div>
									<div style="flex-grow: 1">
										<div>이름 ${CartVO.product_name}</div> 
										<div>가격 ${CartVO.product_price}</div> 
									</div>
									<div id="quantity_row" style="flex-grow: 1">
										<div>수량 <input type="number" name="cartList[${status.index}].cart_quantity" class="cart_quantity" id="${CartVO.product_id}" value="${ CartVO.cart_quantity}"></div>  
										<input type="button" value="삭제" onclick="deleteCartCard('cart${status.count}','${CartVO.cart_id}')">
									</div>
								</div>
							</c:forEach>  
							
							<!-- bottom -->
							<div id="totalCartPrice">
								총금액 ${initTotalPrice}
							</div>
							<div>
								<input type="button" value="계속담기" onclick="location.href='/biz/'"> <input type="submit" value="주문하기">
							</div>
						</form>
					</div>
					
					<!-- orderPage -->
					<div id="orderContainer">
						<div style="height:30;">
							주문목록
						</div>
						<!-- 주문 일자 -->
						<div style="box-sizing: border-box; padding:10px;width:100%; border:1px solid black; ">
							주문일자 2021-02-22
						</div>
						<!-- 물품카드 -->
						<div style="box-sizing: border-box; padding:10px;width:100%;display:inline-flex; border:1px solid black; ">
							<div>
								<img src="product_images/4.jpg" alt="productImg">
							</div>
							<div style="flex-grow: 1">
								이름 가격
							</div>
							<div style="flex-grow: 1">
								수량 삭제
							</div>
						</div>
						<!-- 주문 금액 -->
						<div id="totalOrderPrice" style="box-sizing: border-box; padding:10px;width:100%; border:1px solid black; text-align: right ">
							총 주문 금액 : 232000
						</div>
					</div>
				</div>
			</div>
			<!-- contents end -->
		</div>
	</div>
</body>
</html>
