<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<html>
<head>
	<title>Home</title>
	<link href="${conPath }/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<p>  <a href="main">click</a></p>
<img src="${conPath }/img/f.jpg" alt="img" width="100">
</body>
</html>
