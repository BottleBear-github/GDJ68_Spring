package com.pbw.main.board.qna;

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
public class QnaService implements BoardService{
	
	@Autowired
	private QnaDAO qnaDAO;
	
	@Autowired
	private FileManager fileManager;
	
	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception{
		pager.makeRowNum();
		Long total = qnaDAO.getTotal(pager);
		pager.makePageNum(qnaDAO.getTotal(pager));
		return qnaDAO.getList(pager);
	}
	
	@Override
	public int setAdd(BoardDTO boardDTO, MultipartFile [] files, HttpSession session)throws Exception{
		String path="/resources/upload/qna/";
		int result = qnaDAO.setAdd(boardDTO);
		
		for(MultipartFile multipartFile: files) {
			
			if(multipartFile.isEmpty()) {
				continue;				
			}
			
			String fileName = fileManager.fileSave(path, session, multipartFile);
			QnaFileDTO qnaFileDTO = new QnaFileDTO();
			qnaFileDTO.setOriginalName(multipartFile.getOriginalFilename());
			qnaFileDTO.setFileName(fileName);
			qnaFileDTO.setQnaNum(boardDTO.getNum());
			result = qnaDAO.setFileAdd(qnaFileDTO);
			
		}
		
		
		return result; //qnaDAO.setAdd(boardDTO);
	}

	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.getDetail(boardDTO);
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.setUpdate(boardDTO);
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.setDelete(boardDTO);
	}

	public int setHitCount(BoardDTO boardDTO)throws Exception{
		return qnaDAO.setHitUpdate(boardDTO);
	}
	
	//reply
	public int setReplyAdd(QnaDTO qnaDTO, MultipartFile [] files, HttpSession session)throws Exception{
		BoardDTO parentDTO = new BoardDTO();
		parentDTO.setNum(qnaDTO.getNum());//부모의 글번호
		
		parentDTO=qnaDAO.getDetail(parentDTO);
		QnaDTO p =(QnaDTO)parentDTO;
		qnaDTO.setRef(p.getRef());
		qnaDTO.setStep(p.getStep()+1);
		qnaDTO.setDepth(p.getDepth()+1);
		
		int result = qnaDAO.setStepUpdate(p);
		
		result = qnaDAO.setReplyAdd(qnaDTO);
		return result; //qnaDAO.setReplyAdd(qnaDTO);
	}
	
	
}
