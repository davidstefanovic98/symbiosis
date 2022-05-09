package com.symbiosis.app.service.impl;

import com.symbiosis.app.entity.Role;
import com.symbiosis.app.repository.RoleRepository;
import com.symbiosis.app.service.RoleService;
import com.symbiosis.app.service.generic.impl.GenericCrudServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends GenericCrudServiceImpl<Role> implements RoleService {

    protected RoleServiceImpl(RoleRepository repository) {
        super(repository);
    }
}
