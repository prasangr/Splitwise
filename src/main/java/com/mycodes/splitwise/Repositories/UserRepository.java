package com.mycodes.splitwise.Repositories;

import com.mycodes.splitwise.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}