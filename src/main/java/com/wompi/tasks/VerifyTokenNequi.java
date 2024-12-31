package com.wompi.tasks;

import com.wompi.interactions.GetTokenNequi;

import lombok.RequiredArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import org.apache.http.HttpStatus;

import static com.wompi.utils.ApiInteraction.getStatusCode;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.hamcrest.Matchers.equalTo;

@RequiredArgsConstructor
public class VerifyTokenNequi implements Task {
    private String message = "Valida que obtiene el token de nequi para wompi este aprobado";
    private int statusCode= HttpStatus.SC_OK;
    private final String tokenNequi;

    public static VerifyTokenNequi isApproved(String tokenNequi) {
        return instrumented(VerifyTokenNequi.class,tokenNequi);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(GetTokenNequi.forWompi(tokenNequi));
        actor.should(seeThat(message,
                actorSee -> actor.asksFor(getStatusCode()), equalTo(statusCode)));

    }
    public VerifyTokenNequi message(String message){
        this.message = message;
        return this;
    }
    public VerifyTokenNequi statusCode(int statusCode){
        this.statusCode = statusCode;
        return this;
    }
}
