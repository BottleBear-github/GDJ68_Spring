package com.pbw.main.bankbook.bookAccount;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pbw.main.member.MemberDTO;
import com.pbw.main.util.Pager;

@Service
public class BookAccountService {

	@Autowired
	private BookAccountDAO bookAccountDAO;

	public List<BookAccountDTO> getList(MemberDTO memberDTO, Pager pager)throws Exception{
		pager.makeRowNum();
		return bookAccountDAO.getList(memberDTO);
	}
	
	public int setAdd(BookAccountDTO bookAccountDTO)throws Exception{
		return bookAccountDAO.setAdd(bookAccountDTO);
	}
}
