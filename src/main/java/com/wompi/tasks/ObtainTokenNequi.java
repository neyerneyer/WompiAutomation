package com.wompi.tasks;

import com.wompi.interactions.PostTokenNequi;
import com.wompi.models.RequestNequi;
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
public class ObtainTokenNequi implements Task{
    private String message = "Valida que obtiene el token de nequi para wompi";
    private int statusCode= HttpStatus.SC_OK;
    private final String phone;

    public static ObtainTokenNequi inWompi(String phone){
        return instrumented(ObtainTokenNequi.class,phone);
    }

    @Override
    @Step("{0} #message y el código de estado #statusCode")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(PostTokenNequi.wompi(RequestNequi.builder().phone_number(phone).build()));
        actor.should(seeThat(message,
                actorSee -> actor.asksFor(getStatusCode()), equalTo(statusCode)));
    }
    public ObtainTokenNequi message(String message){
        this.message = message;
        return this;
    }
    public ObtainTokenNequi statusCode(int statusCode){
        this.statusCode = statusCode;
        return this;
    }
}
