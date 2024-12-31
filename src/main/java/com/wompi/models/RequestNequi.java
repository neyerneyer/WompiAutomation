package com.wompi.models;

import lombok.Builder;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonProperty;


@Data
@Builder
public class RequestNequi {
    @JsonProperty("phone_number")
    public String phone_number;

}
