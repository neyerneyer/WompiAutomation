package com.wompi.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
@Data
public class ResponseMerchant {
    public Data data;
    public Meta meta;
@lombok.Data
    public static class Data{
        public int id;
        public String name;
        public String email;
        public String contact_name;
        public String phone_number;
        public boolean active;
        public Object logo_url;
        public String legal_name;
        public String legal_id_type;
        public String legal_id;
        public String public_key;
        public List<String> accepted_currencies;
        public Object fraud_javascript_key;
        public List<Object> fraud_groups;
        public List<String> accepted_payment_methods;
        public List<PaymentMethod> payment_methods;
    @JsonProperty("presigned_acceptance")
    public PresignedAcceptance presignedAcceptance;
    @JsonProperty("presigned_personal_data_auth")
    public PresignedPersonalDataAuth presignedPersonalDataAuth;
@lombok.Data
        public static class PaymentMethod{
            public String name;
            public List<PaymentProcessor> payment_processors;
@lombok.Data
            public static class PaymentProcessor{
                public String name;
            }
        }
        @lombok.Data
        public static class PresignedAcceptance{
            @JsonProperty("acceptance_token")
            public String acceptanceToken;
            public String permalink;
            public String type;
        }
@lombok.Data
        public static class PresignedPersonalDataAuth{
            @JsonProperty("acceptance_token")
            public String acceptanceToken;
            public String permalink;
            public String type;
        }
    }
    @lombok.Data
    public static class Meta{
    }
}
