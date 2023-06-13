package egovframework.let.member.service;

import java.util.List;

import egovframework.rte.psl.dataaccess.util.EgovMap;

public interface MemberService {
	
	//회원목록
	public List<EgovMap> selectMberList(MemberVO vo) throws Exception;
	
	//회원목록 수
	public int selectMberListCnt(MemberVO vo) throws Exception;
}