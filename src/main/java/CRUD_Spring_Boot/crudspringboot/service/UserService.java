package CRUD_Spring_Boot.crudspringboot.service;

import CRUD_Spring_Boot.crudspringboot.models.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUser(long id);

    void save(User user, String[] roles);

    void update(User user, String[] roles);

    void delete(long id);

    User loadUserByUsername(String s);

}
