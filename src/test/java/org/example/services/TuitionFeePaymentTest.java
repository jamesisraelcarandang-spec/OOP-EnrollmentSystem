//package org.example.services;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class TuitionFeePaymentTest {
//    private TuitionFeePaymentService tuitionFeePayment;
//
//    @BeforeEach
//    void setup() {
//        tuitionFeePayment = new TuitionFeePaymentService() {
//            @Override
//            public double calculateTuitionFee(int units, double discountRate) {
//                return 0;
//            }
//
//            @Override
//            public void makePayment(double amount) {
//
//            }
//
//            @Override
//            public double getRemainingBalance() {
//                return 0;
//            }
//
//            @Override
//            public boolean isFullyPaid() {
//                return false;
//            }
//        };
//    }
//
//    @Test
//    @DisplayName("Calculation of Tuition Fee")
//    void shouldReturnCorrectCalculationOfTuitionFee() {
//
//
//    }
//
//    @Test
//    void shouldMakeAPayment() {
//        tuitionFeePayment.calculateTuitionFee(3, 0.10);
//
//        //Act
//        tuitionFeePayment.makePayment(1000);
//
//        //Assert
//        assertEquals(1700, tuitionFeePayment.getRemainingBalance());
//    }
//
//    @Test
//    void shouldCheckIfTheTuitionFeeIsNotFullyPaid() {
//        tuitionFeePayment.calculateTuitionFee(3,0.10);
//
//        tuitionFeePayment.makePayment(1000);
//
//        assertFalse(tuitionFeePayment.isFullyPaid());
//    }
//
//}