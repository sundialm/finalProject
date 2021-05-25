package com.example.endspring.repo;

import com.example.endspring.userDAO.DAOUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<DAOUser, Integer> {
    Optional<DAOUser> findByUsername(String username);
}
