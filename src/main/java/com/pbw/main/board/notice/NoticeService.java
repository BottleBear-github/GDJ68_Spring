package com.pbw.main.board.notice;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.pbw.main.board.BoardDTO;
import com.pbw.main.board.BoardService;
import com.pbw.main.util.FileManager;
import com.pbw.main.util.Pager;


@Service
public class NoticeService implements BoardService{

	@Autowired
	private NoticeDAO noticeDAO;
	
	@Autowired
	private FileManager fileManager;
	
	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception{
		pager.makeRowNum();
		Long total=noticeDAO.getTotal(pager);
		pager.makePageNum(total);
		return noticeDAO.getList(pager);
	}
	
	@Override
	public int setAdd(BoardDTO boardDTO, MultipartFile [] files, HttpSession session)throws Exception {
		String path="/resources/upload/notice/";
		int result = noticeDAO.setAdd(boardDTO);
		
		for(MultipartFile multipartFile: files) {
			
			if(multipartFile.isEmpty()) {
				continue;				
			}
			
			String fileName = fileManager.fileSave(path, session, multipartFile);
			NoticeFileDTO noticeFileDTO = new NoticeFileDTO();
			noticeFileDTO.setOriginalName(multipartFile.getOriginalFilename());
			noticeFileDTO.setFileName(fileName);
			noticeFileDTO.setNoticeNo(boardDTO.getNum());
			result = noticeDAO.setFileAdd(noticeFileDTO);
			
		}
		
		
		return result; //noticeDAO.setAdd(noticeDTO);
	}
	
	@Override
	public BoardDTO getDetail(BoardDTO boardDTO)throws Exception {
		return noticeDAO.getDetail(boardDTO);
	}
	
	@Override
	public int setDelete(BoardDTO boardDTO)throws Exception {
		return noticeDAO.setDelete(boardDTO);
	}
	
	@Override
	public int setUpdate(BoardDTO boardDTO)throws Exception{
		return noticeDAO.setUpdate(boardDTO);
	}
	
	public int setHitCount(NoticeDTO noticeDTO)throws Exception{
		return noticeDAO.setHitCount(noticeDTO);
	}

}
