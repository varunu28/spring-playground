package com.varunu28.springmapstruct.dto;

import jakarta.validation.constraints.NotBlank;

public record CreateProductRequest(
    @NotBlank(message = "product cannot be created with a empty name") String name,
    @NotBlank(message = "product cannot be created with an empty description") String description) {}
