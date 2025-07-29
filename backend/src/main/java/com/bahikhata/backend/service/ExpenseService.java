package com.bahikhata.backend.service;
import com.bahikhata.backend.dto.AIExpenseRequest;
import com.bahikhata.backend.model.Expense;
import com.bahikhata.backend.model.User;
import com.bahikhata.backend.repository.ExpenseRepository;
import com.bahikhata.backend.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;

@Service
public class ExpenseService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ExpenseRepository expenseRepository;

    private final Logger logger = LoggerFactory.getLogger(ExpenseService.class);

    public void saveExpenses(AIExpenseRequest request) {
        User user = userRepository.findByPhoneNumber(request.getPhoneNumber())
                .orElseThrow(() -> new RuntimeException("User not found"));

        for (AIExpenseRequest.ExpenseDTO dto : request.getExpenses()) {
            Expense expense = new Expense();
            expense.setItem(dto.getItem());
            expense.setCategory(dto.getCategory());
            expense.setAmount(dto.getAmount());
            expense.setDate(LocalDate.now());
            expense.setUser(user);

            logger.info("Saving expense: {}", expense);
            expenseRepository.save(expense);
        }
    }
}
