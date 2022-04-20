package com.symbiosis.app.service;

import com.symbiosis.app.entity.Role;

import java.util.List;

public interface RoleService {

    List<Role> findAll();

    Role findById(Integer roleId);

    Role save(Role role);

    Role update(Role role);

    void deleteById(Integer roleId);

}
