package kr.or.ddit.board.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.io.InputStream;

import org.junit.Test;
import org.springframework.mock.web.MockMultipartFile;

import kr.or.ddit.WebTestConfig;

public class BoardControllerTest extends WebTestConfig{

	@Test
	public void listTest() throws Exception {
		mockMvc.perform(get("/board/list")
						.param("gubun_sq", "1"))
				.andExpect(status().isOk())
				.andExpect(view().name("tiles/board/boardList"));
	}
	
	@Test
	public void boardDetailTest() throws Exception {
		mockMvc.perform(get("/board/detail")
						.param("board_sq", "1"))
				.andExpect(status().isOk())
				.andExpect(view().name("tiles/board/board"));
	}
	
	@Test
	public void registViewTest() throws Exception {
		mockMvc.perform(get("/board/regist")
				.param("gubun_sq", "1")
				.param("board_sq", "1"))
		.andExpect(status().isOk())
		.andExpect(view().name("tiles/board/boardRegister"));
	}
	
	@Test
	public void registProcessTest() throws Exception {
		InputStream is = getClass().getResourceAsStream("/kr/or/ddit/upload/brown.png");
		MockMultipartFile file = new MockMultipartFile("file", "brown.png", "image/png", is);
		
		mockMvc.perform(fileUpload("/board/regist")
						.file(file)
						.param("board_title", "TestTitle")
						.param("board_content", "TestContent")
						.param("userid", "brown")
						.param("gubun_sq", "1")
						.param("group_no", "1"))
				.andExpect(status().is3xxRedirection());
	}
	
	@Test
	public void updateViewTest() throws Exception {
		mockMvc.perform(get("/board/update")
				.param("board_sq", "1"))
		.andExpect(status().isOk())
		.andExpect(view().name("tiles/board/boardUpdate"));
	}
	
	@Test
	public void updateProcessTest() throws Exception {
		InputStream is = getClass().getResourceAsStream("/kr/or/ddit/upload/brown.png");
		MockMultipartFile file = new MockMultipartFile("file", "brown.png", "image/png", is);
		
		mockMvc.perform(fileUpload("/board/update")
						.file(file)
						.param("board_sq", "1")
						.param("board_title", "TestTitle")
						.param("board_content", "TestContent")
						.param("board_yn", "y"))
				.andExpect(status().is3xxRedirection());
	}
	
	@Test
	public void deleteProcessTest() throws Exception {
		mockMvc.perform(get("/board/delete")
				.param("board_sq", "1")
				.param("gubun_sq", "1")
				.param("gubun_nm", "1"))
		.andExpect(status().is3xxRedirection())
		.andExpect(view().name("redirect:/board/list?gubun_sq=1&gubun_nm=1"));
	}

}
