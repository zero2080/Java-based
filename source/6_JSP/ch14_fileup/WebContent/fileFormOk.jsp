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
</head>
<body>
	<%
		String path = request.getRealPath("fileUpFolder"); // ★
		out.print("실제로 업로드한 파일이 저장되는 곳 :"+path);
		int maxSize = 1024*1024*10; //// 업로드 파일 최대 용량★
		String file = ""; // 업로드 저장된 파일이름
		String originalFile = ""; // 업로드시 오리지널 파일 이름
		try{
			MultipartRequest multipartRequest = new MultipartRequest(request, path, 
													maxSize, "utf-8", new DefaultFileRenamePolicy());
			Enumeration params = multipartRequest.getFileNames();
			while(params.hasMoreElements()){
				String param = (String)params.nextElement(); // file(파라미터이름)
				file = multipartRequest.getFilesystemName(param);
				originalFile = multipartRequest.getOriginalFileName(param);
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		InputStream  is = null;
		OutputStream os = null;
		try{
			File serverFile = new File(path+"/"+file);
			if(serverFile.exists()){// 파일이 존재하면(첨부를 했을 경우)만 file 복사
				is = new FileInputStream(serverFile);
				os = 
				new FileOutputStream("D:/mega_IT/source/6_JSP/ch14_fileup/WebContent/fileUpFolder/"+file);
				byte[] bs = new byte[(int)serverFile.length()];
				while(true){
					int nReadByte = is.read(bs);
					if(nReadByte == -1) break;
					os.write(bs, 0, nReadByte);
				}
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			os.close();
			is.close();
		}
	%>
	<h2>올린 오리지널 파일은 <%=path%>/<%=originalFile %></h2>
	<h2>업로드된 파일 이름은 <%=path %>/<%=file %></h2>
	<img src="fileUpFolder/<%=file %>" alt="업로드이미지파일">
</body>
</html>













