package com.simplilearn.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.spring.model.User;
import com.simplilearn.spring.service.UserService;

@RestController
public class UserController {


	UserService service;

	UserController(UserService service){
		this.service= service;
	}

	@GetMapping("/")
	String showHome() {

		return "home";
	}


	@GetMapping("/user")
	List<User> listUsers() {

		return service.findAll();
	}



	@PostMapping("/user")
	void saveUser(@RequestBody User user) {

		service.save(user);
	}


	@GetMapping("/user/{id}")
	Optional<User> findUser(@PathVariable int id) {

		return service.findById(id);


	}

	//update user must us putmapping
	@PutMapping("/user")
	void updateUser(@RequestBody User user) {



		service.update(user);
	}


	@DeleteMapping("/user")
	void deleteUser(@PathVariable int id) {

		service.delete(id);

	}


}
