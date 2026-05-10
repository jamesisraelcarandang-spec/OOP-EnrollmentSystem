package org.example.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TuitionFeePaymentTest {
    private TuitionFeePayment tuitionFeePayment;

    @BeforeEach
    void setup() {
        tuitionFeePayment = new TuitionFeePayment();
    }

    @Test
    @DisplayName("Calculation of Tuition Fee without discount")
    void shouldReturnCorrectTuitionWithoutDiscount() {
        double result = tuitionFeePayment.calculateTuitionFee(3, 0);
        assertEquals(3000.0, result);
    }

    @Test
    @DisplayName("Calculation of Tuition Fee with 10% discount")
    void shouldReturnCorrectTuitionWithDiscount() {
        double result = tuitionFeePayment.calculateTuitionFee(3, 10);
        assertEquals(2700.0, result);
    }

    @Test
    @DisplayName("Make a payment and check remaining balance")
    void shouldMakeAPayment() {
        tuitionFeePayment.calculateTuitionFee(3, 10);
        tuitionFeePayment.makePayment(1000);
        assertEquals(1700.0, tuitionFeePayment.getRemainingBalance());
    }

    @Test
    @DisplayName("Overpayment should not change balance")
    void shouldRejectOverpayment() {
        tuitionFeePayment.calculateTuitionFee(3, 0);
        tuitionFeePayment.makePayment(5000);
        assertEquals(3000.0, tuitionFeePayment.getRemainingBalance());
    }

    @Test
    @DisplayName("Dean's Lister scholarship gives 25% discount")
    void shouldApplyDeansListerDiscount() {
        double result = tuitionFeePayment.applyScholarshipDiscount("Dean's Lister", 3);
        assertEquals(2250.0, result);
    }
}
