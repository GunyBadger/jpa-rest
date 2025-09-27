package com.simplilearn.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.simplilearn.spring.model.User;
import com.simplilearn.spring.repository.UserRepository;


@Service
public class UserService {

	UserRepository repository;

	UserService(UserRepository repository){
		this.repository = repository;
	}

	public List<User> findAll() {

		return repository.findAll();
	}

	public void save(User user) {

		validate(user);

		repository.save(user);
	}

	public Optional<User> findByUsername(User user){


		return repository.findByIdUserNotAndUsernameIgnoreCase(user.getIdUser(), user.getUsername());
	}

	public Optional<User> findById(int id) {

		//this is where you put services for additional functionalities like formating

		return repository.findById(id);
	}

	public void update(User user) {

		validate(user);

		var oldUser = repository.findById(user.getIdUser());

			user.setPassword(oldUser.get().getPassword()); //keep old password

		repository.save(user);
	}

	public void delete(int id) {

		repository.deleteById(id);
	}

	private void validate(User user) {
		if(
			user.getUsername() == null || user.getUsername().isEmpty()  ||
			user.getFirstName() == null || user.getFirstName().isEmpty() ||
			user.getLastName() == null || user.getLastName().isEmpty()
			){

			throw new IllegalArgumentException("Invalid User Data");
		}
	}



}
