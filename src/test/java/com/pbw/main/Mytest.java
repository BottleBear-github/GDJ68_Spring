package com.pbw.main;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.pbw.main.bankbook.BankBookDAO;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = ("file:src/main/webapp/WEB-INF/spring/**/*-context.xml"))
public abstract class Mytest {

//	@Autowired
//	private BankBookDAO bankBookDAO;
//	
//	@Test
//	public void deleteTest()throws Exception {
//		int result = bankBookDAO.setDelete(10L);
//		
//		assertNotEquals(0, result);
//	}

	
}
