package egovframework.let.member.service.impl;

import java.util.List;

import egovframework.let.member.service.MemberVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Mapper("memberMapper")
public interface MemberMapper {
	
	//회원목록
	List<EgovMap> selectMberList(MemberVO vo) throws Exception;
	
	//회원목록 수
	int selectMberListCnt(MemberVO vo) throws Exception;
	
		
}
