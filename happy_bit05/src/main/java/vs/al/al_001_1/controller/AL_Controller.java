package vs.al.al_001_1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import vs.al.al_001_1.service.AL_Service;
import vs.co.co_001_1.dto.Page_DTO;
import vs.co.co_001_1.service.Co_Service;
import vs.co.co_001_1.vo.PageUtil;
import vs.cr.cr_001_1.service.Cr_Service;
import vs.lc.lc_003_1.service.LC_003_1_Service;
import vs.li.li_001_1.service.LI_Service;
import vs.pr.pr_003_1.service.Pr_003_1_Service;
import vs.re.re_001_1.service.Re_001_1_Service;

@Controller
@RequestMapping("/al/*")
public class AL_Controller {

	@Autowired
	private Co_Service co_service;
	
	@Autowired
	private AL_Service al_service;

	
	
	//모든 게시글 조회
	@GetMapping(value="/al_001_1")
	public void al_List(Model model,Page_DTO dto) throws Exception {
		
		List al_list = al_service.al_list(dto);
		
		 model.addAttribute("al_list", al_list);
		 model.addAttribute("pageUtil",new PageUtil(dto,co_service.get_total(dto)));
		 model.addAttribute("type",dto.getTypeArr());
		 model.addAttribute("page", dto.getPage());
		System.out.println("page : " + dto.getPage());
		System.out.println("Amount : " + dto.getAmount());
		 
		 
	}
	//신고 게시글 조회
	@GetMapping("/al_002_1")
	public void re_list(Model model) throws Exception{
		
		System.out.println("신고게시글 ㅇㅇ");
		
		model.addAttribute("re_list", al_service.re_list());
		
	}
	
	//신고 상태 변경
	@PostMapping("/disposechange")
	@ResponseBody
	public int disposechange(@RequestParam("de_index") String de_index) {
		
		System.out.println(de_index);
		
		return al_service.disposechange(de_index);
	}
	
	
	
}












