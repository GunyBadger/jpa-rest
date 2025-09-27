package com.simplilearn.spring.repository.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.simplilearn.spring.model.User;

public class UserRowMapper implements RowMapper<User> {


	public User mapRow(ResultSet rs, int rowNum) throws SQLException {

		if (rs != null) {

			User user = new User ();

			user.setIdUser(rs.getInt("idUSER"));
			user.setFirstName(rs.getString("FIRST_NAME"));
			user.setLastName(rs.getString("LAST_NAME"));
			user.setUsername(rs.getString("USERNAME"));
			user.setPassword(rs.getString("PASSWORD"));
			user.setBirthDate(rs.getDate("BIRTH"));
			user.setStatus(rs.getString("STATUS"));
			return user;

		}
		return null;
	}

}
