package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void removeUserById(long id) {
        entityManager.remove(getUserById(id));
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public User getUserById(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void updateUser(User updatedUser) {
        User oldUser = entityManager.find(User.class, updatedUser.getId());
        oldUser.setName(updatedUser.getName());
        oldUser.setSurname(updatedUser.getSurname());
        oldUser.setAge(updatedUser.getAge());
    }

    @Override
    public void cleanUsersTable() {
        entityManager.createNativeQuery("truncate table users");
    }
}
