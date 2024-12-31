package com.wompi.utils;

import lombok.Getter;
import net.serenitybdd.core.Serenity;

@Getter
public enum Keys {
    PUB_STG_TEST(Serenity.environmentVariables().getProperty("wompi.key.stg.test")),
    PVR_STG_TEST(Serenity.environmentVariables().getProperty("wompi.key.stg.pvr"));

    private final String key;

    Keys(String key) {
        this.key = key;
    }
}
