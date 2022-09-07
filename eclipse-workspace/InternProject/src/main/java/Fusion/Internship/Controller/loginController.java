package Fusion.Internship.Controller;

import java.sql.SQLException;
import java.sql.Timestamp;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import Fusion.Internship.DAO.BasicDAO;
import Fusion.Internship.Model.User;
import Fusion.Internship.Service.HomeService;

@Controller
@RequestMapping(value = "/loggedin", method = RequestMethod.POST)
public class loginController {
	
	@Autowired
	HomeService service;
	
	@GetMapping
	public ModelAndView loggedin(@RequestParam(name = "email") String email, @RequestParam(name = "password") String password, HttpSession session) throws SQLException {
		
		ModelAndView mv = new ModelAndView();
		boolean auth = false;
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		User loginUser = service.getUser(email);
		
		if(loginUser != null && loginUser.getPassword().equals(password)) {
			auth = true;
		}
		
		
		
		if(auth) {
			
			mv.setViewName("LoggedIn");
			mv.addObject("adminStatus", loginUser.getAdminStatus());
			
			if(loginUser.getLastLogin() != null) {
				mv.addObject("back", "back");
			}
			
			loginUser.setLastLogin(timestamp);
			session.setAttribute("adminStatus", loginUser.getAdminStatus());
			session.setAttribute("email", email);
			session.setAttribute("loggedin", true);
			mv.addObject("user", session.getAttribute("email"));
			System.out.println(session.getAttribute("adminStatus"));
			
		} else {
			
			mv.setViewName("Home");
			mv.addObject("error", "Invalid Username or Password");
		}
		
		
		
		
		return mv;
		
	}

}
