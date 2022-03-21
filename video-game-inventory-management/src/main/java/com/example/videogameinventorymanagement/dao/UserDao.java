package com.example.videogameinventorymanagement.dao;

import com.example.videogameinventorymanagement.model.User;

import java.util.List;

public interface UserDao {

    List<User> findAll();

    User findByUsername(String username);

    int findIdByUsername(String username);

    boolean create(String username, String password);


}
