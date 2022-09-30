package CRUD_Spring_Boot.crudspringboot.dao;

import CRUD_Spring_Boot.crudspringboot.models.Role;

import java.util.List;

public interface RoleDAO {

    List<Role> getAllRoles();

    Role getRole(long id);

    void saveRole(Role role);

    void updateRole(Role role);

    void deleteRole(long id);

    Role loadRoleByName(String name);
}
