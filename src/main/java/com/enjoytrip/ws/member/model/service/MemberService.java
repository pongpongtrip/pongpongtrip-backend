package com.enjoytrip.ws.member.model.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.enjoytrip.ws.member.model.MemberDto;


public interface MemberService {
	
	//여기부터 만듬 - sooyeon
	void registMember(MemberDto memberDto) throws Exception;
	MemberDto loginMember(Map<String, String> map) throws Exception;
	MemberDto getMemberInfo(String userId) throws Exception;
	void memberUpdate(Map<String, String> map) throws Exception;
	void memberDelete(String userId) throws Exception;
	
	//Admin
//	List<MemberDto> memberList() throws SQLException;
	
	//하이쌤코드
	List<MemberDto> listMember(Map<String, Object> map) throws Exception;
	MemberDto getMember(String userId) throws Exception;
	void updateMemberAdmin(MemberDto memberDto) throws Exception;
	void deleteMemberAdmin(String userId) throws Exception;
}
