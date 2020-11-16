package kr.or.ddit.board.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import kr.or.ddit.ModelTestConfig;
import kr.or.ddit.board.model.BoardGubunVo;

public class BoardGubunServiceTest extends ModelTestConfig{
	
	@Resource(name = "boardGubunService")
	BoardGubunServiceI boardGubunService;
	
	@Test
	public void getBoardGubunListTest() {
		/***Given***/
			
		/***When***/
		List<BoardGubunVo> boardGubunList = boardGubunService.getBoardGubunList();

		/***Then***/
		assertEquals(3, boardGubunList.size());
	}

	@Test
	public void insertBoardGubunTest() {
		/***Given***/
		BoardGubunVo boardGubunVo = new BoardGubunVo("test", "y");
		
		/***When***/
		int insertCnt = boardGubunService.insertBoardGubun(boardGubunVo);
		
		/***Then***/
		assertEquals(1, insertCnt);
	}
	
	@Test
	public void updateBoardGubunTest() {
		/***Given***/
		BoardGubunVo boardGubunVo = new BoardGubunVo(1, "updateTest", "n");
		
		/***When***/
		int insertCnt = boardGubunService.updateBoardGubun(boardGubunVo);
		
		/***Then***/
		assertEquals(1, insertCnt);
	}
}
