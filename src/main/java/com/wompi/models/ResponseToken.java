package com.wompi.models;

import lombok.Data;

@Data
public class ResponseToken {
    public Data data;
    public Meta meta;
    @lombok.Data
    public static class Data{
        public String id;
        public String status;
        public String phone;
        public String phone_number;
    }
    @lombok.Data
    public static class Meta{
    }
}

