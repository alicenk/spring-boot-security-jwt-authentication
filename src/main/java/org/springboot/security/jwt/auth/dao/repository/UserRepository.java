package org.springboot.security.jwt.auth.dao.repository;

import org.springboot.security.jwt.auth.dao.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
