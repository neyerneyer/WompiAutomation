package com.wompi.utils;

public enum WompiEndPoints {
    MERCHANT("/merchants/{merchantPublicKey}"),
    PATH("/{transactionType}"),
    TOKENS("/tokens/{paymentMethodType}"),
    TOKENS_VALIDATE("/tokens/{paymentMethodType}/{tokenId}");
    private final String path;

    WompiEndPoints(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
