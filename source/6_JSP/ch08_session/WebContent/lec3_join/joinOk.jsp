<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.InputStream"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath();
	request.setCharacterEncoding("utf-8");%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<%
		String agree = request.getParameter("agree");
		String msg;
		if(agree.equals("y")){ 
			// 동의 : 세션데이터 id, pw, name을 file에 출력. msg = 가입이 완~
			String id = (String)session.getAttribute("id");
			String pw = (String)session.getAttribute("pw");
			String name = (String)session.getAttribute("name");
			InputStream is = null;
			OutputStream os = null;
			String filePath = application.getRealPath("WEB-INF/member.txt");
			System.out.println("저장될 파일의 진짜 폴더 "+filePath);
			try{ // file에 출력
				os = new FileOutputStream(filePath, true);
				byte[] b = (" id : "+id+"\r\n pw : "+pw+"\r\n name : "
																								+name+"\r\n").getBytes();
				os.write(b);
			}catch(Exception e){
				msg = URLEncoder.encode("파일 출력이 거부되었습니다", "utf-8");
			}finally{
				os.close();
			}
			// 출력한 파일을 copy (WAS가 reset될때마다 파일이 지워지는 것 방지)
			// filePath -> 내 소스 폴더 밑에  WEB-INF/member.txt로 파일복사
			File file = new File(filePath); // 복사할 파일
			String sFilePath = "D:/mega_IT/source/6_JSP/ch08_session/WebContent/WEB-INF/member.txt";
			try{
				is = new FileInputStream(filePath);
				os = new FileOutputStream(sFilePath);
				byte[] bs = new byte[(int)file.length()];
				while(true){
					int cnt = is.read(bs);
					if(cnt==-1) break;
					os.write(bs, 0, cnt);
				}
				msg = URLEncoder.encode("가입이 완료되었습니다","utf-8");
			}catch(Exception e){
				msg = URLEncoder.encode("파일 출력이 거부되었습니다", "utf-8");
			}finally{
				os.close();
				is.close();
			}
		}else{ 
			// 거부 : msg = "가입이 거부되었습니다"
			msg = URLEncoder.encode("가입을 거부하셨습니다", "utf-8");
		}
		// result.jsp?msg로
		//session.removeAttribute("id");
		session.removeAttribute("pw");
		session.removeAttribute("name");
		response.sendRedirect("result.jsp?msg="+msg);
	%>
</body>
</html>



















