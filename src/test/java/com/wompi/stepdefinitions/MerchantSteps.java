package com.wompi.stepdefinitions;

import com.wompi.interactions.GetMerchant;
import com.wompi.models.ResponseMerchant;
import com.wompi.questions.ApiResponseQuestions;
import com.wompi.tasks.ConsultMerchant;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import org.apache.http.HttpStatus;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.is;

public class MerchantSteps {

    @Given("que {string} es un usuario disponible")
    public void isAnAvailableUser(String actor) {
        OnStage.theActorCalled(actor).entersTheScene();
    }

    @When("realiza una solicitud al endpoint de comercios")
    public void requestToTheMerchantEndpoint() {
        theActorInTheSpotlight().attemptsTo(ConsultMerchant.inWompi());
    }

    @Then("valida el estado de la transacción con su respuesta")
    public void validatesStatusTransactionResponse() {
        ResponseMerchant merchant =  theActorInTheSpotlight().asksFor(GetMerchant.getResponseBody());
        theActorInTheSpotlight().should(seeThat("Valida el código de estado",ApiResponseQuestions.hasStatusCode(HttpStatus.SC_OK),is(true)));
        theActorInTheSpotlight().should(seeThat("El campo tiene el valor esperado",ApiResponseQuestions.hasFieldWithValue("data.id", 5113),is(true)));
        theActorInTheSpotlight().should(seeThat("El body contiene el texto esperado",ApiResponseQuestions.bodyContains("Alejandra"),is(true)));
        theActorInTheSpotlight().should(seeThat("Verificar que el objeto ResponseMerchant no sea nulo", ApiResponseQuestions.isMerchantNotNull(merchant), is(true)));
    }
}
