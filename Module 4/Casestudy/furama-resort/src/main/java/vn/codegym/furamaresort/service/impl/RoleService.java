package vn.codegym.furamaresort.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.furamaresort.model.user.Role;
import vn.codegym.furamaresort.repository.RoleRepository;
import vn.codegym.furamaresort.service.IRoleService;

@Service
public class RoleService implements IRoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role getRoleByRoleName(String roleName) {
        return roleRepository.getRoleByRoleName(roleName);
    }
}