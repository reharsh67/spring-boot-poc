package com.boot.poc.userService.service;

import com.boot.poc.userService.model.User;
import com.boot.poc.userService.model.transferobject.UserDTO;

import java.util.List;


public interface UserService {

    public List<UserDTO> getAllUsers();

    public UserDTO getUserById(Long id);

    public UserDTO createUser(User user);

    public UserDTO updateUser(Long id, User user);

    public void deleteUser(Long id);
}
