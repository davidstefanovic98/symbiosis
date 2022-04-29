package com.symbiosis.app.controller;

import com.symbiosis.app.entity.Role;
import com.symbiosis.app.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/roles")
public class RoleController {

    private final RoleService roleService;

    @GetMapping
    public ResponseEntity<List<Role>> getAllRoles(@RequestParam(required = false) Specification<Role> specification,
                                                  @RequestParam(required = false) Sort sort) {
        return ResponseEntity.ok(roleService.findAll(specification, sort));
    }

    @GetMapping("/{roleId}")
    public ResponseEntity<Role> getRoleById(@PathVariable Integer roleId) {
        return ResponseEntity.ok(roleService.findById(roleId));
    }

    @PostMapping
    public ResponseEntity<Role> saveRole(Role role) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(roleService.save(role));
    }

    @PutMapping
    public ResponseEntity<Role> updateRole(Role role) {
        return ResponseEntity.ok(roleService.update(role));
    }

    @DeleteMapping("/{roleId}")
    public void deleteRoleById(@PathVariable Integer roleId) {
        roleService.deleteById(roleId);
    }
}
