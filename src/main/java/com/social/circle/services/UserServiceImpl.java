package com.social.circle.services;

import com.social.circle.dto.UserLoginRequest;
import com.social.circle.dto.UserResponse;
import com.social.circle.entities.Token;
import com.social.circle.entities.User;
import com.social.circle.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public Optional<UserResponse> register(User userDetails) {
        Set<User> usersWithEmail = userRepository.findByEmail(userDetails.getEmail());
        if(!usersWithEmail.isEmpty()) {
            return Optional.empty();
        }
        User savedUser = userRepository.save(userDetails);
        return Optional.of(new UserResponse(savedUser));
    }

    @Override
    public Optional<UserResponse> login(UserLoginRequest loginRequest) {
        // check if user exists ?
        Set<User> usersWithEmail = userRepository.findByEmail(loginRequest.getEmail());
        if(usersWithEmail.isEmpty()){
            return Optional.empty();
        }
        User currentUser = usersWithEmail.stream().toList().get(0);


        // if the token for user exists ?
        List<Token> tokensForUser = currentUser.getTokens();
        if(tokensForUser.size() != 0){

        }



        // email - password matches ?
        return null;
    }
}
