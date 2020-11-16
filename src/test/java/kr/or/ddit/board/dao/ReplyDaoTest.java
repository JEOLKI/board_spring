package kr.or.ddit.board.dao;

import static org.junit.Assert.assertEquals;

import javax.annotation.Resource;

import org.junit.Test;

import kr.or.ddit.ModelTestConfig;
import kr.or.ddit.board.model.ReplyVo;

public class ReplyDaoTest  extends ModelTestConfig{
	
	@Resource(name = "replyRepository")
	private ReplyDaoI replyDao;
	
	@Test
	public void insertReplyTest() {
		/***Given***/
		ReplyVo replyVo = new ReplyVo("reply_content", 1, "brown");
		
		/***When***/
		int insertCnt = replyDao.insertReply(replyVo);

		/***Then***/
		assertEquals(1, insertCnt);
	}
	
	@Test
	public void deleteReplyTest() {
		
		/***Given***/

		/***When***/
		int updateCnt = replyDao.deleteReply(1);

		/***Then***/
		assertEquals(1, updateCnt);
		
	}
	
}
