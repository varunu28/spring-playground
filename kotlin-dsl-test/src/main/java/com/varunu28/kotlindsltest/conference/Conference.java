package com.varunu28.kotlindsltest.conference;

import java.time.LocalDate;

public record Conference(String name, String description, LocalDate startDate, LocalDate endDate) {
}
