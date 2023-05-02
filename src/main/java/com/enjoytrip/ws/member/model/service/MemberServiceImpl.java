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

//	private static  IMemberService mservice=new MemberServiceImpl();
	
	private MemberMapper memberMapper;
	
	@Autowired
	public MemberServiceImpl(MemberMapper memberMapper) {
		super();
		this.memberMapper = memberMapper;
	}
//	public static IMemberService getInstance() {
//		return mservice;
//	}
	

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

}
