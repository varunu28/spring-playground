package com.varunu28.springprofiles.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"test", "qa"}) // This service is active when either 'test' or 'qa' profiles are active
public class CasingServiceTestImpl implements CasingService {
    @Override
    public String changeCasing(String input) {
        // In test implementation, we do not change the casing
        return input;
    }
}
