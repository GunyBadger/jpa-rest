package com.simplilearn.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.simplilearn.spring.model.User;
import com.simplilearn.spring.service.UserService;

@Controller
public class UserController {


	UserService service;

	UserController(UserService service){
		this.service= service;
	}

	@GetMapping("/")
	String showHome() {

		return "home";
	}


	@GetMapping("/list")
	ModelAndView listUsers() {

		List<User> users = service.findAll();

		return new ModelAndView("list", "users", users);
	}




	@GetMapping("/add")
	String addUser(User user) {

		return "add";
	}

	@PostMapping("/add")
	String saveUser(User user, BindingResult result) {

		if(result.hasErrors()) {
			return "add";
		}

		//Check if username already exists
		Optional<User> existingUser = service.findByUsername(user);
		if (existingUser.isPresent()) {
			result.rejectValue("username", "error.user", "Username already exists");
			return "add";
		}

		service.save(user);
		return "redirect:/list";
	}

	@GetMapping("/edit/{id}")
	ModelAndView editUser(@PathVariable int id) {

		Optional<User> user = service.findById(id);

		if(user.isPresent()) {
			return new ModelAndView("edit", "user", user.get());
		}else {
			return new ModelAndView("redirect:/list");
		}
	}

	@PostMapping("/edit")
	String updateUser(User user, BindingResult result) {

		Optional<User> existingUser = service.findByUsername(user);
		if (existingUser.isPresent()) {
			result.rejectValue("username", "error.user", "Username already exists");
			return "edit";
		}

		service.update(user);
		return "redirect:/list";

	}

	@GetMapping("/delete/{id}")
	String deleteUser(@PathVariable int id) {

		service.delete(id);
		return "redirect:/list";
	}


}
