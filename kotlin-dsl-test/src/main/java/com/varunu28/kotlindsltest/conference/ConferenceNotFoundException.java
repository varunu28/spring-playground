package com.varunu28.kotlindsltest.conference;

public class ConferenceNotFoundException extends RuntimeException {
    public ConferenceNotFoundException() {
        super("Conference not found");
    }
}
