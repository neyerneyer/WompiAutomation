package com.wompi.questions;

import com.wompi.interactions.GetTokenNequi;
import com.wompi.models.ResponseToken;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class VerifyTokenNequiQuestion implements Question<Boolean> {

    public static VerifyTokenNequiQuestion status() {
        return new VerifyTokenNequiQuestion();
    }
    @Override
    public Boolean answeredBy(Actor actor) {
        ResponseToken responseToken = actor.asksFor(GetTokenNequi.getResponseBody());
        return "APPROVED".equals(responseToken.getData().getStatus());
    }
}
