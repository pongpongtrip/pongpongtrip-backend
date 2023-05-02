package com.enjoytrip.ws.member.model.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.enjoytrip.ws.member.model.MemberDto;


public interface MemberService {
	void registry(MemberDto dto) throws SQLException;
	MemberDto login(MemberDto dto) throws SQLException;
	MemberDto info(String id) throws SQLException;
	List<MemberDto> memberList() throws SQLException;
	boolean deleteMember(String id) throws SQLException;
	boolean updateMember(MemberDto dto)throws SQLException;
}
