<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script>
		var pageNum;
		$(document).ready(function(){
			var pageCnt = Number('${pageCnt}');
			pageNum = Number($('.pageNum').last().val());
			if(pageCnt == pageNum){
				$('button').css('display','none');
			}
			$('button').click(function(){
				pageNum = Number($('.pageNum').last().val());
				if(isNaN(pageNum)){
					pageNum=1;
				}
				
				$.ajax({
					url : '${conPath}/append.do',
					type : 'get',
					dataType : 'html',
					data : "pageNum="+pageNum,
					success : function(data){
						$('#appendDiv').append(data);
						pageNum = Number($('.pageNum').last().val());
						if(pageCnt == pageNum){
							alert('마지막 페이지까지 뿌려서 버튼을 없앨거야');
							$('button').css('display','none');
						}
					}
				});//ajax
			});// 더보기 버튼
			/* $(window).scroll(function(){
				pageNum = Number($('.pageNum').last().val());
				if(isNaN(pageNum)){
					pageNum=1;
				}
				
				$.ajax({
					url : '${conPath}/append.do',
					type : 'get',
					dataType : 'html',
					data : "pageNum="+pageNum,
					success : function(data){
						$('#appendDiv').append(data);
					}
				});//ajax
			}); */
		});
	</script>
</head>
<body>
	<table>
		<tr><th>번호</th><th>이름</th><th>전화</th><th>주소</th></tr>
			<c:forEach items="${list }" var="dto">
					<tr>
						<td>${dto.no }</td>
						<td>${dto.name }</td>
						<td>${dto.tel }</td>
						<td>${dto.addr }</td>
					</tr>
			</c:forEach>
	</table>
	
	<div id="appendDiv"></div>
	<button>더보기</button>
</body>
</html>