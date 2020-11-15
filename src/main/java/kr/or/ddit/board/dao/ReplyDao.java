package kr.or.ddit.board.dao;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.board.model.ReplyVo;

@Repository("replyRepository")
public class ReplyDao implements ReplyDaoI {

	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;
	
	@Override
	public int insertReply(ReplyVo replyVo) {
		return sqlSession.insert("board.insertReply", replyVo);
	}

	@Override
	public int deleteReply(int reply_sq) {
		return sqlSession.insert("board.deleteReply", reply_sq);
	}
	
}
