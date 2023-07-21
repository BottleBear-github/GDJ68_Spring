package com.pbw.main.bankbook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/bankbook/*") //하나만 적을땐 value 안 써도 됨
public class BankBookController {

	@Autowired
	private BankBookService bankBookService;
	
	@RequestMapping(value="list", method = RequestMethod.GET) //       "/bankbook/" 밑에 list.do 이제는 do뺌
	public String getList(Model model)throws Exception{
		List<BankBookDTO> ar=bankBookService.getList();
		model.addAttribute("list", ar); //반목문 돌려서 하나씩 꺼내는 작업을 이걸로 함
		return "bankbook/list";
	}
	
	
	@RequestMapping(value="detail")  //method = RequestMethod.GET을 안쓰면 기본적으로 GET
	public ModelAndView getDetail(BankBookDTO bankBookDTO, ModelAndView mv)throws Exception{
		bankBookDTO=bankBookService.getDetail(bankBookDTO);
		System.out.println(bankBookDTO.getBookNum());
		System.out.println(bankBookDTO.getBookName());
		mv.addObject("dto", bankBookDTO);   //detail.jsp에서 dto로 꺼내고 있어서
		return mv;
	}
	
	
	
	@RequestMapping(value="add")
	public String getAdd() throws Exception{
		System.out.println("add");
		return "bankbook/add";
	}
	
	@RequestMapping(value="update")
	public String getUpdate() throws Exception{
		System.out.println("update");
		return "bankbook/update";
	}
	
	@RequestMapping(value="delete")
	public String delete() throws Exception{
		System.out.println("delete");
		return "Index";
	}
	
}
