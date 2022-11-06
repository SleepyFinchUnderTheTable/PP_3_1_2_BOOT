package ru.kata.preproject.PP_3_1_2_BOOT.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kata.preproject.PP_3_1_2_BOOT.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
