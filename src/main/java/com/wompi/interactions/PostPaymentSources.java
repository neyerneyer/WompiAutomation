package com.wompi.interactions;

import com.wompi.models.RequestPaymentSource;
import com.wompi.models.ResponsePaymentSource;
import com.wompi.utils.WompiInternalInteraction;
import io.restassured.http.ContentType;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.rest.interactions.Post;
import org.apache.http.HttpHeaders;

import static com.wompi.utils.Constants.TRANSACTION_TYPE;
import static com.wompi.utils.Keys.PVR_STG_TEST;
import static com.wompi.utils.WompiEndPoints.PATH;
import static com.wompi.utils.WompiPath.PAYMENT_SOURCES;
import static net.serenitybdd.screenplay.Tasks.instrumented;

@AllArgsConstructor
public class PostPaymentSources extends WompiInternalInteraction {
private RequestPaymentSource body;

    public static PostPaymentSources wompi(RequestPaymentSource body) {
        return instrumented(PostPaymentSources.class, body);
    }

    public static Question<ResponsePaymentSource> getResponseBody() {
        return new ResponseBody<>(ResponsePaymentSource.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Post.to(PATH.getPath())
                .with(requestSpecification -> getWompiApiURL()
                        .header(HttpHeaders.CONTENT_TYPE, ContentType.JSON)
                        .header(HttpHeaders.AUTHORIZATION, "Bearer " + PVR_STG_TEST.getKey())
                        .pathParam(TRANSACTION_TYPE.getValue(), PAYMENT_SOURCES.getPath())
                        .body(body)
                )

        );
    }
}
