package egovframework.let.login.service.impl;


import egovframework.com.cmm.LoginVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("loginMapper")
public interface LoginMapper {
	
	//일반 로그인을 처리한다
	public LoginVO actionLogin(LoginVO vo) throws Exception;

	//아이디를 찾는다.
	public LoginVO searchId(LoginVO vo) throws Exception;

	//비밀번호를 찾는다.
	public LoginVO searchPassword(LoginVO vo) throws Exception;

	//변경된 비밀번호를 저장한다.
	public void updatePassword(LoginVO vo) throws Exception;
	
		
}
