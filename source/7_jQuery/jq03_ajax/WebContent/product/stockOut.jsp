<%@page import="com.tj.ex.dto.ProductDto"%>
<%@page import="com.tj.ex.dao.ProductDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String pName = request.getParameter("pName");
		ProductDao pDao = ProductDao.getInstance();
		ProductDto pDto = pDao.getProduct(pName);
		if(pDto==null){
			out.print("없는 제품");
		}else{
			out.print(pDto.getpStock()+"개 재고");
		}
	%>
</body>
</html>


















