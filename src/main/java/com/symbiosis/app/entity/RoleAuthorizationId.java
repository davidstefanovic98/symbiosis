package com.symbiosis.app.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RoleAuthorizationId implements Serializable {
    private static final long serialVersionUID = -8345070252279973004L;
    @Column(name = "role_fk", nullable = false)
    private Integer roleId;

    @Column(name = "authorization", nullable = false, length = 64)
    private String authorization;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        RoleAuthorizationId entity = (RoleAuthorizationId) o;
        return Objects.equals(this.authorization, entity.authorization) &&
                Objects.equals(this.roleId, entity.roleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authorization, roleId);
    }

}