package com.pbw.main.board.notice;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.pbw.main.util.Pager;



@Controller
@RequestMapping("/notice/*")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping(value="list")
	public String getNoList(Model model, Pager pager)throws Exception{
		List<NoticeDTO> ar = noticeService.getList(pager);
		model.addAttribute("list", ar);
		model.addAttribute("pager", pager);
		return "board/list";
	}
	
	//form
	@RequestMapping(value="add", method = RequestMethod.GET)
	public String setAdd() throws Exception{
		return "board/add";
	}
		
	//db insert
	@RequestMapping(value="add", method = RequestMethod.POST)
	public String setAdd(NoticeDTO noticeDTO,  MultipartFile [] photos, HttpSession session) throws Exception{
		System.out.println("addpost");
		int result = noticeService.setAdd(noticeDTO, photos, session);
		return "redirect:./list";
	}
	
	@RequestMapping(value="detail") 
	public ModelAndView getDetail(NoticeDTO noticeDTO, ModelAndView mv)throws Exception{
		int result = noticeService.setHitCount(noticeDTO);
		noticeDTO=noticeService.getDetail(noticeDTO);
		mv.addObject("dto", noticeDTO);
		mv.setViewName("board/detail");
		return mv;
	}
	
	@RequestMapping(value="delete")
	public String delete(NoticeDTO noticeDTO) throws Exception{
		System.out.println("delete");
		int result = noticeService.setDelete(noticeDTO);
		return "redirect:./list";
	}
	
	@RequestMapping(value="update", method = RequestMethod.GET)
	public String setUpdate(NoticeDTO noticeDTO, Model model) throws Exception{
		System.out.println("update");
		noticeDTO=noticeService.getDetail(noticeDTO);
		model.addAttribute("dto", noticeDTO);
		return "board/update";
	}
	
	@RequestMapping(value="update", method = RequestMethod.POST)
	public String setUpdate(NoticeDTO noticeDTO) throws Exception{
		System.out.println("updatepost");
		int result = noticeService.setUpdate(noticeDTO);
		return "redirect:./list";
	}
	
	

	
}
