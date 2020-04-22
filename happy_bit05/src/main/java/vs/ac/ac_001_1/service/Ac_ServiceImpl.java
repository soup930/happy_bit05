package vs.ac.ac_001_1.service;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vs.ac.ac_001_1.vo.AcVO;
import vs.co.co_001_1.dto.Page_DTO;

@Service
public class Ac_ServiceImpl implements Ac_Service {

	
	@Autowired
	private SqlSession sqlSession;

	public List<AcVO> ac_List(Page_DTO dto) {
		List<AcVO> list;
		
		
		try {
 
			list = sqlSession.selectList("ac.ac_list",dto);

			return list;

		} catch (Exception e) {
			System.out.println("ac_List ���� " + e);
			return null;
		}

	}
	@Override
	public void ac_insert(AcVO acvo) {
		
		sqlSession.insert("ac.ac_insert" , acvo);
		
	}
	
}