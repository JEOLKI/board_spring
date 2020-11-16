package kr.or.ddit.board.dao;

import java.util.List;

import kr.or.ddit.board.model.AtchFileVo;
import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.model.ReplyVo;
import kr.or.ddit.common.model.PageVo;


public interface BoardDaoI {
	
	List<BoardVo> getBoardList(int gubun_sq);
	
	List<BoardVo> getBoardPageList(PageVo pageVo);

	int getBoardTotalCnt(int gubun_sq);

	BoardVo getBoard(int board_sq);

	List<AtchFileVo> getAtchFileList(int board_sq);

	List<ReplyVo> getReplyList(int board_sq);
	
	int deleteBoard(int board_sq);

	int insertBoard(BoardVo boardVo);

	int insertAtchFile(AtchFileVo atchfileVo);

	int insertBoardChild(BoardVo boardVo);

	AtchFileVo getAtchFile(int atch_sq);

	int deleteAtchFile(int atch_sq);

	int updateBoard(BoardVo boardVo);
}
