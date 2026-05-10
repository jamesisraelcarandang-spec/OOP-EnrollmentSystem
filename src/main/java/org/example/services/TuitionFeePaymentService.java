package org.example.services;

public interface TuitionFeePaymentService {
    double calculateTuitionFee(int units, double discountRate);
    double applyScholarshipDiscount(String scholarshipType, int units);
    void makePayment(double amount);
    double getRemainingBalance();
    boolean isFullyPaid();
}
