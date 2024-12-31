package com.wompi.interactions;

import io.restassured.http.ContentType;
import com.wompi.models.ResponseToken;
import com.wompi.utils.WompiInternalInteraction;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.rest.interactions.Get;
import org.apache.http.HttpHeaders;

import static com.wompi.utils.Constants.PAYMENT_METHOD_TYPE;
import static com.wompi.utils.Constants.TOKEN_ID;
import static com.wompi.utils.Keys.PUB_STG_TEST;
import static com.wompi.utils.WompiEndPoints.TOKENS_VALIDATE;
import static com.wompi.utils.WompiPath.NEQUI;
import static net.serenitybdd.screenplay.Tasks.instrumented;

@AllArgsConstructor
public class GetTokenNequi extends WompiInternalInteraction {
    private final String tokenNequi;

    public static GetTokenNequi forWompi(String tokenNequi) {
        return instrumented(GetTokenNequi.class, tokenNequi);
    }

    public static Question<ResponseToken> getResponseBody() {
        return new ResponseBody<>(ResponseToken.class);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Get.resource(TOKENS_VALIDATE.getPath())
                .with(requestSpecification -> getWompiApiURL()
                        .accept(ContentType.JSON)
                        .header(HttpHeaders.AUTHORIZATION, "Bearer " + PUB_STG_TEST.getKey())
                        .pathParam(PAYMENT_METHOD_TYPE.getValue(), NEQUI.getPath())
                        .pathParam(TOKEN_ID.getValue(), tokenNequi)
                )
        );
    }
}
