package com.enjoytrip.ws.member.model.service;

import java.util.List;
import java.util.Map;

import com.enjoytrip.ws.member.model.MemberDto;


public interface MemberService {
	
	int idCheck(String userId) throws Exception;
	int isMemberDelflag(String userId) throws Exception;
	boolean registMember(MemberDto memberDto) throws Exception;
	boolean registMemberDelflag(MemberDto memberDto) throws Exception;
	void memberUpdate(MemberDto memberDto) throws Exception;
	void memberDelete(String userId) throws Exception;
	
	//수정하면서 안쓴것들
	MemberDto getMemberInfo(String userId) throws Exception;
	
	//Admin
	List<MemberDto> listMember(Map<String, Object> map) throws Exception;
	List<MemberDto> listMemberById(String userId) throws Exception;
	List<MemberDto> listMemberByName(String userName)throws Exception;
	MemberDto getMember(String userId) throws Exception;
	void updateMemberAdmin(MemberDto memberDto) throws Exception;
	void deleteMemberAdmin(String userId) throws Exception;
	
	//JWT
	public MemberDto loginMember(MemberDto memberDto) throws Exception;
	void saveRefreshToken(String userId, String refreshToken)throws Exception;
	void deleRefreshToken(String userid) throws Exception;
	Object getRefreshToken(String userId) throws Exception;
	MemberDto userInfo(String userid) throws Exception;

	int checkPassword(MemberDto memberDto)throws Exception;
	
	
}
