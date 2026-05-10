package org.example.services;

public class TuitionFeePayment implements TuitionFeePaymentService{
    private final double PRICE_PER_UNIT = 1000.00;
    private double balance;
    private double totalTuition;

    public double calculateTuitionFee (int units, double discountRate) {
        totalTuition = units * PRICE_PER_UNIT;
        if (discountRate != 0) {
            totalTuition = totalTuition - (totalTuition * discountRate / 100);
        }
        balance = totalTuition;
        return totalTuition;
    }

    public double applyScholarshipDiscount(String scholarshipType, int units) {
        double discount;
        switch (scholarshipType) {
            case "Dean's Lister":
                discount = 25;
                break;
            case "Academic Scholar":
                discount = 50;
                break;
            case "Presidential Scholar":
                discount = 100;
                break;
            default:
                discount = 0;
                break;
        }
        return calculateTuitionFee(units, discount);
    }

    public void makePayment(double amount) {
        if (amount > balance) {
            System.out.println("Error: Payment of " + amount + " exceeds remaining balance of " + balance);
            return;
        }
        balance = balance - amount;
    }

    public double getRemainingBalance() {
        return balance;
    }
    public boolean isFullyPaid() {
        return balance == 0;
    }
}
