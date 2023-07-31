package com.pbw.main.qnaBoard;

import static org.junit.Assert.assertNotEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.pbw.main.Mytest;
import com.pbw.main.notice.NoticeDTO;

public class QNABoardTest extends Mytest {

	@Autowired
	private QNADAO qnaDAO;
	
//	@Test
//	public void getListTest() throws Exception{
//		List<QNADTO> ar = qnaDAO.getList();
//		assertNotEquals(0, ar.size());
//	}
	
	@Test
	public void addTest()throws Exception{
		QNADTO qnadto = new QNADTO();
		
		for(int i=0; i<100; i++) {
			qnadto.setQnaContents("contesnts"+i);
			qnadto.setQnaName("name"+i);
			qnadto.setQnaSubject("subject"+i);
			qnaDAO.setAdd(qnadto);
		}
	}
}
