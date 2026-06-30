package com.devprep.devprepai.service;

import com.devprep.devprepai.exception.EmailAlreadyExists;
import com.devprep.devprepai.model.User;
import com.devprep.devprepai.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User register(User user) {
        User existing = userRepository.findByEmail(user.getEmail());
        if(existing != null){
            throw new EmailAlreadyExists("User Already Exists with Email : " + user.getEmail());
        }
        return userRepository.save(user);
    }
}
