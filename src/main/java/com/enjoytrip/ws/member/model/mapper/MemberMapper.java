package com.enjoytrip.ws.member.model.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.enjoytrip.ws.member.model.MemberDto;

@Mapper
public interface MemberMapper {

	int idCheck(String userId) throws SQLException;
	void joinMember(MemberDto memberDto) throws SQLException;
	MemberDto loginMember(MemberDto dto) throws SQLException;
	
	/* Admin */
	List<MemberDto> listMember() throws SQLException;
	MemberDto getMember(String userId) throws SQLException;
	boolean updateMember(MemberDto memberDto) throws SQLException;
	boolean deleteMember(String userId) throws SQLException;
	
	//여기부터 만듬 - sooyeon
	void registMember(MemberDto memberDto) throws SQLException;
	
}
