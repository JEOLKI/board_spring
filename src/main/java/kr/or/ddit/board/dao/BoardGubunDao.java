package kr.or.ddit.board.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.board.model.BoardGubunVo;

@Repository("boardGubunRepository")
public class BoardGubunDao implements BoardGubunDaoI {
	
	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;

	@Override
	public List<BoardGubunVo> getBoardGubunList() {
		return sqlSession.selectList("board.getBoardGubunList");
	}

	@Override
	public int insertBoardGubun(BoardGubunVo boardGubunVo) {
		return sqlSession.insert("board.insertBoardGubun", boardGubunVo);
	}
	
	@Override
	public int updateBoardGubun(BoardGubunVo boardGubunVo) {
		return sqlSession.update("board.updateBoardGubun", boardGubunVo);
	}

	@Override
	public int deleteBoardGubun(String gubun_nm) {
		return sqlSession.delete("board.deleteBoardGubunForTest", gubun_nm);
	}
	

}
