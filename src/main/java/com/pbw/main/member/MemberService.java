package com.pbw.main.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

	@Autowired
	private MemberDAO memberDAO;
	
	public void service() {
		System.out.println("MemberService");
		memberDAO.dao();
	}
}
