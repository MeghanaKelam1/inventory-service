package com.app.inventory_service.repo;

import com.app.inventory_service.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepo extends JpaRepository<Users,Long> {
    Users findUserByUsername(String username);
}
