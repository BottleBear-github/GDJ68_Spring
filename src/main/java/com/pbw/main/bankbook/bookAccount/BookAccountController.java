package com.pbw.main.bankbook.bookAccount;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pbw.main.member.MemberDTO;
import com.pbw.main.util.Pager;

@Controller
@RequestMapping("/bookAccount/*")
public class BookAccountController {
	@Autowired
	public BookAccountService bookAccountService;
	
	
	public void getList(HttpSession session, Pager pager) throws Exception{
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		List<BookAccountDTO> ar = bookAccountService.getList(memberDTO, pager);
		
		
	}
	
	//add
	@GetMapping(value = "add")
	public void setAdd(BookAccountDTO bookAccountDTO, Model model) throws Exception{
		model.addAttribute("dto", bookAccountDTO);
	}
	
	@PostMapping(value = "add")
	public String setAdd(BookAccountDTO bookAccountDTO, HttpSession session, Model model) throws Exception{
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		bookAccountDTO.setId(memberDTO.getId());
		int result = bookAccountService.setAdd(bookAccountDTO);
		
		String message="상품가입이 실패";
		
		if(result>0) {
			message="상품가입이 완료";
		}
		model.addAttribute("message", message);
		model.addAttribute("url", "../");
		
		return "commons/result";
		
	}
	
}
