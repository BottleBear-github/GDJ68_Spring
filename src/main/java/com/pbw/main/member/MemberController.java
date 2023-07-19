package com.pbw.main.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/member/*")
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value="login", method = RequestMethod.GET)
	public String getLogin() throws Exception{
		System.out.println("login");
		memberService.service();
		return "member/login";
	}
	
	@RequestMapping("join")
	public String getJoin() throws Exception{
		System.out.println("Join");
		return "member/join";
	}
	
	@RequestMapping("mypage")
	public String getMypage() throws Exception{
		System.out.println("MyPage");
		return "member/mypage";
	}
	
	@RequestMapping("logout")
	public String logout() throws Exception{
		System.out.println("logout");
		return "Index";
	}
	
	
}
