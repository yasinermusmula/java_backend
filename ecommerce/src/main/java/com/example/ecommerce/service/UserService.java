package com.example.ecommerce.service;

import com.example.ecommerce.entity.User;

import java.util.List;

public interface UserService{
    User save(User user);

    List<User> findAll();

    User findById(long id);

    User delete(long id);
}
