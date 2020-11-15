package kr.or.ddit.board.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ddit.board.dao.BoardGubunDaoI;
import kr.or.ddit.board.model.BoardGubunVo;

@Transactional
@Service("boardGubunService")
public class BoardGubunService implements BoardGubunServiceI{
	
	@Resource(name = "boardGubunRepository")
	private BoardGubunDaoI boardGubunDao;
	
	@Override
	public List<BoardGubunVo> getBoardGubunList() {
		return boardGubunDao.getBoardGubunList();
	}

	@Override
	public int insertBoardGubun(BoardGubunVo boardGubunVo) {
		return boardGubunDao.insertBoardGubun(boardGubunVo);
	}

	@Override
	public int updateBoardGubun(BoardGubunVo boardGubunVo) {
		return boardGubunDao.updateBoardGubun(boardGubunVo);
	}

	@Override
	public int deleteBoardGubun(String gubun_nm) {
		return boardGubunDao.deleteBoardGubun(gubun_nm);
	}

}
