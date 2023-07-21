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
	
	//add
	public int setAdd(BankBookDTO bankBookDTO)throws Exception{
		return sqlSession.insert(NAMESPACE+"setAdd", bankBookDTO);  //어느 mapper의 어느 ip를 가져올지
	}
	
	//delete
	public int setDelete(BankBookDTO bankBookDTO) throws Exception{
		return sqlSession.delete(NAMESPACE+"setDelete", bankBookDTO);
	}
	//delete 예제 mapper에서 Long타입의 num으로 바꾸면 가능
//		public int setDelete(Long num) throws Exception{
//			return sqlSession.delete(NAMESPACE+"setDelete", num);
//		}
	
	//update
	public int setUpdate(BankBookDTO bankBookDTO) throws Exception{
		return sqlSession.update(NAMESPACE+"setUpdate", bankBookDTO);
	}
	
	
	
	
}
