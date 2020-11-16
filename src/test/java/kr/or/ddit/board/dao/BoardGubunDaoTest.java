package kr.or.ddit.board.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import kr.or.ddit.ModelTestConfig;
import kr.or.ddit.board.model.BoardGubunVo;

public class BoardGubunDaoTest extends ModelTestConfig{
	
	@Resource(name = "boardGubunRepository")
	private BoardGubunDaoI boardGubunDao;
	
	@Test
	public void getBoardGubunListTest() {
		/***Given***/
			
		/***When***/
		List<BoardGubunVo> boardGubunList = boardGubunDao.getBoardGubunList();

		/***Then***/
		assertEquals(3, boardGubunList.size());
	}

	@Test
	public void insertBoardGubunTest() {
		/***Given***/
		BoardGubunVo boardGubunVo = new BoardGubunVo("1", "y");
		
		/***When***/
		int insertCnt = boardGubunDao.insertBoardGubun(boardGubunVo);
		
		/***Then***/
		assertEquals(1, insertCnt);
	}
	
	@Test
	public void updateBoardGubunTest() {
		/***Given***/
		BoardGubunVo boardGubunVo = new BoardGubunVo(1, "updateTest", "n");
		
		/***When***/
		int insertCnt = boardGubunDao.updateBoardGubun(boardGubunVo);
		
		/***Then***/
		assertEquals(1, insertCnt);
	}
	

}
