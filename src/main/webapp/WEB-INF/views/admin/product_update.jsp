<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<html>
<head>
<title>PRODUCT UPDATE</title>
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
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	var category = ${ProductVO.product_category};
	$("#product_category").val(category).prop("selected", true);

});

</script>
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
					<form 
						action="productUpdate" 
						method="post"
						enctype="multipart/form-data">
						<input type="hidden" name="product_id" value="${ProductVO.product_id}" >
						<table id="adminProductList" style="border: 1px solid #444444;">
							<tr> 
						        <td>상품명</td>
						        <td>
							        <input type="text" 
							        	name="product_name"
							        	value="${ProductVO.product_name}"
							        	style="width:100%;height:100%"
							        	>
						        </td>
						    </tr> 
						    <tr> 
						        <td>상품종류</td>
						        <td>
						        	<select id="product_category" name="product_category">
										<option value="1">카테고리1</option>
									    <option value="2">카테고리2</option>
									    <option value="3">카테고리3</option>
									    <option value="4">카테고리4</option>
									</select>
							        
						        </td>
						    </tr> 
						    <tr> 
						        <td>상품가격</td>
						        <td>
							        <input type="text"
							        	name="product_price"
							        	value="${ProductVO.product_price}"
							        	style="width:100%;height:100%"
							        	>
						        </td>
						    </tr> 
						    <tr> 
						        <td>상품수량</td>
						        <td>
							        <input type="text" 
							        	name="product_quantity"
							        	value="${ProductVO.product_quantity}"
							        	style="width:100%;height:100%"
							        	>
						        </td>
						    </tr>  
						    <tr> 
						        <td>상품설명</td>
						        <td>
							        <input type="text" 
							        	name="product_desc"
							        	value="${ProductVO.product_desc}"
							        	style="width:100%;height:100%"
							        	>
						        </td>
						    </tr> 
						    <tr> 
						        <td>상품이미지</td>
						        <td>
						        	<div>등록된 파일 : ${ProductVO.product_img }</div>
						        	<span>
							        	<input
							        		name="product_img_file"
							        		type="file" 
							        		value="파일첨부">
							        </span>
						        </td>
						    </tr>		
						</table>
						
						<input 
							type="submit" 
						    value="상품수정"
						    style="margin-top: 30px"
						>
					</form>
					
				</div>
			</div>
			<!-- contents end -->
		</div>
	</div>
</body>
</html>
