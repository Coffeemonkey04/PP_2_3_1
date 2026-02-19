package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

    void addUser(String name, String surname, int age);

    void removeUserById(long id);

    List<User> getAllUsers();

    User getUserById(long id);

    void updateUser(Long id, String name, String surname, int age);
}
