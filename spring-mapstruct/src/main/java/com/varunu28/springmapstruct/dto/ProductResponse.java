package com.varunu28.springmapstruct.dto;

public record ProductResponse(
    Long id, String productName, String productDescription, String createdAt, boolean isDeleted) {}
