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
    @DisplayName("Multiple payments should accumulate correctly")
    void shouldHandleMultiplePayments() {
        tuitionFeePayment.calculateTuitionFee(3, 10);
        tuitionFeePayment.makePayment(1000);
        tuitionFeePayment.makePayment(500);
        assertEquals(1200.0, tuitionFeePayment.getRemainingBalance());
    }

    @Test
    @DisplayName("Tuition is not fully paid after partial payment")
    void shouldCheckIfTheTuitionFeeIsNotFullyPaid() {
        tuitionFeePayment.calculateTuitionFee(3, 10);
        tuitionFeePayment.makePayment(1000);
        assertFalse(tuitionFeePayment.isFullyPaid());
    }

    @Test
    @DisplayName("Tuition is fully paid after complete payment")
    void shouldBeFullyPaidAfterCompletePayment() {
        tuitionFeePayment.calculateTuitionFee(3, 10);
        tuitionFeePayment.makePayment(2700);
        assertTrue(tuitionFeePayment.isFullyPaid());
    }
}
