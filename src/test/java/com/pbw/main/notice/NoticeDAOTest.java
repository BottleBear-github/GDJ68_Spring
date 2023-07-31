package com.pbw.main.notice;

import static org.junit.Assert.assertNotEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.pbw.main.Mytest;
import com.pbw.main.board.notice.NoticeDAO;
import com.pbw.main.board.notice.NoticeDTO;

public class NoticeDAOTest extends Mytest {

	@Autowired
	private NoticeDAO noticeDAO;
	
//	@Test
//	public void getListTest() throws Exception{
//		List<NoticeDTO> ar = noticeDAO.getList();
//		assertNotEquals(0, ar.size());
//	}
	
	@Test
	public void addTest() throws Exception {
		NoticeDTO noticeDTO = new NoticeDTO();
		
		for(int i=0; i<100; i++) {
			
			noticeDTO.setNoticeSubject("NoticeSubject"+i);
			noticeDTO.setNoticeName("NoticeName"+i);
			noticeDTO.setNoticeContents("NoticeContents"+i);
			noticeDAO.setAdd(noticeDTO);
		}
		
		System.out.println("Finish");
		
	}
	
}
