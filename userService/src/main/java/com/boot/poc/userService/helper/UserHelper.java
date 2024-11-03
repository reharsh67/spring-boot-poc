package com.boot.poc.userService.helper;

import com.boot.poc.userService.model.User;
import com.boot.poc.userService.model.transferobject.UserDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserHelper {
    public static List<UserDTO> convertToUserDTO(List<User> list){
        if(!list.isEmpty() && list != null) {
            return list.stream().map(user -> new UserDTO(user.getId(), user.getUserName(), user.getUserEmail())).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }
    public static UserDTO convertToUserDTO(User user){
        if(user != null) {
            return new UserDTO(user.getId(), user.getUserName(), user.getUserEmail());
        }
        return new UserDTO();
    }
}
