package com.example.movieticket.model;

public class MockPaymentAdapter implements IPayment {
    @Override
    public PaymentResult pay(double amount) {
        System.out.println("MockPaymentAdapter: paying " + amount);
        return new PaymentResult(true, "OK");
    }
}
