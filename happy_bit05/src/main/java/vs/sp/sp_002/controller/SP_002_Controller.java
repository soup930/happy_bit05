package vs.sp.sp_002.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;


@Controller
public interface SP_002_Controller {

	public ModelAndView SP_002(HttpServletRequest request, HttpServletResponse response) throws Exception;

	ModelAndView SP_002_4(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	}
