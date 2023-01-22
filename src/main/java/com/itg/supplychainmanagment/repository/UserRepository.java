package com.itg.supplychainmanagment.repository;

import com.itg.supplychainmanagment.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmailAddress(String emailAddress);
    User findByEmailAddressAndPassword(String emailAddress, String password);
}
