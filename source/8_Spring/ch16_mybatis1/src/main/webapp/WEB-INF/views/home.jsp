<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<link href="css/emp.css" rel="stylesheet" type="text/css">
</head>
<body>
	<table><tr><th>${greeting }</th></tr></table>
	${deptList }
	<hr>
	${empList }
</body>
</html>
