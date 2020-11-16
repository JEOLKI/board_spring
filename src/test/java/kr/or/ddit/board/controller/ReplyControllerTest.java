package kr.or.ddit.board.controller;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;

import kr.or.ddit.WebTestConfig;

public class ReplyControllerTest extends WebTestConfig{

	@Test
	public void deleteProcessTest() throws Exception{
		mockMvc.perform(get("/reply/delete")
						.param("reply_sq", "1")
						.param("board_sq", "5"))
				.andExpect(status().is3xxRedirection())
				.andExpect(view().name("redirect:/board/detail?board_sq=5"));
	}
	
	@Test
	public void registProcessTest() throws Exception{
		mockMvc.perform(get("/reply/regist")
				.param("reply_content", "TestReply")
				.param("board_sq", "5")
				.param("userid", "brown"))
		.andExpect(status().is3xxRedirection())
		.andExpect(view().name("redirect:/board/detail?board_sq=5"));
	}
	

}
