package vs.mp.mp_001.vo;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import lombok.Data;

@Component
@Data
public class MP_001_3_VO {
	
	private String lc_index;	//게시글 번호
	private String m_index;		//멤버 번호
	private String lc_title;	//게시글 제목
	private String lc_type;		//코스 유형
	private String lc_distance;	//거리
	private String lc_run;		//도보 시간
	private String lc_cycle;	//자전거 시간
	private String lc_area1;	//지역1 (시)
	private String lc_area2;	//지역2 (구)
	private String lc_area3;	//지역3 (동)
	private MultipartFile lc_thumbnail;	//썸네일 (업로드)
	private String lc_text;		//내용
	private String lc_date;		//작성날짜
	private int lc_good;		//좋아요
	private int lc_see;			//조회수
	private String lc_record;	//평균 기록
	private String rn;			//lowNum
	private String mp_index;	//MyCourse index
	
	//지도정보
	private String lc_address;	//출발지 상세
	private String lc_xy_arr;	//좌표
	
}
