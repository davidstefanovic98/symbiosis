package com.symbiosis.app.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Locale;
import java.util.Objects;

@Entity
@Table(name = "role")
@Getter
@Setter
@NoArgsConstructor
public class Role extends Auditable implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "role_id")
    private Integer roleId;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;

    @Override
    public String getAuthority() {
        return String.format("ROLE_%s", name.toUpperCase(Locale.ROOT));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Role role = (Role) o;
        return roleId != null && Objects.equals(roleId, role.roleId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
