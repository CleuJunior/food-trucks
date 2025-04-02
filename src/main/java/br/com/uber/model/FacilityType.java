package br.com.uber.model;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum FacilityType {
    TRUCK("Truck"),
    PUSH_CART("Push Cart");

    @JsonValue
    private final String type;
}
