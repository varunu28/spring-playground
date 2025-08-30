package com.varunu28.springjdbcdemo.dto;

import org.apache.coyote.BadRequestException;

public record CourseCreationRequest(String name, String description) {

    private static final int MINIMUM_NAME_LENGTH = 5;
    private static final int MAXIMUM_NAME_LENGTH = 100;
    private static final int MINIMUM_DESCRIPTION_LENGTH = 10;
    private static final int MAXIMUM_DESCRIPTION__LENGTH = 200;

    public void validate() throws BadRequestException {
        if (name == null || name.isEmpty()) {
            throw new BadRequestException("name cannot be null or empty");
        }
        if (description == null || description.isEmpty()) {
            throw new BadRequestException("description cannot be null or empty");
        }
        if (name.length() < MINIMUM_NAME_LENGTH) {
            throw new BadRequestException("name is too short");
        }
        if (name.length() > MAXIMUM_NAME_LENGTH) {
            throw new BadRequestException("name is too long");
        }
        if (description.length() < MINIMUM_DESCRIPTION_LENGTH) {
            throw new BadRequestException("description is too short");
        }
        if (description.length() > MAXIMUM_DESCRIPTION__LENGTH) {
            throw new BadRequestException("description is too long");
        }
    }
}
