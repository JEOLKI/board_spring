package kr.or.ddit.mvc.view;

import java.io.FileInputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.AbstractView;

public class fileDownloadView extends AbstractView {

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String filename = URLEncoder.encode((String) model.get("filename"), "utf-8").replace("+", " ");
		
		// response content-type
		response.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");
		response.setContentType("application/octet-stream");
		
		// 경로 확인 후 파일 입출력을 통해 응답생성
		// 파일을 읽고
		// 응답 생성
		// memberVo.getFilename(); // 파일경로

		FileInputStream fis = new FileInputStream((String)model.get("filepath"));
		ServletOutputStream sos = response.getOutputStream();

		byte[] buffer = new byte[512];

		while (fis.read(buffer) != -1) {
			sos.write(buffer);
		}

		fis.close();
		sos.flush();
		sos.close();
	}

}
