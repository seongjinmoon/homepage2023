package egovframework.let.file.web;

import java.util.List;
import java.util.Map;

import egovframework.com.cmm.service.EgovFileMngService;
import egovframework.com.cmm.service.FileVO;
import egovframework.com.cmm.util.EgovUserDetailsHelper;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FileMngController {

    @Resource(name = "EgovFileMngService")
    private EgovFileMngService fileService;

    //첨부파일 목록 조회
    @RequestMapping("/file/selectFileList.do")
    public String selectFileList(@ModelAttribute("searchVO") FileVO fileVO, @RequestParam Map<String, Object> commandMap, ModelMap model) throws Exception {
		String atchFileId = (String)commandMap.get("param_atchFileId");
	
		fileVO.setAtchFileId(atchFileId);
		List<FileVO> result = fileService.selectFileInfs(fileVO);
	
		model.addAttribute("fileList", result);
		model.addAttribute("updateFlag", "N");
		model.addAttribute("fileListCnt", result.size());
		model.addAttribute("atchFileId", atchFileId);
	
		return "file/FileList";
    }
    
    //첨부파일 변경을 위한 수정페이지
    @RequestMapping("/file/updateFile.do")
    public String updateFile(@ModelAttribute("searchVO") FileVO fileVO, @RequestParam Map<String, Object> commandMap, ModelMap model) throws Exception {

		String atchFileId = (String)commandMap.get("param_atchFileId");
	
		fileVO.setAtchFileId(atchFileId);
		List<FileVO> result = fileService.selectFileInfs(fileVO);
	
		model.addAttribute("fileList", result);
		model.addAttribute("updateFlag", "Y");
		model.addAttribute("fileListCnt", result.size());
		model.addAttribute("atchFileId", atchFileId);
	
		return "file/FileList";
    }
    
    //첨부파일 삭제
    @RequestMapping("/file/deleteFile.do")
    public String deleteFileInf(@ModelAttribute("searchVO") FileVO fileVO, @RequestParam("returnUrl") String returnUrl, HttpServletRequest request, ModelMap model) throws Exception {
		fileService.deleteFileInf(fileVO);
		return "forward:" + returnUrl;
    }

}
