package org.example.mapper.user;

import org.example.Entities.User.CustomUser;
import org.example.dto.user.CreateUserDTO;


public class UserMapper {


    public static CustomUser ToEntity(CreateUserDTO u) {
        var user = new CustomUser();

        return user;
    }
}