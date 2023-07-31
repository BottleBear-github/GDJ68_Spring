package com.pbw.main.board.notice;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.pbw.main.util.FileManager;
import com.pbw.main.util.Pager;




@Service
public class NoticeService {

	@Autowired
	private NoticeDAO noticeDAO;
	
	@Autowired
	private FileManager fileManager;
	
	public List<NoticeDTO> getList(Pager pager) throws Exception{
		pager.makeRowNum();
		Long total=noticeDAO.getTotal(pager);
		pager.makePageNum(total);
		return noticeDAO.getList(pager);
	}
	
	public int setAdd(NoticeDTO noticeDTO, MultipartFile [] files, HttpSession session)throws Exception {
		String path="/resources/upload/notice/";
		int result = noticeDAO.setAdd(noticeDTO);
		
		for(MultipartFile multipartFile: files) {
			
			if(multipartFile.isEmpty()) {
				continue;				
			}
			
			String fileName = fileManager.fileSave(path, session, multipartFile);
			NoticeFileDTO noticeFileDTO = new NoticeFileDTO();
			noticeFileDTO.setOriginalName(multipartFile.getOriginalFilename());
			noticeFileDTO.setFileName(fileName);
			noticeFileDTO.setNoticeNo(noticeDTO.getNum());
			result = noticeDAO.setFileAdd(noticeFileDTO);
			
		}
		
		
		return result; //noticeDAO.setAdd(noticeDTO);
	}
	
	public NoticeDTO getDetail(NoticeDTO noticeDTO)throws Exception {
		return noticeDAO.getDetail(noticeDTO);
	}
	
	public int setDelete(NoticeDTO noticeDTO)throws Exception {
		return noticeDAO.setDelete(noticeDTO);
	}
	
	public int setUpdate(NoticeDTO noticeDTO)throws Exception{
		return noticeDAO.setUpdate(noticeDTO);
	}
	
	public int setHitCount(NoticeDTO noticeDTO)throws Exception{
		return noticeDAO.setHitCount(noticeDTO);
	}

}
