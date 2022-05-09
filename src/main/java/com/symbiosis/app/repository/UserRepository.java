package com.symbiosis.app.repository;

import com.symbiosis.app.entity.User;
import com.symbiosis.app.repository.generic.JpaSpecificationRepository;

import java.util.Optional;

public interface UserRepository extends JpaSpecificationRepository<User> {

   Optional<User> findByEmail(String email);

}
