package com.pbw.main.bankBook.bookAccount;

import org.springframework.beans.factory.annotation.Autowired;

import com.pbw.main.Mytest;
import com.pbw.main.bankbook.BankBookFileDTO;
import com.pbw.main.bankbook.bookAccount.BookAccountDAO;
import com.pbw.main.bankbook.bookAccount.BookAccountDTO;

public class BookAccountDAOTest extends Mytest {

	@Autowired
	private BookAccountDAO bookAccountDAO;
	
	public void addTest() throws Exception{
		BookAccountDTO bookAccountDTO = new BookAccountDTO();
		bookAccountDTO.setAccount(1111L);
		bookAccountDTO.setAccountBalance(0L);
		bookAccountDTO.setAccountDate(null);
		bookAccountDTO.setAccountNum(1L);
		bookAccountDTO.setAccountPassword("0000");
		bookAccountDTO.setBookNum(1L);
		bookAccountDTO.setId("qwerqwerppp");
		bookAccountDAO.setAdd(bookAccountDTO);
	}
	
}


