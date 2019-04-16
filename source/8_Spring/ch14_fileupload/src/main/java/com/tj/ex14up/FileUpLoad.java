package com.tj.ex14up;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
@Service
public class FileUpLoad {
	public boolean upload(MultipartHttpServletRequest mRequest, Model model) {
		boolean isUpload = false;
		String uploadPath = mRequest.getRealPath("upload/");
		String backupPath = "D:/mega_IT/source/8_Spring/ch14_fileupload/src/main/webapp/upload/";
		Iterator<String> params = mRequest.getFileNames(); // file1,file2,file3
		int i=0;
		String[] fileNames = new String[3];
		while(params.hasNext()) {
			String param = params.next(); 
			MultipartFile mFile = mRequest.getFile(param); // 파라미터의 파일 객체
			String originalFileName = mFile.getOriginalFilename(); // 원파일 이름
			fileNames[i] = originalFileName;
			if(fileNames[i]!=null && !fileNames[i].equals("")) {
				if(new File(uploadPath+fileNames[i]).exists()) {
					// 서버폴더에 첨부한 파일과 같은 이름의 파일이 있을 경우
					fileNames[i] = System.currentTimeMillis() + fileNames[i];
				}
				try {
					//서버에 저장하는 로직
					mFile.transferTo(new File(uploadPath+fileNames[i]));
					System.out.println("서버저장파일 :"+uploadPath+fileNames[i]);
					System.out.println("백업파일 : "+backupPath+fileNames[i]);
					isUpload = filecopy(uploadPath+fileNames[i], 
							backupPath+fileNames[i]);
				} catch (Exception e) {
					e.printStackTrace();
				}//try문 
			}//if (첨부여부에 따라)
			i++;
		}//while
		model.addAttribute("fileNames",fileNames);
		return isUpload;
	}

	private boolean filecopy(String severFile, String targetFile) {
		boolean isCopy = false;
		FileInputStream is = null;
		FileOutputStream os = null;
		try {
			is = new FileInputStream(severFile);
			os = new FileOutputStream(targetFile);
			byte[] buff = new byte[1024*1024*10];
			while(true) {
				int nReadByte = is.read(buff); // 읽은 내용은 buff에 읽은 byte크기는 nReadByte에
				if(nReadByte == -1) break;
				os.write(buff, 0, nReadByte);
			}
			isCopy = true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return isCopy;
	}
}










