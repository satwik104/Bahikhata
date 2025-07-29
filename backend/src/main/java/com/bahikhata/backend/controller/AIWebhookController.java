package com.bahikhata.backend.controller;

import com.bahikhata.backend.dto.AIExpenseRequest;
import com.bahikhata.backend.service.ExpenseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ai")
public class AIWebhookController {

    @Autowired
    private ExpenseService expenseService;

    private final Logger logger = (Logger) LoggerFactory.getLogger(AIWebhookController.class);

    @PostMapping("/expense")
    public ResponseEntity<String> receiveExpenseJson(@RequestBody AIExpenseRequest request) {
        logger.info("Received expense JSON from AI: {}", request);

        try {
            String phoneNumber = request.getPhoneNumber();

            // Mock: Allow only your number to pass
            if (!phoneNumber.equals("YOUR_PHONE_NUMBER")) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("❌ You need to register first.");
            }

            expenseService.saveExpenses(request);
            return ResponseEntity.ok("✅ Expenses recorded successfully!");

        } catch (Exception e) {
            logger.error("❌ Error processing AI JSON", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Oops! Something went wrong. Please try again.");
        }
    }
}
