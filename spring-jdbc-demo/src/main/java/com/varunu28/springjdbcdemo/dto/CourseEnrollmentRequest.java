package com.varunu28.springjdbcdemo.dto;

import jakarta.validation.constraints.NotNull;

public record CourseEnrollmentRequest(@NotNull Integer studentId, @NotNull Integer courseId) {
}
