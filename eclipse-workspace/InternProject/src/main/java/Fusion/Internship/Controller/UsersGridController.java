package Fusion.Internship.Controller;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import Fusion.Internship.Model.User;
import Fusion.Internship.Service.HomeService;

@Controller
public class UsersGridController {
	
	@Autowired
	HomeService service;
		
		@RequestMapping(value = { "/GridUsers" })
		public ModelAndView gridUsers(HttpSession session) throws SQLException {
		
			ModelAndView model = new ModelAndView();
			
			
			if(Boolean.valueOf(session.getAttribute("adminStatus").toString())) {
				
				model.setViewName("GridUsers");
				return model;
			}
			
			model.setViewName("LoggedIn");

			return model;
		}
		
		@RequestMapping(value = "/UsersGridController/usersList", method = RequestMethod.GET)
		@ResponseBody
		public List<User> usersArrayList() throws SQLException {
			List<User> usersList = new ArrayList<>();
			usersList = service.getAllUsers();
			return usersList;
			
		}
		
		@RequestMapping(value = "/UsersGridController/deleteUser", method = RequestMethod.POST)
		@ResponseBody
		public String deleterow(@RequestParam(name = "id") int id) throws SQLException {
			
				service.deleteUser(id);
				return "Sucessfully deleted user with id: " + id;
			
			
			
		}
		

	}