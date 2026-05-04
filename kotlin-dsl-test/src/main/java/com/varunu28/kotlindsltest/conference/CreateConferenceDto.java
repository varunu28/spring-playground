package com.varunu28.kotlindsltest.conference;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record CreateConferenceDto(
        @NotBlank String name, @NotBlank String description, LocalDate startDate, LocalDate endDate) {
}
