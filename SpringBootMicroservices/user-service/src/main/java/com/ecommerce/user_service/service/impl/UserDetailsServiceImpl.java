package com.ecommerce.user_service.service.impl;

import com.ecommerce.user_service.entity.Users;
import com.ecommerce.user_service.repository.UserServiceRepository;
import com.ecommerce.user_service.service.UserService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;


@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserService {
    private static final Logger log = LoggerFactory.getLogger(UserDetailsServiceImpl.class);
    private UserServiceRepository userServiceRepository;

    @Override
    public Users createUser(Users user) {
        log.info("saving user...");
        return userServiceRepository.save(user);
    }

    @Override
    public List<Users> getAllUsers() {
        List<Users> usersList = userServiceRepository.findAll();
        if (!CollectionUtils.isEmpty(usersList)) {
            return usersList;
        } else {
            throw new RuntimeException("no users found");
        }
    }

    @Override
    public Users updateUser(Long userId, Users user) {
        Users userData = userServiceRepository.findById(userId).orElseThrow(() -> new RuntimeException("user not found"));
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
        return userServiceRepository.findById(userId).orElseThrow(() -> new RuntimeException("user not found with a ID :" + userId));
    }

    @Override
    public void deleteUserById(Long userId) {
        Users users = userServiceRepository.findById(userId).orElseThrow(() -> new RuntimeException("user not found with a ID :" + userId));
        if (users != null) {
            userServiceRepository.deleteById(userId);
        }
    }

}
