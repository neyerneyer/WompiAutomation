package com.wompi.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RequestPaymentSource {
    public String type;
    public String token;
    @JsonProperty("customer_email")
    public String customerEmail;
    @JsonProperty("acceptance_token")
    public String acceptanceToken;
    @JsonProperty("accept_personal_auth")
    public String acceptPersonalAuth;
}
