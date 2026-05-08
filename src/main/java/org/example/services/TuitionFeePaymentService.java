package org.example.services;

public interface TuitionFeePaymentService {
    double calculateTuitionFee(int units, double discountRate);
    void makePayment(double amount);
    double getRemainingBalance();
    boolean isFullyPaid();
}
