package com.enjoytrip.ws.member.model.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enjoytrip.ws.member.model.MemberDto;
import com.enjoytrip.ws.member.model.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {
	
	private MemberMapper memberMapper;
	
	@Autowired
	public MemberServiceImpl(MemberMapper memberMapper) {
		super();
		this.memberMapper = memberMapper;
	}


	//여기부터 만듬 - sooyeon
	@Override
	public void registMember(MemberDto memberDto) throws Exception {
		memberMapper.registMember(memberDto);
	}
	
	@Override
	public MemberDto loginMember(Map<String, String> map) throws Exception {
		return memberMapper.loginMember(map);
	}



	@Override
	public MemberDto getMemberInfo(String userId) throws Exception {
		return memberMapper.getMemberInfo(userId);
	}


	@Override
	public void memberUpdate(Map<String, String> map) throws Exception {
		memberMapper.memberUpdate(map);
		
	}


	@Override
	public void memberDelete(String userId) throws Exception {
		memberMapper.memberDelete(userId);
		
	}
	
	
	//Admin
	/*
	 * @Override public List<MemberDto> memberList() throws SQLException { return
	 * memberMapper.listMember(); }
	 */


	@Override
	public List<MemberDto> listMember(Map<String, Object> map) throws Exception {
		return memberMapper.listMember(map);
	}



	@Override
	public MemberDto getMember(String userId) throws Exception {
		return memberMapper.getMember(userId);
	}



	@Override
	public void updateMemberAdmin(MemberDto memberDto) throws Exception {
		memberMapper.updateMemberAdmin(memberDto);
		
	}



	@Override
	public void deleteMemberAdmin(String userId) throws Exception {
		memberMapper.deleteMemberAdmin(userId);
		
	}
	//--여기까지


}
