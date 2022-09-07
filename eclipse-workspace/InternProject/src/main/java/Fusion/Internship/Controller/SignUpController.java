package Fusion.Internship.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(value = { "/SignUp" })
public class SignUpController {
	
	
	@GetMapping
	public ModelAndView homeView()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("SignUp");
		return mv;
	}

}