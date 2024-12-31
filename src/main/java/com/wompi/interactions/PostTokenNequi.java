package com.wompi.interactions;

import com.wompi.models.RequestNequi;
import com.wompi.models.ResponseToken;
import com.wompi.utils.WompiInternalInteraction;
import io.restassured.http.ContentType;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.rest.interactions.Post;
import org.apache.http.HttpHeaders;

import static com.wompi.utils.Constants.PAYMENT_METHOD_TYPE;
import static com.wompi.utils.Keys.PUB_STG_TEST;
import static com.wompi.utils.WompiEndPoints.TOKENS;
import static com.wompi.utils.WompiPath.NEQUI;
import static net.serenitybdd.screenplay.Tasks.instrumented;

@AllArgsConstructor
public class PostTokenNequi extends WompiInternalInteraction {
    private RequestNequi body;

    public static PostTokenNequi wompi(RequestNequi body) {
        return instrumented(PostTokenNequi.class, body);
    }

    public static Question<ResponseToken> getResponseBody() {
        return new ResponseBody<>(ResponseToken.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Post.to(TOKENS.getPath())
                .with(requestSpecification -> getWompiApiURL()
                        .accept(ContentType.ANY)
                        .header(HttpHeaders.CONTENT_TYPE, ContentType.JSON)
                        .header(HttpHeaders.AUTHORIZATION, "Bearer " + PUB_STG_TEST.getKey())
                        .pathParam(PAYMENT_METHOD_TYPE.getValue(), NEQUI.getPath())
                        .body(body)
                )

        );

    }
}
