package com.wompi.tasks;

import com.wompi.interactions.GetMerchant;
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
public class ConsultMerchant implements Task {
    private String message = "Valida que obtiene los comercios de wompi";
    private int statusCode= HttpStatus.SC_OK;

    public static ConsultMerchant inWompi(){
        return instrumented(ConsultMerchant.class);
    }

    @Override
    @Step("{0} #message con código de estado #statusCode")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(GetMerchant.wompi());
        //WaitMoment.onSeconds(30);
        actor.should(seeThat(message,
                actorSee -> actor.asksFor(getStatusCode()), equalTo(statusCode)));
    }

    public ConsultMerchant message(String message){
        this.message = message;
        return this;
    }
    public ConsultMerchant statusCode(int statusCode){
        this.statusCode = statusCode;
        return this;
    }
}
