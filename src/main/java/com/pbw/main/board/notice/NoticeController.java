package com.pbw.main.board.notice;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.pbw.main.board.BoardDTO;
import com.pbw.main.util.Pager;



@Controller
@RequestMapping("/notice/**")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@ModelAttribute("board")
	public String getBoardName() {
		return "notice";
	}
	
	@RequestMapping(value="list")
	public String getNoList(Model model, Pager pager)throws Exception{
		List<BoardDTO> ar = noticeService.getList(pager);
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
	
	//detail
	@RequestMapping(value="detail") 
	public ModelAndView getDetail(NoticeDTO noticeDTO, ModelAndView mv)throws Exception{
		int result = noticeService.setHitCount(noticeDTO);
		BoardDTO boardDTO=noticeService.getDetail(noticeDTO);
		mv.addObject("dto", boardDTO);
		mv.setViewName("board/detail");
		return mv;
	}
	
	//delete
	@RequestMapping(value="delete")
	public String delete(NoticeDTO noticeDTO) throws Exception{
		System.out.println("delete");
		int result = noticeService.setDelete(noticeDTO);
		return "redirect:./list";
	}
	
	@RequestMapping(value="update", method = RequestMethod.GET)
	public ModelAndView setUpdate(NoticeDTO noticeDTO, ModelAndView mv) throws Exception{
		System.out.println("update");
		BoardDTO boardDTO=noticeService.getDetail(noticeDTO);
		mv.setViewName("board/update");
		mv.addObject("dto", boardDTO);
		return mv;
	}
	
	@RequestMapping(value="update", method = RequestMethod.POST)
	public String setUpdate(NoticeDTO noticeDTO) throws Exception{
		System.out.println("updatepost");
		int result = noticeService.setUpdate(noticeDTO);
		return "redirect:./detail?num="+noticeDTO.getNum();
	}
	
	

	
}
