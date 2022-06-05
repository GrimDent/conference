package com.IT.conference.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

    Optional<Users> findUserByEmail(String email);
    Optional<Users> findUserByLogin(String login);
    Optional<Users> findUserById(Long id);
}
