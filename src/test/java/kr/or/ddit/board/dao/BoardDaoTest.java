package kr.or.ddit.board.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import kr.or.ddit.ModelTestConfig;
import kr.or.ddit.board.model.AtchFileVo;
import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.model.ReplyVo;
import kr.or.ddit.common.model.PageVo;

public class BoardDaoTest extends ModelTestConfig{
	
	@Resource(name = "boardRepository")
	private BoardDaoI boardDao;
	
	@Test
	public void getBoardListTest() {
		
		/***Given***/
		int gubun_sq = 1;
		
		/***When***/
		List<BoardVo> boardList = boardDao.getBoardList(gubun_sq);

		/***Then***/
		assertEquals(10, boardList.size());
		
	}
	
	@Test
	public void getBoardPageListTest() {
		
		/***Given***/
		PageVo pageVo = new PageVo(1, 1, 10);
		
		/***When***/
		List<BoardVo> boardList = boardDao.getBoardPageList(pageVo);
		
		/***Then***/
		assertEquals(10, boardList.size());
		
	}
	
	@Test
	public void getBoardTotalCntTest() {
		
		/***Given***/
		int gubun_sq = 1;
		
		/***When***/
		int totalCnt= boardDao.getBoardTotalCnt(gubun_sq);
		
		/***Then***/
		assertEquals(10, totalCnt);
		
	}

	@Test
	public void getBoardTest() {
		
		/***Given***/
		int board_sq = 1;
		
		/***When***/
		BoardVo boardVo= boardDao.getBoard(board_sq);
		
		/***Then***/
		assertEquals(board_sq, boardVo.getBoard_sq());
		
	}
	
	@Test
	public void getAtchFileListTest() {
		
		/***Given***/
		int board_sq = 5;
		
		/***When***/
		List<AtchFileVo> atchFileList= boardDao.getAtchFileList(board_sq);
		
		/***Then***/
		assertEquals(2, atchFileList.size());
		
	}
	
	@Test
	public void getReplyListTest() {
		
		/***Given***/
		int board_sq = 5;
		
		/***When***/
		List<ReplyVo> replyList= boardDao.getReplyList(board_sq);
		
		/***Then***/
		assertEquals(5, replyList.size());
		
	}
	
	@Test
	public void deleteBoardTest() {
		
		/***Given***/
		int board_sq = 8;
		
		/***When***/
		int deleteCnt= boardDao.deleteBoard(board_sq);
		
		/***Then***/
		assertEquals(1, deleteCnt);
		
	}
	
	@Test
	public void insertBoardTest() {
		
		/***Given***/
		BoardVo boardVo = new BoardVo("test", "test", "brown", 1, 1, 1);
		/***When***/
		int board_sq = boardDao.insertBoard(boardVo);
		int Cnt = 0;
		if(board_sq > 1) {
			Cnt=1;
		}
		
		/***Then***/
		assertEquals(1, Cnt);
		
	}
	
	
	
}
