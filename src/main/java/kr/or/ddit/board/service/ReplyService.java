package kr.or.ddit.board.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ddit.board.dao.ReplyDaoI;
import kr.or.ddit.board.model.ReplyVo;

@Transactional
@Service("replyService")
public class ReplyService implements ReplyServiceI{

	@Resource(name = "replyRepository")
	private ReplyDaoI replyDao;
	
	@Override
	public int insertReply(ReplyVo replyVo) {
		return replyDao.insertReply(replyVo);
	}

	@Override
	public int deleteReply(int reply_sq) {
		return replyDao.deleteReply(reply_sq);
	}

}
