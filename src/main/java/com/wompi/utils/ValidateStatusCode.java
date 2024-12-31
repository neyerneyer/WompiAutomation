package com.wompi.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.actors.OnStage;

import java.util.HashMap;
import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.apache.http.HttpStatus.*;
import static org.hamcrest.Matchers.equalTo;

@Getter
@AllArgsConstructor
public enum ValidateStatusCode {
    CREATE("creado",SC_CREATED),
    SUCCESS("exitoso",SC_OK),
    UNPROCESSABLE_ENTITY("improcesable",SC_UNPROCESSABLE_ENTITY);

    private final String message;
    private final int statusCode;
    private static final String process = "";
    private static final Map<String,ValidateStatusCode> statusMap = new HashMap<String,ValidateStatusCode>();

    static {
        for (ValidateStatusCode statusCode : ValidateStatusCode.values()) {
            statusMap.put(statusCode.getMessage().toLowerCase(), statusCode);
        }
    }
    public static ValidateStatusCode getStatusCode(String process,String message) {
        ValidateStatusCode statusCode = statusMap.get(message.toLowerCase());
        if (statusCode == null) {
            throw new IllegalArgumentException("No se encontró el estado solicitado: " + message);
        }
        return statusCode;
    }


    public void validate() {
        Serenity.recordReportData().withTitle(process)
                .andContents(String.valueOf(statusCode));
        OnStage.theActorInTheSpotlight().should(
                seeThat("El código que responde el servicio",
                        actor -> SerenityRest.lastResponse().statusCode(),equalTo(statusCode))
        );
    }
}
