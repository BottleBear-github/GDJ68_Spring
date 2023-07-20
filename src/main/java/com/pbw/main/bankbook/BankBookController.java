package com.pbw.main.bankbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/bankbook/*") //하나만 적을땐 value 안 써도 됨
public class BankBookController {

	@Autowired
	private BankBookService bankBookService;
	
	@RequestMapping(value="list", method = RequestMethod.GET) //       "/bankbook/" 밑에 list.do
	public String getList()throws Exception{
		System.out.println("list");
		return "bankbook/list";
	}
	@RequestMapping(value="detail")  //method = RequestMethod.GET을 안쓰면 기본적으로 GET
	public String getDetail(BankBookDTO bankBookDTO)throws Exception{
		bankBookDTO=bankBookService.getDetail(bankBookDTO);
		System.out.println(bankBookDTO.getBookNum());
		System.out.println(bankBookDTO.getBookName());
		return "bankbook/detail";
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
