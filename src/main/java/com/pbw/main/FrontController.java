package com.pbw.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FrontController {

	//home
	//  /(루트) 주소가 왔을때 실행, index.jsp
	
	@RequestMapping("/*")
	public String home() {
		return "Index";
	}
}
