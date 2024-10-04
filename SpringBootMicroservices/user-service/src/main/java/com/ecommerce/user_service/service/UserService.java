package com.ecommerce.user_service.service;
import java.util.List;

import com.ecommerce.user_service.entity.Users;

public interface UserService {
    public Users createUser(Users user);
    public List<Users> getAllUsers();
    public Users updateUser(Long userId, Users user);
    public Users getUserById(Long userId);
    public void deleteUserById(Long userId);



}
