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
						action="productInsert" 
						method="post"
						enctype="multipart/form-data">
						<table id="adminProductList" style="border: 1px solid #444444;">
							<tr> 
						        <td>상품명</td>
						        <td>
							        <input type="text" 
							        	name="product_name"
							        	value=""
							        	style="width:100%;height:100%"
							        	>
						        </td>
						    </tr> 
						    <tr> 
						        <td>상품종류</td>
						        <td>
							        <select name="product_category" >
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
							        	value=""
							        	style="width:100%;height:100%"
							        	>
						        </td>
						    </tr> 
						    <tr> 
						        <td>상품수량</td>
						        <td>
							        <input type="text" 
							        	name="product_quantity"
							        	value=""
							        	style="width:100%;height:100%"
							        	>
						        </td>
						    </tr>  
						    <tr> 
						        <td>상품설명</td>
						        <td>
							        <input type="text" 
							        	name="product_desc"
							        	value=""
							        	style="width:100%;height:100%"
							        	>
						        </td>
						    </tr> 
						    <tr> 
						        <td>상품이미지</td>
						        <td>
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
						    value="상품 등록"
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
