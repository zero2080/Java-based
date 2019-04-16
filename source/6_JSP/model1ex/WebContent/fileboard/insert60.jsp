<%@page import="com.tj.model1ex.dto.FileBoardDto"%>
<%@page import="com.tj.model1ex.dao.FileBoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%FileBoardDao fbDao = FileBoardDao.getInstance();
	FileBoardDto fbDto = new FileBoardDto();
	for(int i=0 ; i<60 ; i++){
		// writeForm.jsp에서 받아왔던 것
		if(i%2==0)
			fbDto.setCid("bbb");
		else if(i%2==1)
			fbDto.setCid("aaa");
		fbDto.setFsubject("강제로 insert - 테스트 글"+i);
		if(i%2==0)
			fbDto.setFfilename("0220_model1ex.docx");
		else
			fbDto.setFfilename(null);
		fbDto.setFcontent("테스트용글\n입니다");
		fbDto.setFpw("11");
		// writePro.jsp에서 추가한 내용
		fbDto.setFip(request.getRemoteAddr());
		fbDto.setFnum(0);
		fbDto.setFref(0);
		fbDto.setFre_level(0);
		fbDto.setFre_step(0);
		int result = fbDao.insertFileBoard(fbDto);
		System.out.println(result==FileBoardDao.SUCCESS? i+"번째성공":
												i+"번째 실패");
	}
	response.sendRedirect("fboardList.jsp");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
</body>
</html>