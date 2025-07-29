package com.bahikhata.backend.dto;
import java.util.List;

public class AIExpenseRequest {
    private String phoneNumber;
    private List<ExpenseDTO> expenses;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<ExpenseDTO> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<ExpenseDTO> expenses) {
        this.expenses = expenses;
    }

    // Getters and Setters
    public static class ExpenseDTO {
        private String item;
        private String category;
        private Double amount;

        public String getItem() {
            return item;
        }

        public void setItem(String item) {
            this.item = item;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public Double getAmount() {
            return amount;
        }

        public void setAmount(Double amount) {
            this.amount = amount;
        }
// Getters and Setters
    }
}
