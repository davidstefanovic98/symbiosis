package com.symbiosis.app.repository.generic;

import com.symbiosis.app.annotation.Exclude;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

@Exclude
public interface JpaSpecificationRepository<T> extends JpaRepository<T, Integer>, JpaSpecificationExecutor<T> {

}

