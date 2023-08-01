package com.pbw.main.qnaBoard;

import static org.junit.Assert.assertNotEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.pbw.main.Mytest;
import com.pbw.main.board.notice.NoticeDTO;
import com.pbw.main.board.qna.QnaDAO;
import com.pbw.main.board.qna.QnaDTO;

public class QNABoardTest extends Mytest {

	@Autowired
	private QnaDAO qnaDAO;
	
//	@Test
//	public void getListTest() throws Exception{
//		List<QNADTO> ar = qnaDAO.getList();
//		assertNotEquals(0, ar.size());
//	}
	
	@Test
	public void addTest()throws Exception{
		QnaDTO qnadto = new QnaDTO();
		
		for(int i=0; i<100; i++) {
			qnadto.setContents("contesnts"+i);
			qnadto.setName("name"+i);
			qnadto.setSubject("subject"+i);
			qnaDAO.setAdd(qnadto);
		}
	}
}
