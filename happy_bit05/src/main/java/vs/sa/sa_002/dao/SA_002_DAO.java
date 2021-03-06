package vs.sa.sa_002.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import vs.sa.sa_002.dto.Page_DTO;
import vs.sa.sa_002.vo.PageUtil;

@Service
@Repository
public interface SA_002_DAO {
	
	List<Map<String, String>> SaProductsList(Page_DTO dto);
	List<Map<String, String>> searchProducts(Page_DTO dto);
	PageUtil SaGetTotal(Page_DTO dto);
	
	
}
