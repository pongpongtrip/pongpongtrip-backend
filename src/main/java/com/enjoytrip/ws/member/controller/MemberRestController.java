package com.enjoytrip.ws.member.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.enjoytrip.ws.jwt.model.service.JwtService;
import com.enjoytrip.ws.member.model.MemberDto;
import com.enjoytrip.ws.member.model.service.MemberService;

import io.swagger.annotations.ApiParam;




@RestController
@CrossOrigin("*")
@RequestMapping("/member")
public class MemberRestController {
	
	private final Logger logger = LoggerFactory.getLogger(MemberRestController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	private MemberService memberService;
	private JwtService jwtService;

	@Autowired
	public MemberRestController(MemberService memberService,JwtService jwtService) {
		super();
		this.memberService = memberService;
		this.jwtService = jwtService;
	}


	@GetMapping("/{userid}")
	@ResponseBody
	public  ResponseEntity<String> idCheck(@PathVariable("userid") String userId) throws Exception {
		logger.debug("idCheck userid : {}", userId);
		int cnt = memberService.idCheck(userId);
		return new ResponseEntity<String>(cnt+"", HttpStatus.OK);
	}
	
	
	@PostMapping("/regist")
	public ResponseEntity<String> join(@RequestBody MemberDto memberDto)  {
		logger.debug("memberDto info : {}", memberDto);	
		try {
			if(memberService.registMember(memberDto)) {
				return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<String>(FAIL, HttpStatus.OK);
		}
		
		return new ResponseEntity<String>("test", HttpStatus.OK);
	}


	@PostMapping("/login")
	public ResponseEntity<Map<String, Object>> login(
			@RequestBody @ApiParam(value = "로그인 시 필요한 회원정보(아이디, 비밀번호).", required = true) MemberDto memberDto) {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;
		try {
			MemberDto loginUser = memberService.loginMember(memberDto);
			if (loginUser != null) {
				String accessToken = jwtService.createAccessToken("userid", loginUser.getUserId());// key, data
				String refreshToken = jwtService.createRefreshToken("userid", loginUser.getUserId());// key, data
				memberService.saveRefreshToken(memberDto.getUserId(), refreshToken);
				logger.debug("로그인 accessToken 정보 : {}", accessToken);
				logger.debug("로그인 refreshToken 정보 : {}", refreshToken);
				resultMap.put("access-token", accessToken);
				resultMap.put("refresh-token", refreshToken);
				resultMap.put("message", SUCCESS);
				status = HttpStatus.ACCEPTED;
			} else {
				resultMap.put("message", FAIL);
				status = HttpStatus.ACCEPTED;
			}
		} catch (Exception e) {
			logger.error("로그인 실패 : {}", e);
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
	
	@GetMapping("/info/{userid}")
	public ResponseEntity<Map<String, Object>> getInfo(
			@PathVariable("userid") @ApiParam(value = "인증할 회원의 아이디.", required = true) String userid,
			HttpServletRequest request) {
//		logger.debug("userid : {} ", userid);
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.UNAUTHORIZED;
		if (jwtService.checkToken(request.getHeader("access-token"))) {
			logger.info("사용 가능한 토큰!!!");
			try {
//				로그인 사용자 정보.
				MemberDto memberDto = memberService.userInfo(userid);
				resultMap.put("userInfo", memberDto);
				resultMap.put("message", SUCCESS);
				status = HttpStatus.ACCEPTED;
			} catch (Exception e) {
				logger.error("정보조회 실패 : {}", e);
				resultMap.put("message", e.getMessage());
				status = HttpStatus.INTERNAL_SERVER_ERROR;
			}
		} else {
			logger.error("사용 불가능 토큰!!!");
			resultMap.put("message", FAIL);
			status = HttpStatus.UNAUTHORIZED;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
	
	@GetMapping("/logout/{userid}")
	public ResponseEntity<?> removeToken(@PathVariable("userid") String userid) {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;
		try {
			memberService.deleRefreshToken(userid);
			resultMap.put("message", SUCCESS);
			status = HttpStatus.ACCEPTED;
		} catch (Exception e) {
			logger.error("로그아웃 실패 : {}", e);
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);

	}
	
	@PostMapping("/refresh")
	public ResponseEntity<?> refreshToken(@RequestBody MemberDto memberDto, HttpServletRequest request)
			throws Exception {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;
		String token = request.getHeader("refresh-token");
		logger.debug("token : {}, memberDto : {}", token, memberDto);
		if (jwtService.checkToken(token)) {
			if (token.equals(memberService.getRefreshToken(memberDto.getUserId()))) {
				String accessToken = jwtService.createAccessToken("userid", memberDto.getUserId());
				logger.debug("token : {}", accessToken);
				logger.debug("정상적으로 액세스토큰 재발급!!!");
				resultMap.put("access-token", accessToken);
				resultMap.put("message", SUCCESS);
				status = HttpStatus.ACCEPTED;
			}
		} else {
			logger.debug("리프레쉬토큰도 사용불!!!!!!!");
			status = HttpStatus.UNAUTHORIZED;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
	
//	@GetMapping("/logout")
//	public String logout(HttpSession session) {
//		session.invalidate();
//		return "redirect:/";
//	}
//	
//	@GetMapping("/member-info")
//	public String memberInfo() {
//		return "member/member-info";
//	}
//	
//	@GetMapping("/update")
//	public String memberupdate(HttpSession session, Model model) throws Exception {
//		MemberDto memberDto = (MemberDto) session.getAttribute("userinfo");
//		model.addAttribute("memberinfo",memberService.getMemberInfo(memberDto.getUserId()));
//		return "member/memberupdate";
//	}
//	
//	@PostMapping("/update")
//	public String memberupdateaf(@RequestParam Map<String, String> map, Model model, HttpServletRequest rq) throws Exception {
//		logger.info("Welcome userupdateaf! The client map is {}.",map);
//		memberService.memberUpdate(map);
//		HttpSession session = rq.getSession();
//		session.setAttribute("userinfo", memberService.loginMember(map));
//		model.addAttribute("memberinfo", memberService.getMemberInfo(map.get("userId")));
//		return "member/memberupdate";
//	}
//	
//	@GetMapping("/delete")
//	public String memberdelete(HttpSession session, Model model) throws Exception {
//		logger.info("Welcome memberdelete!");
//		MemberDto memberDto = (MemberDto) session.getAttribute("userinfo");
//		memberService.memberDelete(memberDto.getUserId());
//		session.invalidate();
//		//나중에 게시판 구현시, 유저가 작성한 게시글 삭제 -> 탈퇴 해야함
//		return "redirect:/";
//	}
//	
//	@GetMapping("/list")
//	public String list() {
//		return "redirect:/resources/assets/list.html";
//	}


	
}
