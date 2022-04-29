package com.symbiosis.app.repository;

import com.symbiosis.app.entity.Label;
import com.symbiosis.app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface LabelRepository extends JpaRepository<Label, Integer>, JpaSpecificationExecutor<Label> {

}
