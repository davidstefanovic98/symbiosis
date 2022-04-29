package com.symbiosis.app.service;

import com.symbiosis.app.entity.Role;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface RoleService {

    List<Role> findAll(Specification<Role> specification, Sort sort);

    Role findById(Integer roleId);

    Role save(Role role);

    Role update(Role role);

    void deleteById(Integer roleId);

}
