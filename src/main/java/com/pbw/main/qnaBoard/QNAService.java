package com.pbw.main.qnaBoard;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pbw.main.util.Pager;

@Service
public class QNAService {
	
	@Autowired
	private QNADAO qnaDAO;
	
	public List<QNADTO> getList(Pager pager) throws Exception{
		pager.makeRowNum();
		Long total = qnaDAO.getTotal(pager);
		pager.makePageNum(total);
		return qnaDAO.getList(pager);
	}
}
