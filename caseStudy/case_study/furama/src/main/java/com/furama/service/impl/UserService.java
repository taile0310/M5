package com.furama.service.impl;

import com.furama.model.login.User;
import com.furama.repository.IUserRepository;
import com.furama.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public List<User> getListUser() {
        return userRepository.findAll();
    }

//    @Override
//    public boolean login(String username, String password) {
//        Optional<User> user = userRepository.findByUsernameAndPassword(username, password);
//        return user.isPresent();
//    }

//    @Override
//    public void addAccount(User user) {
//        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
//        userRepository.save(user);
//
//    }
}
