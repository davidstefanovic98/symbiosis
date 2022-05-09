package com.symbiosis.app.service.impl;

import com.symbiosis.app.entity.User;
import com.symbiosis.app.repository.UserRepository;
import com.symbiosis.app.repository.generic.JpaSpecificationRepository;
import com.symbiosis.app.service.UserService;
import com.symbiosis.app.service.generic.impl.GenericCrudServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserServiceImpl extends GenericCrudServiceImpl<User> implements UserService, UserDetailsService {

    private final UserRepository userRepository;

    protected UserServiceImpl(UserRepository repository) {
        super(repository);
        this.userRepository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found."));
    }
}
