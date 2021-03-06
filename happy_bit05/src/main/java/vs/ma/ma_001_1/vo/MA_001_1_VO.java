package vs.ma.ma_001_1.vo;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class MA_001_1_VO {
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
	private byte[] lc_thumbnail;	//썸네일
	private String lc_request; //썸네일 화면에 뿌려주는 용도.
	private String lc_text;		//내용
	private String lc_date;		//작성날짜
	private int lc_good;		//좋아요
	private int lc_see;			//조회수
	private String lc_record;	//평균 기록
	private String lc_xy_arr;   //좌표
	private int lc_type2;
}
