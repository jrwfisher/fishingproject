package com.example.fishingproject.dao;

import com.example.fishingproject.model.RegisterUserDto;
import com.example.fishingproject.model.User;

import java.util.List;

public interface UserDao {
    List<User> getUsers();

    User getUserById(int id);

    User getUserByUsername(String username);

    User createUser(RegisterUserDto user);
}
