package com.pbw.main.bankBook;

import static org.junit.Assert.*;

import java.util.List;

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
	public void addTest() throws Exception {
		BankBookDTO bankBookDTO = new BankBookDTO();
		
		for(int i=0; i<30; i++) {
			
			bankBookDTO.setBookName("청년병웅통장"+i);
			bankBookDTO.setBookContents("입출금 내용 및 내역"+i);
			bankBookDTO.setBookRate(8.7);
			bankBookDTO.setBookSale(1);
			bankBookDAO.setAdd(bankBookDTO);
		}
		
		System.out.println("Finish");
		
	}

}
