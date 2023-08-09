package com.pbw.main.bankbook.bookAccount;

import java.util.Calendar;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pbw.main.member.MemberDTO;
import com.pbw.main.util.Pager;

@Repository
public class BookAccountDAO {
	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE="com.pbw.main.bankbook.bookAccount.BookAccountDAO.";

	//list
	public List<BookAccountDTO> getList(MemberDTO memberDTO)throws Exception{
		return sqlSession.selectList(NAMESPACE+"getList", memberDTO);
	}
	
	//add
	public int setAdd(BookAccountDTO bookAccountDTO)throws Exception{
		Calendar ca = Calendar.getInstance();
		bookAccountDTO.setAccount(ca.getTimeInMillis());
		return sqlSession.insert(NAMESPACE+"setAdd", bookAccountDTO);
	}
}
