package com.symbiosis.app.service;

import com.symbiosis.app.entity.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface UserService {

   List<User> findAll(Specification<User> specification, Sort sort);

   User findById(Integer userId);

   User save(User user);

   User update(User user);

   void deleteById(Integer userId);
}
