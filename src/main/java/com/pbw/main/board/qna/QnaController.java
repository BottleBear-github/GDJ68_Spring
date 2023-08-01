package com.pbw.main.board.qna;

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
import com.pbw.main.board.notice.NoticeDTO;
import com.pbw.main.util.Pager;

@Controller
@RequestMapping("/qna/*")
public class QnaController {
	
	@Autowired
	private QnaService qnaService;
	
	@ModelAttribute("board")
	public String getBoardName() {
		return "qna";
	}
	
	@RequestMapping("list")
	public String getList(Model model, Pager pager)throws Exception{
		List<BoardDTO> ar = qnaService.getList(pager);
		model.addAttribute("list", ar);
		model.addAttribute("pager", pager);
		return "board/list";
	}

	@RequestMapping("add")
	public String setAdd() {
		System.out.println("GET add");
		return "board/add";
	}
	
	@RequestMapping(value="add", method = RequestMethod.POST)
	public String setAdd(QnaDTO qnaDTO, MultipartFile [] photos, HttpSession session)throws Exception{
		System.out.println("add POST");
		int result = qnaService.setAdd(qnaDTO, photos, session);
		return "redirect:./list";
	}
	
	@RequestMapping(value="detail") 
	public ModelAndView getDetail(QnaDTO qnaDTO, ModelAndView mv)throws Exception{
		int result = qnaService.setHitCount(qnaDTO);
		BoardDTO boardDTO=qnaService.getDetail(qnaDTO);
		mv.addObject("dto", boardDTO);
		mv.setViewName("board/detail");
		return mv;
	}
	
	@RequestMapping(value="reply")
	public String setReply(Long num, Model model) {
		model.addAttribute("num", num);
		System.out.println("replyget");
		return "board/reply";
	}
	
	@RequestMapping(value="reply", method = RequestMethod.POST)
	public String setReply(QnaDTO qnaDTO, MultipartFile [] photos, HttpSession session) throws Exception{
		int result = qnaService.setReplyAdd(qnaDTO, photos, session);
		System.out.println(result);
		return "redirect:./list";
	}
	
	@RequestMapping("delete")
	public String setDelete(QnaDTO qnaDTO) throws Exception{
		int result = qnaService.setDelete(qnaDTO);
		return "redirect:./list";
	}
	
	@RequestMapping("update")
	public ModelAndView setUpdate(QnaDTO qnaDTO, ModelAndView mv)throws Exception{
		BoardDTO boardDTO=qnaService.getDetail(qnaDTO);
		mv.setViewName("board/update");
		mv.addObject("dto", boardDTO);
		return mv;

	}
	
	@RequestMapping(value="update", method = RequestMethod.POST)
	public String setUpdate(QnaDTO qnaDTO) throws Exception{
		System.out.println("updatepost");
		int result = qnaService.setUpdate(qnaDTO);
		return "redirect:./detail?num="+qnaDTO.getNum();
	}
	
}
