package com.pbw.main.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pbw.main.util.Pager;

@Service
public class QnaService {
	
	@Autowired
	private QnaDAO qnaDAO;
	
	public List<QnaDTO> getList(Pager pager) throws Exception{
		pager.makeRowNum();
		Long total = qnaDAO.getTotal(pager);
		pager.makePageNum(total);
		return qnaDAO.getList(pager);
	}
	
	public int setAdd(QnaDTO qnaDTO)throws Exception{
		return qnaDAO.setAdd(qnaDTO);
	}
}
