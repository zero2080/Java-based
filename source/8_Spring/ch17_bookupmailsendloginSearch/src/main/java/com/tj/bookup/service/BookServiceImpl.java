package com.tj.bookup.service;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.tj.bookup.dao.BookDao;
import com.tj.bookup.model.Book;
@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookDao bookDao;
	private String savePath = "D:/mega_IT/source/8_Spring/ch18_bookuploadloginSch/src/main/webapp/bookImgFileUpload/";
	@Override
	public List<Book> bookListAll() {
		return bookDao.bookListAll();
	}
	@Override
	public List<Book> bookListPaging(Book book) {
		return bookDao.bookListPaging(book);
	}
	@Override
	public Book getBook(int bnum) {
		return bookDao.getBook(bnum);
	}
	@Override
	public int registerBook(MultipartHttpServletRequest mRequest) {
		String uploadPath = mRequest.getRealPath("bookImgFileUpload/");
		Iterator<String> iterator = mRequest.getFileNames();
		String bimg[] = {"",""};
		int idx = 0;
		while(iterator.hasNext()) {
			String uploadFileName = iterator.next();
			MultipartFile mFile = mRequest.getFile(uploadFileName);//실제파일 받아오기
			String originFileName = mFile.getOriginalFilename();
			bimg[idx] = originFileName;//실제저장되는 파일 이름
			if(bimg[idx]!=null && !bimg[idx].equals("")) {
				if(new File(uploadPath+bimg[idx]).exists() || new File(savePath+bimg[idx]).exists()) {
					bimg[idx] = System.currentTimeMillis()+"_"+bimg[idx];
				}
				try {
					System.out.println(idx+"번재 서버: "+uploadPath+bimg[idx]);
					System.out.println(idx+"번재 저장: "+savePath+bimg[idx]);
					mFile.transferTo(new File(uploadPath+bimg[idx]));
					int result = copy(uploadPath+bimg[idx], savePath+bimg[idx]);
					System.out.println(result==1? bimg[idx]+"책이미지 넣음":bimg[idx]+"책이미지 못 넣음");
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}else {
				//bimg[idx] = "noimg.jpg"; 이부분을 넣으면 xml이 훻씬 편하겠네
			}
			idx++;
		}//while
		Book book = new Book();
		book.setBtitle(mRequest.getParameter("btitle"));
		book.setBwriter(mRequest.getParameter("bwriter"));
		book.setBrdate(Date.valueOf(mRequest.getParameter("brdate")));
		book.setBimg1(bimg[0]);
		book.setBimg2(bimg[1]);
		book.setBinfo(mRequest.getParameter("binfo"));
		return bookDao.registerBook(book);
	}
	@Override
	public int modifyBook(MultipartHttpServletRequest mRequest) {
		String uploadPath = mRequest.getRealPath("bookImgFileUpload/");
		Iterator<String> iterator = mRequest.getFileNames();
		String bimg[] = {"",""};
		int idx = 0;
		while(iterator.hasNext()) {
			String uploadFileName = iterator.next();
			MultipartFile mFile = mRequest.getFile(uploadFileName);//실제파일 받아오기
			String originFileName = mFile.getOriginalFilename();
			bimg[idx] = originFileName;//실제저장되는 파일 이름
			if(bimg[idx]!=null && !bimg[idx].equals("")) {
				if(new File(uploadPath+bimg[idx]).exists() || new File(savePath+bimg[idx]).exists()) {
					bimg[idx] = System.currentTimeMillis()+"_"+bimg[idx];
				}
				try {
					mFile.transferTo(new File(uploadPath+bimg[idx]));
					int result = copy(uploadPath+bimg[idx], savePath+bimg[idx]);
					System.out.println(result==1? bimg[idx]+"책이미지 넣음":bimg[idx]+"책이미지 넣음");
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			idx++;
		}//while
		Book book = new Book();
		book.setBnum(Integer.parseInt(mRequest.getParameter("bnum")));
		book.setBtitle(mRequest.getParameter("btitle"));
		book.setBwriter(mRequest.getParameter("bwriter"));
		book.setBrdate(Date.valueOf(mRequest.getParameter("brdate")));
		book.setBimg1(bimg[0]);
		book.setBimg2(bimg[1]);
		book.setBinfo(mRequest.getParameter("binfo"));
		return bookDao.modifyBook(book);
	}
	@Override
	public int cntBook(Book book) {
		return bookDao.cntBook(book);
	}
	private int copy(String originalFile, String targetFile) {
		int isCopy = 0;
		FileInputStream is = null;
		FileOutputStream os =null;
		try{
			is = new FileInputStream(originalFile);
			os = new FileOutputStream(targetFile);
			byte[] buff = new byte[1024*1024];
			int nRead;
			while((nRead = is.read(buff))!=-1){
				os.write(buff, 0, nRead);
			}
			isCopy = 1;
		}catch (IOException e) {
			System.out.println(e.getMessage());
		}finally {
			try{
				if(is!=null) is.close();
				if(os!=null) os.close();
			}catch(IOException e){
				System.out.println(e.getMessage());
			}
		}
		return isCopy;
	}
}
