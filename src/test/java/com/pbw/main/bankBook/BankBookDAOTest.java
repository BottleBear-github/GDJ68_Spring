package com.pbw.main.bankBook;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.pbw.main.Mytest;
import com.pbw.main.bankbook.BankBookDTO;

public class BankBookDAOTest extends Mytest {

	private SqlSession sqlSession;
	
	private final String NAMESPACE="com.pbw.main.bankbook.BankBookDAO.";
	
	public List<BankBookDTO> getList() throws Exception {
		return sqlSession.selectList(NAMESPACE+"getList");
	}

}
