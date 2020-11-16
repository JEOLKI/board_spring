package kr.or.ddit.file;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.board.model.AtchFileVo;
import kr.or.ddit.board.service.BoardServiceI;

@RequestMapping("/file")
@Controller
public class FileController {

	private static final Logger logger = LoggerFactory.getLogger(FileController.class);
	
	@Resource(name = "boardService")
	private BoardServiceI boardService;
	
	@RequestMapping("/download")
	public String fileDownload(int atch_sq, Model model){

		AtchFileVo atchFileVo = boardService.getAtchFile(atch_sq);
		
		logger.debug("atchFileVo : {}", atchFileVo);
		
		model.addAttribute("filepath", atchFileVo.getAtch_filepath());
		model.addAttribute("filename", atchFileVo.getAtch_filename());
		
		return "fileDownloadView";
	}
}
