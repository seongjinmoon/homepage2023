package egovframework.let.hwp.web;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


import kr.dogfoot.hwplib.object.HWPFile;
import kr.dogfoot.hwplib.object.bodytext.Section;
import kr.dogfoot.hwplib.object.bodytext.paragraph.Paragraph;
import kr.dogfoot.hwplib.tool.blankfilemaker.BlankFileMaker;
import kr.dogfoot.hwplib.writer.HWPWriter;


@Controller
public class HwpController {

	
	//한글변환
	@RequestMapping("/hwp/hwp.do")
	public void hwp(HttpServletRequest request, ModelMap model) throws Exception{
		HWPFile hwpFile = BlankFileMaker.make( );

		Section s = hwpFile.getBodyText( ).getSectionList( ).get( 0 );
		Paragraph firstParagraph = s.getParagraph( 0 );
		firstParagraph.getText( ).addString( "난 문성진이라고해" );
		HWPWriter.toFile(hwpFile, "C:\\Users\\SJ\\Desktop\\1.hwp" );
		
	}
	
}