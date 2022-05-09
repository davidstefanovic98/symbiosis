package com.symbiosis.app.service.impl;

import com.symbiosis.app.entity.RoleAuthorization;
import com.symbiosis.app.repository.RoleAuthorizationRepository;
import com.symbiosis.app.service.RoleAuthorizationService;
import com.symbiosis.app.service.generic.impl.GenericCrudServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class RoleAuthorizationServiceImpl extends GenericCrudServiceImpl<RoleAuthorization> implements RoleAuthorizationService {

    protected RoleAuthorizationServiceImpl(RoleAuthorizationRepository repository) {
        super(repository);
    }
}
