package vs.lc.lc_002_1.vo;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
@Component
public class Criteria {
	
	private int pageNum;
	private int amount;
	
	private String lc_type;

	private String type;
	private String keyword;
	
	public Criteria() {
		this(1,12);
	}
	
	public Criteria(int pageNum, int amount) {
		super();
		this.pageNum = pageNum;
		this.amount = amount;
	}
	
	public String[] getTypeArr() {
		return type == null? new String[] {} : type.split(",");
	}


}
