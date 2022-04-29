package com.symbiosis.app.repository;

import com.symbiosis.app.entity.RoleAuthorization;
import com.symbiosis.app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RoleAuthorizationRepository extends JpaRepository<RoleAuthorization, Integer>, JpaSpecificationExecutor<RoleAuthorization> {

}
