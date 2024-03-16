package com.project.todo.domain.auth.repository;

import com.project.todo.domain.auth.domain.RefreshToken;
import org.springframework.data.repository.CrudRepository;

public interface AuthRepository extends CrudRepository<RefreshToken, String> {
    RefreshToken findByEmail(String email);
}
