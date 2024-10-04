package com.ecommerce.user_service.controller;

import com.ecommerce.user_service.dto.UserDTO;
import com.ecommerce.user_service.entity.Users;
import com.ecommerce.user_service.mapper.UserDtoMapper;
import com.ecommerce.user_service.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class UsersController {
    private static final Logger log = LoggerFactory.getLogger(UsersController.class);
    @Autowired
    private UserService userService;
    @PostMapping("/users")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        try {
            Users users= UserDtoMapper.DtoToEntity(userDTO);
            return ResponseEntity.ok(UserDtoMapper.entityToDto(userService.createUser(users)));
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<Users> usersList = userService.getAllUsers();
        List<UserDTO>userDTOList=usersList.stream().map(UserDtoMapper::entityToDto).toList();
        return ResponseEntity.ok(userDTOList);
    }
    @PutMapping("/users/{userId}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long userId, @RequestBody UserDTO userDTO) {
        Users users= UserDtoMapper.DtoToEntity(userDTO);
        return ResponseEntity.ok(UserDtoMapper.entityToDto(userService.updateUser(userId, users)));
    }
   @GetMapping("/users/{userId}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long userId) {
        Users user = userService.getUserById(userId);
        if (user != null) {
            return ResponseEntity.ok(UserDtoMapper.entityToDto(user));
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/users/{userId}")
    public ResponseEntity<UserDTO> deleteUserById(@PathVariable Long userId) {
        try{
            userService.deleteUserById(userId);
            return ResponseEntity.ok().build();
        }
        catch (Exception e){
            log.error("can't remove user :{}", String.valueOf(e));
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
