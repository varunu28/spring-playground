package com.varun.springmvc.formencoded.dto;

import java.util.UUID;

public record UpdateLastNameRequest(UUID id, String lastName) {
}
