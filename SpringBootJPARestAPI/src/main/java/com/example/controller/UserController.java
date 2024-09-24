package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.User;
import com.example.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService; 

	
//	@RequestMapping("/msg")
//	@ResponseBody
	
	@GetMapping("/msg")
	public String getMSG() {
		return "this msg got from server";
	}
	
	@GetMapping("/allUsers")
	public List<User> getAllUsers() {
		return this.userService.getAllUsers();
	}
	
	@PostMapping("/add")
	public User addUser(@RequestBody User u) {
		return this.userService.addUser(u);
	}
	
	@PutMapping("/update/{id}")
	public void updateUser(@RequestBody User u,@PathVariable("id") int id) {
		u.setId(id);
		this.userService.updateUser(u);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteUser(@PathVariable("id") int id) {
		this.userService.deleteUser(id);
	}
}
