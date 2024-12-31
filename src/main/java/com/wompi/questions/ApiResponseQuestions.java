package com.wompi.questions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Question;

import static com.wompi.utils.ApiInteraction.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class ApiResponseQuestions {

    @Step("Validar que el código de estado sea {0}")
    public static Question<Boolean> hasStatusCode(int expectedStatusCode) {
        return actor -> {
            int actualStatusCode =  actor.asksFor(getStatusCode());
            return actualStatusCode == expectedStatusCode;
        };
    }

    @Step("Validar que el campo '{0}' tenga el valor '{1}'")
    public static Question<Boolean> hasFieldWithValue(String fieldPath, Object expectedValue) {
        return actor -> {
            Object actualValue = actor.asksFor(getFieldFromJson(fieldPath));
            assertThat("El valor del campo no es el esperado", actualValue, is(expectedValue));
            return true;
        };
    }

    @Step("Validar que el cuerpo contiene el texto '{0}'")
    public static Question<Boolean> bodyContains(String expectedText) {
        return actor -> {
            String responseBody = actor.asksFor(getResponseBodyAsString());
            return responseBody.contains(expectedText);
        };
    }

    @Step("Verificar que el objeto ResponseMerchant no sea nulo")
    public static Question<Boolean> isMerchantNotNull(Object responseObject) {
        return actor -> {
            return responseObject != null;
        };
    }
}
