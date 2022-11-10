package ru.kata.preproject.PP_3_1_2_BOOT.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.preproject.PP_3_1_2_BOOT.dao.UserDAO;
import ru.kata.preproject.PP_3_1_2_BOOT.model.User;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<User> listUsers() {
        return userDAO.listUsers();
    }

    @Override
    @Transactional
    public void addOneUser(User user) {
        userDAO.addOneUser(user);
    }

    @Override
    @Transactional
    public void deleteUserByID(int id) {
        userDAO.deleteUserByID(id);
    }

    @Override
    @Transactional
    public void editUserDetails(User userFin, int id) {
        userFin.setId(id);
        userDAO.editUserDetails(userFin, id);
    }

    @Override
    public User getOneUser(int id) {
        return userDAO.getOneUser(id);
    }
}
