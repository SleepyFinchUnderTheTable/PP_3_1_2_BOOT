package ru.kata.preproject.PP_3_1_2_BOOT.dao;

import ru.kata.preproject.PP_3_1_2_BOOT.model.User;

import java.util.List;

public interface UserDAO {
    public List<User> listUsers();

    public void addOneUser(User user);

    public void deleteUserByID(int id);

    public void editUserDetails(User userFin, int id);

    public User getOneUser(int id);

}
