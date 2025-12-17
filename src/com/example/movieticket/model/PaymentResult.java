package com.example.movieticket.model;

public class PaymentResult {
    public final boolean success;
    public final String message;
    public PaymentResult(boolean s, String m) { success = s; message = m; }
}
