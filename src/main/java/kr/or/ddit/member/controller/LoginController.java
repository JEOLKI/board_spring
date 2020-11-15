package kr.or.ddit.member.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.board.service.BoardGubunService;
import kr.or.ddit.board.service.BoardGubunServiceI;
import kr.or.ddit.member.model.MemberVo;
import kr.or.ddit.member.service.MemberServiceI;

@Controller
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Resource(name = "memberService")
	private MemberServiceI memberService;

	@Resource(name = "boardGubunService")
	private BoardGubunServiceI boardGubunService;

	@RequestMapping(path = "/login", method = { RequestMethod.GET })
	public String view() {
		return "login/view";
	}

	@RequestMapping(path = "/login", method = { RequestMethod.POST })
	public String login(String userid, String pass, HttpSession session) {
		logger.debug("userId : {}, password : {} ", userid, pass);
		MemberVo memberVo = memberService.getMember(userid);
		// 디비에 등록된 회원이 없거나, 비밀번호가 틀린경우 (로그인 페이지)
		if (memberVo == null || !memberVo.getPass().equals(pass)) {
			return "login/view";
		}
		// 비밀번호가 일치하는 경우(메인 페이지로 이동)
		else if (memberVo.getPass().equals(pass)) {
			session.setAttribute("S_MEMBER", memberVo);
			session.setAttribute("boardGubunList", boardGubunService.getBoardGubunList());
			return "main";
		}
		return "login/view";
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "login/view";
	}

}
