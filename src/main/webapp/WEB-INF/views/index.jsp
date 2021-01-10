<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<!DOCTYPE html>

<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<c:choose>
       <c:when test="${empty sessionScope.loginUser}">
       	로그아웃 됨
       </c:when>
       <c:otherwise>
       
         ${sessionScope.loginUser.user_name}
       
       </c:otherwise>       
       </c:choose>
       
       <c:choose>
       <c:when test="${empty sessionScope.product}">
       	로그아웃 됨
       </c:when>
       <c:otherwise>
       
         ${sessionScope.product.product_name}
       
       </c:otherwise>       
       </c:choose>
hello world!

<input type="text" name="id">


</body>
</html>