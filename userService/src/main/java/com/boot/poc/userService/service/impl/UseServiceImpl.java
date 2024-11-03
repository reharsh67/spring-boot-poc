package com.boot.poc.userService.service.impl;

import com.boot.poc.userService.helper.UserHelper;
import com.boot.poc.userService.model.User;
import com.boot.poc.userService.model.transferobject.UserDTO;
import com.boot.poc.userService.repository.UserRepository;
import com.boot.poc.userService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UseServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public List<UserDTO> getAllUsers() {
        return UserHelper.convertToUserDTO(userRepository.findAll());
    }

    @Override
    public UserDTO getUserById(Long id) {
        return UserHelper.convertToUserDTO(userRepository.findById(id).orElseThrow());
    }

    @Override
    public UserDTO createUser(User user) {
        return UserHelper.convertToUserDTO(userRepository.save(user));
    }

    @Override
    public UserDTO updateUser(Long id, User user) {
        User usr = userRepository.findById(id).orElseThrow();
        usr.setId(user.getId());
        usr.setUserEmail(user.getUserEmail());
        usr.setUserName(user.getUserName());
        return UserHelper.convertToUserDTO(userRepository.save(usr));
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
