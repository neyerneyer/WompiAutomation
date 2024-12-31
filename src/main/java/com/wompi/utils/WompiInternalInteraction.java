package com.wompi.utils;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.core.Serenity;
import static net.serenitybdd.rest.SerenityRest.given;

public abstract class WompiInternalInteraction extends ApiInteraction {
    private static final String WOMPI_API_URL_BASE = Serenity.environmentVariables().getProperty("wompi.api.url.base");

    protected static RequestSpecification getWompiApi() {
        return given()
                .baseUri(WOMPI_API_URL_BASE);
    }

    protected static RequestSpecification getWompiApiURL() {
        return getWompiApi().accept(ContentType.JSON);
    }
}
