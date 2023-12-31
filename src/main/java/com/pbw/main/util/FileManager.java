package com.pbw.main.util;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManager {

	
	public String fileSave(String path, HttpSession session, MultipartFile multipartFile) throws Exception {
		//파일의 정보를 이용해서 HDD에 파일을 저장
				//1. 어디에 저장??
//				String path="/resources/upload/member/";
				//Service에서 처리
				
				//2. 실제 경로 알아오기
				//jsp : application
				//java : ServletContext
				String realPath = session.getServletContext().getRealPath(path);
				System.out.println(realPath);
				
				File file = new File(realPath);
				
				if(!file.exists()) {     //dir이 없으면 생성
					file.mkdirs();
				}
				
				//3.어떤이름으로 저장??
				//3-1.시간을 이용
//				Calendar ca = Calendar.getInstance();
//				long result =ca.getTimeInMillis();
//				file = new File(file, result+"_"+multipartFile.getOriginalFilename());
				//3-2.API 사용
				String uId = UUID.randomUUID().toString();
				uId = uId+"_"+multipartFile.getOriginalFilename();
				System.out.println(uId);
				file = new File(file, uId);
				
				//4. 파일을 저장 , 방법은 두가지
				//4-1. Spring에서 제공하는 API FileCopyUtils메서드 copy메서드
//				FileCopyUtils.copy(multipartFile.getBytes(), file);
				
				//4-2. MultipartFile의 transFerTo메서드
				multipartFile.transferTo(file);
				
				return uId;
	}
}
















