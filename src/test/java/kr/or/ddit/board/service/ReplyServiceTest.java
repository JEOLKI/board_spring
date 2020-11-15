package kr.or.ddit.board.service;

import static org.junit.Assert.assertEquals;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.board.model.ReplyVo;

public class ReplyServiceTest {
	
	ReplyServiceI replyService;
	ReplyVo replyVo;
	
	SqlSession sqlSession;
	
	@Before
	public void setup() {
		replyService = new ReplyService();
		replyVo = new ReplyVo();
	}
	
	@After
	public void reset() {
		sqlSession.close();
	}
	
	@Test
	public void insertReplyTest() {
		/***Given***/
		replyVo = new ReplyVo("reply_content", 1, "brown");
		
		/***When***/
		int insertCnt = replyService.insertReply(replyVo);

		/***Then***/
		assertEquals(1, insertCnt);
		
	}
	
	@Test
	public void deleteReplyTest() {
		
		/***Given***/
		

		/***When***/
		int updateCnt = replyService.deleteReply(1);

		/***Then***/
		assertEquals(1, updateCnt);
		
	}

}
