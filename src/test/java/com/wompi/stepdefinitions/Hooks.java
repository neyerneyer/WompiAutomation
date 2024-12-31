package com.wompi.stepdefinitions;

import io.cucumber.java.Before;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

public class Hooks {
    @Before
    public void setUp() {
        //OnStage.setTheStage(new OnlineCast());
        OnStage.setTheStage(Cast.whereEveryoneCan(CallAnApi.at(Serenity.environmentVariables().getProperty("wompi.api.url.base"))));
    }
}
