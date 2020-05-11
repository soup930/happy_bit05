package vs.mp.mp_001.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import vs.lo.lo_001.vo.LO_001_VO;
import vs.mp.mp_001.dao.MP_001_Dao;
import vs.mp.mp_001.dto.Page_DTO;
import vs.mp.mp_001.vo.MP_001_3_VO;
import vs.mp.mp_001.vo.PageUtil;
import vs.ms.ms_001.vo.MS_001_VO;

@Service
@Log4j
public class MP_001_ServiceImpl implements MP_001_Service{
	
	@Autowired
	private MP_001_Dao dao;
	private PageUtil pageutil;

	@Override
	public MP_001_3_VO getMC(String lc_index) {
		return dao.getMC(lc_index);
	}
	
	@Override
	public List<MP_001_3_VO> getMCList(Page_DTO dto) {
		// TODO Auto-generated method stub
		log.info("my코스 리스트 조회.......! " +dto);
		List<MP_001_3_VO> list = dao.getMCList(dto);
		return list;
	}
	
	/*
	 * @Override public List<MP_001_3_VO> getMyCourse(Page_DTO dto) { // TODO
	 * Auto-generated method stub log.info("my코스  상세조회.......!"); log.info(dto);
	 * List<MP_001_3_VO> list = dao.getMyCourse(dto); return list; }
	 */

	@Override
	public PageUtil paging(Page_DTO dto) {
		pageutil = dao.GetTotal(dto);
		return pageutil;
	}
	
	@Override
	public int memberUpdate(MS_001_VO vo) {
		// TODO Auto-generated method stub
		return dao.memberUpdate(vo);
	}

	@Override
	public void updateThumbnail(Map<String, Object> hmap) {
		// TODO Auto-generated method stub
		dao.updateThumbnail(hmap);
		
	}

	@Override
	public LO_001_VO getMemberList(LO_001_VO list) {
		// TODO Auto-generated method stub
		dao.getMemberList(list);
		return list;
	}

	@Override
	public List<Map<String, String>> getMyCourseDetail(Page_DTO dto) {
		// TODO Auto-generated method stub
		log.info("my코스  detail.......!");
		return  dao.getMyCourseDetail(dto);
	}
	

	
	
}
