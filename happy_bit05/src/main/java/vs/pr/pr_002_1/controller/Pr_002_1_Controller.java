package vs.pr.pr_002_1.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import vs.co.co_001_1.dto.Page_DTO;
import vs.co.co_001_1.vo.PageUtil;
import vs.pr.pr_002_1.service.Pr_002_1_Service;
import vs.pr.pr_002_1.vo.Pr_002_1VO;

@Controller
@RequestMapping("/pr/*")
public class Pr_002_1_Controller {

	@Autowired
	private Pr_002_1_Service pr_service;
	
	//개인기록 리스트 테스트
	@GetMapping("/pr_002_1")
	public void pr_list(Model model,Page_DTO dto) {
		
		List<Pr_002_1VO> prvo = pr_service.pr_list(dto);
		model.addAttribute("data", pr_service.pr_list(dto));
		model.addAttribute("pageUtil",new PageUtil(dto,pr_service.get_total(dto)));
		model.addAttribute("type",dto.getTypeArr());
		model.addAttribute("page", dto.getPage());
		
	}
}
