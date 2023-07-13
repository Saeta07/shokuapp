package com.proyectosena.shokuapp.repository;

import com.proyectosena.shokuapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean findByEmail(String email);
}
