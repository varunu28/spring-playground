package com.varunu28.springprofiles.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("!test & !qa") // This service is active when neither 'test' nor 'qa' profiles are active
public class CasingServiceImpl implements CasingService {
    @Override
    public String changeCasing(String input) {
        return input.toUpperCase();
    }
}
