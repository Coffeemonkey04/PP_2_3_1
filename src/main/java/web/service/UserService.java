package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

    void addUser(User user);

    void removeUserById(long id);

    List<User> getAllUsers();

    void cleanUsersTable();

    User getUserById(long id);

    void updateUser(User user);
}
