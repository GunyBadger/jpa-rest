package com.simplilearn.spring.repository;


import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;


import com.simplilearn.spring.model.User;



public interface UserRepository extends JpaRepository<User, Integer> {


		//String sql= "SELECT * FROM `user` WHERE idUSER != ? AND UPPER(USERNAME) = UPPER(?)";

	public Optional<User> findByIdUserNotAndUsernameIgnoreCase(int idUser, String username);




}
