package vs.ms.ms_001.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import vs.ms.ms_001.vo.MS_001_VO;



@Service
@Repository
@Mapper
@Component
public class MS_001_DAOImpl implements MS_001_DAO{
	

	@Autowired
	private SqlSession sqlSession;
	private MS_001_VO ms_001_vo;
	
	@Override
	public MS_001_VO memberVO(MS_001_VO list) {
		System.out.println("ms dao "+ list);
		sqlSession.insert("member.get_member", list);
		
		System.out.println("dao : memberList");
		return list;
	}
	


}