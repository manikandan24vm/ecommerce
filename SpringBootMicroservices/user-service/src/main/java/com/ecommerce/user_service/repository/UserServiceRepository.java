package com.ecommerce.user_service.repository;

import com.ecommerce.user_service.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserServiceRepository extends JpaRepository<Users,Long> {
}
