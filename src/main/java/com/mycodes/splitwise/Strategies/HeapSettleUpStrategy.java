package com.mycodes.splitwise.Strategies;

import com.mycodes.splitwise.Models.Expense;
import com.mycodes.splitwise.Models.User;
import org.springframework.core.PriorityOrdered;

import java.util.*;

public class HeapSettleUpStrategy implements SettleUpStrategy {


    @Override
    public List<Expense> settleUp(List<Expense> expensesToSettle) {
        Map<User,Integer> extraAmount=new HashMap<>();
        List<Expense> transactions=new ArrayList<>();

       ////Map creation for extra amount
        for(Expense expense:expensesToSettle){
         for (User user:expense.getPaidBy().keySet()){
             if(!extraAmount.containsKey(user)){
                 extraAmount.put(user,0);
             }
             extraAmount.put(user,extraAmount.get(user)+expense.getPaidBy().get(user));
         }
         }

        for (Expense expense:expensesToSettle){
            for (User user:expense.getHadToPay().keySet()){
                if(!extraAmount.containsKey(user)){
                    extraAmount.put(user,0);
                }
                extraAmount.put(user,extraAmount.get(user)-expense.getHadToPay().get(user));
            }
        }
        Queue<Record> negativeQueue = new PriorityQueue<>();
        // This queue will contain the amount had to pay by the users.

        Queue<Record> positiveQueue = new PriorityQueue<>();
        // This queue will contain the amount paid extra by the users.

        // For loop to fill the queue based on the extra amount map.
        for (User user: extraAmount.keySet()) {
            if (extraAmount.get(user) > 0) {
                positiveQueue.add(new Record(user, extraAmount.get(user)));
            } else {
                negativeQueue.add(new Record(user, extraAmount.get(user)));
            }
        }






// create transaction list.
        while (!positiveQueue.isEmpty() && !negativeQueue.isEmpty()) {
            Record firstNegative = negativeQueue.remove(); // user paid lesser.
            Record firstPostive = positiveQueue.remove(); // user paid extra.

            if (firstPostive.amount > Math.abs(firstNegative.amount)) {
                //1000  > -500
                // B -> A 500
                transactions.add(
                        new Expense(firstNegative.User.toDto(), firstPostive.user.toDto(), Math.abs(firstNegative.pendingAmount))
                );
                // A -> 1000-500 = 500
                positiveQueue.add(new Record(firstPostive.user, firstPostive.pendingAmount - Math.abs(firstNegative.pendingAmount)));
            } else {
                // 500 > -1000
                transactions.add(
                        new Expense(firstNegative.user.toDto(), firstPostive.user.toDto(), firstPostive.pendingAmount)
                );
                negativeQueue.add(new Record(firstNegative.user, firstNegative.pendingAmount + firstPostive.pendingAmount));
            }
        }
        return transactions;
    }
}