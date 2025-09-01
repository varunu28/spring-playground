package com.varunu28.springbeansdemo.service;

public interface EmailService {

    /**
     * Sends an email to the given email address.
     *
     * @param content content of the email
     * @param toEmail email address to which the email is to be sent
     */
    void sendEmail(String content, String toEmail);
}
