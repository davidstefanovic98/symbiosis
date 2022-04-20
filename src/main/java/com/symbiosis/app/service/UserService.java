package com.symbiosis.app.service;

import com.symbiosis.app.entity.User;

import java.util.List;

public interface UserService {

   List<User> findAll();

   User findById(Integer userId);

   User save(User user);

   User update(User user);

   void deleteById(Integer userId);
}
