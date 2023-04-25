package egovframework.let.temp3.service.impl;


import egovframework.let.temp3.service.Temp3Service;
import egovframework.let.temp3.service.Temp3VO;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.psl.dataaccess.util.EgovMap;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;


@Service("temp3Service")
public class Temp3ServiceImpl extends EgovAbstractServiceImpl implements Temp3Service {

    @Resource(name = "propertiesService")
    protected EgovPropertyService propertyService;
    
    @Resource(name="temp3Mapper")
	private Temp3Mapper temp3Mapper;
    
    @Resource(name = "egovTempIdGnrService")
    private EgovIdGnrService idgenService;
    
    
    //임시데이터 목록 가져오기
  	public List<EgovMap> selectTempList(Temp3VO vo) throws Exception {
  		return temp3Mapper.selectTempList(vo);
  	}
  	
  	//임시데이터 목록 수
  	public int selectTempListCnt(Temp3VO vo) throws Exception {
  		return temp3Mapper.selectTempListCnt(vo);
  	}
  	
    public Temp3VO selectTemp(Temp3VO vo) throws Exception {
		return temp3Mapper.selectTemp(vo);
	}
	
	public String insertTemp(Temp3VO vo) throws Exception {
		String id = idgenService.getNextStringId();
		vo.setTempId(id);
		temp3Mapper.insertTemp(vo);
		
		return id;
	}
	
	//임시데이터 수정하기
	public void updateTemp(Temp3VO vo) throws Exception{
		temp3Mapper.updateTemp(vo);
	}
	
	//임시데이터 삭제하기
	public void deleteTemp(Temp3VO vo) throws Exception{
		temp3Mapper.deleteTemp(vo);
	}
	
}
