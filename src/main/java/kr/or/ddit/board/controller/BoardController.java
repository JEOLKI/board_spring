package kr.or.ddit.board.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.board.service.BoardServiceI;
import kr.or.ddit.common.model.PageVo;

@RequestMapping("/board")
@Controller
public class BoardController {

	@Resource(name = "boardService")
	private BoardServiceI boardService;
	
	@RequestMapping(path = "/list")
	public String list(int gubun_sq,
					   @RequestParam(name="page", defaultValue = "1", required = false) int page,
					   @RequestParam(name="pageSize", defaultValue = "10", required = false ) int pageSize,
					   Model model) {
		
		PageVo pageVo = new PageVo(gubun_sq, page, pageSize);
		Map<String, Object> map = boardService.getBoardPageList(pageVo);
		model.addAttribute("cpage", page);
		model.addAttribute("pages", map.get("pages"));
		model.addAttribute("boardList", map.get("boardList"));
		model.addAttribute("gubun_sq", gubun_sq);
		
		return "tiles/board/boardList";
	}
	
	@RequestMapping(path = "/detail", method = {RequestMethod.GET})
	public String boardDetail(int board_sq,
							  Model model) {
		
		Map<String, Object> map = boardService.getBoard(board_sq);
		model.addAttribute("boardVo", map.get("boardVo"));
		model.addAttribute("atchFileList", map.get("atchFileList"));
		model.addAttribute("replyList", map.get("replyList"));
		
		return "tiles/board/board";
	}
	
	
	
	@RequestMapping(path = "/regist", method = {RequestMethod.GET})
	public String registView() {
		
//		gubun_sq = Integer.parseInt(request.getParameter("gubun_sq"));
//		userid = request.getParameter("userid");
//		group_no = request.getParameter("group_no") == null? 0 : Integer.parseInt(request.getParameter("group_no")); 
//		board_p_sq = request.getParameter("board_sq") == null? 0 : Integer.parseInt(request.getParameter("board_sq"));
		
		return "tiles/board/boardRegister";
	}
	
	@RequestMapping(path = "/regist", method = {RequestMethod.POST})
	public String registProcess() {
		
//		String board_title = request.getParameter("board_title");
//		String editordata = request.getParameter("editordata");
//		
//		logger.debug("editordata : {}", editordata);
//		
//		if(group_no == 0) {
//			boardVo = new BoardVo(board_title, editordata, userid, gubun_sq);
//		}else {
//			boardVo = new BoardVo(board_title, editordata, userid, board_p_sq, gubun_sq, group_no);
//		}
//		
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("boardVo", boardVo);
//		
//		List<Part> fileList = new ArrayList<Part>();
//		fileList.add(request.getPart("file1"));
//		fileList.add(request.getPart("file2"));
//		fileList.add(request.getPart("file3"));
//		fileList.add(request.getPart("file4"));
//		fileList.add(request.getPart("file5"));
//		
//		AtchFileVo atchFileVo;
//		List<AtchFileVo> atchFileList = new ArrayList<AtchFileVo>();
//		
//		for (Part file : fileList) {
//			
//			if(file != null) {
//				if(file.getSize() > 0) {
//					String fileName = FileUploadUtil.getFilename(file.getHeader("Content-Disposition"));
//					String filePath = "D:\\attachment\\" + UUID.randomUUID().toString() +"."+ FileUploadUtil.getExtension(fileName);
//					atchFileVo = new AtchFileVo( filePath , fileName);
//					atchFileList.add(atchFileVo);
//					file.write(filePath);
//				}
//			}
//		}
//		
//		logger.debug("atchFileList : {}", atchFileList);
//		
//		map.put("atchFileList", atchFileList);
//		
//		int boardCurSq = boardService.insertBoard(map);
//		
//		response.sendRedirect("/board?board_sq="+boardCurSq);
		
		return "tiles/board/boardRegister";
	}
	
}
