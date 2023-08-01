package com.pbw.main.board.notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pbw.main.board.BoardDAO;
import com.pbw.main.board.BoardDTO;
import com.pbw.main.util.Pager;



@Repository
public class NoticeDAO implements BoardDAO{
	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE="com.pbw.main.board.notice.NoticeDAO.";
	
	//total
	@Override
	public Long getTotal(Pager pager)throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getTotal", pager);
	}
	
	//List
	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		return sqlSession.selectList(NAMESPACE+"getList", pager);
	}
	//add
	@Override
	public int setAdd(BoardDTO boardDTO)throws Exception{
		return sqlSession.insert(NAMESPACE+"setAdd", boardDTO);
	}
	//detail
	@Override
	public NoticeDTO getDetail(BoardDTO boardDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getDetail", boardDTO);
	}
	
	//delete
	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception{
		return sqlSession.delete(NAMESPACE+"setDelete", boardDTO);
	}

	//update
	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception{
		return sqlSession.update(NAMESPACE+"setUpdate", boardDTO);
	}
	
	@Override
	public int setHitCount(BoardDTO boardDTO) throws Exception{
		return sqlSession.update(NAMESPACE+"setHitCount", boardDTO);
	}
	
	public int setFileAdd(NoticeFileDTO noticeFileDTO)throws Exception{
		return sqlSession.insert(NAMESPACE+"setFileAdd", noticeFileDTO);
	}
	

}
