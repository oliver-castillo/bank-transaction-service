package com.bank.transactionservice.model.enums;

public enum TransactionType {
    DEPOSIT,
    WITHDRAWAL,
    TRANSFER,
    PAYMENT;

    public static TransactionType fromString(String type) {
        return valueOf(type.toUpperCase());
    }
}
