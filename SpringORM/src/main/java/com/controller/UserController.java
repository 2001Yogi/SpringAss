


 package com.controller;
  
  import javax.servlet.http.HttpServletRequest;
  
  import javax.servlet.http.HttpSession;
  
  import org.springframework.beans.factory.annotation.Autowired; 
  import org.springframework.stereotype.Controller;
	import org.springframework.ui.Model;
	import org.springframework.web.bind.annotation.ModelAttribute; 
	import org.springframework.web.bind.annotation.RequestMapping; 
	import org.springframework.web.bind.annotation.RequestMethod;
	import org.springframework.web.bind.annotation.RequestParam;
   import com.dao.UserDao; 
   import com.model.User;  @Controller 
   public class UserController {  @Autowired private UserDao dao;  @RequestMapping("/") public String index() { System.out.print("This is index URL"); return "index"; }  @RequestMapping("/registration") public String registration() { System.out.print("This is Registration URL"); return "registration"; }  @RequestMapping(value="/insert",method = RequestMethod.POST) public String insertUser(@ModelAttribute User u,Model m) { this.dao.inserOrUpdatetUser(u); m.addAttribute("list", this.dao.getAllUser()); return "login"; }  @RequestMapping(value="/login", method=RequestMethod.POST) 
 public String loginUser(@ModelAttribute User u, Model m, HttpSession session) { 
	 User loggedInUser = this.dao.getUserByEmailPassword(u.getEmail(),u.getPassword()); 	 if (loggedInUser != null) { // Successful login, store the user in the		 session.setAttribute(null, loggedInUser); 		 	return "home"; } else { 			 m.addAttribute("error", "Invalid email or password"); 
			 return "login"; } }  @RequestMapping("/edit") public String editProfile(HttpSession session, Model m) { 
	 System.out.print("This is Edit URL"); User loggedInUser = (User)	session.getAttribute("loggedInUser"); 
	 if (loggedInUser != null) {		m.addAttribute("user", loggedInUser); 
		return "edit"; 
		} else 
		{ return "home";		} 
}  @RequestMapping(value="/editprofile", method=RequestMethod.POST) 
 public String updateProfile(@ModelAttribute("user") User updatedUser, HttpSession session, Model m) { 
	 User loggedInUser = (User)session.getAttribute("loggedInUser");  if (loggedInUser != null) { // Update the user details, including gender	 loggedInUser.setFirstname(updatedUser.getFirstname());	 loggedInUser.setLastname(updatedUser.getLastname());	 loggedInUser.setEmail(updatedUser.getEmail());	 loggedInUser.setPassword(updatedUser.getPassword()); // Remember to hash the  // Save the updated user in the database this.dao.inserOrUpdatetUser(loggedInUser);  session.setAttribute("loggedInUser", loggedInUser);  m.addAttribute("message", "Profile updated successfully"); return "home"; } else { return "login"; } } 
 }