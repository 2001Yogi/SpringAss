package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.model.User;
import com.example.repo.UserRepo;

@Component
public class UserService {

	@Autowired
	private UserRepo userRepo;
	
	public List<User> getAllUsers(){
		return this.userRepo.findAll();
//		
//		List<User> list = new ArrayList<>();		
//		User u1 = new User(1, "java", 98765312, "ahmedabad");
//		User u2 = new User(2, "python", 98765312, "ahmedabad");
//		User u3 = new User(3, "php", 98765312, "ahmedabad");
//		list.add(u1);
//		list.add(u2);
//		list.add(u3);
//		
//		return list;
	}
	
	public User addUser(User u) {
		return this.userRepo.save(u);
	}
	
	public void deleteUser(int id) {
		this.userRepo.deleteById(id);
	}
	
	public void updateUser(User u) {
		this.userRepo.save(u);
	}
}
