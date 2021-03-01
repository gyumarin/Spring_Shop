<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<!DOCTYPE html>
<html>
<body>
	<div style="width:200px; display:flex; flex-direction: column;border: 1px solid #444444;">
		<div>관리목록</div>
		<input type="button" value="상품 리스트" onclick="location.href='/biz/admin/productList'" style="margin-top: 20px">
		<input type="button" value="상품 등록" onclick="location.href='/biz/admin/product_insert_form'" style="margin-top: 20px">
		<input type="button" value="주문 리스트" onclick="location.href='/biz/admin/orderList'" style="margin-top: 20px">
	</div>
</body>
</html>