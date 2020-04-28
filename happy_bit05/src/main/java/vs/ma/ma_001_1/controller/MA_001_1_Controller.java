package vs.ma.ma_001_1.controller;

import java.util.Base64;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import vs.ma.ma_001_1.service.MA_001_1_Service;
import vs.ma.ma_001_1.vo.MA_001_1_VO;

@Controller
@Log4j
@AllArgsConstructor
@RequestMapping("ma/001/*")
public class MA_001_1_Controller {

	private MA_001_1_Service service;
	
	 @RequestMapping(value="main")
	 public String mainList(@RequestParam("lc_area2") String lc_area2, @RequestParam("lc_area3") String lc_area3, Model model) {
		 
		 List<MA_001_1_VO> listVO = service.mainList(lc_area2, lc_area3); 
		 
		//리스트 썸네일 인코딩, 디코딩 작업.
			for(int i = 0; i < listVO.size(); i++) {
				
				MA_001_1_VO vo = listVO.get(i);
				
				if(vo.getLc_thumbnail() != null) {
					
					byte[] imageContent = Base64.getEncoder().encode(vo.getLc_thumbnail());
					
					//System.out.println("대체 뭐야........" + imageContent);
					String thumbnail = new String(imageContent);
					
					//System.out.println(thumbnail);
				
					vo.setLc_request(thumbnail);
				// model.addAttribute("thumbnail"+i, thumbnail);
				}else {
					vo.setLc_request("");
				}
			}
			
		 model.addAttribute("list", listVO);
		 
		 return "MA/MA_001";
	 }
}