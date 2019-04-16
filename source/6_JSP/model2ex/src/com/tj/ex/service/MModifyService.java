package com.tj.ex.service;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.tj.ex.dao.MemberDao;
import com.tj.ex.dto.MemberDto;
public class MModifyService implements Service {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// 파일첨부 로직 + 파라미터들 받아 DB에 join
		String path = request.getRealPath("mPhotoUp");
		int maxSize = 1024*1024*5; // 최대업로드 사이즈는 5M
		MultipartRequest mRequest = null;
		String mPhoto = "";
		try {
			mRequest = new MultipartRequest(request, path, maxSize, 
									"utf-8", new DefaultFileRenamePolicy());
			Enumeration<String> params = mRequest.getFileNames();
			String param = params.nextElement();
			mPhoto = mRequest.getFilesystemName(param);
			// mId, mPw,  mName, mEmail, mPhoto, mBirth, mAddress 파라미터 값 받아
			String mId = mRequest.getParameter("mId");
			String mPw = mRequest.getParameter("mPw");
			String mName = mRequest.getParameter("mName");
			String mEmail = mRequest.getParameter("mEmail");
			Date mBirth = null;
			String mBirthStr = mRequest.getParameter("mBirth");
			if(!mBirthStr.equals("")) {
				mBirth = Date.valueOf(mBirthStr);
			}
			String mAddress = mRequest.getParameter("mAddress");
			if(mPhoto==null) { // 사진은 원래 db에 있는 걸로 해
				String dbmPhoto = mRequest.getParameter("dbmPhoto");
				mPhoto = dbmPhoto;
			}
			// dto객체로 만들고, dao의 joinMember(dto)호출
			MemberDto dto = new MemberDto(mId, mPw, mName, mEmail, mPhoto, 
						mBirth, mAddress, null);
			MemberDao mDao = new MemberDao();
			int result = mDao.modifyMember(dto);
			if(result == MemberDao.SUCCESS) {
				// 회원수정 성공시 세션 갈아엎기, modifyResultMsg 추가하기
				HttpSession httpSession = request.getSession();
				httpSession.setAttribute("member", dto);
				request.setAttribute("resultMsg", "회원정보 수정 성공");
			}else {
				// 회원수정 실패시 modifyResultMsg 추가하기
				request.setAttribute("resultMsg", "회원정보 수정 실패");
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
			request.setAttribute("resultMsg", "5M 이하의 사진만 첨부 가능");
		}
		// 서버에 올라간 mPhoto 파일을 소스폴더에 filecopy
		File serverFile = new File(path+"/"+mPhoto);
		if(serverFile.exists()) {
			InputStream  is = null;
			OutputStream os = null;
			try {
				is = new FileInputStream(serverFile);
				os = new FileOutputStream("D:/mega_IT/source/6_JSP/model2ex/WebContent/mPhotoUp/"+mPhoto);
				byte[] bs = new byte[(int)serverFile.length()];
				while(true) {
					int nByteCnt = is.read(bs);
					if(nByteCnt==-1) break;
					os.write(bs, 0, nByteCnt);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} finally {
				try {
					if(os!=null) os.close();
					if(is!=null) is.close();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}
}
