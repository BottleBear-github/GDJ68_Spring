package com.pbw.main.board;

import java.util.List;

import com.pbw.main.board.notice.NoticeDTO;
import com.pbw.main.util.Pager;

public interface BoardDAO {
	
	//List
	public List<BoardDTO> getList(Pager pager)throws Exception;
	
	//Detail
	public BoardDTO getDetail(BoardDTO boardDTO)throws Exception;
	
	//Add
	public int setAdd(BoardDTO boardDTO)throws Exception;
	
	//Update
	public int setUpdate(BoardDTO boardDTO)throws Exception;
	
	//Delete
	public int setDelete(BoardDTO boardDTO)throws Exception;
	
	//totalCount
	public Long getTotal(Pager pager)throws Exception;
	
	//조회수 업데이트
	public int setHitUpdate(BoardDTO boardDTO)throws Exception;

	

}