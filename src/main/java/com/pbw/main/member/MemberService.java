package com.pbw.main.member;

import java.io.File;
import java.util.Calendar;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.pbw.main.util.FileManager;

@Service
public class MemberService {

	@Autowired
	private MemberDAO memberDAO;
	
	@Autowired
	private FileManager fileManager;	
	
	public int setJoin(MemberDTO memberDTO, HttpSession session, MultipartFile multipartFile)throws Exception{
		String path="/resources/upload/member/";
		
		int result = memberDAO.setJoin(memberDTO);
		System.out.println("memberDTOsetJoin");
		
		if(!multipartFile.isEmpty()) {
			
			String fileName =  fileManager.fileSave(path, session, multipartFile);
			
			MemberFileDTO memberFileDTO = new MemberFileDTO();
			memberFileDTO.setId(memberDTO.getId());
			memberFileDTO.setOriginalName(multipartFile.getOriginalFilename());
			memberFileDTO.setFileName(fileName);
			result = memberDAO.setFileJoin(memberFileDTO);
		}

		return result; //memberDAO.setJoin(memberDTO);
	}
	
	public MemberDTO getLogin(MemberDTO memberDTO)throws Exception{
		return memberDAO.getLogin(memberDTO);
	}
	
	public int setMemberUpdate(MemberDTO memberDTO)throws Exception{
		return memberDAO.setMemberUpdate(memberDTO);
	}
	
	public int setMemberDelete(MemberDTO memberDTO)throws Exception{
		return memberDAO.setMemberDelete(memberDTO);
	}
	
}
