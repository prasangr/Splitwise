package com.mycodes.splitwise.Strategies;


import com.mycodes.splitwise.Models.Expense;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SettleUpStrategy {
List<Expense> settleUp(List<Expense> expensesToSettle);

// Settle - Bunch of expenses
// User - expenses
// group - expenses
}
