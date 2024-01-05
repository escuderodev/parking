package br.com.escuderodev.parking.models.parking;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ParkingRegistrationData(
        @NotNull
        Integer fixedTime,
        @NotBlank
        String paymentMethod

) {
}
