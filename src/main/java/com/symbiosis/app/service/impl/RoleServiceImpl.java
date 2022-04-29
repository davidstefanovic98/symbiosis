package com.symbiosis.app.service.impl;

import com.symbiosis.app.entity.Role;
import com.symbiosis.app.repository.RoleRepository;
import com.symbiosis.app.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public List<Role> findAll(Specification<Role> specification, Sort sort) {
        return roleRepository.findAll(specification, sort == null ? Sort.unsorted() : sort);
    }

    @Override
    public Role findById(Integer roleId) {
        return roleRepository.findById(roleId)
                .orElseThrow(() -> new NoSuchElementException("Role with id " + roleId + "not found."));
    }

    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role update(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public void deleteById(Integer roleId) {
        roleRepository.deleteById(roleId);
    }
}
