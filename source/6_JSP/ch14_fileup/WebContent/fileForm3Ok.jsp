<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
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
	<%
		request.setCharacterEncoding("utf-8");
		String path = request.getRealPath("fileUpFolder");
		int maxSize = 1024*1024*10;
		String[] file = {"","",""};
		String[] originalFile = {"","",""};
		MultipartRequest mRequest=null;
		try{
			mRequest = new MultipartRequest(request, path, maxSize,
																	"utf-8", new DefaultFileRenamePolicy());
			Enumeration params = mRequest.getFileNames(); // file2, file1, file0
			int idx = 0;
			while(params.hasMoreElements()){
				String param = (String)params.nextElement();
				System.out.println(idx+"번째로 들어온 파라미터 이름 :"+param);
				file[idx] = mRequest.getFilesystemName(param);
				originalFile[idx] = mRequest.getOriginalFileName(param);
				idx++;
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		// 파일복사
		for(String f : file){
			InputStream  is = null;
			OutputStream os = null;
			try{
				File serverFile = new File(path+"/"+f);
				if(serverFile.exists()){
					is = new FileInputStream(serverFile);
					os = 
					new FileOutputStream("D:/mega_IT/source/6_JSP/ch14_fileup/WebContent/fileUpFolder/"+f);
					byte[] bs = new byte[(int)serverFile.length()];
					while(true){
						int nReadByte = is.read(bs);
						if(nReadByte==-1)break;
						os.write(bs, 0, nReadByte);
					}
				}
			}catch(Exception e){
				System.out.println(e.getMessage());
			}finally{
				if(os!=null) os.close();
				if(is!=null) is.close();
			}
		}
		String subject = mRequest.getParameter("subject");
	%>
	<h1>첫번째 파라미터로 온 파일</h1>
	<h2>업로드된 파일이름 : <%=file[2] %></h2>
	<h2>업로드 오리지널파일 : <%=originalFile[2] %></h2>
	<img src="fileUpFolder/<%=file[2] %>" alt="2번째 배열방 것">
	<hr>
	<h1>두번째 파라미터로 온 파일</h1>
	<h2>업로드된 파일이름 : <%=file[1] %></h2>
	<h2>업로드 오리지널파일 : <%=originalFile[1] %></h2>
	<img src="fileUpFolder/<%=file[1] %>" alt="1번째 배열방 것">
	<hr>
	<h1>세번째 파라미터로 온 파일</h1>
	<h2>업로드된 파일이름 : <%=file[0] %></h2>
	<h2>업로드 오리지널파일 : <%=originalFile[0] %></h2>
	<img src="fileUpFolder/<%=file[0] %>" alt="2번째 배열방 것">
	<hr>
	<h2>제목 : <%=subject %></h2>
</body>
</html>




















