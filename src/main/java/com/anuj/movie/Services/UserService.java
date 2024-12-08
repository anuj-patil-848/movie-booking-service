package com.anuj.movie.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anuj.movie.Converter.UserConverter;
import com.anuj.movie.Entities.User;
import com.anuj.movie.Exceptions.UserAlreadyExists;
import com.anuj.movie.Repositories.UserRepository;
import com.anuj.movie.Request.UserRequest;

@Service
public class UserService {
    
    @Autowired
	UserRepository userRepository;
	

	public String addUser(UserRequest userRequest) throws UserAlreadyExists{
		Optional<User> users = userRepository.findByEmailId(userRequest.getEmailId());
		if (users.isPresent()) {
			throw new UserAlreadyExists();
		}

		User user = UserConverter.userDtoToUser(userRequest);

		userRepository.save(user);
		return "User Saved Successfully";
	}
}
