package com.tj.ex14up;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;
@Controller
public class HomeController {
	@Autowired
	private FileUpLoad fileUpload;
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "input";
	}
	@RequestMapping(value="fileupload", method=RequestMethod.POST)
	public String fileupload(MultipartHttpServletRequest mRequest,
			Model model) {
		if(fileUpload.upload(mRequest, model)) {
			model.addAttribute("fileupResult","파일업로드 성공");
		}
		return "fileResult";
	}
}












