package CRUD_Spring_Boot.crudspringboot.dao;

import CRUD_Spring_Boot.crudspringboot.models.Role;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RoleDAOImpl implements RoleDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Role> getAllRoles() {
        return entityManager.createQuery("from Role", Role.class).getResultList();
    }

    @Override
    public Role getRole(long id) {
        return entityManager.find(Role.class, id);
    }

    @Override
    public void saveRole(Role role) {
        entityManager.persist(role);
    }

    @Override
    public void updateRole(Role role) {
        entityManager.merge(role);
    }

    @Override
    public void deleteRole(long id) {
        entityManager.remove(getRole(id));
    }

    @Override
    public Role loadRoleByName(String name) {
        return entityManager.createQuery("FROM Role r WHERE r.role = :name", Role.class)
                .setParameter("name", name)
                .getResultList().stream().findAny().orElse(null);
    }
}
