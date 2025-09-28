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
public class ShowController {




	@GetMapping("/")
	String showHome() {

		return "home";
	}


	@GetMapping("/list")
	String listUsers() {

		return "list";
	}




	@GetMapping("/add")
	String addUser(User user) {

		return "add";
	}



	@GetMapping("/edit/{id}")
	ModelAndView editUser(@PathVariable int id) {


			return new ModelAndView("edit", "id", id);

	}





}
