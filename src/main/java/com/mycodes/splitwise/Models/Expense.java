package com.mycodes.splitwise.Models;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Getter
@Setter
public class Expense extends BaseModel {
    private String description;
    private Double amount;

    @ManyToOne
    private User createdBy;

    @OneToMany(mappedBy = "expense")
    private List<ExpenseUsers> expenseUsers;

    @ManyToOne
    private Group group;

    public Map<User, Integer> getPaidBy() {
        Map<User, Integer> paidBy = new HashMap<>();

        if (expenseUsers == null) {
            return paidBy;
        }

        for (ExpenseUsers expenseUser : expenseUsers) {
            if (expenseUser.getExpenseUserType() == ExpenseUserType.PAID_BY) {
                paidBy.put(expenseUser.getUser(), expenseUser.getAmount());
            }
        }

        return paidBy;
    }

    public Map<User, Integer> getHadToPay() {
        Map<User, Integer> hadToPay = new HashMap<>();

        if (expenseUsers == null) {
            return hadToPay;
        }

        for (ExpenseUsers expenseUser : expenseUsers) {
            if (expenseUser.getExpenseUserType() == ExpenseUserType.HAD_TO_PAY) {
                hadToPay.put(expenseUser.getUser(), expenseUser.getAmount());
            }
        }

        return hadToPay;
    }


}
