package vn.codegym.furamaresort.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.codegym.furamaresort.model.user.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    Role getRoleByRoleName(String name);
}