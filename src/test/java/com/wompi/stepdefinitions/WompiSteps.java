package com.wompi.stepdefinitions;

import com.wompi.exceptions.GeneralError;
import com.wompi.interactions.GetMerchant;
import com.wompi.interactions.GetTokenNequi;
import com.wompi.models.FactoryPaymentSource;
import com.wompi.models.ResponseMerchant;
import com.wompi.models.ResponseToken;
import com.wompi.questions.IsPhoneNumberCorrect;
import com.wompi.questions.VerifyTokenNequiQuestion;
import com.wompi.tasks.ConsultMerchant;
import com.wompi.tasks.CreatePaymentSources;
import com.wompi.tasks.ObtainTokenNequi;
import com.wompi.tasks.VerifyTokenNequi;
import com.wompi.utils.ValidateStatusCode;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.http.HttpStatus;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class WompiSteps {

    @Given("que {string} es un cliente registrado con celular {string}")
    public void customerRegisteredWithMobile(String actor, String phone) {
        theActorCalled(actor).wasAbleTo(ObtainTokenNequi.inWompi(phone));
        ResponseToken responseToken = theActorInTheSpotlight().asksFor(GetTokenNequi.getResponseBody());
        theActorInTheSpotlight().remember("infoResponseToken", responseToken);
        theActorInTheSpotlight().attemptsTo(VerifyTokenNequi.isApproved(responseToken.getData().getId()));
        theActorInTheSpotlight().should("Valida que el statud del token es: APPROVED", seeThat(VerifyTokenNequiQuestion.status(), is(true)));
        theActorInTheSpotlight().should(seeThat(IsPhoneNumberCorrect.value(), equalTo(phone))
                .orComplainWith(GeneralError.class,"La comparación de los valores no fue lo esperado"));
    }

    @And("obtiene los tokens de aceptacion prefirmados para wompi")
    public void getAcceptanceTokensPrefirmedForWompi() {
        theActorInTheSpotlight().wasAbleTo(ConsultMerchant.inWompi());
        ResponseMerchant merchant = theActorInTheSpotlight().asksFor(GetMerchant.getResponseBody());
        theActorInTheSpotlight().remember("infoMerchant", merchant);
    }

    @And("genero un fuente de pago de tipo {string}")
    public void generoATypePaymentSource(String paymentSource) {
        theActorInTheSpotlight().recall("infoResponseToken");
        theActorInTheSpotlight().recall("infoMerchant");
        theActorInTheSpotlight().attemptsTo(CreatePaymentSources.inWompi(
                        FactoryPaymentSource.getRequestPaymentSource(
                                paymentSource,
                                theActorInTheSpotlight().recall("infoResponseToken"),
                                theActorInTheSpotlight().recall("infoMerchant")
                        )
                ).statusCode(HttpStatus.SC_CREATED)
                .message("Valida que se creo la nueva fuente de pago para: " + paymentSource));

    }
    @And("genero un fuente de pago de tipo {string} no procesable")
    public void generoATypePaymentSourceUnProcessable(String paymentSource) {
        theActorInTheSpotlight().recall("infoResponseToken");
        theActorInTheSpotlight().recall("infoMerchant");
        theActorInTheSpotlight().attemptsTo(CreatePaymentSources.inWompi(
                        FactoryPaymentSource.getRequestPaymentSource(
                                paymentSource,
                                theActorInTheSpotlight().recall("infoResponseToken"),
                                theActorInTheSpotlight().recall("infoMerchant")
                        )
                ).statusCode(HttpStatus.SC_UNPROCESSABLE_ENTITY)
                .message("Valida que no se creo la nueva fuente de pago para: " + paymentSource));

    }

    @Then("el proceso de {string} del usuario es {string}")
    public void verifyStatusCode(String process, String status) {
        ValidateStatusCode.getStatusCode(process,status).validate();
    }
}
