package com.wompi.interactions;

import com.wompi.models.ResponseMerchant;
import com.wompi.utils.WompiInternalInteraction;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static com.wompi.utils.Constants.MERCHANT_PUBLIC_KEY;
import static com.wompi.utils.Keys.PUB_STG_TEST;
import static com.wompi.utils.WompiEndPoints.MERCHANT;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetMerchant extends WompiInternalInteraction {

    public static GetMerchant wompi() {
        return instrumented(GetMerchant.class);
    }

    public static Question<ResponseMerchant> getResponseBody(){
        return new ResponseBody<>(ResponseMerchant.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Get.resource(MERCHANT.getPath())
                .with(requestSpecification -> getWompiApiURL()
                        .pathParam(MERCHANT_PUBLIC_KEY.getValue(),PUB_STG_TEST.getKey())
                ));
    }
}
