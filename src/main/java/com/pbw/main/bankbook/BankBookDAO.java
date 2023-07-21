package com.pbw.main.bankbook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class BankBookDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE="com.pbw.main.bankbook.BankBookDAO.";  //이 mapper에서 라는 뜻
	
	//List
	public List<BankBookDTO> getList() throws Exception {
		return sqlSession.selectList(NAMESPACE+"getList");
	}
	
	//detail
	public BankBookDTO getDetail(BankBookDTO bankBookDTO) throws Exception{
				
		return sqlSession.selectOne(NAMESPACE+"getDetail", bankBookDTO);
		
	
	}
}
