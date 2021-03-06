package vs.cm.cm_001_1.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import vs.co.co_001_1.dto.Page_DTO;
import vs.pr.pr_002_1.vo.Pr_002_1VO;

@Repository
public interface PrMapper {

	public List<Pr_002_1VO> pr_list(Page_DTO dto);
	
	public int get_total(Page_DTO dto);
	
	public List<Pr_002_1VO> chart_list();
	
	//개인기록 상세보기
	public List<Pr_002_1VO> pr_detail(String pr_index);
	//개인기록 수정
	public int update(Pr_002_1VO vo);
	//개인기록 삭제
	public int pr_delete(String pr_index);
}
