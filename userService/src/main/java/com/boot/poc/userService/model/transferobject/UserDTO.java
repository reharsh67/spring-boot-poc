package com.boot.poc.userService.model.transferobject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class UserDTO {
    private Long id;
    private String userName;
    private String userEmail;
}
