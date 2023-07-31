package com.pbw.main.qnaBoard;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pbw.main.util.Pager;

@Controller
@RequestMapping("/qnaBoard/*")
public class QNAController {
	
	@Autowired
	private QNAService qnaService;
	
	@RequestMapping("list")
	public String getList(Model model, Pager pager)throws Exception{
		List<QNADTO> ar = qnaService.getList(pager);
		model.addAttribute("list", ar);
		model.addAttribute("pager", pager);
		return "qnaBoard/list";
	}

	@RequestMapping("add")
	public void setAdd() {
		System.out.println("GET add");
	}
	
	@RequestMapping(value="add", method = RequestMethod.POST)
	public String setAdd(QNADTO qnaDTO)throws Exception{
		System.out.println("add POST");
		int result = qnaService.setAdd(qnaDTO);
		return "redirect:./list";
	}
}