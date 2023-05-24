package com.enjoytrip.ws.member.model.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enjoytrip.ws.member.model.MemberDto;
import com.enjoytrip.ws.member.model.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {
	
//	private MemberMapper memberMapper;
//	@Autowired
//	public MemberServiceImpl(MemberMapper memberMapper) {
//		super();
//		this.memberMapper = memberMapper;
//	}
	
	@Autowired
	private SqlSession sqlSession;
	

	@Override
	public int isMemberDelflag(String userId) {
		return sqlSession.getMapper(MemberMapper.class).isMemberDelflag(userId);
	}

	
	@Override
	public boolean registMember(MemberDto memberDto) throws Exception {
		return sqlSession.getMapper(MemberMapper.class).registMember(memberDto);
	}
	
	@Override
	public boolean registMemberDelflag(MemberDto memberDto) throws Exception {
		return sqlSession.getMapper(MemberMapper.class).registMemberDelflag(memberDto);
	}
	
	@Override
	public MemberDto loginMember(MemberDto memberDto) throws Exception {
		if(memberDto.getUserId() == null || memberDto.getUserPassword() == null) {
			return null;
		}
		return sqlSession.getMapper(MemberMapper.class).loginMember(memberDto);
	}



	@Override
	public MemberDto getMemberInfo(String userId) throws Exception {
		return sqlSession.getMapper(MemberMapper.class).getMemberInfo(userId);
	}



	@Override
	public void memberDelete(String userId) throws Exception {
		sqlSession.getMapper(MemberMapper.class).memberDelete(userId);
		
	}
	
	@Override
	public int idCheck(String userId) throws Exception {
		return sqlSession.getMapper(MemberMapper.class).idCheck(userId);
	}
	
	
	//Admin

	@Override
	public List<MemberDto> listMember(Map<String, Object> map) throws Exception {
		return sqlSession.getMapper(MemberMapper.class).listMember(map);
	}
	
	@Override
	public List<MemberDto> listMemberById(String userId) throws Exception {
		return sqlSession.getMapper(MemberMapper.class).listMemberById(userId);
	}

	@Override
	public List<MemberDto> listMemberByName(String userName) throws Exception {
		return sqlSession.getMapper(MemberMapper.class).listMemberByName(userName);
	}


	@Override
	public MemberDto getMember(String userId) throws Exception {
		return sqlSession.getMapper(MemberMapper.class).getMember(userId);
	}


	@Override
	public void updateMemberAdmin(MemberDto memberDto) throws Exception {
		sqlSession.getMapper(MemberMapper.class).updateMemberAdmin(memberDto);
		
	}


	@Override
	public void deleteMemberAdmin(String userId) throws Exception {
		sqlSession.getMapper(MemberMapper.class).deleteMemberAdmin(userId);
		
	}
	//--Admin end

	@Override
	public void saveRefreshToken(String userId, String refreshToken) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("userid", userId);
		map.put("token", refreshToken);
		sqlSession.getMapper(MemberMapper.class).saveRefreshToken(map);
		
	}

	@Override
	public void deleRefreshToken(String userid) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("userid", userid);
		map.put("token", null);
		sqlSession.getMapper(MemberMapper.class).deleteRefreshToken(map);
		
	}

	@Override
	public Object getRefreshToken(String userId) throws Exception {
		return sqlSession.getMapper(MemberMapper.class).getRefreshToken(userId);
	}

	@Override
	public MemberDto userInfo(String userid) throws Exception {
		return sqlSession.getMapper(MemberMapper.class).userInfo(userid);
	}

	@Override
	public int checkPassword(MemberDto memberDto) throws Exception {
		return sqlSession.getMapper(MemberMapper.class).checkPassword(memberDto);
	}

	@Override
	public void memberUpdate(MemberDto memberDto) throws Exception {
		sqlSession.getMapper(MemberMapper.class).memberUpdate(memberDto);
		
	}







}
