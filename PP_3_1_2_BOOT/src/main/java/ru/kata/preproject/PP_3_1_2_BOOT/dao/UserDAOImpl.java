package ru.kata.preproject.PP_3_1_2_BOOT.dao;

import org.springframework.stereotype.Repository;
import ru.kata.preproject.PP_3_1_2_BOOT.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> listUsers() {
        return entityManager.createQuery("select user from User user", (User.class)).getResultList();
    }

    @Override
    public void addOneUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void deleteUserByID(int id) {
        entityManager.remove(getOneUser(id));
    }

    @Override
    public void editUserDetails(User userFin, int id) {
        entityManager.merge(userFin);
    }

    @Override
    public User getOneUser(int id) {
        return entityManager.find(User.class, id);
    }
}
