package kr.or.ddit.board.service;

import static org.junit.Assert.assertEquals;

import javax.annotation.Resource;

import org.junit.Test;

import kr.or.ddit.ModelTestConfig;
import kr.or.ddit.board.model.ReplyVo;

public class ReplyServiceTest extends ModelTestConfig{
	
	@Resource(name = "replyService")
	ReplyServiceI replyService;
	
	@Test
	public void insertReplyTest() {
		/***Given***/
		ReplyVo	replyVo = new ReplyVo("reply_content", 1, "brown");
		
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
