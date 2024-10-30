package com.scm.repositories;

import com.scm.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    //extra methods db related
    //custom query methods

    //custom finder methods
    Optional<User> findByEmail(String email);

    Optional<User> findByEmailAndPassword(String email, String password);

}
