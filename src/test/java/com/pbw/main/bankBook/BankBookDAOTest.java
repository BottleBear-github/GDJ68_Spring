package com.pbw.main.bankBook;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.pbw.main.Mytest;
import com.pbw.main.bankbook.BankBookDAO;
import com.pbw.main.bankbook.BankBookDTO;

public class BankBookDAOTest extends Mytest {

	@Autowired
	private BankBookDAO bankBookDAO;
	
	@Test
	public void getListTest()throws Exception{
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startRow", 1);
		map.put("lastRow", 10);
		
//		List<BankBookDTO> ar = bankBookDAO.getList(map);
//		System.out.println(ar.get(0).getBookNum());
//		System.out.println(ar.get(9).getBookNum());
		
	}
	
	
//	@Test
//	public void addTest() throws Exception {
//		BankBookDTO bankBookDTO = new BankBookDTO();
//		
//		for(int i=0; i<30; i++) {
//			
//			bankBookDTO.setBookName("청년병웅통장"+i);
//			bankBookDTO.setBookContents("입출금 내용 및 내역"+i);
//			bankBookDTO.setBookRate(8.7);
//			bankBookDTO.setBookSale(1);
//			bankBookDAO.setAdd(bankBookDTO);
//		}
//		
//		System.out.println("Finish");
//		
//	}

}
