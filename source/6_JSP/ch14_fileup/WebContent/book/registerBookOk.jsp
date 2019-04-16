<%@page import="com.tj.dao.BookDao"%>
<%@page import="com.tj.dto.BookDto"%>
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
		request.setCharacterEncoding("utf-8");
		String path = request.getRealPath("bookImg");
		int maxSize = 1024*1024*10;
		String[] fileName = {"",""};
		MultipartRequest mRequest = null;
		try{
			mRequest = new MultipartRequest(request, path, maxSize, 
										"utf-8", new DefaultFileRenamePolicy());
			Enumeration params = mRequest.getFileNames();
			int i=1;
			while(params.hasMoreElements()){
				String param = (String)params.nextElement();
				fileName[i] = mRequest.getFilesystemName(param);
				i--;
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		// 파일카피
		for(String f : fileName){
			InputStream  is = null;
			OutputStream os = null;
			try{
				File file = new File(path+"/"+f);
				if(file.exists()){
					is = new FileInputStream(file);
					os = new FileOutputStream("D:/mega_IT/source/6_JSP/ch14_fileup/WebContent/bookImg/"+f);
					byte[] bs = new byte[(int)file.length()];
					while(true){
						int nbyte = is.read(bs);
						if(nbyte==-1) break;
						os.write(bs, 0, nbyte);
					}
				}
			}catch(Exception e){
				System.out.println(e.getMessage());
			}finally{
				if(os!=null) os.close();
				if(is!=null) is.close();
			}
		}
		// DB에 insert 할 데이터를 dto에 setting
		String btitle = mRequest.getParameter("btitle");
		int bprice = Integer.parseInt(mRequest.getParameter("bprice"));
		/* for(int i=0 ; i<fileName.length ; i++){
			if(fileName[i]==null){
				fileName[i] = "nothing.jpg";
			}
		} */
		String bimage1 = fileName[0];
		String bimage2 = fileName[1];
		for(int i=0 ;i <fileName.length ; i++){
			if(fileName[i]==null)
				System.out.println(i+"번째파일 :" +fileName[i] +": 첨부 안 함");
		}
		String bcontent=mRequest.getParameter("bcontent");
		int bdiscount = Integer.parseInt(mRequest.getParameter("bdiscount"));
		BookDto dto = new BookDto(0, btitle,bprice, bimage1, bimage2,
										bcontent, bdiscount);
		BookDao bookDao = BookDao.getInstance();
		int result = bookDao.insertBook(dto);
		if(result==BookDao.SUCCESS){
			response.sendRedirect("listBook.jsp");
		}else{
	%>
			<script>
				alert('책등록 실패');
				history.back();
			</script>		
	<%}	%>
</body>
</html>























