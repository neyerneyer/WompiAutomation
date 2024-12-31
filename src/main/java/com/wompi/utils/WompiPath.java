package com.wompi.utils;

public enum WompiPath {
    NEQUI("nequi"),
    PAYMENT_SOURCES("payment_sources"),
    TRANSACTIONS("transactions"),
    ;

    private final String path;

    WompiPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
