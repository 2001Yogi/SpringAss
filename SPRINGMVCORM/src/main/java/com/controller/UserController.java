package com.controller;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dao.UserDao;
import com.model.User;

@Controller
public class UserController {
	@Autowired
	private UserDao dao;
	
	@RequestMapping("/")
	public String indexPage() {
		return "index";
	}
	
	@RequestMapping("/registration")
	public String registerPage(Model m) {
		return "registration";
	}
	
	@RequestMapping(value="/insert",method = RequestMethod.POST)
	public String insertUser(@ModelAttribute User u,Model m) {
		this.dao.inserOrUpdatetUser(u);
		m.addAttribute("list", this.dao.getAllUser());
		return "home";
	}
	
	@RequestMapping("/home")
	public String homePage(Model m) {
		m.addAttribute("list", this.dao.getAllUser());
		return "home";
	}
	
	@RequestMapping(value="/edit/{id}")
	public ModelAndView editUser(@PathVariable("id") int id) {
		User u= this.dao.getUserById(id);
		ModelAndView m = new ModelAndView();
		m.addObject("u", u);
		m.setViewName("update");
		return m;
	}
	@RequestMapping(value="/delete/{id}")
	public String deleteUser(@PathVariable("id") int id,Model m) {
		this.dao.deleteUser(id);
		List<User> list = this.dao.getAllUser();
		m.addAttribute("list", list);
		return "home";
	}
	
	@RequestMapping(value="/getUser/{id}")
	public ModelAndView getUser(@PathVariable("id") int id) {
	    User u = this.dao.getUserById(id); // Fetch user by ID
	    ModelAndView m = new ModelAndView();
	    m.addObject("u", u); // Add user object to the model
	    m.setViewName("userDetails"); // View name (JSP page to render)
	    return m;
	}
	
	
}
