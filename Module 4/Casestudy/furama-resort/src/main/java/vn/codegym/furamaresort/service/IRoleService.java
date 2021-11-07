package vn.codegym.furamaresort.service;

import org.springframework.stereotype.Service;
import vn.codegym.furamaresort.model.user.Role;

@Service
public interface IRoleService {
    Role getRoleByRoleName(String roleName);
}