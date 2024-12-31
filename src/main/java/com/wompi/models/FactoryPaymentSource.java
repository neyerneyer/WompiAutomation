package com.wompi.models;

public class FactoryPaymentSource {

   public static RequestPaymentSource getRequestPaymentSource(String type, ResponseToken responseToken, ResponseMerchant merchant) {
       return  RequestPaymentSource.builder()
               .type(type)
               .token(responseToken.getData().getId())
               .customerEmail(merchant.getData().getEmail())
               .acceptanceToken(merchant.getData().getPresignedAcceptance().getAcceptanceToken())
               .acceptPersonalAuth(merchant.getData().getPresignedPersonalDataAuth().getAcceptanceToken())
               .build();
   }
}
