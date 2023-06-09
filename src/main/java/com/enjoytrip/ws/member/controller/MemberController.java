package com.enjoytrip.ws.member.controller;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.enjoytrip.ws.member.model.MemberDto;
import com.enjoytrip.ws.member.model.service.MemberService;



@Controller
@RequestMapping("/member")
public class MemberController {
	
	private final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	private MemberService memberService;

	public MemberController(MemberService memberService) {
		super();
		this.memberService = memberService;
	}

	@GetMapping("/regist")
	public String join() {
		return "member/regist";
	}
	
	
	@GetMapping("/{userid}")
	@ResponseBody
	public String idCheck(@PathVariable("userid") String userId) throws Exception {
		logger.debug("idCheck userid : {}", userId);
		int cnt = memberService.idCheck(userId);
		return cnt + "";
	}
	
	
	@PostMapping("/regist")
	public String join(MemberDto memberDto, Model model) {
		logger.debug("memberDto info : {}", memberDto);
		try {
			memberService.registMember(memberDto);
			return "redirect:/member/login";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "회원 가입 중 문제 발생!!!");
			return "error/error";
		}
	}

	
	@GetMapping("/login")
	public String login() {
		return "member/login";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam Map<String, String> map, @RequestParam(name = "saveid", required = false) String saveid, Model model, HttpSession session, HttpServletResponse response) {
		logger.debug("login map : {}", map);
		
		try {
			MemberDto memberDto = memberService.loginMember(map);
			if(memberDto != null) {
				session.setAttribute("userinfo", memberDto);

				Cookie cookie = new Cookie("enjoytrip_id", map.get("userId"));
				cookie.setPath("/attraction"); //여기 나중에 수정
				if("ok".equals(saveid)) {
					cookie.setMaxAge(60*60*24*365*40);
				} else {
					cookie.setMaxAge(0);
				}
				response.addCookie(cookie);
				return "redirect:/";
			} else {
				model.addAttribute("msg", "아이디 또는 비밀번호 확인 후 다시 로그인하세요!");
				return "member/login";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "로그인 중 문제 발생!!!");
			return "error/error";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("/member-info")
	public String memberInfo() {
		return "member/member-info";
	}
	
	@GetMapping("/update")
	public String memberupdate(HttpSession session, Model model) throws Exception {
		MemberDto memberDto = (MemberDto) session.getAttribute("userinfo");
		model.addAttribute("memberinfo",memberService.getMemberInfo(memberDto.getUserId()));
		return "member/memberupdate";
	}
	
	@PostMapping("/update")
	public String memberupdateaf(@RequestParam Map<String, String> map, Model model, HttpServletRequest rq) throws Exception {
		logger.info("Welcome userupdateaf! The client map is {}.",map);
		memberService.memberUpdate(map);
		HttpSession session = rq.getSession();
		session.setAttribute("userinfo", memberService.loginMember(map));
		model.addAttribute("memberinfo", memberService.getMemberInfo(map.get("userId")));
		return "member/memberupdate";
	}
	
	@GetMapping("/delete")
	public String memberdelete(HttpSession session, Model model) throws Exception {
		logger.info("Welcome memberdelete!");
		MemberDto memberDto = (MemberDto) session.getAttribute("userinfo");
		memberService.memberDelete(memberDto.getUserId());
		session.invalidate();
		//나중에 게시판 구현시, 유저가 작성한 게시글 삭제 -> 탈퇴 해야함
		return "redirect:/";
	}
	
	@GetMapping("/list")
	public String list() {
		return "redirect:/resources/assets/list.html";
	}


	
}
