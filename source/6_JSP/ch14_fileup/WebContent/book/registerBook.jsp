<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="../css/style.css" rel="stylesheet">
</head>
<body>
	<form action="registerBookOk.jsp" method="post" enctype="multipart/form-data">
		<table>
			<caption>책등록</caption>
			<tr><th>책이름</th>
					<td><input type="text" name="btitle" required="required" 
									size="30"></td>
			</tr>
			<tr><th>가격</th>
					<td><input type="text" name="bprice" required="required" size="30"></td>
			</tr>
			<tr><th>책이미지1</th>
					<td><input type="file" name="bimage1"></td>
			</tr>
			<tr><th>책이미지2</th>
					<td><input type="file" name="bimage2"></td>
			</tr>
			<tr><th>책소개</th>
					<td><textarea rows="5" cols="32" name="bcontent"></textarea></td>
			</tr>
			<tr><th>할인율</th>
					<td><input type="text" name="bdiscount" size="30" value="0"></td>
			</tr>
			<tr><td colspan="2">
						<input type="submit" value="책등록">
						<input type="reset" value="다시작성">
						<input type="button" value="책목록" onclick="location='listBook.jsp'">
				
		</table>
	</form>
</body>
</html>



















