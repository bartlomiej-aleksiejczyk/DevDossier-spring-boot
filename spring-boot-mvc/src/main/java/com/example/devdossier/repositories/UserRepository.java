package com.example.devdossier.repositories;

import com.example.devdossier.models.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}