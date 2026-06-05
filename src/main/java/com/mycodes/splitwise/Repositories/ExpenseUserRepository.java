package com.mycodes.splitwise.Repositories;

import com.mycodes.splitwise.Models.ExpenseUsers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseUserRepository extends JpaRepository<ExpenseUsers, Long> {
}
