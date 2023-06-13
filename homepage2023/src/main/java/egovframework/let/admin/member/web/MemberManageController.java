package egovframework.let.admin.member.web;

import egovframework.com.cmm.EgovMessageSource;
import egovframework.let.join.service.JoinService;
import egovframework.let.member.service.MemberService;
import egovframework.let.member.service.MemberVO;
import egovframework.let.utl.fcc.service.EgovStringUtil;
import egovframework.rte.psl.dataaccess.util.EgovMap;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import net.sf.json.JSONObject;

import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MemberManageController {

	@Resource(name = "memberService")
    private MemberService memberService;
	
	@Resource(name = "egovMessageSource")
	EgovMessageSource egovMessageSource;
	
	
	//회원목록
	@RequestMapping(value = "/admin/member/memberList.do")
	public String memberList(@ModelAttribute("searchVO") MemberVO vo,  HttpServletRequest request, ModelMap model, HttpSession session) throws Exception{
		PaginationInfo paginationInfo = new PaginationInfo();

		paginationInfo.setCurrentPageNo(vo.getPageIndex());
		paginationInfo.setRecordCountPerPage(vo.getPageUnit());
		paginationInfo.setPageSize(vo.getPageSize());

		vo.setFirstIndex(paginationInfo.getFirstRecordIndex());
		vo.setLastIndex(paginationInfo.getLastRecordIndex());
		vo.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		
		List<EgovMap> resultList = memberService.selectMberList(vo);
		model.addAttribute("resultList", resultList);
		
		int totCnt = memberService.selectMberListCnt(vo);
		
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);
		
		
		return "/admin/member/MemberList";
	}
		
	//회원상세
	@RequestMapping(value = "/admin/member/memberRegist.do")
	public String memberRegist(@ModelAttribute("searchVO") MemberVO vo,  HttpServletRequest request, ModelMap model) throws Exception{
		
		
		return "/admin/member/MemberRegist";
	}
	
}