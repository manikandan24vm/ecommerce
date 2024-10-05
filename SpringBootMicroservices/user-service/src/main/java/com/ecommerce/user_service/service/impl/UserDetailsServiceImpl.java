package com.ecommerce.user_service.service.impl;

import com.ecommerce.user_service.entity.Users;
import com.ecommerce.user_service.exception.UserNotFoundException;
import com.ecommerce.user_service.repository.UserServiceRepository;
import com.ecommerce.user_service.service.UserService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;


@Service

public class UserDetailsServiceImpl implements UserService {
    private static final Logger log = LoggerFactory.getLogger(UserDetailsServiceImpl.class);
    @Autowired
    private UserServiceRepository userServiceRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Users createUser(Users user) {
        try {
            log.info("saving user...");
            String password = user.getPassword();
            user.setPassword(passwordEncoder.encode(password));
            return userServiceRepository.save(user);
        }
        catch (Exception e){
          throw  new RuntimeException("cannot create the user.."+e);
        }

    }

    @Override
    public List<Users> getAllUsers() {
        List<Users> usersList = userServiceRepository.findAll();
        if (!CollectionUtils.isEmpty(usersList)) {
            return usersList;
        } else {
            throw new UserNotFoundException("no users found");
        }
    }

    @Override
    public Users updateUser(Long userId, Users user) {
        Users userData = userServiceRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("user not found"));
        userData.setFirstName(user.getFirstName());
        userData.setLastName(user.getLastName());
        userData.setEmail(user.getEmail());
        userData.setPhoneNumber(user.getPhoneNumber());
        userData.setAddress(user.getAddress());
        userData.setPassword(user.getPassword());
        return userServiceRepository.save(userData);

    }

    @Override
    public Users getUserById(Long userId) {
        return userServiceRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("user not found with a ID :" + userId));
    }

    @Override
    public void deleteUserById(Long userId) {
        Users users = userServiceRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("user not found with a ID :" + userId));
        if (users != null) {
            userServiceRepository.deleteById(userId);
        }
    }

}
