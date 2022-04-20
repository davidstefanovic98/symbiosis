package com.symbiosis.app.controller;

import com.symbiosis.app.entity.Role;
import com.symbiosis.app.entity.User;
import com.symbiosis.app.service.RoleService;
import com.symbiosis.app.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/roles")
public class RoleController {

    private final RoleService roleService;

    @GetMapping("/role")
    public ResponseEntity<List<Role>> getAllRoles() {
        return ResponseEntity.ok(roleService.findAll());
    }

    @PostMapping("/role")
    public ResponseEntity<Role> saveRole(Role role) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(roleService.save(role));
    }

    @PutMapping("/role")
    public ResponseEntity<Role> updateRole(Role role) {
        return ResponseEntity.ok(roleService.update(role));
    }

    @DeleteMapping("/role/{roleId}")
    public void deleteRoleById(@PathVariable Integer roleId) {
        roleService.deleteById(roleId);
    }
}
