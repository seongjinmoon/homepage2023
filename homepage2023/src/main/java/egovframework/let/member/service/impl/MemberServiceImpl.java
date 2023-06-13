package egovframework.let.member.service.impl;

import egovframework.let.member.service.MemberService;
import egovframework.let.member.service.MemberVO;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.psl.dataaccess.util.EgovMap;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;


@Service("memberService")
public class MemberServiceImpl extends EgovAbstractServiceImpl implements MemberService {

    @Resource(name="memberMapper")
	private MemberMapper memberMapper;
    
    
	//회원목록
	public List<EgovMap> selectMberList(MemberVO vo) throws Exception{
		return memberMapper.selectMberList(vo);
	}
	
	//회원목록 수
	public int selectMberListCnt(MemberVO vo) throws Exception{
		return memberMapper.selectMberListCnt(vo);
	}

		
}
