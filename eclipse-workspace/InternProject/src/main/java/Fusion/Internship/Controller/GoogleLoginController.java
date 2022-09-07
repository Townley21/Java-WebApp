package Fusion.Internship.Controller;

import java.security.Principal;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import Fusion.Internship.DAO.BasicDAO;
import Fusion.Internship.Model.User;
import Fusion.Internship.Service.HomeService;

@Controller
public class GoogleLoginController {
	
	@Autowired
	HomeService service;
	
	@GetMapping(value = { "/googlelogin"})
	public ModelAndView googlelogin(HttpServletRequest request, ModelAndView mv) throws SQLException {
		
		OAuth2AuthenticationToken tokens = (OAuth2AuthenticationToken)request.getUserPrincipal();
		String userEmail = tokens.getPrincipal().getAttributes().get("email").toString();
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		
		if(service.getUser(userEmail) != null) {
			mv.addObject("back", " back");
			return mv;
		}
		
		User user = new User(0, null, null, null , false, 0, null, null, null);
		
		user.setEmail(userEmail);
		user.setLastLogin(timestamp);
		user.setPassword("GOOGLE_ACCOUNT");
		service.createUser(user);
		
		return mv;
		
	}
		
	
}
