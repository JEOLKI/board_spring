package kr.or.ddit.board.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;

import kr.or.ddit.WebTestConfig;

public class BoardGubunControllerTest extends WebTestConfig{

	@Test
	public void listTest() throws Exception {
		mockMvc.perform(get("/boardGu/list"))
				.andExpect(status().isOk())
				.andExpect(model().attributeExists("boardGubunList"))
				.andExpect(view().name("jsonView"));
	}
	
	@Test
	public void registViewTest() throws Exception {
		mockMvc.perform(get("/boardGu/regist"))
				.andExpect(status().isOk())
				.andExpect(view().name("tiles/board/boardGubunRegister"));
	}
	
	@Test
	public void registProcessTest() throws Exception {
		mockMvc.perform(post("/boardGu/regist")
				.param("gubun_nm", "TestGubun")
				.param("gubun_yn", "y"))
				.andExpect(status().is3xxRedirection())
				.andExpect(view().name("redirect:/boardGu/regist"));
	}
	
	@Test
	public void updateProcessTest() throws Exception {
		mockMvc.perform(post("/boardGu/update")
				.param("gubun_sq", "1")
				.param("gubun_nm", "TestGubun")
				.param("gubun_yn", "y"))
				.andExpect(status().is3xxRedirection())
				.andExpect(view().name("redirect:/boardGu/regist"));

		mockMvc.perform(post("/boardGu/update")
				.param("gubun_nm", "TestGubun")
				.param("gubun_yn", "y"))
				.andExpect(status().is3xxRedirection())
				.andExpect(view().name("redirect:main"));
	}
	
	

}
