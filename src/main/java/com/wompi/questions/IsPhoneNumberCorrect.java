package com.wompi.questions;

import com.wompi.interactions.GetTokenNequi;
import com.wompi.models.ResponseToken;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class IsPhoneNumberCorrect implements Question<String> {


    public static IsPhoneNumberCorrect value() {
        return new IsPhoneNumberCorrect();
    }
    @Override
    public String answeredBy(Actor actor) {
        ResponseToken responseToken = actor.asksFor(GetTokenNequi.getResponseBody());
        return responseToken.getData().getPhone_number();
    }
}
