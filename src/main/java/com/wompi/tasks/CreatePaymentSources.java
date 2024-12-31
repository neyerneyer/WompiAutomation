package com.wompi.tasks;

import com.wompi.interactions.PostPaymentSources;
import com.wompi.interactions.PostTokenNequi;
import com.wompi.models.RequestNequi;
import com.wompi.models.RequestPaymentSource;
import lombok.RequiredArgsConstructor;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import org.apache.http.HttpStatus;

import static com.wompi.utils.ApiInteraction.getStatusCode;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.hamcrest.Matchers.equalTo;

@RequiredArgsConstructor
public class CreatePaymentSources implements Task {
    private String message = "Valida que se creo la nueva fuente de pago para wompi";
    private int statusCode= HttpStatus.SC_OK;
    private final RequestPaymentSource requestPaymentSource;

    public static CreatePaymentSources inWompi(RequestPaymentSource requestPaymentSource){
        return instrumented(CreatePaymentSources.class,requestPaymentSource);
    }

    @Override
    @Step("{0} #message y el código de estado #statusCode")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(PostPaymentSources.wompi(requestPaymentSource));
        actor.should(seeThat(message,
                actorSee -> actor.asksFor(getStatusCode()), equalTo(statusCode)));
    }

    public CreatePaymentSources message(String message){
        this.message = message;
        return this;
    }
    public CreatePaymentSources statusCode(int statusCode){
        this.statusCode = statusCode;
        return this;
    }
}
