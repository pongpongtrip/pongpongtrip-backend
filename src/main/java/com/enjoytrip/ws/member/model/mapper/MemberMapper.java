package com.enjoytrip.ws.member.model.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.enjoytrip.ws.member.model.MemberDto;

@Mapper
public interface MemberMapper {

	int idCheck(String userId) throws SQLException;
	int isMemberDelflag(String userId);
	boolean registMember(MemberDto memberDto) throws SQLException;
	boolean registMemberDelflag(MemberDto memberDto);
	void joinMember(MemberDto memberDto) throws SQLException;
	MemberDto loginMember(MemberDto dto) throws SQLException;
	void memberUpdate(MemberDto memberDto) throws SQLException;
	void memberDelete(String userId) throws SQLException;
		
	//안쓴것들
	MemberDto loginMember(Map<String, String> map) throws SQLException;
	MemberDto getMemberInfo(String userId) throws SQLException;
	
	//Admin
	List<MemberDto> listMember(Map<String, Object> map) throws SQLException;
	MemberDto getMember(String userId) throws SQLException;
	boolean updateMemberAdmin(MemberDto memberDto) throws SQLException;
	boolean deleteMemberAdmin(String userId) throws SQLException;
	
	void saveRefreshToken(Map<String, String> map)throws SQLException;
	void deleteRefreshToken(Map<String, String> map)throws SQLException;
	Object getRefreshToken(String userId) throws SQLException;
	public MemberDto userInfo(String userid) throws SQLException;
	int checkPassword(MemberDto memberDto) throws SQLException;
	
}
