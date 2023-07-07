package com.example.codeupspringblog.repositories;

import com.example.codeupspringblog.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
