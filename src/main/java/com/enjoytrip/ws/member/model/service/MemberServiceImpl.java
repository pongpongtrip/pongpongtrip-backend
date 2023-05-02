package com.enjoytrip.ws.member.model.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

	

	@Override
	public void registry(MemberDto dto) throws SQLException {
		memberMapper.joinMember(dto);
	}

	@Override
	public MemberDto login(MemberDto dto) throws SQLException {
		return memberMapper.loginMember(dto);
	}
	
	@Override
	public MemberDto info(String id) {
		// return memberMapper.info(id);
		return null;
	}
	@Override
	public List<MemberDto> memberList() throws SQLException {
		return memberMapper.listMember();
	}
	@Override
	public boolean deleteMember(String id) throws SQLException {
		return memberMapper.deleteMember(id);
	}
	@Override
	public boolean updateMember(MemberDto dto) throws SQLException {
		return memberMapper.updateMember(dto);
	}


	//여기부터 만듬 - sooyeon
	@Override
	public void registMember(MemberDto memberDto) throws Exception {
		memberMapper.registMember(memberDto);
	}

}
