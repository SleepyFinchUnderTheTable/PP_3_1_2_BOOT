package ru.kata.preproject.PP_3_1_2_BOOT.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.preproject.PP_3_1_2_BOOT.model.User;
import ru.kata.preproject.PP_3_1_2_BOOT.repository.UserRepository;


import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl( UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> listUsers() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public void addOneUser(User user) {
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void deleteUserByID(int id) {
        userRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void editUserDetails(User userFin, int id) {
        userFin.setId(id);
        userRepository.save(userFin);
    }

    @Override
    public User getOneUser(int id) {
        return userRepository.findById(id).orElse(null);
    }
}
