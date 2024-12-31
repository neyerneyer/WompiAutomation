package com.wompi.utils;



public enum Constants {
    MERCHANT_PUBLIC_KEY("merchantPublicKey"),
    PAYMENT_METHOD_TYPE("paymentMethodType"),
    TOKEN_ID("tokenId"),
    TRANSACTION_TYPE("transactionType");
    private final String value;

    Constants(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
}
