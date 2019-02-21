package com.Briantpt30.TaskProject.Models.data;

import com.Briantpt30.TaskProject.Models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("roleRepository")
public interface RoleDao extends JpaRepository<Role, Integer> {
    Role findByRole(String role);
}
