package com.wompi.models;

import lombok.Data;

@Data
public class ResponsePaymentSource {
    public Data data;
    public Meta meta;
    @lombok.Data
    public static class Data {
        public int id;
        public PublicData public_data;
        public String token;
        public String type;
        public String status;
        public String customer_email;

        @lombok.Data
        public static class PublicData {
            public String type;
            public String phone_number;
            public String phone;
        }
    }
    @lombok.Data
    public static class Meta{
    }
}
