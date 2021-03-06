package vs.mb.mb_001_1.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import vs.lc.lc_003_1.vo.LC_003_1_VO;
import vs.lo.lo_001.vo.LO_001_VO;
import vs.mb.mb_001_1.vo.PR_VO;
import vs.pr.pr_002_1.vo.Pr_002_1VO;
import vs.pr.pr_002_1.vo.Upload_pr_vo;

@Component
@AllArgsConstructor
@Log4j
public class MB_daoImpl implements MB_dao{

	private SqlSession session;
	
	@Override
	public LC_003_1_VO getLC(String lc_index) {
		// TODO Auto-generated method stub
		System.out.println("DAO에서 번호는??? : " + lc_index);
		return session.selectOne("lc.lc_003_01", lc_index);
	}
	
	@Override
	public List<LC_003_1_VO> getCourseList() {
		System.out.println("다오");
		return session.selectList("mb.getlist");
	}
	
	
	@Override
	public Boolean login(LO_001_VO vo) {
		int count = 0;
		try {
			count = session.selectOne("mb.login",vo);
			
			//로그인 정보 체크
			if(count == 0) {
				log.info("로그인 실패");
				return false;
			}else if(count == 1) {
				log.info("로그인 성공");
				return true;	
			}else {
				log.info("회원정보 error");
				return false;
			}
			
		} catch (Exception e) {
			//에러
			log.info("아이디 못찾음");
			return false;
		}
		
		
	}
	
	@Override
	public List<Map<String, String>> getMyRecordList(String m_index) {
		return session.selectList("mb.getMyRecordList", m_index);
	}
	
	@Override
	public List<Map<String, String>> getMyRecordListSort(Map<String, String> map) {
		log.info("getMyRecordListSorting : "+map);
			return session.selectList("mb.getMyRecordListSort", map);
	}

	@Override
	public void regist(PR_VO pr_vo) {
		// TODO Auto-generated method stub
		System.out.println("dao 단에서 pr_vo" + pr_vo);
		session.insert("mb.regist", pr_vo);
	}
	
	//업로드페이지에 코스정보 불러오기
	@Override
	public Pr_002_1VO upload(String pr_index) {
		// TODO Auto-generated method stub
		return session.selectOne("mb.course_info",pr_index);
	}
	
	@Override
	public void update1(Upload_pr_vo pr_vo) {
		// TODO Auto-generated method stub
		session.update("mb.update1",pr_vo);
	}
	
	@Override
	public void update2(Map<String, Object> hmap) {
		// TODO Auto-generated method stub
		session.update("mb.update2",hmap);
	}
	
	@Override
	public List<Pr_002_1VO> pr_list() {
		// TODO Auto-generated method stub
		return session.selectList("mb.pr_list");
	}

	@Override
	public List<Map<String, String>> getMCListAppSort(Map<String, String> map) {
		log.info("getMCListAppSorting : "+map);
		return session.selectList("mb.getMCListAppSort", map);
	}

}
