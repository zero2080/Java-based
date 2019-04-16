<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="css/style.css" rel="stylesheet">
</head>
<body>
	<form action="fileForm3Ok.jsp" method="post" enctype="multipart/form-data">
		<p>제목  <input type="text" name="subject"></p>
		<p>파일0 <input type="file" name="file0"></p>
		<p>파일1 <input type="file" name="file1"></p>
		<p>파일2 <input type="file" name="file2"></p>
		<p><input type="submit" value="파일업로드"></p>
	</form>
</body>
</html>