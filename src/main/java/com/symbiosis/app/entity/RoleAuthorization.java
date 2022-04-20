package com.symbiosis.app.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "role_authorization")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class RoleAuthorization extends Auditable{

    @EmbeddedId
    private RoleAuthorizationId id;

    @MapsId("roleId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "role_fk", nullable = false)
    @ToString.Exclude
    private Role role;
}